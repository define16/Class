# https://www.kaggle.com/c/airbnb-recruiting-new-user-bookings

import os
import sys
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

from sklearn.pipeline import Pipeline
from sklearn.impute import SimpleImputer
from sklearn.preprocessing import OneHotEncoder
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.pipeline import FeatureUnion

from sklearn.ensemble import VotingClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import BaggingClassifier
from sklearn.multiclass import OneVsOneClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import GridSearchCV
from sklearn.ensemble import RandomForestClassifier


import warnings


AIRBNB_PATH = os.path.join("dataSet", "airbnb")

#
class DataFrameSelector(BaseEstimator, TransformerMixin):
    def __init__(self, attribute_names):
        self.attribute_names = attribute_names
    def fit(self, X, y=None):
        return self
    def transform(self, X):
        return X[self.attribute_names]


def load_data(filename, titanic_path=AIRBNB_PATH):
    csv_path = os.path.join(titanic_path, filename)
    return pd.read_csv(csv_path)

def case1(df_train):
    df_train.loc[df_train['age'] < 5, 'age'] = 1
    df_train.loc[df_train['age'] > 100, 'age'] = 99
    df_train['age'] = df_train['age'].fillna(float(int(df_train['age'].mean()))) # 나이를 평균으로 줬을때
    # df_train['age'] = df_train['age'].fillna(27.0) # 실제 미국인들이 가장 여행을 많이 다니는 나이

    df_train["age_temp"] = np.ceil(df_train["age"] / 10)
    df_train["age_temp"].where(df_train["age_temp"] < 8, 8.0, inplace=True) # 8-9는 드랍


    # date_account_created에서 year과 date로 나눔
    year, date =[] ,[]
    for d in df_train["date_account_created"] :
        year.append(int(d.split("-")[0]))
        date.append(int(d.split("-")[1]))
    df_train["year"] = np.array(year)
    df_train["date"] = np.array(date)

    # df_train["age_temp"].hist();
    # plt.show()

    # print(df_train["age_temp"].value_counts() / len(df_train))
    df_train = df_train.drop("date_first_booking" , axis=1) # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("id" , axis=1) # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("date_account_created", axis=1)

    df_train['first_affiliate_tracked'] = df_train['first_affiliate_tracked'].fillna("self") # NaN은 스스로 들어왔다는 의미

    # 데이터 양이 너무 많이 나이로 계층적 샘플링을 진행
    df_train, _ = train_test_split(df_train, test_size=0.5, random_state=42, stratify=df_train["age_temp"])
    df_train = df_train.drop("age_temp", axis=1)
    train_set, test_set = train_test_split(df_train, test_size=0.2, random_state=42)
    #print("debug point1")
    #print(train_set.shape, test_set.shape)
    #print(df_train.info(memory_usage='deep'))

    for col in ["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider", "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"] :
        # print("feature : " + col)
        set1 = set(train_set[col])
        set2 = set(test_set[col])

        # print("수정전 길이 :",len(set1), len(set2))
        # print(set1)
        # print(set2)
        # print("----")

        if len(set1) < len(set2) :
            complement = (list(set2 - set1))
            exc_temp = set((list(set1 - set2)) + (list(set2 - set1)))
            exc = list(exc_temp - set(complement))
            # print("중복되지 않는것들 : ", complement)
            # print("확인 :", exc)
            # print("최종 :", complement)
            for c in complement:
                test_set = test_set[test_set[col] != c]
            for e in exc:
                train_set = train_set[train_set[col] != e]

        elif len(set2) < len(set1) :
            complement = (list(set1 - set2))
            exc_temp = set((list(set2 - set1)) + (list(set1 - set2)))
            exc = list(exc_temp - set(complement))
            # print("중복되지 않는것들 : ", complement)
            # print("확인 :", exc)
            # print("최종 :", complement)
            for c in complement:
                train_set = train_set[train_set[col] != c]
            for e in exc:
                test_set = test_set[test_set[col] != e]


    num_pipeline = Pipeline([
        ("select_numeric", DataFrameSelector(["timestamp_first_active", "age", "signup_flow", "year", "date"])),
    ])

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider", "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"])),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])
    #print("debug point 2")
    #print(train_set.columns)
    #print(test_set.columns)


    X_train = preprocess_pipeline.fit_transform(train_set)
    y_train = train_set["country_destination"]
    X_test = preprocess_pipeline.fit_transform(test_set)
    y_test = test_set["country_destination"]

    print(X_train.shape, y_train.shape)
    print(X_test.shape, y_test.shape)

    print("----- SGDClassifier -----")
    from sklearn.linear_model import SGDClassifier
    sgd_clf = SGDClassifier(random_state=42, n_jobs=-1)
    sgd_clf.fit(X_train, y_train)
    sgd_scores = cross_val_score(sgd_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", sgd_scores.mean())
    y_pred = sgd_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- OneVsOneClassifier -----")
    ovo_clf = OneVsOneClassifier(SGDClassifier(random_state=42, n_jobs=-1))
    ovo_clf.fit(X_train, y_train)
    ovo_scores = cross_val_score(ovo_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", ovo_scores.mean())
    y_pred = ovo_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- KNeighborsClassifier -----")
    knn_clf = KNeighborsClassifier(n_jobs=-1)
    knn_clf.fit(X_train, y_train)
    knn_scores = cross_val_score(knn_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", knn_scores.mean())
    y_pred = knn_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    parameters = {'n_neighbors': (1, 3, 10, 30), 'weights': ('uniform', 'distance')}
    grid_search = GridSearchCV(knn_clf, parameters, n_jobs=-1)
    grid_search.fit(X_train, y_train)
    grid_search_scores = cross_val_score(grid_search, X_train, y_train, cv=50, scoring="accuracy")
    print("그리드 서치 후 교차검증으로 나온 성능 :", grid_search_scores.mean())
    y_pred = grid_search_scores.predict(X_test)
    print("그리드 서치 후 테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- RandomForestClassifier -----")
    forest_clf = RandomForestClassifier(n_estimators=15, random_state=42, n_jobs=-1)
    forest_clf.fit(X_train, y_train)
    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", forest_scores.mean())
    y_pred = forest_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    parameters = {'n_estimators ': (1, 3, 10, 30, 100), 'max_depth' : (1, 5 , 10, 20, 100)}
    grid_search = GridSearchCV(forest_clf, parameters, n_jobs=-1)
    grid_search.fit(X_train, y_train)
    grid_search_scores = cross_val_score(grid_search, X_train, y_train, cv=50, scoring="accuracy")
    print("그리드 서치 후 교차검증으로 나온 성능 :", grid_search_scores.mean())
    y_pred = grid_search_scores.predict(X_test)
    print("그리드 서치 후 테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")


    print("----- DecisionTreeClassifier -----")
    tree_clf = DecisionTreeClassifier(max_depth=50, random_state=42, n_jobs=-1)
    tree_clf.fit(X_train, y_train)
    tree_scores = cross_val_score(tree_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", tree_scores.mean())
    y_pred = tree_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    parameters = {'max_depth' : (1, 5 , 10, 20, 100)}
    grid_search = GridSearchCV(tree_clf, parameters, n_jobs=-1)
    grid_search.fit(X_train, y_train)
    grid_search_scores = cross_val_score(grid_search, X_train, y_train, cv=50, scoring="accuracy")
    print("그리드 서치 후 교차검증으로 나온 성능 :", grid_search_scores.mean())
    y_pred = grid_search_scores.predict(X_test)
    print("그리드 서치 후 테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")


    print("----- VotingClassifier 앙상블 -----")
    log_clf = LogisticRegression(random_state=42, n_jobs=-1)
    rnd_clf = RandomForestClassifier(random_state=42, n_jobs=-1)
    sgd_clf = SGDClassifier(random_state=42, n_jobs=-1)
    tree_clf = DecisionTreeClassifier(max_depth=50, random_state=42, n_jobs=-1)
    forest_clf = RandomForestClassifier(n_estimators=15, random_state=42, n_jobs=-1)

    # 각 분류기의 예측값(레이블)을 가지고 다수결 투표를 통해 최종 앙상블 예측
    voting_clf = VotingClassifier(
        estimators=[('lr', log_clf), ('rf', rnd_clf), ('sgd', sgd_clf), ('tree', tree_clf), ('forest', forest_clf)],
        voting='soft', n_jobs=-1)
    voting_clf.fit(X_train, y_train)
    voting_scores = cross_val_score(voting_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", voting_scores.mean())
    y_pred = voting_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")


    # 배깅을 이용한 앙상블 학습
    # estimators : 개별 모형 목록, 리스트나 named parameter 형식으로 입력
    # max_sample : 각 기본 추정량을 훈련하기 위해 X에서 추출 할 샘플 수
    # bootstrap : 교체로 샘플을 그릴 것인지 여부
    # n_jobs : 적합 및 예측 모두 에 대해 병렬로 실행할 작업 수
    print("----- BaggingClassifier 앙상블 -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")


def case2(df_train, df_test):
    df_train.loc[df_train['age'] < 5, 'age'] = 1
    df_train.loc[df_train['age'] > 100, 'age'] = 99

    # df_train['age'] = df_train['age'].fillna(float(int(df_train['age'].mean())))  # 나이를 평균으로 줬을때
    # df_train['age'] = df_train['age'].fillna(27.0) # 실제 미국인들이 가장 여행을 많이 다니는 나이

    df_train["age_temp"] = np.ceil(df_train["age"] / 10)
    df_train["age_temp"].where(df_train["age_temp"] < 8, 8.0, inplace=True)  # 8-9는 드랍
    # print(df_train["date_account_created"])

    # date_account_created에서 year과 date로 나눔
    year, date = [], []
    for d in df_train["date_account_created"]:
        # print(d.split("-")[0], d.split("-")[1])
        year.append(int(d.split("-")[0]))
        date.append(int(d.split("-")[1]))
    df_train["year"] = np.array(year)
    df_train["date"] = np.array(date)



    # df_train["age_temp"].hist();
    # plt.show()

    # print(df_train["age_temp"].value_counts() / len(df_train))
    df_train = df_train.drop("date_first_booking", axis=1)  # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("id", axis=1)  # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("date_account_created", axis=1)

    df_train['first_affiliate_tracked'] = df_train['first_affiliate_tracked'].fillna("self")  # NaN은 스스로 들어왔다는 의미

    num_pipeline = Pipeline([
        ("select_numeric", DataFrameSelector(["timestamp_first_active", "age", "signup_flow", "year", "date"])),
        ("imputer", SimpleImputer(strategy="median")),
    ])

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(
            ["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider",
             "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"])),
        # ("imputer", MostFrequentImputer()),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])

    X_train = preprocess_pipeline.fit_transform(df_train)
    y_train = df_train["country_destination"].copy()

    X_test = preprocess_pipeline.fit_transform(df_test)
    y_test = df_test["country_destination"].copy()

    print("----- 랜덤 포레스트 -----")
    forest_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    forest_clf.fit(X_train, y_train)

    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", forest_scores.mean())

    y_pred = forest_clf.predict(X_test)

    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    """
    print("========== 과제 ==========\n")
    print("----- 결정트리 분류 -----")
    tree_clf = DecisionTreeClassifier(max_depth=10)
    tree_clf.fit(X_train, y_train)

    tree_scores = cross_val_score(tree_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", tree_scores.mean())

    y_pred = tree_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()


    print("----- 결정트리 회귀 -----")
    tree_reg = DecisionTreeRegressor()
    tree_reg.fit(X_train, y_train)

    tree_scores = cross_val_score(tree_reg, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", tree_scores.mean())

    y_pred = tree_reg.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()


    print("----- 로지스틱 회귀 -----")
    log_clf = LogisticRegression(random_state=42)
    log_clf.fit(X_train, y_train)

    log_scores = cross_val_score(log_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", log_scores.mean())

    y_pred = log_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 투표 기반 -----")
    log_clf = LogisticRegression(random_state=42)
    rnd_clf = RandomForestClassifier(random_state=42)
    svm_clf = SVC(random_state=42)

    # 각 분류기의 예측값(레이블)을 가지고 다수결 투표를 통해 최종 앙상블 예측
    voting_clf = VotingClassifier(
        estimators=[('lr', log_clf), ('rf', rnd_clf), ('svc', svm_clf)],
        voting='hard')
    voting_clf.fit(X_train, y_train)
    voting_scores = cross_val_score(voting_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", voting_scores.mean())

    y_pred = voting_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    # 배깅을 이용한 앙상블 학습

    # estimators : 개별 모형 목록, 리스트나 named parameter 형식으로 입력
    # max_sample : 각 기본 추정량을 훈련하기 위해 X에서 추출 할 샘플 수
    # bootstrap : 교체로 샘플을 그릴 것인지 여부
    # n_jobs : 적합 및 예측 모두 에 대해 병렬로 실행할 작업 수
    print("----- 배깅을 이용한 앙상블 -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 배깅을 이용한 앙상블(max_depth=5) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=5), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 배깅을 이용한 앙상블(max_depth=4) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=4), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()


    print("----- 배깅을 이용한 앙상블(max_depth=3) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=3), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()


    print("----- 배깅을 이용한 앙상블(max_depth=2) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=2), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()
"""

def case3(df_train, df_test):
    pass

if __name__ == "__main__":
    warnings.simplefilter(action='ignore')
    df_train = load_data("train_users_2.csv")
    #print(df_train.head())
    #print(df_train.shape)
    # df_train.memory_usage(index=True)
    df_train.memory_usage(deep=True)
    # print(df_train.info(memory_usage='deep'))
    # print(df_train.describe()) # 통계확인
    # print(df_train.isnull().sum()) # 빠진값 확인

    # target 확인
    # df_train["country_destination"].value_counts()

    # 범주형 데이터 확인
    # print(df_train["date_account_created"].value_counts())
    # print(df_train["gender"].value_counts())
    # print(df_train["signup_method"].value_counts())

    # 나이 확인
    df_train['age'] = df_train['age'].dropna()  # age에 있는 NaN 제거

    # age_plot = sns.countplot(df_train['age'])
    # 나이 그래프 그리기
    # for ind, label in enumerate(age_plot.get_xticklabels()):
    #    if ind % 15 == 0:
    #        label.set_visible(True)
    #    else:
    #        label.set_visible(False)
    # plt.show()

    print("-- Case1 --")
    case1(df_train)

    # print("-- Case2 -- ")
    # case2(df_train)

    # print("-- Case3 --")
    # case3(df_train,df_test)


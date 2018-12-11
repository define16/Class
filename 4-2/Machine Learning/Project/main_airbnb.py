# https://www.kaggle.com/c/airbnb-recruiting-new-user-bookings

import os
import sys
import pandas as pd
import numpy as np
from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.ensemble import RandomForestClassifier
from sklearn.ensemble import VotingClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.svm import SVC
from sklearn.tree import DecisionTreeRegressor
from sklearn.ensemble import BaggingClassifier
from sklearn.ensemble import BaggingRegressor
from sklearn.tree import DecisionTreeClassifier
from sklearn.pipeline import Pipeline
from sklearn.impute import SimpleImputer
from sklearn.preprocessing import OneHotEncoder, LabelEncoder, LabelBinarizer
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import cross_val_score
from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.pipeline import FeatureUnion
import seaborn as sns
import matplotlib.pyplot as plt

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

class MostFrequentImputer(BaseEstimator, TransformerMixin):
    def fit(self, X, y=None):
        self.most_frequent_ = pd.Series([X[c].value_counts().index[0] for c in X], index=X.columns)
        return self

    def transform(self, X, y=None):
        return X.fillna(self.most_frequent_)

def load_data(filename, titanic_path=AIRBNB_PATH):
    csv_path = os.path.join(titanic_path, filename)
    return pd.read_csv(csv_path)

def case1(df_train, df_test):
    df_train.loc[df_train['age'] < 5, 'age'] = 1
    df_train.loc[df_train['age'] > 100, 'age'] = 99
    df_train['age'] = df_train['age'].fillna(float(int(df_train['age'].mean()))) # 나이를 평균으로 줬을때
    # df_train['age'] = df_train['age'].fillna(27.0) # 실제 미국인들이 가장 여행을 많이 다니는 나이

    df_train["age_temp"] = np.ceil(df_train["age"] / 10)
    df_train["age_temp"].where(df_train["age_temp"] < 8, 8.0, inplace=True) # 8-9는 드랍
    # print(df_train["date_account_created"])



    # date_account_created에서 year과 date로 나눔
    year, date =[] ,[]
    for d in df_train["date_account_created"] :
        # print(d.split("-")[0], d.split("-")[1])
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
    # df_train, _ = train_test_split(df_train, test_size=0.5, random_state=42, stratify=df_train["age_temp"])
    df_train = df_train.drop("age_temp", axis=1)
    train_set, test_set = train_test_split(df_train, test_size=0.2, random_state=42, stratify=df_train["country_destination"])
    #print("debug point1")
    #print(train_set.shape, test_set.shape)
    #print(df_train.info(memory_usage='deep'))

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


    for col in ["timestamp_first_active", "age", "signup_flow", "year", "date"]:
        test_set = test_set.drop(str(col), axis=1)
        train_set = train_set.drop(str(col), axis=1)

    for col in ["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider", "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"]:
        print("feature : " + col)
        encoder = OneHotEncoder(sparse=False)
        train_enc = encoder.fit_transform(train_set[col].values.reshape(-1, 1))
        print(train_enc.shape)

        encoder2 = OneHotEncoder(sparse=False)
        test_enc = encoder2.fit_transform(test_set[col].values.reshape(-1, 1))
        print(test_enc.shape)

    # for col in




    """
    X_train = preprocess_pipeline.fit_transform(train_set)
    y_train = train_set["country_destination"]
    X_test = preprocess_pipeline.fit_transform(test_set)
    y_test = test_set["country_destination"]

    # shape 크기가 맞지 않는다.
    print(X_train.shape, y_train.shape)
    print(X_test.shape, y_test.shape)
    """

    """
    print("----- 랜덤 포레스트 -----")
    forest_clf = RandomForestClassifier(n_estimators=15, random_state=42)
    forest_clf.fit(X_train, y_train)

    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=20)
    print("교차검증으로 나온 성능 :", forest_scores.mean())

    y_pred = forest_clf.predict(X_train)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print("테스트결과 :", (y_train == y_pred).sum() / len(y_train))
    print()
    """
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
def case2(df_train, df_test):
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

    # 데이터 양이 너무 많이 나이로 계층적 샘플링을 진행
    df_train, _ = train_test_split(df_train, test_size=0.5, random_state=42, stratify=df_train["age_temp"])
    train_set, test_set = train_test_split(df_train, test_size=0.2, random_state=42,
                                           stratify=df_train["country_destination"])

    print(df_train.info(memory_usage='deep'))

    num_pipeline = Pipeline([
        ("select_numeric", DataFrameSelector(["timestamp_first_active", "age", "signup_flow", "year", "date"])),
        ("imputer", SimpleImputer(strategy="median")),
    ])
    print(num_pipeline.fit_transform(df_train))

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(
            ["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider",
             "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"])),
        # ("imputer", MostFrequentImputer()),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])
    print(num_pipeline.fit_transform(df_train))

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])

    X_train = preprocess_pipeline.fit_transform(train_set)
    y_train = train_set["country_destination"].copy()

    X_test = preprocess_pipeline.fit_transform(test_set)
    y_test = test_set["country_destination"].copy()

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
    df_train = load_data("train_users_2.csv")
    df_test = load_data("test_users.csv")
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

    #print("-- Case1 --")
    case1(df_train, df_test)
    """
    print("-- Case2 -- ")
    case2(df_train,df_test)
    print("-- Case3 --")
    case3(df_train,df_test)
    """

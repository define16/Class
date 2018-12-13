# https://www.kaggle.com/c/airbnb-recruiting-new-user-bookings

import os
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.pipeline import Pipeline
from sklearn.preprocessing import OneHotEncoder
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.pipeline import FeatureUnion

from sklearn.ensemble import VotingClassifier
from sklearn.ensemble import BaggingClassifier
from sklearn.multiclass import OneVsOneClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import SGDClassifier
from sklearn.multiclass import OneVsRestClassifier


import warnings
AIRBNB_PATH = os.path.join("dataSet", "airbnb")


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

def start(df_train):
    df_train['age'] = df_train['age'].dropna()  # age에 있는 NaN 제거
    df_train.loc[df_train['age'] < 5, 'age'] = 1
    df_train.loc[df_train['age'] > 100, 'age'] = 99
    df_train['age'] = df_train['age'].fillna(21.0) # 실제 미국인들이 가장 여행을 많이 다니는 나이

    df_train["age_temp"] = np.ceil(df_train["age"] / 10)
    df_train["age_temp"].where(df_train["age_temp"] < 8, 8.0, inplace=True) # 8-9는 드랍

    # date_account_created에서 year과 date로 나눔
    year, date =[] ,[]
    for d in df_train["date_account_created"] :
        year.append(int(d.split("-")[0]))
        date.append(int(d.split("-")[1]))
    df_train["year"] = np.array(year)
    df_train["date"] = np.array(date)

    df_train = df_train.drop("date_first_booking" , axis=1) # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("id" , axis=1) # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("date_account_created", axis=1)
    df_train = df_train.drop("timestamp_first_active", axis=1) # first_affiliate_tracked와 겹침

    df_train['first_affiliate_tracked'] = df_train['first_affiliate_tracked'].fillna("self") # NaN은 스스로 들어왔다는 의미


    # 데이터 양이 너무 많이 나이로 계층적 샘플링을 진행
    df_train, _ = train_test_split(df_train, test_size=0.5, random_state=42, stratify=df_train["age_temp"])
    df_train = df_train.drop("age_temp", axis=1)
    train_set, test_set = train_test_split(df_train, test_size=0.2, random_state=42, stratify=df_train["country_destination"])

    for col in ["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider", "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"] :
        # print("feature : " + col)
        set1 = set(train_set[col])
        set2 = set(test_set[col])

        # print("수정전 길이 :",len(set1), len(set2))

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
        ("select_numeric", DataFrameSelector(["age", "signup_flow", "year", "date"])),
    ])

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(["gender", "signup_method", "language", "affiliate_channel", "affiliate_provider", "first_affiliate_tracked", "signup_app", "first_device_type", "first_browser"])),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])

    X_train = preprocess_pipeline.fit_transform(train_set)
    y_train = train_set["country_destination"]
    X_test = preprocess_pipeline.fit_transform(test_set)
    y_test = test_set["country_destination"]

    print("Train :", X_train.shape, y_train.shape)
    print("Test :", X_test.shape, y_test.shape)


    print("----- SGDClassifier -----")
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

    print("----- OneVsRestClassifier -----")
    ovr_clf = OneVsRestClassifier(LogisticRegression())
    ovr_clf.fit(X_train, y_train)
    ovr_scores = cross_val_score(ovr_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", ovr_scores.mean())
    y_pred = ovr_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- KNeighborsClassifier -----")
    knn_clf = KNeighborsClassifier(n_jobs=-1, n_neighbors=30, weights='uniform')
    knn_clf.fit(X_train, y_train)
    knn_scores = cross_val_score(knn_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", knn_scores.mean())
    y_pred = knn_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- LogisticRegression -----")
    lr_clf = LogisticRegression(random_state=42)
    lr_clf.fit(X_train, y_train)
    lr_scores = cross_val_score(lr_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", lr_scores.mean())
    y_pred = lr_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- RandomForestClassifier -----")
    forest_clf = RandomForestClassifier(n_estimators=100, random_state=42, n_jobs=-1)
    forest_clf.fit(X_train, y_train)
    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", forest_scores.mean())
    y_pred = forest_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    # parameters = {'n_estimators': (1, 3, 10, 30, 100), 'max_depth' : (1, 5 , 10, 20, 100)}
    # grid_search = GridSearchCV(forest_clf, parameters, n_jobs=-1)
    # grid_search.fit(X_train, y_train)
    # grid_search_scores = cross_val_score(grid_search, X_train, y_train, cv=50, scoring="accuracy")
    # print("그리드 서치 후 교차검증으로 나온 성능 :", grid_search_scores.mean())
    # y_pred = grid_search_scores.predict(X_test)
    # print("그리드 서치 후 테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    print("----- DecisionTreeClassifier -----")
    tree_clf = DecisionTreeClassifier(max_depth=100, random_state=42)
    tree_clf.fit(X_train, y_train)
    tree_scores = cross_val_score(tree_clf, X_train, y_train, cv=50, scoring="accuracy")
    print("교차검증으로 나온 성능 :", tree_scores.mean())
    y_pred = tree_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")

    # parameters = {'max_depth' : (1, 5 , 10, 20, 100)}
    # grid_search = GridSearchCV(tree_clf, parameters, n_jobs=-1)
    # grid_search.fit(X_train, y_train)
    # grid_search_scores = cross_val_score(grid_search, X_train, y_train, cv=50, scoring="accuracy")
    # print("그리드 서치 후 교차검증으로 나온 성능 :", grid_search_scores.mean())
    # y_pred = grid_search_scores.predict(X_test)
    # print("그리드 서치 후 테스트결과 :", (y_test == y_pred).sum() / len(y_test), "\n")


    print("----- VotingClassifier 앙상블 -----")
    log_clf = LogisticRegression(random_state=42)
    rnd_clf = RandomForestClassifier(random_state=42)
    sgd_clf = SGDClassifier(random_state=42, loss='log')
    tree_clf = DecisionTreeClassifier(max_depth=50, random_state=42)
    forest_clf = RandomForestClassifier(n_estimators=100, random_state=42)
    # 각 분류기의 예측값(레이블)을 가지고 다수결 투표를 통해 최종 앙상블 예측
    voting_clf = VotingClassifier(
        estimators=[('lr', log_clf), ('rf', rnd_clf), ('sgd', sgd_clf), ('tree', tree_clf), ('forest', forest_clf)],
        voting='soft')
    voting_clf.fit(X_train, y_train)
    voting_scores = cross_val_score(voting_clf, X_train, y_train, cv=10, scoring="accuracy")
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


def check_dataSet(df_train):
    # 나이 그래프
    age_plot = sns.countplot(df_train['age'])
    for ind, label in enumerate(age_plot.get_xticklabels()):
        if ind % 15 == 0:
            label.set_visible(True)
        else:
            label.set_visible(False)
    plt.show()

    # 여행 가는 곳의 비율
    sns.set_style('ticks')
    fig, ax = plt.subplots()
    fig.set_size_inches(11.7, 8.27)
    destination_percentage = df_train.country_destination.value_counts() / df_train.shape[0] * 100
    destination_percentage.plot(kind='bar', color='#FF6666')
    plt.xlabel('Destination Country')
    plt.ylabel('Percentage')
    sns.despine()
    plt.show()

    # 미국과 NDF를 제외한 나머지(이유 : 2개가 대다수를 차지함)
    sns.set_style('ticks')
    fig, ax = plt.subplots()
    fig.set_size_inches(11.7, 8.27)
    data_without_NDF = df_train[df_train['country_destination'] != 'US']
    data_without_NDF1 = data_without_NDF[data_without_NDF['country_destination'] != 'NDF']
    sns.boxplot(y='age', x='country_destination', data=data_without_NDF1)
    plt.xlabel('Destination Country box plot ( removed NDF,US )')
    plt.ylabel('Age of Users')
    sns.despine()
    plt.show()

    # 성별 비율
    sns.set_style('ticks')
    fig, ax = plt.subplots()
    fig.set_size_inches(11.7, 8.27)
    gender_percentage = df_train.gender.value_counts() / df_train.shape[0] * 100
    gender_percentage.plot(kind='bar', color='#FF9999')
    plt.xlabel('Gender')
    plt.ylabel('Percentage')
    sns.despine()
    plt.show()

    # first_device_type 비율
    sns.set_style('ticks')
    fig, ax = plt.subplots()
    fig.set_size_inches(11.7, 8.27)
    device_percentage = df_train.first_device_type.value_counts() / df_train.shape[0] * 100
    device_percentage.plot(kind='bar', color='#CC3333')
    plt.xlabel('Device used by user')
    plt.ylabel('Percentage')
    sns.despine()
    plt.show()

    # 여행지의 언어
    sns.set_style('ticks')
    fig, ax = plt.subplots()
    fig.set_size_inches(11.7, 8.27)
    destination_percentage = df_train.language.value_counts() / df_train.shape[0] * 100
    destination_percentage.plot(kind='bar', color='#FF3333')
    plt.xlabel('Destination Country')
    plt.ylabel('Percentage')
    sns.despine()
    plt.show()

    df_train.loc[df_train['age'] < 5, 'age'] = 1
    df_train.loc[df_train['age'] > 100, 'age'] = 99
    df_train['age'] = df_train['age'].fillna(21.0)   # 실제 미국인들이 가장 여행을 많이 다니는 나이

    df_train["age_temp"] = np.ceil(df_train["age"] / 10)
    df_train["age_temp"].where(df_train["age_temp"] < 8, 8.0, inplace=True)  # 8-9는 드랍

    # date_account_created에서 year과 date로 나눔
    year, date = [], []
    for d in df_train["date_account_created"]:
        year.append(int(d.split("-")[0]))
        date.append(int(d.split("-")[1]))
    df_train["year"] = np.array(year)
    df_train["date"] = np.array(date)


    # print(df_train["age_temp"].value_counts() / len(df_train))
    df_train = df_train.drop("date_first_booking", axis=1)        # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("id", axis=1)                       # 상관관계도 낮고, 데이터를 임의 값으로 넣을 수가 없다. 그래서 삭제
    df_train = df_train.drop("date_account_created", axis=1)
    df_train = df_train.drop("timestamp_first_active", axis=1)  # first_affiliate_tracked와 겹침

    df_train['first_affiliate_tracked'] = df_train['first_affiliate_tracked'].fillna("self")  # NaN은 스스로 들어왔다는 의미


if __name__ == "__main__":
    warnings.simplefilter(action='ignore')
    df_train = load_data("train_users_2.csv")
    df_train.memory_usage(deep=True)
    print(df_train.info(memory_usage='deep'))
    # print(df_train.describe()) # 통계확인
    print(df_train.isnull().sum()) # 빠진값 확인

    # target 확인
    df_train["country_destination"].value_counts()

    print("-- Start --")
    start(df_train)

    print("-- Check_dataSet -- ")
    check_dataSet(df_train)


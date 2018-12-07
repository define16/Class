# https://www.kaggle.com/mehdidag/black-friday

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


BACKFRIDAY_PATH = os.path.join("dataSet", "backfriday")

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

def load_data(filename, backfriday_path=BACKFRIDAY_PATH):
    csv_path = os.path.join(backfriday_path, filename)
    return pd.read_csv(csv_path)

def case1(df_data):
    print(df_data.head())   # 데이터 확인
    print(df_data.isnull().sum())
    print(df_data.info()) # 통계확인

    # target 확인
    df_data["Purchase"].value_counts()

    # 범주형 데이터 확인
    # print(df_data["Age"])
    # print(df_data["Gender"])
    # print(df_data["Product_ID"])

    # df_train["age_temp"].hist();
    # plt.show()
    # print(df_train["age_temp"].value_counts() / len(df_train))
    # 데이터 수 줄이기
    df_data, __ =  train_test_split(df_data, test_size=0.5, random_state=42)
    train_set, test_set = train_test_split(df_data, test_size=0.2, random_state=42)

    num_pipeline = Pipeline([
        ("select_numeric", DataFrameSelector(["Occupation", "Marital_Status", "Product_Category_1"])),
        # ("select_numeric", DataFrameSelector(["age"])),
        # ("imputer", SimpleImputer(strategy="median")),
    ])

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(["Product_ID", "Gender", "Age","City_Category","Stay_In_Current_City_Years"])),
        # ("select_cat", DataFrameSelector(["gender"])),
        ("imputer", MostFrequentImputer()),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])



    X_train = preprocess_pipeline.fit_transform(train_set)
    # print(X_train.corr())
    y_train = train_set["Purchase"].copy()

    print(sys.getsizeof(X_train))
    print(sys.getsizeof(y_train))


    print("----- 서포트 벡터 머신 -----")
    svm_clf = SVC(gamma="auto")
    print(sys.getsizeof(X_train))
    print(sys.getsizeof(y_train))
    svm_clf.fit(X_train, y_train)
    print("fit end")
    svm_scores = cross_val_score(svm_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", svm_scores.mean())

    X_test = preprocess_pipeline.transform(test_set)
    y_pred = svm_clf.predict(X_test)

    y_test = test_set["country_destination"].values
    print("테스트결과 :",(y_test == y_pred).sum() / len(y_test))
    print()

    """
    print("----- 랜덤 포레스트 -----")
    forest_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    forest_clf.fit(X_train, y_train)

    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=2)
    print("교차검증으로 나온 성능 :", forest_scores.mean())

    y_pred = forest_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()


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
    pass

def case3(df_train, df_test):
    pass

if __name__ == "__main__":
    df_data = load_data("BlackFriday.csv")

    print("-- Case1 --")
    case1(df_data)
    """
    print("-- Case2 -- ")
    case2(df_train,df_test)
    print("-- Case3 --")
    case3(df_train,df_test)
    """

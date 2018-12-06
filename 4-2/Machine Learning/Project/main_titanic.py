import os
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
from sklearn.preprocessing import OneHotEncoder
from sklearn.svm import SVC
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import cross_val_score
from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.pipeline import FeatureUnion
import seaborn as sns
import matplotlib.pyplot as plt

import warnings

TITANIC_PATH = os.path.join("dataSet", "titanic")

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

def load_titanic_data(filename, titanic_path=TITANIC_PATH):
    csv_path = os.path.join(titanic_path, filename)
    return pd.read_csv(csv_path)

def case1(train_data, test_data, y_test):
    # 범주형 데이터 확인

    # 상관관계 확인
    train_copy = train_data.copy()
    corr_matrix = train_copy.corr()
    print(corr_matrix)
    # 가장 관련 없는 특징 추가하지 않기
    # PassengerId, Ticket, name, Cabin, SibSp

    num_pipeline = Pipeline([
        ("select_numeric", DataFrameSelector(["Age", "Parch", "Fare", "Pclass"])),
        ("imputer", SimpleImputer(strategy="median")),
    ])

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(["Sex", "Embarked", "SibSp"])),
        ("imputer", MostFrequentImputer()),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])

    X_train = preprocess_pipeline.fit_transform(train_data)
    y_train = train_data["Survived"]


    print("----- 서포트 벡터 머신 -----")
    svm_clf = SVC(gamma="auto")
    svm_clf.fit(X_train, y_train)
    svm_scores = cross_val_score(svm_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", svm_scores.mean())

    X_test = preprocess_pipeline.transform(test_data)
    y_pred = svm_clf.predict(X_test)

    y_test = y_test["Survived"].values
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 랜덤 포레스트 -----")
    forest_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    forest_clf.fit(X_train, y_train)

    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", forest_scores.mean())

    y_pred = forest_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("========== 과제 ==========\n")
    print("----- 결정트리 분류 -----")
    tree_clf = DecisionTreeClassifier(max_depth=10)
    tree_clf.fit(X_train, y_train)

    tree_scores = cross_val_score(tree_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", tree_scores.mean())

    y_pred = tree_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 결정트리 회귀 -----")
    tree_reg = DecisionTreeRegressor()
    tree_reg.fit(X_train, y_train)

    tree_scores = cross_val_score(tree_reg, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", tree_scores.mean())

    y_pred = tree_reg.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 로지스틱 회귀 -----")
    log_clf = LogisticRegression(random_state=42)
    log_clf.fit(X_train, y_train)

    log_scores = cross_val_score(log_clf, X_train, y_train, cv=10)
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
    voting_scores = cross_val_score(voting_clf, X_train, y_train, cv=10)
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
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 배깅을 이용한 앙상블(max_depth=5) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=5), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 배깅을 이용한 앙상블(max_depth=4) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=4), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 배깅을 이용한 앙상블(max_depth=3) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=3), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()

    print("----- 배깅을 이용한 앙상블(max_depth=2) -----")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42, max_depth=2), n_estimators=500,
        max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    bag_clf.fit(X_train, y_train)
    bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", bag_scores.mean())

    y_pred = bag_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    print()




def case2(train_data, test_data, y_test):
    # 생존자 비율과 수
    f, ax = plt.subplots(1, 2, figsize=(18, 8))
    train_data['Survived'].value_counts().plot.pie(explode=[0, 0.1], autopct='%1.1f%%', ax=ax[0], shadow=True)
    ax[0].set_title('Survived')
    ax[0].set_ylabel('')
    sns.countplot('Survived', data=train_data, ax=ax[1])
    ax[1].set_title('Survived')
    plt.show()

    # 성별별 살아남는 비율
    f, ax = plt.subplots(1, 2, figsize=(18, 8))
    train_data['Survived'][train_data['Sex'] == 'male'].value_counts().plot.pie(explode=[0, 0.1], autopct='%1.1f%%',
                                                                            ax=ax[0], shadow=True)
    train_data['Survived'][train_data['Sex'] == 'female'].value_counts().plot.pie(explode=[0, 0.1], autopct='%1.1f%%',
                                                                              ax=ax[1], shadow=True)
    ax[0].set_title('Survived (male)')
    ax[1].set_title('Survived (female)')
    plt.show()

    # 객실 등급과 성별 별 생존자수 확인
    pd.crosstab([train_data['Sex'], train_data['Survived']], train_data['Pclass'], margins=True).style.background_gradient(cmap='summer_r')

    #  배를 탄 항구의 위치와의 연관성
    f, ax = plt.subplots(2, 2, figsize=(20, 15))
    sns.countplot('Embarked', data=train_data, ax=ax[0, 0])
    ax[0, 0].set_title('No. Of Passengers Boarded')
    sns.countplot('Embarked', hue='Sex', data=train_data, ax=ax[0, 1])
    ax[0, 1].set_title('Male-Female Split for Embarked')
    sns.countplot('Embarked', hue='Survived', data=train_data, ax=ax[1, 0])
    ax[1, 0].set_title('Embarked vs Survived')
    sns.countplot('Embarked', hue='Pclass', data=train_data, ax=ax[1, 1])
    ax[1, 1].set_title('Embarked vs Pclass')
    plt.show()

    # 상관관계 확인
    train_copy = train_data.copy()
    corr_matrix = train_copy.corr()
    print(corr_matrix["Survived"])
    # 가장 관련 없는 특징 추가하지 않기
    # PassengerId, Ticket, name, Cabin, SibSp

    num_pipeline = Pipeline([
        ("select_numeric", DataFrameSelector(["Age", "Parch", "Fare", "Pclass", "Parch"])),
        ("imputer", SimpleImputer(strategy="median")),
    ])

    cat_pipeline = Pipeline([
        ("select_cat", DataFrameSelector(["Sex", "Embarked", "SibSp"])),
        ("imputer", MostFrequentImputer()),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])

    # X_train = preprocess_pipeline.fit_transform(train_data)
    # y_train = train_data["Survived"]
    #
    #
    # print("----- 서포트 벡터 머신 -----")
    # svm_clf = SVC(gamma="auto")
    # svm_clf.fit(X_train, y_train)
    # svm_scores = cross_val_score(svm_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", svm_scores.mean())
    #
    # X_test = preprocess_pipeline.transform(test_data)
    # y_pred = svm_clf.predict(X_test)
    #
    # y_test = y_test["Survived"].values
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 랜덤 포레스트 -----")
    # forest_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    # forest_clf.fit(X_train, y_train)
    #
    # forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", forest_scores.mean())
    #
    # y_pred = forest_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("========== 과제 ==========\n")
    # print("----- 결정트리 분류 -----")
    # tree_clf = DecisionTreeClassifier(max_depth=10)
    # tree_clf.fit(X_train, y_train)
    #
    # tree_scores = cross_val_score(tree_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", tree_scores.mean())
    #
    # y_pred = tree_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 결정트리 회귀 -----")
    # tree_reg = DecisionTreeRegressor()
    # tree_reg.fit(X_train, y_train)
    #
    # tree_scores = cross_val_score(tree_reg, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", tree_scores.mean())
    #
    # y_pred = tree_reg.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 로지스틱 회귀 -----")
    # log_clf = LogisticRegression(random_state=42)
    # log_clf.fit(X_train, y_train)
    #
    # log_scores = cross_val_score(log_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", log_scores.mean())
    #
    # y_pred = log_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 투표 기반 -----")
    # log_clf = LogisticRegression(random_state=42)
    # rnd_clf = RandomForestClassifier(random_state=42)
    # svm_clf = SVC(random_state=42)
    #
    # # 각 분류기의 예측값(레이블)을 가지고 다수결 투표를 통해 최종 앙상블 예측
    # voting_clf = VotingClassifier(
    #     estimators=[('lr', log_clf), ('rf', rnd_clf), ('svc', svm_clf)],
    #     voting='hard')
    # voting_clf.fit(X_train, y_train)
    # voting_scores = cross_val_score(voting_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", voting_scores.mean())
    #
    # y_pred = voting_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # # 배깅을 이용한 앙상블 학습
    #
    # # estimators : 개별 모형 목록, 리스트나 named parameter 형식으로 입력
    # # max_sample : 각 기본 추정량을 훈련하기 위해 X에서 추출 할 샘플 수
    # # bootstrap : 교체로 샘플을 그릴 것인지 여부
    # # n_jobs : 적합 및 예측 모두 에 대해 병렬로 실행할 작업 수
    # print("----- 배깅을 이용한 앙상블 -----")
    # bag_clf = BaggingClassifier(
    #     DecisionTreeClassifier(random_state=42), n_estimators=500,
    #     max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    # bag_clf.fit(X_train, y_train)
    # bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", bag_scores.mean())
    #
    # y_pred = bag_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 배깅을 이용한 앙상블(max_depth=5) -----")
    # bag_clf = BaggingClassifier(
    #     DecisionTreeClassifier(random_state=42, max_depth=5), n_estimators=500,
    #     max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    # bag_clf.fit(X_train, y_train)
    # bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", bag_scores.mean())
    #
    # y_pred = bag_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 배깅을 이용한 앙상블(max_depth=4) -----")
    # bag_clf = BaggingClassifier(
    #     DecisionTreeClassifier(random_state=42, max_depth=4), n_estimators=500,
    #     max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    # bag_clf.fit(X_train, y_train)
    # bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", bag_scores.mean())
    #
    # y_pred = bag_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 배깅을 이용한 앙상블(max_depth=3) -----")
    # bag_clf = BaggingClassifier(
    #     DecisionTreeClassifier(random_state=42, max_depth=3), n_estimators=500,
    #     max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    # bag_clf.fit(X_train, y_train)
    # bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", bag_scores.mean())
    #
    # y_pred = bag_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()
    #
    # print("----- 배깅을 이용한 앙상블(max_depth=2) -----")
    # bag_clf = BaggingClassifier(
    #     DecisionTreeClassifier(random_state=42, max_depth=2), n_estimators=500,
    #     max_samples=100, bootstrap=True, n_jobs=-1, random_state=42)
    # bag_clf.fit(X_train, y_train)
    # bag_scores = cross_val_score(bag_clf, X_train, y_train, cv=10)
    # print("교차검증으로 나온 성능 :", bag_scores.mean())
    #
    # y_pred = bag_clf.predict(X_test)
    # print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))
    # print()


def case3(train_data, test_data, y_test):
    pass




if __name__ == "__main__":
    warnings.simplefilter(action='ignore')
    print("-- START --")
    train_data = load_titanic_data("train.csv")
    test_data = load_titanic_data("test.csv")
    y_test = load_titanic_data("gender_submission.csv")

    train_data.head()   # 데이터 확인
    train_data.info()   # 누락된 데이터 확인
    train_data.describe() # 통계확인

    # target 확인
    train_data["Survived"].value_counts()

    # print("-- Case1 --")
    # case1(train_data, test_data, y_test)
    print("-- Case2 --")
    case2(train_data, test_data, y_test)
    print("-- Case3 --")
    case3(train_data, test_data, y_test)

    print("-- END --")
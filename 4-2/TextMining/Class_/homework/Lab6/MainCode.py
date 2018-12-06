'''


'''

import os
import tarfile
import urllib.request
from builtins import range

import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.model_selection import StratifiedShuffleSplit
import matplotlib.pyplot as plt
from pandas.plotting import scatter_matrix
from sklearn.preprocessing import Imputer
from sklearn.preprocessing import OneHotEncoder
from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler
from sklearn.pipeline import FeatureUnion
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.tree import DecisionTreeRegressor
from sklearn.model_selection import cross_val_score
from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import GridSearchCV
from sklearn.model_selection import RandomizedSearchCV
from scipy.stats import randint

import warnings

warnings.filterwarnings('ignore')
HOUSING_PATH = os.path.join("datasets")


garageCars_ix, garageArea_ix = 26, 27
class CombinedAttributesAdder(BaseEstimator, TransformerMixin):
    def __init__(self, add_GarageCars_per_GarageArea=True):
        self.add_GarageCars_per_GarageArea = add_GarageCars_per_GarageArea

    def fit(self, X, y=None):
        return self

    def transform(self, X, y=None):
        if self.add_GarageCars_per_GarageArea:
            garageCars_per_GarageArea = X[:, garageCars_ix] / X[:, garageArea_ix]
            return np.c_[X, garageCars_per_GarageArea]
        else:
            return np.c_[X]


class DataFrameSelector(BaseEstimator, TransformerMixin):
    def __init__(self, attribute_names):
        self.attribute_names = attribute_names

    def fit(self, X, y=None):
        return self

    def transform(self, X):
        return X[self.attribute_names].values




def load_train_data(housing_path=HOUSING_PATH):
    csv_path = os.path.join(housing_path, "train.csv")
    return pd.read_csv(csv_path)



def display_scores(scores):
    print("Scores : ", scores)
    print("Mean : ", scores.mean())
    print("Standard deviation : ", scores.std(), end="\n\n")


'''
집값 예측하기
'''
if __name__ == "__main__":
    '''1) 데이터 준비'''
    salePrice = load_train_data()
    print(salePrice.info())

    '''2) 데이터 설명 '''
    # 데이터 형태 파악
    salePrice["SalePrice"].hist();
    plt.show()
    salePrice["SalePrice_cat"] = np.ceil(salePrice["SalePrice"] / 140000)
    salePrice["SalePrice_cat"].where(salePrice["SalePrice_cat"] < 4, 4.0, inplace=True)
    print(salePrice["SalePrice_cat"].value_counts())
    salePrice["SalePrice_cat"].hist();
    plt.show()
    ''' 
    문제 정의 : 주거용 주택의 다양한 변수로 주택의 최종 가격을 예측하는 문제입니다.
    데이터의 특징은 OverallQual(전체 재질 및 마감 품질), GrLivArea(주거 사용 가능한 면적)와 높은 양의 상관관계를 가지고 있고
    EnclosedPorch(현관면적), KitchenAbvGr(부엌 품질)와 낮은 음의 상관관계를 가지는 특징이 있다.
    '''

    '''3) 데이터 전처리'''
    train_set, test_set = train_test_split(salePrice, test_size=0.2, random_state=42, stratify=salePrice["SalePrice_cat"])

    # SalePrice_cat 삭제(계층적 샘플링 종료)
    for set_ in (train_set, test_set):
        set_.drop("SalePrice_cat", axis=1, inplace=True)

    # 상관관계확인
    print("----- 상관관계확인 -----")
    train_copy = train_set.copy()
    corr_matrix = train_copy.corr()
    print(corr_matrix["SalePrice"].sort_values(ascending=False))


    '''4) 특징 선택'''
    # 특성 제거
    train = train_set.drop("Alley", axis=1)
    train = train.drop("MSZoning", axis=1)
    train = train.drop("Street", axis=1)
    train = train.drop("LotShape", axis=1)
    train = train.drop("LandContour", axis=1)
    train = train.drop("Utilities", axis=1)
    train = train.drop("LotConfig", axis=1)
    train = train.drop("LandSlope", axis=1)
    train = train.drop("Neighborhood", axis=1)
    train = train.drop("Condition1", axis=1)
    train = train.drop("Condition2", axis=1)
    train = train.drop("BldgType", axis=1)
    train = train.drop("HouseStyle", axis=1)
    train = train.drop("RoofStyle", axis=1)
    train = train.drop("RoofMatl", axis=1)
    train = train.drop("Exterior1st", axis=1)
    train = train.drop("Exterior2nd", axis=1)
    train = train.drop("MasVnrType", axis=1)
    train = train.drop("ExterQual", axis=1)
    train = train.drop("ExterCond", axis=1)
    train = train.drop("Foundation", axis=1)
    train = train.drop("BsmtQual", axis=1)
    train = train.drop("BsmtCond", axis=1)
    train = train.drop("BsmtExposure", axis=1)
    train = train.drop("BsmtFinType1", axis=1)
    train = train.drop("BsmtFinType2", axis=1)
    train = train.drop("Heating", axis=1)
    train = train.drop("HeatingQC", axis=1)
    train = train.drop("CentralAir", axis=1)
    train = train.drop("Electrical", axis=1)
    train = train.drop("KitchenQual", axis=1)
    train = train.drop("Functional", axis=1)
    train = train.drop("FireplaceQu", axis=1)
    train = train.drop("GarageType", axis=1)
    train = train.drop("GarageFinish", axis=1)
    train = train.drop("GarageQual", axis=1)
    train = train.drop("GarageCond", axis=1)
    train = train.drop("PavedDrive", axis=1)
    train = train.drop("PoolQC", axis=1)
    train = train.drop("Fence", axis=1)
    train = train.drop("MiscFeature", axis=1)
    train = train.drop("SaleType", axis=1)
    train = train.drop("SaleCondition", axis=1)



    train_labels = train["SalePrice"].copy()
    train = train.drop("SalePrice", axis=1)
    print(train.info())
    # , "Street", "LotShape","LandContour", "Utilities", "LotConfig", "LandSlope", "Neighborhood", "Condition1", "Condition2", "BldgType", "HouseStyle"
    # ,"RoofStyle", "RoofMatl", "Exterior1st", "Exterior2nd", "MasVnrType", "ExterQual","ExterCond", "Foundation", "BsmtQual","BsmtCond", "BsmtExposure", "BsmtFinType1", "BsmtFinType2"
    # ,"Heating", "HeatingQC", "CentralAir", "Electrical", "KitchenQual", "Functional", "FireplaceQu", "GarageType", "GarageFinish", "GarageQual", "GarageCond", "PavedDrive", "PoolQC"
    # ,"Fence", "MiscFeature", "SaleType", "SaleCondition"]
    num_attr = list(train)
    # cat_attr = ["SaleCondition"]


    num_pipeline = Pipeline([
        ('selector', DataFrameSelector(num_attr)),
        ('attribs_adder', CombinedAttributesAdder()), # 평방 피트 단위의 차고 크기당 자동차 용량의 차고 크기
        ('imputer', Imputer(strategy="median")), # 빈값 채우기
        ('std_scaler', StandardScaler()), # 특징값 스케일링
    ])

    # cat_pipeline = Pipeline([
    #     ('selector', DataFrameSelector(cat_attr)),
    #     ('cat_encoder', OneHotEncoder(sparse=False)),
    # ])

    # full_pipeline = FeatureUnion(transformer_list=[
    #     ("cat_pipeline", cat_pipeline),
    #     ("num_pipeline", num_pipeline),
    #
    # ])

    salePrice_prepared = num_pipeline.fit_transform(train)
    # salePrice_prepared = full_pipeline.fit_transform(train)
    # print(housing_prepared)

    # print(salePrice_prepared)

    '''5) 모델 선택, 학습 및 평가'''
    print("-----"*5, "결과", "-----"*5)
    # 선형모델로 학습
    lin_reg = LinearRegression()
    lin_reg.fit(salePrice_prepared, train_labels)
    # lin_salePrice_predictions = lin_reg.predict(salePrice_prepared) # 예측
    # 교차 검증
    lin_scores = cross_val_score(lin_reg, salePrice_prepared, train_labels,
                             scoring="neg_mean_squared_error", cv=10)
    lin_rmse_score = np.sqrt(-lin_scores) # RMSE 오차 계산
    print("선형 모델 오차")
    display_scores(lin_rmse_score)

    # 결정 트리모델로 학습
    tree_reg = DecisionTreeRegressor()
    tree_reg.fit(salePrice_prepared, train_labels)
    # tree_salePrice_predictions = tree_reg.predict(salePrice_prepared) # 예측
    # 교차 검증
    tree_scores = cross_val_score(tree_reg, salePrice_prepared, train_labels,
                             scoring="neg_mean_squared_error", cv=10)
    tree_rmse_score = np.sqrt(-tree_scores)
    print("결정 트리 모델 오차")
    display_scores(tree_rmse_score)

    # 랜덤 포레스트 모델로 학습
    forest_reg = RandomForestRegressor()
    forest_reg.fit(salePrice_prepared, train_labels)
    # forest_salePrice_predictions = forest_reg.predict(salePrice_prepared)  # 예측
    # 교차 검증
    forest_scores = cross_val_score(forest_reg, salePrice_prepared, train_labels,
                             scoring="neg_mean_squared_error", cv=10)
    forest_rmse_score = np.sqrt(-forest_scores)
    print("랜덤 포레스트 모델 오차")
    display_scores(forest_rmse_score)

    # 그리드 탐색
    param_grid = [
        {'n_estimators': [3,10,30], 'max_features': [2,4,6,8]},
        {'bootstrap': [False], 'n_estimators': [3, 10], 'max_features': [2,3,4]}
    ]

    grid_seach = GridSearchCV(forest_reg, param_grid, cv=10,
                              scoring='neg_mean_squared_error',
                              return_train_score=True)
    grid_seach.fit(salePrice_prepared, train_labels)
    print("그리드 탐색 오차")
    print(grid_seach.best_params_)
    print(grid_seach.best_estimator_)

    # 랜덤 탐색
    param_distribs = {'n_estimators': randint(low=1, high=200),
                      'max_features': randint(low=1, high=8),
    }

    forest_reg_rand = RandomForestRegressor(random_state=42)
    rnd_seach = RandomizedSearchCV(forest_reg_rand, param_distributions=param_distribs, n_iter=10, cv=5,
                                   scoring='neg_mean_squared_error', random_state=42, n_jobs=-1)
    rnd_seach.fit(salePrice_prepared, train_labels)
    print("rnd_seach 탐색 오차")
    cvres = rnd_seach.cv_results_
    for mean_score, params in zip(cvres["mean_test_score"], cvres["params"]):
        print(np.sqrt(-mean_score), params)


    feature_importances = grid_seach.best_estimator_.feature_importances_
    print(feature_importances)



    #최종 테스트
    final_model = grid_seach.best_estimator_

    X_test = test_set.drop("SalePrice", axis=1)
    Y_test = test_set["SalePrice"].copy()

    X_test_prepared = num_pipeline.transform(X_test)
    final_prediction = final_model.predict(X_test_prepared)

    final_rmse = np.sqrt(mean_squared_error(Y_test, final_prediction))
    print("최종 테스트")
    print(final_rmse)

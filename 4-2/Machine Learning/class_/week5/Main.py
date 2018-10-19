
from class_.week5 import DownloadData as load
from class_.week6 import AttributeAdder as w6
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from pandas.plotting import scatter_matrix
from sklearn.model_selection import train_test_split
from sklearn.model_selection import StratifiedShuffleSplit
import warnings

warnings.filterwarnings('ignore')

if __name__=="__main__":
    load.fetch_housing_data()
    housing = load.load_housing_data()

    """
    # 블록주석(쌍따옴표 3개)도 들여쓰기(indent) 레벨이 맞을 맞춰야한다.
    
    train_set, test_set을 위한 랜덤 추출

    train_set, test_set = training.split_train_test(housing, 0.2)
    print(len(train_set), "train +", len(test_set), "test")

    # 위아래 같은 소스 

    sklearn을 사용하여 테스트셋과 트레이닝셋을 구분
    train_set, test_set = train_test_split(housing, test_size=0.2, random_state=42)
    print(len(train_set), "train +", len(test_set), "test")

    # 중간 소득의 히스토그램을 조금 더 자세히 살펴본다.
    housing["median_income"].hist(bins=16, range=[0.0, 16.0])
    plt.show()
    """

    # 카테고리 개수를 제한하기 위해 1.5로 나눈다.
    housing["income_cat"] = np.ceil(housing["median_income"] / 1.5)
    # 5 이상은 5로 레이블한다.
    housing["income_cat"].where(housing["income_cat"] < 5, 5.0, inplace=True)
    print(housing["income_cat"].value_counts())

    """
    # 소득 카테로리르 기반으로 계층 샘플링하기
    split = StratifiedShuffleSplit(n_splits=1, test_size=0.2, random_state=42)
    for train_index, test_index in split.split(housing, housing["income_cat"]) :
        strat_train_set = housing.loc[train_index]
        strat_test_set = housing.loc[test_index]
    """

    # 계층적 샘플링
    train_set, test_set = train_test_split(housing, test_size=0.2, random_state=42, stratify=housing["income_cat"])
    print(test_set["income_cat"].value_counts() / len(test_set))
    print()
    print(train_set["income_cat"].value_counts() / len(train_set))

    # income_cat특성을 삭제
    for set_ in (train_set, test_set):
        set_.drop("income_cat", axis=1, inplace=True)

    """
    train_copy = train_set.copy()
    # 지리정보로 모든 구역을 산점도 표현
    ax = train_copy.plot(kind="scatter", x="longitude", y="latitude", alpha=0.3)
    # plt.show()

    # 지리정보+주택가격을 컬러맵으로 표현
    ax = train_copy.plot(kind="scatter", x="longitude", y="latitude", alpha=0.4,
                         s=train_copy["population"]/100, label="population", figsize=(10,7),
                         c="median_house_value", cmap=plt.get_cmap("jet"), colorbar=True,
                         sharex=False)
    # plt.legend()
    # plt.show()

    # median_house_value를 기준으로 상관관계 파악
    train_copy = train_set.copy()
    corr_matrix = train_copy.corr()
    print(corr_matrix["median_house_value"].sort_values(ascending=False))

    # 상관관계를 조사를 위한 산점도
    attributes = ["median_house_value", "median_income", "total_rooms", "housing_median_age"]
    scatter_matrix(train_copy[attributes], figsize=(12, 8))

    train_copy["rooms_per_household"] = train_copy["total_rooms"] / train_copy["households"]
    train_copy["bedrooms_per_room"] = train_copy["total_bedrooms"] / train_copy["total_rooms"]
    train_copy["population_per_household"] = train_copy["population"] / train_copy["households"]

    corr_matrix = train_copy.corr()
    print(corr_matrix["median_house_value"].sort_values(ascending=False))
    """


    train = train_set.drop("median_house_value", axis=1)
    train_labels = train_set["median_house_value"].copy()


    """
    sample_incomplete_rows = train[train.isnull().any(axis=1)].head()
    print(sample_incomplete_rows)
    """

    # 빈 값 대체
    from sklearn.preprocessing import Imputer

    imputer = Imputer(strategy="median")

    housing_num = train.drop("ocean_proximity", axis=1)
    imputer.fit(housing_num)

    print(imputer.statistics_)
    print(housing_num.median().values)

    # 빈 값 대체
    X = imputer.transform(housing_num)
    housing_tr = pd.DataFrame(X, columns=housing_num.columns, index=list(train.index.values))

    print(housing_tr.head(), end="\n\n")
    print(housing.iloc[17606])

    housing_cat = train["ocean_proximity"]
    print(housing_cat.head(10), end="\n\n")

    housing_cat_encoded, housing_categories = housing_cat.factorize()
    print(housing_cat_encoded[:10])
    print(housing_categories)


    from sklearn.preprocessing import OneHotEncoder
    encoder = OneHotEncoder()
    housing_cat_onehot = encoder.fit_transform(housing_cat_encoded.reshape(-1, 1))
    print(housing_cat_onehot)

    print(housing_cat_onehot.toarray())
"""
    from sklearn.preprocessing import LabelBinarizer
    encoder = LabelBinarizer()
    housing_cat_onehot = encoder.fit_transform(housing_cat)
    print(housing_cat_onehot)

    print(pd.get_dummies(housing_cat).values)
    print(pd.get_dummies(housing))
"""

############## week6 ##############
## 특성 스케일링
attr_adder = w6.CombinedAttributesAdder(add_bedrooms_per_room=False)
housing_extra_attribs = attr_adder.transform(train.values)

from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler

# 전처리 단계 연결
num_pipeline = Pipeline([
    ('imputer' , Imputer(strategy="median")),
    ('attribs_adder', w6.CombinedAttributesAdder()),
    ('std_scaler', StandardScaler()),
])

###
housing_num_tr = num_pipeline.fit_transform(housing_num)
from sklearn.pipeline import make_pipeline
num_pipeline2 = make_pipeline(Imputer(strategy="median"),
                              w6.CombinedAttributesAdder(), StandardScaler())
housing_num_tr2 = num_pipeline2.fit_transform(housing_num)
###

num_attr = list(housing_num)
cat_attr = ["ocean_proximity"]

#  변환 파이프 라인 사용 DataFrameSelector
num_pipeline = Pipeline([
    ('selector', w6.DataFrameSelector(num_attr)),
    ('imputer', Imputer(strategy="median")),
    ('attribs_adder', w6.CombinedAttributesAdder()),
    ('std_scaler', StandardScaler()),
])

cat_pipeline = Pipeline([
    ('selector', w6.DataFrameSelector(cat_attr)),
    ('cat_encoder', OneHotEncoder(sparse=False)),
])
print(num_pipeline.steps)

from sklearn.pipeline import FeatureUnion
full_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])



# train.fillna(train.mean(), inplace=True)

housing_prepared = full_pipeline.fit_transform(train)
print(housing_prepared)
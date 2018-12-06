from class_.Lab8 import DataFrameSelector as dfs
from class_.Lab8 import MostFrequentImputer as mfi
import os
import pandas as pd


TITANIC_PATH = os.path.join("datasets", "titanic")

def load_titanic_data(filename, titanic_path=TITANIC_PATH):
    csv_path = os.path.join(titanic_path, filename)
    return pd.read_csv(csv_path)

if __name__ == "__main__":
    train_data = load_titanic_data("train.csv")
    test_data = load_titanic_data("test.csv")
    y_test = load_titanic_data("gender_submission.csv")

    train_data.head()   # 데이터 확인
    train_data.info()   # 누락된 데이터 확인
    train_data.describe() # 통계확인

    # target 확인
    train_data["Survived"].value_counts()

    # 범주형 데이터 확인
    #print(train_data["Pclass"].value_counts())
    #print(train_data["Sex"].value_counts())
    #print(train_data["Embarked"].value_counts())

    # Case 1
    from sklearn.pipeline import Pipeline
    from sklearn.impute import SimpleImputer

    print(train_data)
    num_pipeline = Pipeline([
        ("select_numeric", dfs.DataFrameSelector(["Age", "SibSp", "Parch", "Fare"])),
        ("imputer", SimpleImputer(strategy="median")),
    ])

    print(num_pipeline.fit_transform(train_data))

    from sklearn.base import BaseEstimator, TransformerMixin
    from sklearn.preprocessing import OneHotEncoder

    cat_pipeline = Pipeline([
        ("select_cat", dfs.DataFrameSelector(["Pclass", "Sex", "Embarked"])),
        ("imputer", mfi.MostFrequentImputer()),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])

    # print(cat_pipeline.fit_transform(train_data))
    from sklearn.pipeline import FeatureUnion

    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline),
        ("cat_pipeline", cat_pipeline),
    ])

    '''
    # Case 2
    from sklearn.compose import ColumnTransformer
    num_pipeline = Pipeline([
        ("imputer", SimpleImputer(strategy="median")),
    ])
    cat_pipeline = Pipeline([
        ("imputer", mfi.MostFrequentImputer(strategy="median")),
        ("cat_encoder", OneHotEncoder(sparse=False)),
    ])
    preprocess_pipeline = FeatureUnion(transformer_list=[
        ("num_pipeline", num_pipeline,["Age", "SibSp", "Parch", "Fare"]),
        ("cat_pipeline", cat_pipeline, ["Pclass", "Sex", "Embarked"]),
    ])
    '''
    # pandas만 ?
    X_train = preprocess_pipeline.fit_transform(train_data)
    y_train = train_data["Survived"]

    from sklearn.svm import SVC
    from sklearn.ensemble import RandomForestClassifier
    from sklearn.model_selection import cross_val_score

    svm_clf = SVC(gamma="auto")
    svm_clf.fit(X_train, y_train)
    svm_scores = cross_val_score(svm_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :",svm_scores.mean())

    X_test = preprocess_pipeline.transform(test_data)
    y_pred = svm_clf.predict(X_test)

    y_test = y_test["Survived"].values
    print("테스트결과 :",(y_test == y_pred).sum() / len(y_test))

    forest_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    forest_clf.fit(X_train, y_train)

    forest_scores = cross_val_score(forest_clf, X_train, y_train, cv=10)
    print("교차검증으로 나온 성능 :", forest_scores.mean())

    y_pred = forest_clf.predict(X_test)
    print("테스트결과 :", (y_test == y_pred).sum() / len(y_test))

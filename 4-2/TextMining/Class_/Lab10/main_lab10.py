from sklearn import datasets
import numpy as np
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler
from sklearn.svm import LinearSVC
from sklearn.svm import SVC

if __name__=="__main__":
    iris = datasets.load_iris() # 데이터 다운

    # 선형 SVM 분류 - 소프트 마진 분류
    print("선형 SVM 분류 - 소프트 마진 분류")
    X = iris["data"][: ,(2 ,3)]
    y = (iris["target"] == 2).astype(np.float64)

    svm_clf = Pipeline([
        ("scaler", StandardScaler()),
        ("linear_svc", LinearSVC(C=1, loss="hinge", random_state=42)),
    ])

    svm_clf.fit(X, y)
    print(svm_clf.predict([[5.5, 1.7]]))

    # 비선형 SVM 분류 - 다항식 커널
    poly_kernel_svm_clf = Pipeline([
        ("scaler", StandardScaler()),
        ("svm_clf", SVC(kernel="poly", degree=3, coef0=1, C=5))
    ])
    poly_kernel_svm_clf.fit(X, y)


    # 비선형 SVM 분류 - 가우시안 RBF 커널
    rbf_kernel_svm_clf = Pipeline([
        ("scaler", StandardScaler()),
        ("svm_clf", SVC(kernel="rbf", gamma=5, C=0.001))
    ])
    rbf_kernel_svm_clf.fit(X, y)
    print()
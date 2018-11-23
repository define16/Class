from sklearn import datasets
import numpy as np
from sklearn.linear_model import LogisticRegression

import matplotlib.pyplot as plt
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split

from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler
from sklearn.svm import LinearSVC
from sklearn.svm import SVC

def plot_gradient_descent(theta, eta, theta_path=None):
    m = len(X)
    plt.plot(X, y, "b.")
    n_iterations = 1000
    for iteration in range(n_iterations):
        if iteration < 10:
            y_predict = X_new.dot(theta)
            style = "b-" if iteration > 0 else "r--"
            plt.plot(X_new, y_predict, style)
        gradients = 2/m * X.T.dot(X.dot(theta) - y)
        theta = theta - eta * gradients
        if theta_path is not None:
            theta_path.append(theta)
    plt.xlabel("$x_1$", fontsize=18)
    plt.axis([0, 2, 0, 15])
    plt.title(r"$\eta = {}$".format(eta), fontsize=16)


def plot_learning_curves(model, X, y):
    X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=10)
    train_errors, val_errors = [], []
    for m in range(1, len(X_train)):
        model.fit(X_train[:m], y_train[:m])
        y_train_predict = model.predict(X_train[:m])
        y_val_predict = model.predict(X_val)
        train_errors.append(mean_squared_error(y_train[:m], y_train_predict))
        val_errors.append(mean_squared_error(y_val, y_val_predict))

    plt.plot(np.sqrt(train_errors), "r-+", linewidth=2, label="train")
    plt.plot(np.sqrt(val_errors), "b-", linewidth=3, label="validation")
    plt.legend(loc="upper right", fontsize=14)
    plt.xlabel("train set size", fontsize=14)
    plt.ylabel("RMSE", fontsize=14)

# def plot_model(model_class, polynomial, alphas, **model_kargs):
#     for alpha, style in zip(alphas, ("b-", "g--", "r:")):
#         model = model_class(alpha, **model_kargs) if alpha > 0 else LinearRegression()
#         if polynomial:
#             model = Pipeline([
#                     ("poly_features", PolynomialFeatures(degree=10, include_bias=False)),
#                     ("std_scaler", StandardScaler()),
#                     ("regul_reg", model),
#                 ])
#         model.fit(X, y)
#         y_new_regul = model.predict(X_new)
#         lw = 2 if alpha > 0 else 1
#         plt.plot(X_new, y_new_regul, style, linewidth=lw, label=r"$\alpha = {}$".format(alpha))
#     plt.plot(X, y, "b.", linewidth=3)
#     plt.legend(loc="upper left", fontsize=15)
#     plt.xlabel("$x_1$", fontsize=18)
#     plt.axis([0, 3, 0, 4])

if __name__=="__main__":
    iris = datasets.load_iris() # 데이터 다운
    print(list(iris.keys())) # 품종이 Iris-Virginica이면 1, 아니면 0

    print(iris.DESCR)
    X = iris["data"][:, 3:] # 꽃잎 넓이
    y = (iris["target"] == 2).astype(np.int)



    # some_digit = X[36000]
    # some_digit_image = some_digit.reshape(28,28)
    # plt.imshow(some_digit_image, cmap=matplotlib.cm.binary, interpolation="nearest")
    # plt.axis("off")
    # plt.show()


    log_reg = LogisticRegression()
    log_reg.fit(X, y)

    X_new = np.linspace(0, 3, 1000).reshape(-1, 1)
    y_proba = log_reg.predict_proba(X_new)
    decision_boundary = X_new[y_proba[:, 1] >= 0.5][0]

    # 양쪽의 확률이 똑같이 50%가 되는 1.6cm 근방에서 결정 경계
    print(log_reg.predict([[1.7], [1.5]]))

    X = iris["data"][:, (2, 3)]
    y = (iris["target"] == 2).astype(np.int)

    # 꽃잎 너비와 꽃잎 길이 두 개의 특성으로 훈련 및 예측
    log_reg = LogisticRegression(solver="liblinear", C=10**10, random_state=42)
    log_reg.fit(X, y)
    print(log_reg.predict([[4.0, 1.0], [6.0, 2.5]]))

    X = iris["data"][:, (2,3)]
    y = iris["target"]

    softmax_reg = LogisticRegression(multi_class="multinomial", solver="lbfgs", C=10, random_state=42)
    softmax_reg.fit(X, y)

    print(softmax_reg.predict([[5,2]]))
    print(softmax_reg.predict_proba([[5,2]]))

    # 선형 SVM 분류 - 소프트 마진 분류
    print("선형 SVM 분류 - 소프트 마진 분류")
    X = iris["data"][:,(2,3)]
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
import os
import urllib.request
from sklearn.datasets import fetch_mldata
import matplotlib.pyplot as plt
import numpy as np
from sklearn.base import BaseEstimator
import matplotlib
import imp

class Naver5Classifier(BaseEstimator) :
    def fit(self,X, y=None):
        pass
    def predict(self,X):
        return np.zeros((len(X),1),dtype=bool)


def download_mnist_data(url, path):
    path = os.path.join(path,"mldata")
    if not os.path.isdir(path):
        os.makedirs(path)

    filename = os.path.basename(url)
    filepath = os.path.join(path, filename)

    if not os.path.isfile(filepath):
        urllib.request.urlretrieve(url, filepath)

def plot_precision_recall_vs_threshold(precisions, recalls, thresholds):
    plt.plot(thresholds, precisions[:-1], "b--", label="precision")
    plt.plot(thresholds, recalls[:-1], "g-", label="recall")
    plt.xlabel("threshold")
    plt.legend(loc="center left")
    plt.xlim([-600000, 600000])
    plt.ylim([0,1])

# Receiver Operationg Characteristic : roc_curve() 함수를 사용해 여러 임계값에서 TPR과 FPR을 계산해야 한다.
def plot_roc_curve(fpr, tpr, label=None):
    plt.plot(fpr, tpr, linewidth=2, label=label)
    plt.plot([0,1],[0,1], 'k--')
    plt.axis([0,1,0,1])
    plt.xlabel('FPR')
    plt.ylabel('TPR')


def plot_digits(instatances, images_per_row=10, **options):
    size = 28
    images_per_row = min(len(instatances), images_per_row)
    images = [instatances.reshape(size, size) for instance in instatances]
    n_rows = (len(instatances) - 1) // images_per_row + 1
    row_images = []
    n_empty = n_rows * images_per_row - len(instatances)
    images.append(np.zeros(size, size * n_empty))
    for row in range(n_rows) :
        rimages = images[row * images_per_row : (row + 1) * images_per_row]
        row_images.append(np.concatenate(rimages, axis=1))
    image = np.concatenate(row_images, axis=0)
    plt.imshow(image, cmap=matplotlib.cm.binary, **options)
    plt.axis("off")

# 노이즈가 추가된 이미지 확인 코드
def plot_digit(data) :
    image = data.reshape(28, 28)
    plt.imshow(image, cmap=matplotlib.cm.binary, interpolation="nearest")
    plt.axis("off")





if __name__ == "__main__" :
    url = "http://210.115.230.193/data/mnist-original.mat"
    data_home = "datasets"
    download_mnist_data(url, data_home)
    mnist =fetch_mldata('MNIST original', data_home=data_home)
    print("데이터 셋 확인")
    print(mnist)

    # 형상 확인
    X, y = mnist["data"], mnist["target"]
    print("이미지가 70,000개가 있고 각 이미지에는 784개의 특성이 있음")
    print(X.shape, y.shape)

    # 샘플의 특성을 추출해서 28 * 28 배열로 크기를 바꾸고 이미지를 확인한다.
    some_digit = X[36000]
    # some_digit_image = some_digit.reshape(28,28)
    # plt.imshow(some_digit_image, cmap=matplotlib.cm.binary, interpolation="nearest")
    # plt.axis("off")
    # plt.show()
    print("이미지 확인")
    print(y[36000])

    # MNIST 데이터셋은 이미 훈련 세트(앞의 60,000개의 이미지)와 테스트 세트(뒤의 10,000개의 이미지)로 나뉘어 있다.
    X_train, X_test, y_train, y_test = X[:60000], X[60000:], y[:60000], y[60000:]
    shuffle_index = np.random.permutation(60000)

    # 훈련 세트를 섞어서 모든 교차 검증 폴드가 비슷해지도록 만든다.
    X_train, y_train = X_train[shuffle_index], y_train[shuffle_index]


    # 문제를 단순화해서 하나의 숫자, 예를 들어 5만 식별해본다.
    y_train_5 = (y_train == 5)
    y_test_5 = (y_test == 5)

    from sklearn.linear_model import SGDClassifier
    sgd_clf = SGDClassifier(max_iter=5, random_state=42)
    sgd_clf.fit(X_train, y_train_5)

    sgd_clf.predict([X[36000]])

    print("SGDClassifier 예측값 :",sgd_clf.predict([X[36000]]))


    #교차 검증을 사용한 정확도 측정
    from sklearn.model_selection import StratifiedKFold
    from sklearn.base import clone

    skfolds = StratifiedKFold(n_splits=3, random_state=42)

    # 교차 검증 구현
    print("교차 검증 값")
    # for train_index, test_index in skfolds.split(X_train, y_train_5):
    #     clone_clf = clone(sgd_clf)
    #     X_train_folds = X_train[train_index]
    #     y_train_folds = y_train_5[train_index]
    #     X_test_fold = X_train[test_index]
    #     y_test_fold = y_train_5[test_index]
    #
    #     clone_clf.fit(X_train_folds, y_train_folds)
    #     y_pred = clone_clf.predict(X_test_fold)
    #     n_correct = sum(y_pred == y_test_fold)
    #     print(n_correct / len(y_pred))

    from sklearn.model_selection import cross_val_score

    print(cross_val_score(sgd_clf, X_train, y_train_5, cv=3, scoring="accuracy"))

    # 모든 이미지를 5가아님 클래스로 분류하는 더미 분류기를 만들어서 비교하는 과정
    # never_5_clf = Naver5Classifier()
    # print("Naver5Classifier 교차검증값 ")
    # print(cross_val_score(never_5_clf, X_train, y_train_5, cv=3, scoring="accuracy"))

    from sklearn.model_selection import cross_val_predict
    from sklearn.metrics import confusion_matrix

    # K-겹 교차 검증을 수행하지만, 평가점수를 반환하지 않고 각 테스트 폴드에서 얻은 예측을 반환
    y_train_pred = cross_val_predict(sgd_clf, X_train, y_train_5, cv=3)
    y_train_pred_no_cv = sgd_clf.predict(X_train)
    print("K-겹 교차 검증을 수행하지만, 평가점수를 반환하지 않고 각 테스트 폴드에서 얻은 예측을 반환")
    print(confusion_matrix(y_train_5, y_train_pred))
    print(confusion_matrix(y_train_5, y_train_pred_no_cv))

    from sklearn.metrics import precision_score, recall_score
    print("정밀도 :",precision_score(y_train_5, y_train_pred)) # 정밀도
    print("재현율 :",recall_score(y_train_5, y_train_pred)) # 재현율

    from sklearn.metrics import f1_score
    print("f1 Score :",f1_score(y_train_5, y_train_pred))

    # y_scores = sgd_clf.decision_function([some_digit])
    # print(y_scores)
    #
    # threshold = 0;
    # y_some_digit_pred = (y_scores > threshold)
    # print(y_some_digit_pred)

    from sklearn.metrics import precision_recall_curve

    y_scores = cross_val_predict(sgd_clf, X_train, y_train_5, cv=3, method="decision_function")
    precisions, recalls, thresholds = precision_recall_curve(y_train_5, y_scores)

    # plot_precision_recall_vs_threshold(precisions, recalls, thresholds)
    # plt.show()

    # y_train_pred_90 = (y_scores > 70000)
    #
    # print("정밀도 90%에 해당하는 모델")
    # print(precision_score(y_train_5, y_train_pred_90))
    # print(recall_score(y_train_5, y_train_pred_90))

    from sklearn.metrics import roc_curve

    # roc_curve() 함수를 사용해 여러 임계값에서 TPR과 FPR을 계산한 그래프
    # fpr, tpr, thresholds = roc_curve(y_train_5, y_scores)
    # plot_roc_curve(fpr, tpr) # 여러 임계값에서 TPR과 FPR을 계산
    # plt.show()


    print("ROC의 AUC를 계산하는 함수")
    from sklearn.metrics import roc_auc_score
    print(roc_auc_score(y_train_5, y_scores))

    from sklearn.ensemble import RandomForestClassifier

    forest_clf = RandomForestClassifier(random_state=42)
    y_probas_forest = cross_val_predict(forest_clf, X_train, y_train_5, cv=3, method="predict_proba")

    y_scores_forest = y_probas_forest[:, 1]
    fpr_forest, tpr_forest, thresholds_forest = roc_curve(y_train_5, y_scores_forest)

    #  SGDClassfier의 ROC 곡선과 ROC AUC 점수로 그린 그래프
    # plt.plot(fpr, tpr, "b:", label="SGD")
    # plot_roc_curve(fpr_forest, tpr_forest, "RandomForest")
    # plt.legend(loc="lower right")
    # plt.show()

    # 다중 클래스 분류 작업
    sgd_clf.fit(X_train, y_train)
    sgd_clf.predict([some_digit])
    # decision_function() 함수를 사용해 클래스 마다 하나씩 10개의 점수를 확인
    some_digit_scores = sgd_clf.decision_function([some_digit])
    print("클래스 마다 하나씩 10개의 점수를 확인")
    print(some_digit_scores)
    # 가장 높은 점수는 클래스 5에 해당하는 값
    print("가장 높은 점수는 클래스 5에 해당하는 값")
    print(np.argmax(some_digit_scores))
    print(sgd_clf.classes_)
    print(sgd_clf.classes_[5])

    from sklearn.multiclass import OneVsOneClassifier
    ovo_clf = OneVsOneClassifier(SGDClassifier(max_iter=5, random_state=42))
    ovo_clf.fit(X_train, y_train)
    print("OneVsOneClassifier 예측값 :",ovo_clf.predict([some_digit]))

    print(len(ovo_clf.estimators_))

    forest_clf.fit(X_train, y_train)
    print("RandomForestClassifier")
    print(forest_clf.predict([some_digit]))
    print(forest_clf.predict_proba([some_digit]))

    # 분류기 평가
    print("분류기평가")
    print(cross_val_score(sgd_clf, X_train, y_train, cv=3, scoring="accuracy"))

    from sklearn.preprocessing import  StandardScaler
    scaler = StandardScaler()
    X_train_scaled = scaler.fit_transform(X_train.astype(np.float64))
    print(cross_val_score(sgd_clf, X_train_scaled, y_train, cv=3, scoring="accuracy"))
    # 모델의 성능 향상을 위한 에러의 종류를 분석
    y_train_pred = cross_val_predict(sgd_clf,X_train_scaled, y_train, cv=3)
    conf_mx = confusion_matrix(y_train, y_train_pred)
    print(conf_mx)

    # plt.matshow(conf_mx, cmap=plt.cm.gray)
    # plt.show()

    # 그래프의 에러 부분에 초점을 맞춤 다른 항목은 유지하고 주대각선만 0으로 채워서 그래프를 그림
    # row_sums = conf_mx.sum(axis=1, keepdims=True)
    # norm_conf_mx = conf_mx / row_sums
    # np.fill_diagonal(norm_conf_mx, 0)
    # plt.matshow(norm_conf_mx, cmap=plt.cm.gray)
    # plt.show()

    # cl_a, cl_b = 3,5
    # x_aa = X_train[(y_train == cl_a) & (y_train_pred == cl_a)]
    # x_ab = X_train[(y_train == cl_a) & (y_train_pred == cl_b)]
    # x_ba = X_train[(y_train == cl_b) & (y_train_pred == cl_a)]
    # x_bb = X_train[(y_train == cl_b) & (y_train_pred == cl_b)]

    # 3과 5의 결과를 확인+
    # plt.figure(figsize=(8,8))
    # plt.subplot(221); plot_digits(x_aa[:25], images_per_row=5)
    # plt.subplot(222); plot_digits(x_ab[:25], images_per_row=5)
    # plt.subplot(223); plot_digits(x_ba[:25], images_per_row=5)
    # plt.subplot(224); plot_digits(x_bb[:25], images_per_row=5)
    # plt.show()

    from sklearn.neighbors import KNeighborsClassifier

    y_train_large = (y_train >= 7)
    y_train_odd = (y_train % 2 == 1)
    y_multilabel = np.c_[y_train_large, y_train_odd]

    knn_clf = KNeighborsClassifier()
    knn_clf.fit(X_train, y_multilabel)

    print("KNeighborsClassifier 결과 :",knn_clf.predict([some_digit]))

    # y_train_knn_pred = cross_val_predict(knn_clf, X_train, y_multilabel, cv=3, n_jobs=-1)
    # print(f1_score(y_multilabel, y_train_knn_pred, average="macro"))

    noise = np.random.randint(0,100,(len(X_train), 784))
    X_train_mod = X_train + noise
    noise = np.random.randint(0,100,(len(X_test), 784))
    X_test_mod = X_test + noise
    y_train_mod = X_train
    y_test_mod = X_test

    some_index = 5500
    # plt.subplot(121); plot_digit(X_test_mod[some_index])
    # plt.subplot(122); plot_digit(X_test_mod[some_index])
    # plt.show()

    knn_clf.fit(X_train_mod, y_train_mod)
    print(knn_clf.predict(y_test_mod))
    clean_digit = knn_clf.predict([X_test_mod[some_index]])
    plot_digit(clean_digit)

    plt.show()


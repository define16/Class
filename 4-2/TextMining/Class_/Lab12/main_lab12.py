from sklearn.model_selection import train_test_split
from sklearn.datasets import make_moons

if __name__=="__main__":
    X, y = make_moons(n_samples=500, noise=0.30, random_state=42)
    X_train, X_test, y_train, y_test = train_test_split(X, y, random_state=42)

    # 투표 기반 분류기
    from sklearn.ensemble import RandomForestClassifier
    from sklearn.ensemble import VotingClassifier
    from sklearn.linear_model import LogisticRegression
    from sklearn.svm import SVC


    # voting='hard'(직접 투표)인 경우
    print("------ voting='hard'(직접 투표)인 경우 ------")
    log_clf = LogisticRegression(solver='liblinear', random_state=42)
    rnd_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    svm_clf = SVC(gamma='auto', random_state=42)

    voting_clf = VotingClassifier(
        estimators=[('lr', log_clf), ('rf', rnd_clf), ('svc', svm_clf)],
        voting='hard'
    )
    voting_clf.fit(X_train, y_train)

    from sklearn.metrics import accuracy_score

    for clf in (log_clf, rnd_clf, svm_clf, voting_clf):
        clf.fit(X_train, y_train)
        y_pred = clf.predict(X_test)
        print(clf.__class__.__name__, accuracy_score(y_test, y_pred))


    # voting='soft'(간접 투표)인 경우
    print("------ voting='soft'(간접 투표)인 경우 ------")
    log_clf = LogisticRegression(solver='liblinear', random_state=42)
    rnd_clf = RandomForestClassifier(n_estimators=10, random_state=42)
    svm_clf = SVC(gamma='auto', probability=True,random_state=42)

    voting_clf = VotingClassifier(
        estimators=[('lr', log_clf), ('rf', rnd_clf), ('svc',svm_clf)],
        voting='soft'
    )

    voting_clf.fit(X_train, y_train)

    for clf in (log_clf, rnd_clf, svm_clf, voting_clf):
        clf.fit(X_train, y_train)
        y_pred = clf.predict(X_test)
        y_pred = clf.predict(X_test)
        print(clf.__class__.__name__, accuracy_score(y_test, y_pred))

    from sklearn.ensemble import BaggingClassifier
    from sklearn.tree import DecisionTreeClassifier


    #  배깅
    print("------ 배깅(bootstrap=True) ------")
    # n_jobs : 사용 코어 갯수
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42), n_estimators=500, max_samples=100,
        bootstrap=True, n_jobs=-1, random_state=42)

    bag_clf.fit(X_train, y_train)
    y_pred = bag_clf.predict(X_test)

    from sklearn.metrics import accuracy_score
    print(accuracy_score(y_test, y_pred))

    tree_clf = DecisionTreeClassifier(random_state=42)
    tree_clf.fit(X_train, y_train)
    y_pred_tree = tree_clf.predict(X_test)
    print(accuracy_score(y_test, y_pred_tree))

    #  배깅 (oob_score평가)
    print("------ 배깅 (oob_score평가) ------")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(random_state=42), n_estimators=500, max_samples=100,
        bootstrap=True, n_jobs=-1, oob_score=True, random_state=40)

    bag_clf.fit(X_train, y_train)
    print(bag_clf.oob_score_)

    y_pred = bag_clf.predict(X_test)
    print(accuracy_score(y_test, y_pred))

    from sklearn.ensemble import RandomForestClassifier
    import numpy as np

    #랜덤 포레스트
    print("------ 랜덤 포레스트 ------")
    bag_clf = BaggingClassifier(
        DecisionTreeClassifier(splitter="random", max_leaf_nodes=16, random_state=42),
        n_estimators=500, max_samples=1.0, bootstrap=True, n_jobs=-1, random_state=42)

    bag_clf.fit(X_train, y_train)
    y_pred = bag_clf.predict(X_test)

    rnd_clf = RandomForestClassifier(n_estimators=500, max_leaf_nodes=16, n_jobs=-1, random_state=42)
    rnd_clf.fit(X_train, y_train)

    y_pred_rf = rnd_clf.predict(X_test)
    print(np.sum(y_pred == y_test) / len(y_test))
    print(np.sum(y_pred_rf == y_test) / len(y_test))

    print("------ 랜덤 포레스트 (특성 중요도) ------")
    from sklearn.datasets import load_iris
    iris = load_iris()
    rnd_clf = RandomForestClassifier(n_estimators=500, n_jobs=-1, random_state=42)
    rnd_clf.fit(iris["data"], iris["target"])
    for name, score in zip(iris["feature_names"], rnd_clf.feature_importances_):
        print(name, score)

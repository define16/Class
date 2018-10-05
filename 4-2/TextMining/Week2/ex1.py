from multiprocessing import Pipe

from sklearn.datasets import fetch_20newsgroups
twenty_train = fetch_20newsgroups(subset='train', shuffle=True)

from sklearn.feature_extraction.text import CountVectorizer
count_vect = CountVectorizer()
X_train_counts = count_vect.fit_transform(twenty_train.data)
print("Count Vector : ", X_train_counts.shape)

from sklearn.feature_extraction.text import TfidfTransformer
tfidf_transformer = TfidfTransformer()

X_train_tfidf = tfidf_transformer.fit_transform(X_train_counts)
print("Tfidf : ", X_train_tfidf.shape)

print("------ Naive Bayes algorithm ------")
from sklearn.naive_bayes import MultinomialNB
clf = MultinomialNB().fit(X_train_tfidf, twenty_train.target)

from sklearn.pipeline import Pipeline
text_clf = Pipeline([('vect', CountVectorizer()),
                     ('tfidf', TfidfTransformer()),
                     ('clf', MultinomialNB())])

text_clf = text_clf.fit(twenty_train.data, twenty_train.target)

import numpy as np
twenty_test = fetch_20newsgroups(subset='test', shuffle=True)
predicted = text_clf.predict(twenty_test.data)
print("Accuracy : ", np.mean(predicted == twenty_test.target))

# Running ML algorithm : SVM algorithm
print("----- Support Vector Machine ----")
from sklearn.linear_model import SGDClassifier
text_clf_svm =  Pipeline([('vect', CountVectorizer()),
                        ('tfidf', TfidfTransformer()),
                         ('clf-svm',SGDClassifier(loss='hinge',
                                                  penalty='l2',
                                                  alpha=1e-3,
                                                  n_iter = 5,
                                                  random_state=42))
                         ])

_ = text_clf_svm.fit(twenty_train.data, twenty_train.target)
predicted_svm = text_clf_svm.predict(twenty_train.data)
print("Accuracy : ", np.mean(predicted_svm == twenty_train.target))

print('---- Grid Search : Naive Bayes ----')
from sklearn.model_selection import GridSearchCV
parameters = {'vect_ngram_range' : [(1,1), (1,2)],
              'tfidf_use-idf' : (True, False),
              'clf__alpha' : (1e-2,1e-3)
              }

gs_clf = GridSearchCV(text_clf, parameters, n_jobs=1)
gs_clf = gs_clf.fit(twenty_train.data, twenty_train.target)
print(gs_clf.best_score_)
print(gs_clf.best_params_)
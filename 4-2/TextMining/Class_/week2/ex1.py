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
# 모델의 정의
from sklearn.naive_bayes import MultinomialNB
clf = MultinomialNB().fit(X_train_tfidf, twenty_train.target) #학습

# 실제 실행
from sklearn.pipeline import Pipeline
text_clf = Pipeline([('vect', CountVectorizer()),
                     ('tfidf', TfidfTransformer()), # 정교한 숫자로 변환
                     ('clf', MultinomialNB())]) # MultinomialNB로 실행

text_clf = text_clf.fit(twenty_train.data, twenty_train.target) # 학습

# 성능테스트
import numpy as np
twenty_test = fetch_20newsgroups(subset='test', shuffle=True)
predicted = text_clf.predict(twenty_test.data)
print("Accuracy : ", np.mean(predicted == twenty_test.target))

# Running ML algorithm : SVM algorithm
print("----- Support Vector Machine ----")
# 선형 모듈 공간에 기준선을 두고 그룹을 나눔
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
# 여러 파라메타를 비교하여 가장 성능좋은 파라메타를 찾아줌
from sklearn.model_selection import GridSearchCV
parameters = {'vect__ngram_range' : [(1,1), (1,2)],
              'tfidf__use_idf' : (True, False),
              'clf__alpha' : (1e-2,1e-3)
              }

gs_clf = GridSearchCV(text_clf, parameters, n_jobs=1)
gs_clf = gs_clf.fit(twenty_train.data, twenty_train.target)
print(gs_clf.best_score_)
print(gs_clf.best_params_)

print('---- Grid Search : SVM ----')
# 여러 파라메타를 비교하여 가장 성능좋은 파라메타를 찾아줌
from sklearn.model_selection import GridSearchCV
parameters_svm = {'vect__ngram_range' : [(1,1), (1,2)],
              'tfidf__use_idf' : (True, False),
              'clf-svm__alpha' : (1e-2,1e-3)
              }

gs_clf_svm = GridSearchCV(text_clf_svm, parameters_svm, n_jobs=1)
gs_clf_svm = gs_clf_svm.fit(twenty_train.data, twenty_train.target)
print(gs_clf_svm.best_score_)
print(gs_clf_svm.best_params_)


print('---- Naive bayes with Steaming ----')
# Steaming 어근을 찾는것
from nltk.stem.snowball import SnowballStemmer
# ignore_stopwords는 의미 없는 단어를 제거
stemmer = SnowballStemmer("english", ignore_stopwords=True)

# StemmedCountVectorizer은 Stemmed를 하는 CountVectorizer이다
class StemmedCountVectorizer(CountVectorizer) :
    def build_analyzer(self):
        analyer = super(StemmedCountVectorizer, self).build_analyzer()
        return lambda doc: ([stemmer.stem(w) for w in analyer(doc)])

stemmed_count_vect = StemmedCountVectorizer(stop_words='english')

text_mnb_stemmed = Pipeline([('vect', CountVectorizer()),
                        ('tfidf', TfidfTransformer()),
                             ('mnb', MultinomialNB(fit_prior=False))])
text_mnb_stemmed = text_mnb_stemmed.fit(twenty_train.data, twenty_train.target)

predicted_mnb_stemmed = text_mnb_stemmed.predict(twenty_test.data)
print('Accuracy : ', np.mean(predicted_mnb_stemmed == twenty_test.target))
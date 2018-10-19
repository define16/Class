from bs4 import BeautifulSoup as bs

from bs4.element import Tag
import codecs

with codecs.open('n3-collection-master\\reuters.xml', 'r', 'utf-8') as infile :
    soup = bs(infile, 'html5lib')

docs = []
for elem in soup.find_all('document') :
    texts = []

    for c in elem.find('textwithnamedentities').children:
        if type(c) == Tag :
            if c.name == "namedentityintext" :
                label = 'N' # Named Entity 부분이라는 의미
            else :
                label = 'I'
            for w in c.text.split(' ') :
                if len(w) > 0:
                    texts.append((w,label))
    docs.append(texts)
print(docs[0][:10])

import nltk

data = []
for i, doc in enumerate(docs) :
    # 문서에서 토큰(단어)을 가져와 리스트에 저장
    tokens = [t for t, label in doc]
    # 품사 태그 확인
    tagged = nltk.pos_tag(tokens)
    # 단어, 품사 태그, 그리고 label을 저장
    data.append([(w, pos, label) for (w, label), (word, pos) in zip(doc, tagged)])

## features 생성
def word2features(doc, i):
    word = doc[i][0]
    pos_tag = doc[i][1]

    # 모든 단어에서의 공통적인 특징
    features = [
        'bias' ,
        'word.lower=' + word.lower(),
        'word[-3:]=' + word[-3:],
        'word[-2:]=' + word[-2:],
        'word.isupper=%s' % word.isupper(),
        'word.istitle=%s' % word.istitle(),
        'word.isdigit=%s' % word.isdigit(),
        'postag=' + pos_tag
    ]

    if i > 0:
        word1 = doc[i-1][0]
        pos_tag1 = doc[i-1][1]
        features.extend([
            '-1:word.lower=' + word1.lower(),
            '-1:word.isupper=%s' % word1.isupper(),
            '-1:word.istitle=%s' % word1.istitle(),
            '-1:word.isdigit=%s' % word1.isdigit(),
            '-1:postag=' + pos_tag1
        ])
    else:
        # 있다면 '문서의 시작'이라고 표시
        features.append('BOS')

    if i < len(doc) - 1:
        word1 = doc[i + 1][0]
        pos_tag1 = doc[i + 1][1]
        features.extend([
            '+1:word.lower=' + word1.lower(),
            '+1:word.isupper=%s' % word1.isupper(),
            '+1:word.istitle=%s' % word1.istitle(),
            '+1:word.isdigit=%s' % word1.isdigit(),
            '+1:postag=' + pos_tag1
        ])
    else:
        # 있다면 '문서의 시작'이라고 표시
        features.append('EOS')

    return features

##### 모델에 학습 진행
from sklearn.model_selection import train_test_split

#문서에서 feature(특징)을 추출하는 함수 선언
def extract_features(doc):
    return [word2features(doc,i) for i in range(len(doc))]

# 각 문서의 label에 대한 정보를 저장하는 리스트를 생성하는 함수 선언
def get_labels(doc):
    return [label for (token, postag, label) in doc]

X = [extract_features(doc) for doc in data]
y = [get_labels(doc) for doc in data]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

#### CRF 모델 사용
import pycrfsuite
trainer = pycrfsuite.Trainer(verbose=True)

# 모델에 학습 데이터를 입력
for xseq, yseq in zip(X_train, y_train) :
    trainer.append(xseq, yseq)


trainer.set_params({
    # L1 penalty의 계수
    'c1' : 0.1,
    # L2 penalty의 계수 \
    'c2': 0.01,
    # 최대 반복 횟수
    'max_iterations' : 200,

    'feature.possible_transitions' : True
})

# 학습이 끝난 후, "crf.model"의 이름으로 모델을 파일로 저장
trainer.train('crf.model')


### 결과 확인
tagger = pycrfsuite.Tagger()
tagger.open('crf.model')
y_pred = [tagger.tag(xseq) for xseq in X_test]

# Let's take a look at a random sample in the testing set
i = 12
for x, y in zip(y_pred[i], [x[1].split("=")[1] for x in X_test[i]]):
    print("%s (%s)" % (y, x))

### Sckikit-learn으로 쉽게 성능 확인
import numpy as np
from sklearn.metrics import classification_report

#label을 탐색하기 위한 딕셔너리 생성
labels = {"N" : 1, "I" : 0}

# 문자열의 탸ㅐ그를 1차원의 배열로 변환
predictions = np.array([labels[tag] for row in y_pred for tag in row])
truths = np.array([labels[tag] for row  in y_test for tag in row])

# 분류 성능 결과 출력
print(classification_report(
    truths, predictions,
    target_names=["I", "N"]))

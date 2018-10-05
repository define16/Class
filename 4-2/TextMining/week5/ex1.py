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

    return features;
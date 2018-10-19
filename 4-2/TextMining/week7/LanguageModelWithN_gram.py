'''
 n-gram은 이와 같은 확률적 언어 모델의 대표적인 것으로서,
 n개 단어의 연쇄를 확률적으로 표현해 두면 실제로
 발성된 문장의 기록을 계산할 수 있다.
'''

# Step 1 : Bag of Words
from nltk.corpus import reuters
from collections import Counter, defaultdict

counts = Counter(reuters.words())
total_count = len(reuters.words())

# 공통적으로 가장 많이 나타나는 20개의 단어
print(counts.most_common(n=20))

# 빈도 비율 계산
for word in counts:
    counts[word] /= float(total_count)

# 빈도 비율의 총합 계산
print(sum(counts.values()))

import random
# 100개의 단어 생성
text = []

for _ in range(100) :
    r = random.random()
    accumulator = 0

    for word, freq in counts.items():
        accumulator += freq

        if accumulator >= r:
            text.append(word)
            break

print(" ".join(text))

# 텍스트의 확률 계산
from operator import mul
from functools import reduce
print(reduce(mul, [counts[w] for w in text], 1.0))

# Step 2 : Bi-gram & Tri-gram
from nltk import bigrams, trigrams
first_sentence = reuters.sents()[0]
print(first_sentence)

### Bi-gram 결과
print("\n----- Bi-gram 결과 확 확인인 -----")
print(list(bigrams(first_sentence)))
### Bi-gram 결과
print("\n----- 패딩된 Bi-gram 결과 확인 -----")
print((list(bigrams(first_sentence, pad_left=True, pad_right=True))))
### Bi-gram 결과
print("\n----- Tri-gram 결과 확인 -----")
print(list(trigrams(first_sentence)))
### Bi-gram 결과
print("\n----- 패딩된 Tri-gram 결과 확인 -----")
print((list(trigrams(first_sentence, pad_left=True, pad_right=True))))

### Reuters 데이터(말뭉치)를 이용한 Tri-gram 모델 생성
print("\n----- Tri-gram 모델 생성 -----")
model = defaultdict(lambda : defaultdict(lambda : 0))

for sentence in reuters.sents() :
    print("\n문장 : ", sentence)
    for w1, w2, w3 in trigrams(sentence, pad_right=True, pad_left=True):
        model[(w1,w2)][w3] += 1

# 'what the' 다음에 'economists'가 나오는 것이 2개 존재
print(model['what','the']['economists'])

for w1_w2 in model:
    total_count = float(sum(model[w1_w2].values()))

    for w3 in model[w1_w2]:
        model[w1_w2][w3] /= total_count

print(model['what', 'the']['economists'])

### Language Model을 이용해 텍스트 생성하기
print("\n----- 언어 모델을 이용해 텍스트 생성하기 -----")
import random

text = [None, None]
prob = 1.0

sentence_finished = False

while not sentence_finished:
    r = random.random()
    accumulator = .0

    for word in model[tuple(text[-2:])].keys():
        accumulator += model[tuple(text[-2:])][word]

        if accumulator >= r:
            prob *= model[tuple(text[-2:])][word]
            text.append(word)
            print("aa : " ,text)
            break

    if text[-2:] == [None, None]:
        sentence_finished = True

print("텍스트의 확률 : ", prob)
print(" ".join([t for t in text if t]))
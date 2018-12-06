from konlpy.tag import Twitter
from konlpy.utils import pprint
from keras.models import Sequential
from keras.layers import Embedding
from keras.layers import LSTM, Dense
from keras.preprocessing import sequence
from keras.models import load_model
from keras.models import model_from_json
import Project.mysql as db

import numpy as np
import pandas as pd

import matplotlib.pyplot as plt

import re
import csv

# 천단위, 음절 임베딩
# rnn

def save_db(tableName, dataSet):
    for data in dataSet:
        db.insert_dataSet(tableName, data)

    print("Insert Finish")

# 한글 데이터 로드
def read_csv():
    f = open('koreanLabling.csv', 'r', encoding='utf-8')
    rdr = csv.reader(f)
    data = []
    for line in rdr:
        data.append(line)
        # print(line)

    f.close()

    return data

# 한글 데이터 딕셔너리로 변환
def make_dict(data):
    new_dict = dict()
    word, index = [],[]
    for d in data:
        word.append(d[0])
        index.append(d[1])

    new_dict = dict(zip(word, index))

    # print(new_dict)

    return new_dict


#텍스트 정제(전처리)
def cleanText(readData):
    #텍스트에 포함되어 있는 특수 문자 제거
    # text = re.sub('[-=+;,#/\?:^$.@*\"※~&%ㆍ!』\\‘|\(\)\[\]\<\>`\'…》ㅋㅎ0123456789zxcvbnmasdfghjkklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP]', '', readData)
    text = re.sub( '[^ ㄱ-ㅣ가-힣]+','', readData) # 한글 빼고 다지우기

    return text

def save_model():
    import tensorflow as tf
    w1 = tf.Variable(tf.random_normal(shape=[2]), name='w1')
    w2 = tf.Variable(tf.random_normal(shape=[5]), name='w2')
    saver = tf.train.Saver()
    sess = tf.Session()
    sess.run(tf.global_variables_initializer())
    saver.save(sess, 'my_test_model')

# 음절 단위로 끊기
def make_syllable(sentences, korean_dict):
    sentence = []
    for sent in sentences:
        # sent = str(sent)
        sent = sent.replace("\n", "")
        sent = sent.replace(" ", "")
        sent = sent.replace("ㅋ", "")
        sent = sent.replace("ㅎ", "")
        sent = cleanText(sent)
        sent2 = []
        for s in sent:
            # print(type(s), s, korean_dict.get(s))
            sent2.append(int(korean_dict.get(s)))
        sentence.append(sent2)

    return sentence

def _word2vec(sentence):
    from gensim.models import Word2Vec
    # min_count : 단어의 빈도수, size = 차원수 , window : 학습시 양쪽 확인하는 길이
    embedding_model = Word2Vec(sentences=sentence, size=30, window=2, min_count=1, workers=4, iter=100, sg=1)
    embedding_model = Word2Vec(sentences=sentence)
    embedding_model.init_sims(replace=True)
    embedding_model.save('ko_word2vec_e.model')

    test_s = ""
    test_s = test_s.replace(" ", "")
    test_s = cleanText(test_s)
    test_a = 0

    for a in range(0,len(test_s)-1):
        print(embedding_model[test_s[a]])
        print(test_s[a] + test_s[a+1])
        test_a += embedding_model.wv.similarity(test_s[a], test_s[a+1])

    print(test_a/len(test_s))


###성능 테스트

def hypothesis(X, theta):
    return X @ theta.T


def cost_fn(X, y, theta):
    c = np.power(((X @ theta.T) - y), 2)
    cost = np.sum(c) / (2 * len(X))
    return cost


def gradientDescent(X, y, theta, alpha, epochs):
    cost_list = np.zeros(epochs)

    for i in range(epochs):
        theta = theta - (alpha / len(X)) * np.sum(X * (X @ theta.T - y), axis=0)
        cost_list[i] = cost_fn(X, y, theta)

    return theta, cost_list



if __name__ == "__main__":
    flag = False # 새로운 학습(T), 완성된 모델 사용(F)\
    flag_db = True # 저장 (T), 불러오기(F)
    bullying_sentences = []
    nice_sentences = []

    data = read_csv()
    korean_dict = make_dict(data) # 한글 문자 라벨링
    db.init()

    if flag_db:
        inFp = open("dataSet/악플.txt", "r")
        temp = inFp.readlines()
        # db저장
        for sent in temp:
            sent = sent.replace("\n", "")
            sent = cleanText(sent)
            print(sent)
            bullying_sentences.append(sent)
        # save_db("bullying", bullying_sentences)
        inFp = open("dataSet/보통.txt", "r")
        temp = inFp.readlines()
        # db저장
        for sent in temp:
            sent = sent.replace("\n", "")
            sent = cleanText(sent)
            nice_sentences.append(sent)
        # save_db("nice", nice_sentences)

    else:
        bullying_sentences = db.select_dataSet("bullying")
        nice_sentences = db.select_dataSet("nice")


    sentences_temp1 = make_syllable(bullying_sentences, korean_dict)
    sentences_temp2 = make_syllable(nice_sentences, korean_dict)
    sentences = sentences_temp1+sentences_temp2
    bullying, nice = [], []
    print(sentences)

    for s in sentences_temp1:
        bullying.append(1)
    for s in sentences_temp2:
        nice.append(0)


    # \ufeff 가 생길 때 utf-8 이 아닌 utf-8-sig 로 사용하면 된다.
    inFp = open("dataSet/testSet.txt", "r", encoding='utf-8-sig')
    test_sentences = inFp.readlines()
    test_sentences = make_syllable(test_sentences, korean_dict)
    print(test_sentences)

    # 이 벡터를 rnn을

    # RNN은 전에 입력된 input이 다음의 output에 영향을 준다.

    print(len(sentences), len( (bullying+nice)))


    vocab_size = 1000000

    X_train, y_train = sentences, (bullying+nice)
    X_test, y_test = test_sentences, [0,1,0,1,1,1,0,1,0,0,0,0,0,0,1,1,0]
    print("test셋 길이 : ", len(X_test), len(y_test))
    print("Load dataset with {} training samples, {} test samples".format(len(X_train), len(X_test)))

    print("--- Review ---")
    print(X_train[6])
    print(type(X_train[6][0]))
    print("--- Label ---")
    print(y_train[6])


    print("Maximum review length: {}".format(len(max((X_train + X_test), key=len))))
    print("Minimum review length: {}".format(len(min((X_train + X_test), key=len))))




    # 데이터 길이 일치 시키기
    # max_words = len(max((X_train + X_test)))
    # print("전", X_train[4][48])
    max_words = 15
    X_train = sequence.pad_sequences(X_train, maxlen=max_words)
    X_test = sequence.pad_sequences(X_test, maxlen=max_words)
    # print("후", X_train[4][48])

    # print(X_train[4][48])
    # print(X_train[12][58])
    # print(X_train[0][64])
    # print(X_train[0][0])

    print(X_train)

    if flag :
        embedding_size = 12
        model = Sequential()
        model.add(Embedding(vocab_size, embedding_size, input_length=max_words))  # 임베딩
        # model.add(Embedding(vocab_size, embedding_size))
        model.add(LSTM(100))
        model.add(Dense(1, activation="sigmoid"))
        print(model.summary())

        model.compile(loss="binary_crossentropy", optimizer="adam", metrics=["accuracy"])

        # 학습 모델을 이용해 학습 진행
        batch_size = 4
        num_epochs = 15
        # X_valid, y_valid = X_train[:batch_size], y_train[:batch_size]
        # X_train2, y_train2 = X_train[:batch_size], y_train[:batch_size]
        print("\n--- Training ---")
        # model.fit(X_train2, y_train2, validation_data=(X_valid, y_valid), batch_size=batch_size, epochs=num_epochs)
        model.fit(X_train, y_train,  epochs=num_epochs)
        # jSon으로 저장
        # model_json = model.to_json()
        # with open("model.json", "w") as json_file:
        #     json_file.write(model_json)
        model.save("bullying_classification_model.h5")

    else :
        model = load_model("bullying_classification_model.h5")
        print("Loaded model")

        model.compile(loss="binary_crossentropy", optimizer="adam", metrics=["accuracy"])

    scores = model.evaluate(X_test, y_test, verbose=0)
    print("Test1 accuracy:", scores[1])
    y_pred = model.predict(X_test)
    print("번호", "예측", "원래")
    __ = 0;
    for pre in y_pred :
        if pre > 0.5 :
            print(__+1, "1", y_test[__])
        else :
            print(__+1,"0", y_test[__])
        __ += 1



    # inFp = open("dataSet/testset2.txt", "r")
    # test_sentences = inFp.readlines()
    # test_sentences = make_syllable(test_sentences, korean_dict)
    # print(test_sentences)

    # X_test, y_test = test_sentences, [0,0,0,0,0,1,1,1]
    # X_test = sequence.pad_sequences(X_test, maxlen=max_words)
    # print(len(X_test), len(y_test))
    # scores = model.evaluate(X_test, y_test, verbose=0)
    # y_pred = model.predict(X_test)
    # print("Test2 accuracy:", scores[1])
    # print("예측")
    # print(y_pred)


    # learning_rate = 0.01
    # epochs = 10
    # theta = np.zeros([1, len(X_train[0])])
    # t_theta, t_cost_list = gradientDescent(X_train, y_train, theta, learning_rate, epochs)
from keras.datasets import imdb
from keras.models import Sequential
from keras.layers import Embedding
from keras.layers import LSTM, Dense
from keras.preprocessing import sequence

# RNN은 전에 입력된 input이 다음의 output에 영향을 준다.
# dataset information
vocab_size = 5000

(X_train, y_train), (X_test, y_test) = imdb.load_data(num_words=vocab_size)
print("Load dataset with {} training samples, {} test samples".format(len(X_train), len(X_test)))

print("--- Review ---")
print(X_train[6])
print("--- Label ---")
print(y_train[6])


word2idx = imdb.get_word_index()
idx2word = {i: word for word, i in word2idx.items()}
print([idx2word.get(i, ' ') for i in X_train[6]])
print("--- Label ---")
print(y_train[6])

print("Maximum review length: {}".format(len(max((X_train + X_test), key=len))))
print("Minimum review length: {}".format(len(min((X_train + X_test), key=len))))

# 데이터 길이 일치 시키기
max_words = len(max((X_train + X_test)))

max_words = 500
X_train = sequence.pad_sequences(X_train, maxlen=max_words)
X_test = sequence.pad_sequences(X_test, maxlen=max_words)

embedding_size = 32
model = Sequential()
model.add(Embedding(vocab_size, embedding_size, input_length=max_words))
model.add(LSTM(100))
model.add(Dense(1, activation="sigmoid"))
print(model.summary())

model.compile(loss="binary_crossentropy", optimizer="adam", metrics=["accuracy"])



# 학습 모델을 이용해 학습 진행
batch_size = 64
num_epochs = 3
X_valid, y_valid = X_train[:batch_size], y_train[:batch_size]
X_train2, y_train2 = X_train[:batch_size], y_train[:batch_size]
print("\n--- Training ---")
model.fit(X_train2, y_train2, validation_data=(X_valid, y_valid), batch_size=batch_size, epochs=num_epochs)

scores = model.evaluate(X_test, y_test, verbose=0)
print("Test accuracy:", scores[1])
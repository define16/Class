import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

from sklearn.model_selection import train_test_split


if __name__ == "__main__":
    data_train = pd.read_csv('dataSet/titanic/fashion-mnist_train.csv')
    data_test = pd.read_csv('dataSet/titanic/fashion-mnist_test.csv')

    x = np.array(data_train.iloc[:, 1:])
    y = np.array(data_train.iloc[:, 0])

    x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=13)
    plt.imshow(x_train[0].reshape((28, 28)), cmap='gray')
    print("x_train shape:", x_train.shape, "y_train shape:", y_train.shape)
    print(x_train)

    # x_train = x_train.values.reshape(-1, 28, 28, 1).astype('float32') / 255.
    # x_test = x_test.values.reshape(-1, 28, 28, 1).astype('float32') / 255.




    # y_train = to_categorical(y_train.astype('float32'))
    # y_test = to_categorical(y_test.astype('float32'))
    print('Training', x_train.shape, x_train.max())
    print('Testing', x_test.shape, x_test.max())
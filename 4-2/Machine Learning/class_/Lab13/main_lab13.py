# 선형 회귀
import tensorflow as tf
import numpy as np
from sklearn.datasets import fetch_california_housing
from sklearn.preprocessing import StandardScaler

def reset_graph(seed=42):
    tf.reset_default_graph()
    tf.set_random_seed(seed)
    np.random.seed(seed)

def fetch_batch(epoch, batch_index, batch_size):
    np.random.seed(epoch * n_batches + batch_index)
    indices = np.random.randint(m, size=batch_size)
    X_batch = scaled_housing_data_plus_bias[indices]
    y_batch = housing.target.reshape(-1,1)[indices]

    return X_batch, y_batch

if __name__ == "__main__":
    reset_graph()


    housing = fetch_california_housing()
    m, n = housing.data.shape

    housing_data_plus_bias = np.c_[np.ones((m, 1)), housing.data]

    scaler = StandardScaler()
    scaled_housing_data = scaler.fit_transform(housing.data)
    scaled_housing_data_plus_bias = np.c_[np.ones((m,1)), scaled_housing_data]

    n_epochs = 10   # 1000, 시간 문제로 감소
    learning_rate = 0.01
    batch_size = 100    # 배치 크기(1000, 시간 문제로 감소)
    n_batches = int(np.ceil(m / batch_size))   # 전체 배치 횟수


    # X = tf.constant(housing_data_plus_bias, dtype=tf.float32, name="X")
    # y = tf.constant(housing.target.reshape(-1,1), dtype=tf.float32, name="y")
    # XT = tf.transpose(X)
    # theta = tf.matmul(tf.matmul(tf.matrix_inverse(tf.matmul(XT, X)), XT), y)
    #
    # with tf.Session() as sess:
    #     theta_value = theta.eval()
    # print(theta_value)

    # fetch_batch()에서 scaled_housing_data_plus_bias 했기 때문에 n+1이 된다.

    X = tf.placeholder(tf.float32, shape=(None, n+1), name="X")
    y = tf.placeholder(tf.float32, shape=(None, 1), name="y")

    theta = tf.Variable(tf.random_uniform([n+1, 1], -1.0, 1.0), name="theta")
    y_pred = tf.matmul(X, theta, name="predictions")
    error = y_pred - y
    mse = tf.reduce_mean(tf.square(error), name="mse")

    optimizer = tf.train.GradientDescentOptimizer(learning_rate=learning_rate)

    training_op = optimizer.minimize(mse)

    init = tf.global_variables_initializer()
    with tf.Session() as sess:
        sess.run(init)

        for epoch in range(n_epochs):
            for batch_index in range(n_batches):
                X_batch, y_batch = fetch_batch(epoch, batch_index, batch_size)
                sess.run(training_op, feed_dict={X: X_batch, y: y_batch})
        best_theta = theta.eval()

    print(best_theta)





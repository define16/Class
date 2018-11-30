import tensorflow as tf
import numpy as np


def reset_graaph(seed=42):
    tf.reset_default_graph()
    tf.set_random_seed(seed)
    np.random.seed(seed)


if __name__ == "__main__":
    reset_graaph()

    x = tf.Variable(3, name="x")
    y = tf.Variable(4, name="y")

    f = x * x * y + y + 2

    print(f)

    sess = tf.Session()
    sess.run(x.initializer)
    sess.run(y.initializer)
    result = sess.run(f)

    print(result)

    sess.close()

    init = tf.global_variables_initializer()
    with tf.Session() as sess:
        init.run()
        result = f.eval()
    print(result)



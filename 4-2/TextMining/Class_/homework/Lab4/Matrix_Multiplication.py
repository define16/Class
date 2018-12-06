# Lab2 Homework

import random

random.seed(20180920)
def makeMatrix(row, col):
    pass

def matMul(mat1, mat2):
    pass

if __name__=="__main__":
    mat_1 = makeMatrix(3,3)
    mat_2 = makeMatrix(3,3)
    result = matMul(mat_1, mat_2)
    print(mat_1)
    print(mat_2)
    print(result)

    mat_1 = makeMatrix(3,3)
    mat_2 = makeMatrix(3,5)
    result = matMul(mat_1, mat_2)
    print(mat_1)
    print(mat_2)
    print(result)

    mat_1 = makeMatrix(2,3)
    mat_2 = makeMatrix(3,2)
    result = matMul(mat_1, mat_2)
    print(mat_1)
    print(mat_2)
    print(result)

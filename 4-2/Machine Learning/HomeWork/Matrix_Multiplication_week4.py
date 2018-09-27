# week4 Homework

import random

random.seed(20180920)
def makeMatrix(row, col):
    mat = []
    for i in range(0,row) :
        temp_list = []; # row
        for j in range(0,col) :
            temp_list.append(random.randint(1, 5)) #1,5까지의 값
        mat.append(temp_list)   # col

    return mat

def matMul(mat1, mat2):
    result = []
    # result[mat1의 row][mat2의 col]
    for i in range(len(mat1)): # mat1 row
        temp_list = []
        for j in range(len(mat2[i])): # mat2 col
            sum_ = 0;
            for k in range(len(mat1[i])): # mat1 col
                # result col
                temp = mat1[i][k] * mat2[k][j]
                sum_ += temp
            temp_list.append(sum_) # result row
        result.append(temp_list)

    return result
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

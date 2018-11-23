import pickle
import os
import numpy as np
import urllib.request
import re

np.random.seed(20180926)
def makeMatrix():
    nr = np.random.randint(5, size=40)
    matrix = np.array(nr, dtype=np.float64) # NaN의 자료형은 float

    for n in range(len(matrix)):
       if matrix[n] == 0:
            matrix[n] = np.nan # NaN으로 변환

    return matrix;


def savefile(filepath, matrix):
    f = open(filepath, "wb") # 저장하기
    pickle.dump(matrix, f)
    f.close()

def loadfile(filepath):
    f = open(filepath, "rb")  # 불러오기
    matrix = pickle.load(f)
    return matrix

def check_size(url):
    data = (str)(urllib.request.urlopen(url).read()); # 문자열로 변경
    # 슬라이싱
    row = (int)(data[2])
    col = (int)(data[4])

    return row,col

def nanToZero(matrix):
    for n in range(len(matrix)):
       if matrix[n] != matrix[n]: # NaN끼리 비교하면 항상 false가 나온다.
            matrix[n] = 0

    return matrix

def matchShape(matrix, row, col):
    # temp1,temp2 = [],[]
    # for r in range(row):
    #   mat1[col*r:col*(r+1)]
    # for c in range(col):
    #     temp2.append(matrix[row*c:row*(c+1)])
    # mat1 = np.array(temp1, dtype=np.float64)
    # mat2 = np.array(temp2, dtype=np.float64)
    mat1 = matrix.reshape(row,col) # 5,8 형태로 전환
    mat2 = matrix.reshape(col,row) # 8,5 형태로 전환

    return mat1, mat2

def matMul(mat1, mat2):

    result = np.matrix(mat1) * np.matrix(mat2)

    return result


if __name__ == "__main__":
    file_path = os.getcwd() + "/matrix.pkl"
    url = "http://210.115.230.193/data/size.txt"

    matrix = makeMatrix()
    print(matrix, end='\n\n')
    savefile(file_path,matrix)

    del matrix
    matrix = loadfile(file_path)
    print(matrix, end="\n\n")

    row, col = check_size(url)
    print(row, col, end = "\n\n")

    matrix = nanToZero(matrix)
    print(matrix, end = "\n\n")

    mat1, mat2 = matchShape(matrix, row, col)
    print(mat1, end='\n\n')
    print(mat2, end='\n\n')

    result = matMul(mat1, mat2)
    print(result)
import numpy as np

nz = np.zeros((2,2))    # 모든 값이 0인 배열 생성
print(nz)

no = np.ones((1,2)) # 모든 값이 1인 배열 생성
no2 = np.ones((2))  # 형상에 주의할 필요가 있음
print(no)
print(no2)

nc = np.full((2,2),7)   # 모든 값이 특정 상수인 배열 생성
print(nc)

ne = np.eye(2)  # 2x2 단위 행렬 생성
print(ne)

nr = np.random.random((2,2))    # 임의의 값으로 채워진 배열 생성
print(nr)

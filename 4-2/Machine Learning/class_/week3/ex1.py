import numpy as np

narr1 = np.array([1,2,3])   # rank가 1인 배열 생성
print(type(narr1))
print(narr1.shape) # 배열의 모양
print(narr1[0],narr1[1],narr1[2])

narr1[0] = 5
print(narr1)

narr2 = np.array([[1,2,3], [4,5,6]])  # rank가 2인 배열 생성
print(narr2.shape)
print(narr2[0,0], narr2[0][1], narr2[1,0])

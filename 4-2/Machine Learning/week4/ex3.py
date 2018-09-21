import numpy as np

narr = np.array([[1,2,3,4],[5,6,7,8],[9,10,11,12]])
print(narr)

data = narr[:2,1:3] # narr에서 첫 두행과 1열, 2열로 이루어진 부분배열 추출
print(data)

print(narr[0][1])
data[0][0] = 77 # 슬라이싱된 배열은 원본 배열과 같은 데이터를 참조한다.
print(narr)     # 따라서 원본 배열의 값 또한 수정 되었다.

row1 = narr[1,:]    # 원본 배열의 두 번째 행을 rank가 1인 배열로 추출
row2 = narr[1:2,:]  # 원본 배열의 두 번째 행을 rank가 2인 배열로 추출
print(row1, row1.shape)
print(row2, row2.shape)

col1 = narr[:,1]
col2 = narr[:,1:2]
print(col1, col1.shape)
print(col2, col2.shape)
import numpy as np

narr = np.array([[1,2,3], [4,5,6], [7,8,9], [10,11,12]])
print(narr)

narr2 = np.array([0,2,0,1]) # 인덱스 배열
print(narr[np.arange(4), narr2]) # 인덱스 배열을 이용해 각 행에서 하나의 요소를 선택

narr[np.arange(4), narr2] += 10 # 인덱스 배열을 이용해 각 행에서의 요소를 변경
print(narr)
import numpy as np

narr = np.array([[1,2],[3,4],[5,6]])
print(narr,narr.shape)

print(narr[[0,1,2],[0,1,0]])    #정수 배열 인덱싱
print(np.array([narr[0,0],narr[1,1],narr[2,0]]))    #리스트가 아닌 배열을 생성하는 과정

print(narr[[0,0],[1,1]])    # 동일 요소 재사용
print(np.array([narr[0,1],narr[0,1]]))
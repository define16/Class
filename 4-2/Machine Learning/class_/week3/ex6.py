import numpy as np

narr= np.array([1,2])
print(narr.dtype)

narr2 = np.array([1.0,2.0])
print(narr2.dtype)

narr3 = np.array([1,2], dtype= np.int64) # 특정 자료형을 명시적으로 지정
print(narr3.dtype)

import numpy as np

# 브로드캐스팅

x = np.array([[1,2,3], [4,5,6], [7,8,9], [10,11,12]])
v = np.array([1,0,1])
y = np.empty_like(x) # x와 동일한 shape를 가지며 비어 있는 배열 생성

for i in range(4) : # 반복문을 통해 행렬x의 각 행에 벡터 v를 더하고 있다.
    y[i] = x[i] + v # y[i,:] = x[i,:] + v 와 동일
print(y)
print("== 다른 방법 ==")
vv = np.tile(v,(4,1)) # 두 번째 인자로 넘긴 형상으로 v를 쌓는다.
print(vv, end= '\n\n')

y = x + vv
print(y)

print("== 다른 방법 ==")
print(x.shape, y.shape)

y = x + v

print(y)
import numpy as np
import pandas as pd


np.random.seed(20180917)
dates = pd.date_range('20180917', periods=6)
df = pd.DataFrame(np.random.rand(6,4), index=dates, columns=list('ABCD'))

print(df)
print(df.head())
print(df.tail(3))

print("--"*35)
print(df.index) # 인덱스 확인
print(df.columns) # 컬럼 확인
print(df.values) # 안에 있는 데이터 확인

print("--"*35)
print(df.describe()) # 간단한 통계정보를 보여준다.

print("--"*35)
print(df.T) # index와 column을 바꾼 형태

print("--"*35)
print(df.sort_index(axis=1, ascending=False)) #  컬럼에 대해 내림차순으로 정렬
print(df.sort_values(by='B')) #  DataFrame 내부에 있는 값으로 정렬

print("--"*35)
print(df['A']) # A라는 이름을 가진 컬럼의 데이터를 가져온다
print(df.A) # 위 방법과 같음

print("--"*35)
print(df[0:3]) #맨 처음 세개의 행을 가지고 온다.
print(df['20180917':'20180920']) # 인덱스명을 사용해서 해당하는 범위의데이터를 가지고온다.
print("--"*16, "주의","--"*16)
# print(df['20180917']) # 오류
print(df['20180917':'20180917']) # 이런 형태로 입력

# 특정 인덱스 값 가지고 오기 loc, at
print("--"*35)
print(df.loc[dates[0]])
print(df.loc['20180917'])
print(df.loc['2018-09-17'])
print(df.loc[:,['A','B']])
print(df.loc[dates[0],['A','B']])
print(df.at[dates[0],'A'])

print("--"*35)
print(df.iloc[3])
print(df.iloc[2:5, 0:2])

print("--"*35)
print(df.iloc[[1,2,4],[0,2]])
print(df.iloc[1:3,:])
print(df.iloc[:,1:3])
print(df.iloc[1,1])
print(df.iat[1,1])

print("--"*35)
print(df[df.A > 0]) # 양수 값만 출력
print(df[df > 0])# 전체 출력 양수 이외의 값은 NaNㅇ로 표현

print("--"*35)
df2 = df.copy()
df2['E'] = ['one', 'one','two', 'three', 'four', 'three']
print(df2)
# 필터링을 해야하는 경우 isin를 사용
print(df2[df2['E'].isin(['two','four'])])

print("--"*35)
df.loc[:, 'D'] = np.array([5] * len(df)) # len(df) -= 6
# 우변의 값은 [5,5,5,5,5,5]
print(df)

print("--"*35)
df2 = df.copy()
df2[df2 > 0] = -df2
print(df2)

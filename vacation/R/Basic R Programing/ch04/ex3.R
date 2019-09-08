score <- matrix(c(80, 60, 90, 70 ,70, 50, 100 , 80, 95 , 70, 95, 80), nrow = 4)
print(score)
score[2,2] <- score[2,2] + 20
print(score)
# 벡터의 형태로 출력됨
kor <- score[,1] 
print(kor)
# 행렬의 형태로 출력이 된다.
kor <- score[,1,drop = FALSE]
print(kor)
# 행렬의 1,1은 (2,2) 1,2은 (2,3) 2,1은 (3,2) 2,2은 (3,3)
subStu <- score[c(2,3),c(2,3)]
print(subStu)

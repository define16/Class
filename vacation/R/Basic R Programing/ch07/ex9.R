setwd("D:/Programing Folder/R/Class/Edwith/ch07/Data") # 폴더 주소 입력
kor <- scan("ch7_1_kor.txt")
print(kor)
boxplot(
  kor, main="국어점수의 분포", ylab = "점수", col = 5
)
print(max(kor)); print(min(kor)); print(median(kor))
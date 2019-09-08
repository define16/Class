setwd("D:/Programing Folder/R/Class/Edwith/ch07/Data") # 폴더 주소 입력
kor <- scan("ch7_1_kor.txt")
print(kor)
hist(kor,
     breaks = 10,
     freq = FALSE,
     #col = c("red", "blue", "green"), 
     col = rainbow(10),
     main = "국어 점수의 분포",
     xlab = "국어 점수", ylab = "비율")
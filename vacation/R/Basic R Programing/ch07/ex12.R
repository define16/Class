setwd("D:/Programing Folder/R/Class/Edwith/ch07/Data") # 폴더 주소 입력
data <- read.table("ch7_2_1_student.txt", header = TRUE, stringsAsFactors = FALSE)

# 행렬 형태로 변형하기 위해서 세 과목 점수를 data1에 할당
data1 <- data[,-1] # 1열은 제외
data2 <- t(data1) # data1의 전치

barplot(data2, ylim = c(0,350), xlab = "이름", ylab = "점수",
        names.arg= data$name, col = c(2,3,4), beside = FALSE, border = "cyan")
# 1열은 범례값이라서 제외

#범례 추가하기
legend("topright", c("국어", "영어", "수학"), cex = 0.8, 
       fill = c(2,3,4), horiz = T) 
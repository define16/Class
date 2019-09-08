setwd("D:/Programing Folder/R/Class/Edwith/ch07/Data") # 폴더 주소 입력
data <- read.table("ch7_2_1_student.txt", header = TRUE, stringsAsFactors = FALSE)

# 행렬 형태로 변형하기 위해서 세 과목 점수를 data1에 할당
data1 <- data[,-1] # 1열은 제외
data2 <- as.matrix(data1) # 데이터 프레임을 행렬 형태로 변혀
name <- c("국어", "영어", "수학")

barplot(data2, main ="과목별 성적", ylim = c(0,150), xlab = "이름", ylab = "점수",
        names.arg= name, col = rainbow(nrow(data2)), beside = TRUE)


#범례 추가하기
legend(1,140, data$name, cex = 0.8, fill = rainbow(nrow(data2)), horiz = T) 
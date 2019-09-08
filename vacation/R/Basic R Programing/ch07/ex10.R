setwd("D:/Programing Folder/R/Class/Edwith/ch07/Data") # 폴더 주소 입력
data <- read.table("ch7_2_1_student.txt", header = TRUE, stringsAsFactors = FALSE)

#barplot(data$kor, main ="국어 성적", ylim = c(0,100), xlab = "이름", ylab = "점수",
#        names.arg=data$name, col = c(1,2,3,4,5,6))

barplot(data$eng, main ="영어 성적", ylim = c(0,100), xlab = "이름", ylab = "점수",
        names.arg=data$name, col = c(1,2,3,4,5,6))
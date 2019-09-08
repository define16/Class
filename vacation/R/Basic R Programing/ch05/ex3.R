number <- seq(1:4)
name <- c("정우성","김철수", "송중기","김영희")
kor <- c(80, 60, 90, 70)
eng <- c(70, 50, 100, 80)
mat <- c(95, 70, 95, 80)
grade <- c("B", "D", "A", "C")
stuInfo <- data.frame(번호 = number, 이름 = name, 국어 = kor, 영어 = eng, 수학 = mat, 등급 = grade, stringsAsFactors = FALSE)

sci <- c(95, 85, 75, 80)
stuOne <- list(5,"홍길동", 85, 95, 80, 90, "A")
stuTwo <- list(6,"강개토", 95, 80 ,90, "A") # 인자 하나가 부족해서 오류발생
# Error in xi[[j]] : subscript out of bounds

stuInfo <- cbind(stuInfo[,c(1:5)], sci, stuInfo[6])
stuInfo <- rbind(stuInfo[c(1:2),], stuOne, stuInfo[c(3:4),])
# stuInfo <- rbind(stuInfo, stuTwo) # 오류 발생 코드

# 행또는 열 삭제
stuInfo <- stuInfo[-5,]
stuInfo <- stuInfo[-c(1:3),]

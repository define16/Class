id <- c("1","2","3","4")
name <- c("정우성", "김철수","송중기", "김영희")
kor <- c(80, 60, 90, 70)
eng <- c(70, 50, 100, 80)
mat <- c(95, 70, 95, 80)
score1 <- data.frame(학번=id, 이름=name, 국어=kor, 영어=eng, 수학=mat)

avgValue <- apply(score1[,c(3:5)],1,mean) # apply는 원하는 행,열만 계산 할 수 있다.
print(avgValue)

finalGrade <- c() # 초기화
for(n in avgValue) {
  if(n>=90) {
    Grade <- "A"
  } else if(n>=80) {
    Grade <- "B"
  } else if(n>=70) {
    Grade <- "C"
  } else if(n>=60) {
    Grade <- "D"
  } else {
    Grade <- "F"
  }
  
  finalGrade <- c(finalGrade, Grade) #계산된 값을 누적 시키기 위해서 사요
}
print(finalGrade)

score1 <- cbind(score1, 평균 = avgValue, 등급 = finalGrade)
print(score1)



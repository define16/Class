calcScore <- function() {
  totValue <- sum(score1)
  avgValue <- mean(score1)
  cat("성적 합계 : ", totValue, "성적평균 : ", avgValue,"\n")
  score1[2] <<- 95 #전역변수의 값을 대입 또는 변경할때 사용
}

score1 <- c(70, 80, 90, 60)
calcScore()


score <- c(80,90,70,65,55,30,60,90,88,100,76,30,55,61,89,68,78,70,88,82)
sumScore <- sum(score) # 총점
avgScore <- mean(score) # 평균
midScore <- median(score) # 입력한 데이터에서 가운데 위치한 성적 귀하기 
stdNum <- length(score) # 학생 수 구하기
maxScore <- max(score) # 최고점수
minScore <- min(score) # 최저 점수

cat("총점 = ", sumScore, "학생 수 = ", stdNum, "\n")
cat("평균 점수 = ", avgScore, "가운데 점수 = ", midScore, "\n")
cat("최고 점수 = ", maxScore, "최저 점수 = ", minScore, "\n")
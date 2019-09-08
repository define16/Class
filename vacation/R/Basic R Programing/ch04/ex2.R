kor <- c(80, 60, 90, 70)
eng <- c(70, 50, 100, 80)
math <- c(95, 70, 95)
totStu <- kor + eng + math
cat("totStu : "); print(totStu)

res <- kor / math # 벡터의 길이가 다르면 짧은 길이를 갖는 벡터가 앞부터 반복된다.
cat("res : "); print(res)

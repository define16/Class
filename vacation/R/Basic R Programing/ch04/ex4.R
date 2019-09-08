midSco <- matrix(c(80, 60, 90, 70 ,70, 50, 100 , 80, 95 , 70, 95, 80), nrow = 4) #중간
finSco <- matrix(c(85, 75, 95, 80, 80, 70, 95, 90, 90, 85 ,90, 85), nrow = 4) #기말
colnames(midSco) <- c("국어", "수학", "영어")
rownames(midSco) <- c("정우성", "김철수", "송중기", "김영희")
midSco[3,2] <- 100
totalSco <- midSco + finSco
print(totalSco)

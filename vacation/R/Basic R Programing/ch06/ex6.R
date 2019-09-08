setwd("D:/Programing Folder/R/Class/Edwith/ch06/Data") # 폴더 주소 입력
score <- read.table("ch6_score_list.txt", header = FALSE, stringsAsFactors = FALSE)
score1 <- read.table("ch6_score_space.txt", header = TRUE, stringsAsFactors = FALSE)

print(score)
print(score1)

score2 <- read.table("ch6_score_comma.csv", header = FALSE, sep = ",", stringsAsFactors = FALSE)
print(score2)
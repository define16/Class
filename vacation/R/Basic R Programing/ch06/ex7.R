setwd("D:/Programing Folder/R/Class/Edwith/ch06/Data") # 폴더 주소 입력
kor = c(80,90,70)
write.table(kor, "kor1.txt")
write.table(kor, "kor2.txt", quote=FALSE, row.names = FALSE, col.names = FALSE)
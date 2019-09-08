

setwd("D:/Programing Folder/R/Class/Edwith/ch06/Data") # 폴더 주소 입력

txtLine <-  scan("ch6_score_list.txt", what = list(name = character(), kor = numeric(), eng = numeric(), mat = numeric()),n=4) # 텍스트 파일 가지고 오기

#writeLines(txtLine, ".txt") # 텍스트 파이에 저장하기
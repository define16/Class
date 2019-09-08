setwd("D:/Programing Folder/R/Class/Edwith") # 폴더 주소 입력

txtLine <- readLines(".txt", n=4) # 텍스트 파일 가지고 오기

writeLines(txtLine, ".txt") # 텍스트 파이에 저장하기
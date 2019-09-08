#library(ggmap);

# 데이터 불러오기
setwd("D:/Programing Folder/R/Class/Edwith/ch10/Data") # 폴더 주소 입력
loc <- read.csv("대한민국도시.csv", header = TRUE)
print(loc)

# 지도불러오기
kor <- get_map("jeonju", zoom = 7, maptype = "roadmap")
korMap <- ggmap(kor)
print(korMap)

# 지도에서 도시 표시하기
korMap1 <- korMap + geom_point(data = loc, aes(x = LON, y = LAT), size = 3, colour = "red")
print(korMap1)

# 그림 파일로 저장하기

ggsave("대한민국도시.jpg", dpi = 200)
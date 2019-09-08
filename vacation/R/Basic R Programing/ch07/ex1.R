# 고수준 그래픽함수 - 그래프를 생성하기 위한 함수
# plot(), barplot(), hist(), pie(), boxplot()
# 저수준 그래픽함수 - 부가적인 속성을 추가하거나 변경하기 위한 함수
# points(), lines(), abline(), title(), text(), box(), axis(), legend(), grid()

kor <- c(61, 78, 95, 80, 72)
eng <- c(81, 87, 90, 72, 82)

plot(kor, type = "o", pch = 1)
points(eng, type="b", pch=2, lty=2, lwd=2) 

grid() # 격자 무늬 생성
txt = c("kor", "eng")
legend("topright", txt, pch = 1:2, bty = "n") # 범례 표
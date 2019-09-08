data("pressure")
plot(pressure,
     xlim = c(0, 400), # x, y축 범위를 정해준다.
     ylim = c(0, 850),
     main = "Temp. & Press.", # 그래프 제목을 정해준다.
     xlab = "온도", ylab = "기압", #x축이름과 y축 이름을 정해준다.
     cex.lab = 1.1, # 축 제목의 크기를 기준 크기의 1.1배로 변경
     col = 2) # 점의 색상을 2번으로 변경

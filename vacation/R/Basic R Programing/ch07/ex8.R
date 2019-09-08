x <- c(203, 325, 412, 500, 120)
lbl <- c("금정점", "서구점", "동구점", " 사상점", "중구점")
pie(x, main = "가매야별 판매실적",
    labels = lbl,
    radius = 1.0,
    col = rainbow(length(x)))
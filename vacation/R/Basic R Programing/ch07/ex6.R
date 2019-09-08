data <- c(203, 325, 412, 500, 120)
name <- c("금정점", "서구점", "동구점", " 사상점", "중구점")
barplot(data, 
        main = "가맹점별 판매실적",
        names.arg = name,
        col = c("black", "red", "green", "blue", "cyan"),
        ylab = "판매실적(백만원)", ylim = c(0, 600))
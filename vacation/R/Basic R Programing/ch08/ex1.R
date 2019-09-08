inNum <- readline("입력하세요 : ")
number <- as.numeric(inNum)
remainder <- number %% 2

if(remainder == 0) {
  result <- "even number"
} else {
  result <- "odd number"
}

cat(number, "is an", result)

x <- 0; base <- 100; multi <- 7;
repeat{
  if(x > base) break;
  x <- x + multi
}

cat(base, "을 초과하면서 ", base, "에 가장 가까운 ", multi, "의 배수는 ", x,"입니다.\n")
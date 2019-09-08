fourCalcFun <- function(a, b) {
  totValue <- a + b;
  minusValue <- a - b;
  mulValue <- a * b;
  divValue <- a/ b;
  cat(a, "+", b,"=",totValue,"\n")
  cat(a, "-", b,"=",minusValue,"\n")
  cat(a, "*", b,"=",mulValue,"\n")
  cat(a, "/", b,"=",divValue,"\n")
}

divFun <- function(a, b) {
  quotient <- a / b
  remainder <- a %% b
  cat(a, "/", b,"=",quotient,"\n")
  cat(a, "%%", b,"=",remainder,"\n")
}

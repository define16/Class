# name <- readline("데이터를 입력해주세요 : ")
# print(name)

inWei <- readline("몸무게 : ")
inHei <- readline("키 : ")

# readline은 문자형이라서 숫자로 변환시켜줘야한다.
wei <- as.numeric(inWei)
hei <- as.numeric(inHei)

VBmi <- (wei * 10000) / (hei^2);

# cat("당신의 BMI 지수는 ", VBmi, "입니다." )
outmsg = sprintf("당신의 BMI 지수는 %.3f 입니다.", VBmi)
print(outmsg)
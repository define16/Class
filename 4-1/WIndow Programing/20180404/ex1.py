s = str(input("문자열을 입력하세요 : "));
r ='';


for i in range(len(s)-1 , -1, -1) :
   r += s[i];
   print("%s" % s[i], end="")

print("내용을 거꾸로 출력 :", r)

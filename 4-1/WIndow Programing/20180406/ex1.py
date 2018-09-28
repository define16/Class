s = ['','','','',''];
check  = 0;
for i in range(0,5,1) :
    s[i] = str(input("문자열을 입력하세요 : "));

long = '';

for j in range(0,len(s), 1) :
    if check <= len(s[j]) :
        check = len(s[j])
        long = s[j];




print("가장 긴 문자열은 : " ,long, "입니다.");

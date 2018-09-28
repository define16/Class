s = str(input("문자열을 입력하세요 : "));
scnt = 0;
bcnt = 0;


for i in range(0, len(s), 1) :
    if ord(s[i]) < 97 :
        bcnt += 1;
    elif ord(s[i]) >= 97:
        scnt += 1;

print("대문자 개수 : ", bcnt);
print("소문자 개수 : ", scnt);


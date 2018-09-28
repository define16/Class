s = "i'm fine thank you and you?";

f1 = s.split();
f2 = s.split("you");

print(s);

print("공백 기준으로 자르기");
for i in range(0, len(f1), 1) :
    print("%d번째 문자열은 %s 입니다." % (i+1,f1[i]));

print("you 기준으로 자르기");
for i in range(0, len(f2), 1) :
    print("%d번째 문자열은 %s 입니다." % (i+1,f2[i]));




i = int(input("하나의 숫자를 입력하세요 : "));
answer = ["입력하신 데이터는 [", "]이고, 소수입니다." , "]이고, 소수가 아닙니다."];

isT = True;

if i == 1 :
      isT = True;
else :
    for k in range(2, i, 1) :
        if i % k == 0 :
            isT = False;
            break;

if isT :
    s = answer[0] + str(i) + answer[1];
else :
    s = answer[0] + str(i) + answer[2];

print(s);
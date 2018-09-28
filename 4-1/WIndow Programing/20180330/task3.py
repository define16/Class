import random

bingo = random.randint(1,10)

s = "";
flag = False;

for i in range(0,5,1) :
    i = int(input("숫자를 입력하세요 : "));

    if bingo == i :
        s = "[빙고] 잘 하셨습니다.";
        flag = True;
        break;
    elif  bingo > i :
        print("-  숫자가 너무 작습니다.");
        s = "-  5번의 기회를 모두 사용하셨습니다. 다시 시도하세요."
    else :
        print("- 숫자가 너무 큽니다.");
        s = "-  5번의 기회를 모두 사용하셨습니다. 다시 시도하세요."

if flag :
    print(s);
else :
    print(s);

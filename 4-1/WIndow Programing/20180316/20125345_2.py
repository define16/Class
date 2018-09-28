num = 0;

while True :
    num = input("반복행 수를 입력하세요 (종료 :q 또는 Q) : ")

    if num == "q" or num == "Q" :
        break;

    else :
        num  = int(num);
        for i in range(1, num+1, 1) :
            for j in range(1, i+1, 1) :
                print("■", end = "");
            print("");




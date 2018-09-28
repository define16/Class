while True : 
    print("1) 덧셈 2) 뺄셈 3) 곱셈 4) 나눗셈 5) 나머지 값 6) 프로그램 종료");

    i = int(input("메뉴를 선택하세요 : "));

    if i == 1 :
        a = int(input("두개의 숫자값을 입력하세요 : "))
        b = int(input("두개의 숫자값을 입력하세요 : "))

        sum= a + b;
        print("입력하신 데이터는 [%d], [%d]이고, [뎃셈]수식에 따라 결과값은 [%d]입니다." % (a, b ,sum));

    
    elif i == 2 :
        a = int(input("두개의 숫자값을 입력하세요 : "))
        b = int(input("두개의 숫자값을 입력하세요 : "))

        sum= a - b;
        print("입력하신 데이터는 [%d], [%d]이고, [뺄셈]수식에 따라 결과값은 [%d]입니다." % (a, b ,sum));
    elif i == 3 :
        a = int(input("두개의 숫자값을 입력하세요 : "))
        b = int(input("두개의 숫자값을 입력하세요 : "))

        sum= a * b;
        print("입력하신 데이터는 [%d], [%d]이고, [곱셈]수식에 따라 결과값은 [%d]입니다." % (a, b ,sum));
    elif i == 4 :
        a = int(input("두개의 숫자값을 입력하세요 : "))
        b = int(input("두개의 숫자값을 입력하세요 : "))

        sum= a // b;
        print("입력하신 데이터는 [%d], [%d]이고, [나눗셈]수식에 따라 결과값은 [%d]입니다." % (a, b ,sum));
    elif i == 5 :
        a = int(input("두개의 숫자값을 입력하세요 : "))
        b = int(input("두개의 숫자값을 입력하세요 : "))

        sum= a % b;
        print("입력하신 데이터는 [%d], [%d]이고, [나머지 값]수식에 따라 결과값은 [%d]입니다." % (a, b ,sum));
        
    elif i == 6 :
        break;
    


    

    

    
    

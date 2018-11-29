s = str(input("문자열을 입력하세요 : "));

answer = ["선택[",  "] 번에 의해 [", "] [", "] 로 출력합니다."];
typef= ''
printf = ''
r = ''

while True :
    select = int(input("1) 대문자로 출력 \n2) 소문자로 출력\n3) 문자열을 반대로 출력\n4) 원문 출력 \n5) 프로그램 종료 \n번호를 선택하세요 : "))
    r = ''
    if select == 1 :
        typef = '대문자'
        for i in range(0, len(s), 1):
            if ord(s[i]) >= 97 :
                r += chr(ord(s[i]) - 32)

            else :
                r += s[i];


    elif select == 2 :
        typef = '소문자'
        for i in range(0, len(s), 1):
            if ord(s[i]) < 97:
                r += chr(ord(s[i]) + 32)
            else :
                r += s[i];

    elif select == 3 :
        typef = '문자열 반대'
        for i in range(len(s) - 1, -1, -1):
            r += s[i];

    elif select == 4 :
        typef = '원문'
        r = s;

    elif select == 5 :
        break;

    printf = answer[0] + str(select) +answer[1] + typef + answer[2] + r + answer[3];
    print(printf , '\n');

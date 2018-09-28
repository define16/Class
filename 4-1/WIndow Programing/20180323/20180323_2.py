while True : 
    i = int(input("면적을 구하고자 하는 도형을 선택하세요 (1:사각형, 2: 삼각형, 3:원) : "));

    if i == 1 :
        w = int(input("-가로 : "))
        h = int(input("-세로 : "))

        sum = w * h;

        print("-사각형의 면적은 [%d] 입니다." % (sum));

    elif i == 2 :
        w = int(input("-밑변 : "))
        h = int(input("-높이 : "))

        sum = w * h / 2;

        print("-삼각형의 면적은 [%d] 입니다." % (sum));

    elif i == 3 :
        r = int(input("-반지름 : "))


        sum = r * r * 3.14;

        print("-원의 면적은 [%d] 입니다." % (sum));

    else :

        break;
    

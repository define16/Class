flag = True;

f = ['금경원', '이승재', '이은상', '조준형']
answer = ""
while flag :
    i = int(input("1)친구 리스트 출력\n2)친구 추가\n3)친구 삭제\n4)이름 변경\n5)종료\n메뉴를 선택하세요: "));

    if i == 1 :
        for i in f :
            print(i , end=" ")
        print('\n')
    elif i == 2:
        name = str(input("추가할 이름을 입력하세요 : "))
        f.append(name)
    elif i == 3:
        name = str(input("삭제할 이름을 입력하세요 : "))
        if name in f:
            f.remove(name)
        else :
            print("이름이 없습니다. 다시 입력하세요.")
    elif i == 4:
        name1 = str(input("변경할 이름을 입력하세요 : "))
        if name1 in f:
            name2 = str(input("변경후 이름을 입력하세요 : "))
            f[f.index(name1)] = name2
        else :
            print("이름이 없습니다. 다시 입력하세요.")

    elif i == 5:
        flag = False;
    else :
        print("잘못된 입력입니다.")
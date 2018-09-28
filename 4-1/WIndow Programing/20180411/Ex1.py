def findProduct(product,sinput):
    needed = 0;
    if sinput in list(product.keys()) :
        needed = product.get(sinput);
    else :
        needed = -1;

    return needed;

def exchange(needed ,money):
    m = money - needed;

    return int(m)

def inputMoney(needed, money):
    m = exchange(needed, money)

    return m

def need_more(change):
    flag = True

    while flag :
        more_money = int(input("현금을 더 넣어주세요 : "));
        if change < 0 :
            change = change * (-1);

        #print("안 " , change)
        change = inputMoney(change, more_money);
        print("부족한 금액 : ", change)

        if change >= 0 :
            flag = False


    return change


flag, needed, money, change = True, 0, 0, 0;
product = {'사이다' : 1000, '콜라' : 1000 , '커피' : 800 , '이온음료' : 1500};

while flag :
    print("=====================================================");
    print(list(product.keys()));
    print(list(product.values()));
    sinput = str(input("원하는 상품을 입력하세요 : (종료 : n) "));
    if sinput == 'n' :
        flag = False;

    needed = findProduct(product, sinput);
    #print("need " , needed, type(needed));
    if needed == -1 :
        print("종료합니다.")

    else :
        money = int(input("현금을 넣어주세요 : "));
        change = inputMoney(needed, money);

       # print("chage", change, type(change))

        if change < 0 :
            print(change,"만큼 현금이 부족합니다.")
            more = str(input("추가로 현금을 넣으시겠습니까 ? 예: y 아니요 : n "));
            if more == 'y' :
                change = need_more(change)

            elif more == 'n':
                print("종료합니다.")
                flag = False;
            else :
                print("잘못입력하셨습니다");
                money = 0;

        else :
            change = inputMoney(needed, money);

        print("선택한 음료는 " + sinput);
        print("거스름돈 : " , change, "입니다." )
        money = 0;





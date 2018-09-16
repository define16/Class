import os
import random
import re

def create_dic():
    try :
       os.chdir("LotteryProgram\\data")
    except FileNotFoundError:
       os.mkdir("LotteryProgram\\data")


def create_num():
    list_num = []
    flag = True;
    will = int(input("Enter how many games you will buy : "))
    auto = int(input("Enter how many games you want to create automatically : "))

    # 수동이 있을때
    if will > auto :
        for i in range(will-auto) :
            list_temp = [];
            aa = input("Enter your number : ")
            if bool(re.search("[a-zA-Z가-힝!@#$%^&*{}]",aa)) :
                print("Error! Must be Number")
                flag = False
                break;

            # 구분자가 공백 또는 ","
            if aa.find(",") == -1 :
                list_temp = aa.split(" ");
            else :
                list_temp = aa.split(",");

            if len(list_temp) != 6 :
                print("Error! Not Enough Number")
                flag = False
                break;

            #문자를 숫자로 변경
            for j in range(6) :
                list_temp[j] = int(list_temp[j])

            list_num.append(list_temp)

            print(list_temp)

    if(flag) :
    # 자동처리
        for i in range(auto):
            k = range(1,47)
            list_num.append(random.sample(k,6))
            print(list_num)


def check_num():
    pass

def save_file():
    pass

def winner():
    pass

def __main__():
    flag = True
    create_dic()
    print("============= Menu =============")
    print("1. Creation\t\t\t\t(C)")
    print("2. Display the Set\t\t(D)")
    print("3. Save to file\t\t\t(S)")
    print("4. Check the Result\t\t(R)")
    print("5. Exit the Program\t\t(Q)")
    print("================================")

    while flag :
        num = input("Select Menu : ")

        if num == "1" or num == "c" or num == "C":
            create_num()

        elif num == "2":
            pass
        elif num == "3":
            pass
        elif num == "4":
            pass
        elif num == "5":
            print("END")
            flag = False
        else :
            print("Error! You input wrong data")


__main__()
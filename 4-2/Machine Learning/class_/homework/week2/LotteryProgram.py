import os
import random
import re
import pickle
import time
import calendar


def create_dic():
    try :
       os.chdir(os.getcwd()+"\\LotteryProgram\\data")
    except FileNotFoundError:
       os.makedirs(os.getcwd()+"\\LotteryProgram\\data")

def lottery_number_check(list_temp) :
    flag = True
    # 6개 이상 입력시 오류
    if len(list_temp) != 6:
        print("Error! Not Enough Number")
        flag =  False
    # 중복처리
    if len(list_temp) != len(set(list_temp)):
        print("There are duplicate number");
        flag =  False
    return flag

def date_check(list_temp) :
    flag = True
    # 3개 이상 입력시 오류
    if len(list_temp) != 3:
        print("Error! Not Enough Number")
        flag = False

    return flag


# 로또 입력
def create_num():
    list_num = []
    flag = True;
    will = int(input("Enter how many games you will buy : "))
    auto = int(input("Enter how many games you want to create automatically : "))
    # 수동이 있을때
    if will > auto :
        i=0;
        while i < (will-auto) :
            list_temp = [];
            aa = input("Enter your number : ")
            # 숫자외 입력시 오류
            if bool(re.search("[a-zA-Z가-힝!@#$%^&*{}]", aa)):
                print("Error! Must be Number")
                flag = False
                continue

            # 구분자가 공백 또는 ","
            if aa.find(",") == -1 :
                list_temp = aa.split(" ");
            else :
                list_temp = aa.split(",");

            flag = lottery_number_check(list_temp)
            if not flag :
                continue


            #문자를 숫자로 변경
            for j in range(6) :
                list_temp[j] = int(list_temp[j])
            list_temp.append(-1)
            list_num.append(list_temp)
            # print(list_temp)

            i+=1


    # 자동처리
    if(flag) :
        for i in range(auto):
            k = range(1,47)
            temp = random.sample(k,6)
            temp.sort()
            temp.append(-2)
            list_num.append(temp)
            # print(list_num)


    return list_num;

# 숫자 출력
def check_num(list_num):
    print("============ NumberSet ============")
    for i in range(len(list_num)) :
        if list_num[i][6] == -1 : # 수동일때
            print("m ::  ", end="")
        else : # 자동일때
            print("a ::  ", end="")
        for j in range(6) :
            print("%2d" % (int(list_num[i][j])), end=" ")
        print()
    print("===================================")

def save_file(list_num):
    now = time.localtime() # 현재시간
    fileName = "%04d%02d%02d-%02d%02d" % (now.tm_year, now.tm_mon, now.tm_mday, now.tm_hour, now.tm_min)

    f = open(os.getcwd()+"\\" + fileName+".pkl", "wb")
    pickle.dump(list_num,f)
    f.close()
    print("save() :: Date save complete....")

def winner():
    date_n = ""
    list_n = ""

    while True :
        date_n = input("Enter date : ")
        if bool(re.search("[a-zA-Z가-힝!@#$%^&*{}]", date_n)):
            print("Error! Must be Number")
            continue

        if len(date_n) != 10:
            continue

        # 구분자가 공백 또는 "/"
        if date_n.find("/") == -1:
            list_date = date_n.split(" ");
        else:
            list_date = date_n.split("/");

        flag = date_check(list_date)

        if not flag :
            continue

        list_n = input("Enter list : ")
        if bool(re.search("[a-zA-Z가-힝!@#$%^&*{}]", list_n)):
            print("Error! Must be Number")
            continue

        # 구분자가 공백 또는 ","
        if list_n.find(",") == -1:
            list_num = list_n.split(" ");
        else:
            list_num = list_n.split(",");

        flag = lottery_number_check(list_num)
        if not flag :
            continue

        break;

    year_n = [int(list_date[0]),int(list_date[0])]
    month_n = [int(list_date[1]),int(list_date[1])]
    date_n = [int(list_date[2]),int(list_date[2])]

    cal = calendar.weekday(year_n[0], month_n[0], date_n[0]);
    date_n[0] = date_n[0] - (cal + 1);
    date_n[1] = date_n[1] + (5 - cal)

    monran = calendar.monthrange(year_n[0], month_n[0])
    # 지난 달과 이번달 사이에 있을때
    if 0 > date_n[0]:
        if month_n[0] == 1:  # 작년 12월과 1월 사이일때
            year_n[0] -= 1
            monran_ = calendar.monthrange(year_n[0], 12)
        else:
            monran_ = calendar.monthrange(year_n[0], month_n[0] - 1)
            date_n[0] = monran_[1] + date_n[0]
            month_n[0] = month_n[0] - 1

    # 이번달과 다음달 사이에 있을때
    if monran[1] < date_n[1]:
        date_n[1] = date_n[1] - monran[1]
        month_n[1] += 1

    y = [str(year_n[0]), str(year_n[1])]
    m = [str(month_n[0]), str(month_n[1])]
    d = [str(date_n[0]), str(date_n[1])]

    if  month_n[0] < 10 :
        m[0] = "0" + m[0]
    if  month_n[1] < 10 :
        m[1] = "0" + m[1]
    if  date_n[0] < 10 :
        d[0] = "0" + m[0]
    if  date_n[1] < 10 :
        d[1] = "0" + m[1]
    # string 으로 변환 시켜 계산
    firstDate = y[0] + m[0] + d[0]
    lastDate = y[1] + m[1] + d[1]

    folder = os.getcwd()
    index = 1;

    for filename in os.listdir(folder): #Data 폴더 읽기
        # print(filename)
        date_ = int(filename.split("-")[0][:8])
        time_ = int(filename.split("-")[1].split(".")[0])
        # print(year_, month_, date_,time_)

        if date_ <= int(lastDate) and date_ >= int(firstDate) : # 같은 주차인 파일 모두 불러오기
            if date_ == lastDate and  time_ > 2000 :
                continue
            if date_ == firstDate and time_ < 0 :
                continue



            print("loadfile() :: Data load complete....")
            f = open(os.getcwd()+ "\\" + filename, "rb") # 불러오기
            list_num1 = pickle.load(f)

            print('=' * 25 + ' Game Result ' + '=' * 25)
            print('I  index     type          number            match    rank\t\tl')
            index = 1
            for ii in list_num1:
                gametype = ""
                if ii[6] == -1 : # 수동
                    gametype = "m"
                if ii[6] == -2 : # 자동
                    gametype = "a"

                match = 0;
                for i in range(0,5):
                    for j in range(i,6):
                        if(ii[i] == list_n[j]) :
                            match += 1;


                rank = 7 - match
                prize = ""
                if rank < 5:
                    prize = '*'

                print('lGame%4d :   %s     %3d%3d%3d%3d%3d%3d         %d       %d %s\t\tl' % (
                    index, gametype, ii[0], ii[1], ii[2], ii[3], ii[4], ii[5], match, rank, prize))
                index += 1
                f.close()
            print('=' * 63)
        else :
            print("No Lottery")




def __main__():
    flag = True
    list_num = []
    create_dic()
    while flag :
        print("============= Menu =============")
        print("1. Creation\t\t\t\t(C)")
        print("2. Display the Set\t\t(D)")
        print("3. Save to file\t\t\t(S)")
        print("4. Check the Result\t\t(R)")
        print("5. Exit the Program\t\t(Q)")
        print("================================")

        num = input("Select Menu : ")

        if num == "1" or num == "c" or num == "C":
            list_num = create_num()

        elif num == "2" or num == "d" or num == "D":
            check_num(list_num);

        elif num == "3" or num == "s" or num == "S":
            save_file(list_num)

        elif num == "4" or num == "r" or num == "R":
            winner();

        elif num == "5" or num == "q" or num == "Q":
            print("main() :: Exit the Program")
            flag = False
        else :
            print("Error! You input wrong data")


__main__()
from tkinter import *
import time
import threading
from functools import partial
import random

def stopWatch():
    global flag, record;
    hour, minute, second = int(record[0]), int(record[1]),int(record[2]);

    for hours in range(hour, 100):
        if flag != 0 :
            break;
        for minutes in range(minute, 60):
            if flag != 0:
                break;
            for seconds in range(second, 60):
                if flag != 0:
                    break;
                time.sleep(1)

                if hours < 10 :
                    record[0] = "0"+ str(hours)
                else :
                    record[0] = str(hours)

                if minutes < 10 :
                    record[1] = "0"+ str(minutes)
                else :
                    record[1] = str(minutes)

                if seconds < 10 :
                    record[2] = "0"+ str(seconds)
                else :
                    record[2] = str(seconds)

                time_text.configure(text = record[0]  + ":" + record[1]  + ":" + record[2]);
        hours = hours + 1

def clickStart(level):
    global flag, t;
    flag = 0;
    t = threading.Thread(target=stopWatch)
    if level == 1 :
        for i in range(0,12) :
            clickUnBocked(i)
    elif level == 2 :
        for i in range(0,20) :
            clickUnBocked(i)
    else :
        for i in range(0,30) :
            clickUnBocked(i)

    t.start()

def clickStop(level) :
    global flag, t;

    if score < 30 and level == 1:
        check_score_label.configure(text="점수가 부족합니다.", bg="red")
    elif score >= 30 and score < 100 and level == 2 :
        check_score_label.configure(text="점수가 부족합니다.", bg="red")
    elif score >= 100 and score < 325 and level == 3 :
        check_score_label.configure(text="점수가 부족합니다.", bg="red")
    else:
        flag = 1;
        check_score_label.configure(text="다음 단계로!")
        if level == 1 :
            nextbtn.place(x=195 , y=320)
        elif level == 2 :
            nextbtn.place(x=195 , y=380)
        else :
            nextbtn.place(x=300, y=420)

def clickUnBocked(index) :
    btnList[index].configure(state="normal", bg="white");

def clickBocked(index) :
    print("clickBocked")
    btnList[index].configure(state="disabled", bg="black");

def clickScore(index,name) :
    global clickCcount, temp_name, score;

    clickCcount += 1;

    if clickCcount % 2 == 1 :
        temp_name = ['',''];
        temp_name[0] = name;
        temp_index[1] = -1;
        temp_index[0] = index;


    else :
        temp_name[1] = name;
        temp_index[1] = index;

    clickBocked(index)
    if temp_index[0] != -1 and temp_index[1] != -1 :

        if temp_name[0] == temp_name[1] :
            if score < 30 :
                score += 5;
            elif score >= 30 and score < 100 :
                score += 10;
            else :
                score += 15;
            score_text.configure(text=str(score));
            temp_name = ['',''];

        else :
            # print("땡!")
            btnList[temp_index[0]].configure(state="normal", bg="white");
            btnList[temp_index[1]].configure(state="normal", bg="white");

def clickNext(level) :
    print(level)
    if level == 1:
        frame.destroy();
        level2();
    elif level == 2 :
        frame1.destroy();
        level3();
    else :
      messageWindow();

def messageWindow():
    global mesbox
    mesbox = Toplevel()
    mesbox.title('마침')
    mesbox.geometry("200x100");
    mesbox.resizable(0, 0)
    message = "수고하셨습니다!\n걸린 시간은 " + record[0]  + ":" + record[1]  + ":" + record[2] + " 입니다.\n" + "당신의 점수는 " + str(score) + "점 입니다."
    Label(mesbox, text=message).place(x=15, y=15);
    Button(mesbox, text='확인', command=close).place(x=85, y=75);

def close() :
    mesbox.destroy();
    window.destroy();

def level1() :
        global time_text, score_text, score, btnList, check_score_label, nextbtn
        level, num = 1 , 0;
        xPos, yPos = 75, 30;
        num, j = 0, 0;
        photoList = [None] * 12;
        btnList = [None] * 12;
        namelist = [''] * 12;
        ran = [];

        frame.pack();
        level1Button.configure(state="disabled");
        clickStart_with_arg = partial(clickStart, level)
        startbtn = Button(frame, text="시작", command = clickStart_with_arg);
        clickStop_with_arg = partial(clickStop, level)
        finishbtn = Button(frame, text="완료", command = clickStop_with_arg);
        clickNext_with_arg = partial(clickNext, level)
        nextbtn = Button(frame, text="다음", command = clickNext_with_arg, bg="skyblue");

        check_score_label = Label(frame, text='');
        for i in range(0, 12):
            ran.append(i);

        random.shuffle(ran);
        print(ran)
        for i in ran:
            if i > 5:
                j = i - 6;
                namelist[num] = fnameList[j];
                photoList[num] = PhotoImage(file="GIF/" + fnameList[j]);
                action_with_arg = partial(clickScore, int(num), namelist[num])
                btnList[num] = Button(frame, image=photoList[num],command=action_with_arg, state="disabled");

            else :
                namelist[num] = fnameList[i];
                photoList[num] = PhotoImage(file="GIF/" + fnameList[i]);
                action_with_arg = partial(clickScore, int(num), namelist[num])
                btnList[num] = Button(frame, image=photoList[num],command=action_with_arg, state="disabled");
            num += 1;

        num = 0;
        for i in range(0, 3):
            for k in range(0, 4):
                btnList[num].place(x=xPos, y=yPos);
                num += 1;
                xPos += 70;
            xPos = 75;
            yPos += 70;

            startbtn.place(x= 170, y=yPos+5);
            finishbtn.place(x= 230, y=yPos+5);

        check_score_label.place(x=175 , y=yPos+50);

        window.mainloop();

def level2():
    global time_text, score_text, score, btnList, check_score_label, nextbtn, frame1
    level, num = 2, 0;
    xPos, yPos = 45, 30;
    num, j = 0, 0;
    photoList = [None] * 20;
    btnList = [None] * 20;
    namelist = [''] * 20;
    ran = [];

    frame1.pack();
    clickStart_with_arg = partial(clickStart, level)
    startbtn = Button(frame1, text="시작", command=clickStart_with_arg);
    clickStop_with_arg = partial(clickStop, level)
    finishbtn = Button(frame1, text="완료", command=clickStop_with_arg);
    clickNext_with_arg = partial(clickNext, level)
    nextbtn = Button(frame1, text="다음", command=clickNext_with_arg , bg="skyblue");
    check_score_label = Label(frame1, text='');

    for i in range(0, 20):
        ran.append(i);

    random.shuffle(ran);

    for i in ran :
        if i > 9:
            j = i - 10;
            namelist[num] = fnameList[j];
            photoList[num] = PhotoImage(file="GIF/" + fnameList[j]);
            action_with_arg = partial(clickScore, int(num), namelist[num])
            btnList[num] = Button(frame1, image=photoList[num], command=action_with_arg, state="disabled");

        else:
            namelist[num] = fnameList[i];
            photoList[num] = PhotoImage(file="GIF/" + fnameList[i]);
            action_with_arg = partial(clickScore, int(num), namelist[num])
            btnList[num] = Button(frame1, image=photoList[num], command=action_with_arg, state="disabled");
        num += 1;

    num = 0;
    for i in range(0, 4):
        for k in range(0, 5):
            btnList[num].place(x=xPos, y=yPos);
            num += 1;
            xPos += 70;
        xPos = 45;
        yPos += 70;

        startbtn.place(x=160, y=yPos + 5);
        finishbtn.place(x=230, y=yPos + 5);

    check_score_label.place(x=175, y=350);

    window.mainloop();

def level3():
    global time_text, score_text, score, btnList, check_score_label, nextbtn, frame2
    level, num = 3, 0;
    xPos, yPos = 0, 30;
    num, j = 0, 0;
    photoList = [None] * 30;
    btnList = [None] * 30;
    namelist = [''] * 30;
    ran = [];

    frame2.pack();
    clickStart_with_arg = partial(clickStart, level)
    startbtn = Button(frame2, text="시작", command=clickStart_with_arg);
    clickStop_with_arg = partial(clickStop, level)
    finishbtn = Button(frame2, text="완료", command=clickStop_with_arg);
    clickNext_with_arg = partial(clickNext, level)
    nextbtn = Button(frame2, text="다음", command=clickNext_with_arg , bg="skyblue");
    check_score_label = Label(frame2, text='');

    for i in range(0, 30):
        ran.append(i);

    random.shuffle(ran);

    for i in ran :
        if i > 14:
            j = i - 15;
            namelist[num]  = fnameList[j];
            photoList[num] = PhotoImage(file="GIF/" + fnameList[j]);
            action_with_arg = partial(clickScore, int(num), namelist[num])
            btnList[num] = Button(frame2, image=photoList[num], command=action_with_arg, state="disabled");

        else:
            namelist[num] = fnameList[i];
            photoList[num] = PhotoImage(file="GIF/" + fnameList[i]);
            action_with_arg = partial(clickScore, int(num), namelist[num])
            btnList[num] = Button(frame2, image=photoList[num], command=action_with_arg, state="disabled");
        num += 1;

    num = 0;
    for i in range(0, 5):
        for k in range(0, 6):
            btnList[num].place(x=xPos, y=yPos);
            num += 1;
            xPos += 70;
        xPos = 0;
        yPos += 70;

        startbtn.place(x=140, y=yPos + 5);
        finishbtn.place(x=210, y=yPos + 5);

    check_score_label.place(x=155, y=yPos + 40);

    window.mainloop();

## main
fnameList = ["froyo.gif", "gingerbread.gif", "honeycomb.gif", "icecream.gif", "jellybean.gif", "kitkat.gif", "lollipop.gif", "marshmallow.gif", "nougat.gif", "eclair.gif","dog.gif","dog2.gif","dog3.gif","dog4.gif","dog5.gif"] ;
flag = False;
record = ['0','0','0','0']; # 0번:시, 1번:분, 2번:초, 3번:점수
check = 0;
score, clickCcount,temp_name, temp_index = 0, 0, ['',''] ,[-1,-1];

window = Tk();
window.title("과제3");
window.geometry("420x555");
window.resizable(0,0)

frame = Frame(window, width=420, height=475);
frame1 = Frame(window, width=420, height=475);
frame2 = Frame(window, width=420, height=475);


introLabel = Label(window,text = "레벨1 : 3X4\n레벌2 : 4X5\n레벨3 : 5X6\n레벨순으로 게임이 진행됩니다.\n 하단의 시작버튼을 클릭해주세요.");
next_with_arg = partial(clickNext, 0)
level1Button = Button(window, text = "시작", command = level1);

time_label = Label(window, text="시간 : ");
time_text = Label(window, text="00:00:00");
score_label = Label(window, text="점수 : ");
score_text = Label(window, text="0");

time_label.place(x=125, y=110);
time_text.place(x=155, y=110);
score_label.place(x=225, y=110);
score_text.place(x=255, y=110);

introLabel.pack(side = TOP);

level1Button.pack();
window.mainloop();
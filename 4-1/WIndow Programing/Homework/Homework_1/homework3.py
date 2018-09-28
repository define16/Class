import random

mTuple = ('가위','바위','보');
mList = list(mTuple);

s = str(input("게임시작(가위, 바위, 보) "));

com = random.choice(mList);

winer = 0;

if s == com :
     winer = 0;
elif s == '가위' :
    if com == '보' :
        winer = 1;
    else :
        winer = 2;

elif s == '바위':
    if com == '가위' :
        winer = 1;
    else :
        winer = 2;
else :
    if com == '바위' :
        winer = 1;
    else :
        winer = 2;

print("사용자 : [ %s ], 컴퓨터 : [ %s ]" % (s, com) );

if winer == 0 :
    print("비겼습니다.");
elif winer == 1 :
    print("사용자가 이겼습니다.");
else :
    print("컴퓨터가 이겼습니다.");
s = "i'm fine thank you and you?";

f1 = s.find("you");
f2 = s.find("you", 16);
f3 = s.rfind("you");

print(s);

print("you의 위치는 %d 번째입니다." % f1);
print("16번째 이후, you의 위치는 %d 번째입니다." % f2);
print("you의 위치는 %d 번째입니다. (역으로 검색)" % f3);





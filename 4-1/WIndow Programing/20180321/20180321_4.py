score = int(input("성적을 입력하세요 : "));
c = ""

if score >= 90 :
    c = "A";
elif score >= 80 and score < 90 :
    c = "B";
elif score >= 70 and score < 80 :
    c = "C";
elif score >= 60 and score < 70 :
    c = "D";
else : 
    c = "F";

print("당신의 점수는 [ %d ]이고, 학점은 [ %s ]입니다." % (score, c ));

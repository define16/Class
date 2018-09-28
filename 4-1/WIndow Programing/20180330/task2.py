nameList = ["홍길동", "123", "김철수","5678","김영희","3333","김부자","5555"];
answer = "";
id = str(input("1) 아이디 : "));
pw = str(input("2) 비밀번호 : "));

for i in range(0,len(nameList),2) :
    if id == nameList[i] :
        if pw == nameList[i+1] :
            answer = "회원이십니다."
            break;

        else :
            answer = "회원이 아닙니다."
    else :
        answer = "회원이 아닙니다."

print(answer);


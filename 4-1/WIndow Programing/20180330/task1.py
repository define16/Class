s = '';
answer = ["큰 수는 [", "] 수 인 [", "] 입니다."];
big = 0;

input1 = int(input("첫번째 수:"));
input2 = int(input("두번째 수:"));


mtuple = (input1, input2);

if input1 < input2 :
    s = "두번째"
    big = input2;
elif input1 > input2 :
    s = "첫번째";
    big = input1;
else :
    s = "같음"
    big = input1;

print(answer[0], s, answer[1], big, answer[2]);

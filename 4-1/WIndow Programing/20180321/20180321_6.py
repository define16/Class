a = int(input("1) 초기값을 입력하세요 : "))
b = int(input("2) 최종값을 입력하세요 : "))
c = int(input("3) 배수를 입력하세요 : "))
answer = 0;
cnt = 0;

for i in range(a, b+1, c) :
    #if i % c == 0 :
    answer = answer + i;
    cnt += 1;


print("[ %d ]배수의 개수는 [ %d ], 합은 [ %d ] 입니다." % (c, cnt, answer));

# for i in range(a, b + 1, i):
#     if i % c == 0 :
#         answer = answer + i;
#         cnt += 1;
#
# print("[ %d ]배수의 개수는 [ %d ], 합은 [ %d ] 입니다." % (c, cnt, answer));

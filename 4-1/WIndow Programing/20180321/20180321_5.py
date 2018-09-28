n = int(input("n수를 입력하세요 : "));
answer = 0; 
for i in range(1, n+1, 1) :
    answer = answer + i;
    
print("1qnxj [ %d ] 까지의 합은 [ %d ] 입니다. " % (n, answer))


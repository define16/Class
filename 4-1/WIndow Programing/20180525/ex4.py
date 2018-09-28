def sum_(kor, eng, mth) :
    sum = kor + eng + mth;
    return sum;

def avg_(sum) :
    avg = sum / 3;
    return  avg;

outFp = open("data2.txt", "w", encoding="UTF-8");

name = input("이름을 입력하세요 : ");
kor = int(input("국어점수를 입력하세요 : "))
eng = int(input("영어점수를 입력하세요 : "))
mth = int(input("수학점수를 입력하세요 : "))
sum = sum_(kor, eng, mth);
avg = avg_(sum);


outFp.writelines(name + "  " + str(kor) +  "  "  + str(eng) + "  " + str(mth) + "  " + str(sum) + "  " + str(avg));



outFp.close()

print("--- 정상적으로 파일에 씀 ---")
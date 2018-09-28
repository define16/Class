def sum_(kor, eng, mth) :
    sum = kor + eng + mth;
    return sum;

def avg_(sum) :
    avg = sum / 3;
    return  avg;

inFp = open("data1.txt", "r", encoding="UTF-8")
outFp = open("data2.txt", "w", encoding="UTF-8");
student = [];

inList = inFp.readlines()
for inStr in inList:
    student = inStr.split(" ");
    student[3] = student[3] .replace("\n","")
    sum = sum_(int(student[1]),int(student[2]),int(student[3]));
    avg = avg_(sum);
    outFp.writelines("-------------------------------------------------\n");
    outFp.writelines(student[0] + "  " + student[1]+ "  " + student[2]+ "  " + student[3] + "  " + str(sum) + "  " + str(avg) +"\n");

inFp.close()
outFp.writelines("-------------------------------------------------\n");
outFp.close()

print("--- 정상적으로 파일에 씀 ---")
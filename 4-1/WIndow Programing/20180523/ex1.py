
class Student :
    #name, kor, eng, mth, sum, avg
    total = [];
    score = ['',0,0,0,0,0.0,0,''];

    def __init__(self,total):
        for i in total :
            for j in range(0, len(i)) :
                self.score[j] = i[j];
            self.total.append(self.score);


    def setScore(self, total):
        self.total = [None] * 3;
        for i in total:
            for j in range(0, len(i)) :
                self.score[j] = i[j];
            self.total.append(self.score)


    def getScore(self):
        return self.total;

    def sumScore(self, total):
        sum = 0;
        temp = [];
        for i in total :
            sum = 0;
            for j in range(1,4) :
                sum += int(i[j]);
            i[4] = sum;
            temp.append(i)

        return temp;


    def avgScore(self,total):
        avg = 0.0;
        temp = [];
        for i in total :
            avg = 0.0;
            avg = i[4] / 3;
            i[5] = avg;
            temp.append(i);

        return temp;

    def rankScore(self, total):
        rank = [1,1,1];
        temp = [];

        for i in range(0, len(total)) :
            for j in range(0, len(total)) :
                if i != j :
                    if total[i][4] < total[j][4] :
                        rank[i] += 1;

        index = 0;
        for i in total :
            i[6] = rank[index];
            index += 1;
            temp.append(i)

        return temp;

    def hak(self,total):
        temp1 = []
        for i in total :
            temp = int(i[5]);
            if temp >= 90 :
                i[7] = 'A';
            elif temp >= 80 and temp < 90 :
                i[7] = 'B';
            elif temp >= 70 and temp < 80 :
                i[7] = 'C';
            elif temp >= 60 and temp < 70 :
                i[7] = 'D';
            else :
                i[7] = 'F'

            temp1.append(i);

        return temp1;




class Println(Student) :

    def __init__(self):
        pass;

    def toPrint(self, total):
        index = 1;
        for i in total :
            print("[%d] [ %s ] 학생" % (index,i[0]))
            print("국어 :", i[1], "\n영어 :", i[2], "\n수학 :", i[3], "\n총점 :", i[4],  "\n평균 :", i[5],  "\n등수 :", i[6], "\n학점 :", i[7]);
            index += 1;

        index = 1;
        for i in total :
            print("[%d] [ %s ] " % (index,i[0]), end="");

            for j in range(1,int(i[5])+1 ,1) :
                if j % 10 == 0 :
                    print("■", end="")
            print(" (평균 : %f )" % i[5])
            index += 1;
## main ##

total = [];
score = ['', 0, 0, 0, 0, 0.0, 0,''];
output=['이름','국어','영어','수학']
p = Println();

for i in range(0,3) :
    score = ['',0,0,0,0,0.0,0,''];
    for j in range(0,4) :
        score[j] = input(output[j] + " 입력하세요 : ");
    total.append(score);

print(total)
s = Student(total)

total = s.sumScore(total);
total = s.avgScore(total);
total = s.rankScore(total);
total = s.hak(total)

p.toPrint(total)











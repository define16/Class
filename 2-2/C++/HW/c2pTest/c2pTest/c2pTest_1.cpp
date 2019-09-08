#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
using namespace std;

class problem1{
public:
	struct str{
		double korean, english, math;
		string name;
		double sum, average;
		char grade;
		int rank, num;
	}student[4];
	double korSum, engSum, mathSum;
	double korAvg, engAvg, mathAvg;

	virtual void getInput(string txt) = 0;
	virtual void getSum() = 0;
	virtual void getAverage() = 0;
	virtual void getGrade() = 0;
	virtual void getRank() = 0;
	virtual void outPut(string txt) = 0;
};
class problem1_1:public problem1{
public:
	void getInput(string txt){
		ifstream input(txt);
		if(input.fail()){
			cout<<"파일 불러오기 실패."<<endl;
		}
		int i = 0;
		while (!input.eof())
		{
			input >> student[i].num >> student[i].name 
				>> student[i].korean >> student[i].english >> student[i].math;
			i++;
		}
		input.close();
	}

	void getSum(){
		korSum = 0;
		engSum = 0;
		mathSum = 0;
		for(int i = 0; i < 4; i++)
		{
			korSum += student[i].korean;
			engSum += student[i].english;
			mathSum += student[i].math;

			student[i].sum = student[i].korean + student[i].english + student[i].math;
		}
	}

	void getAverage(){
		for(int i = 0; i < 4; i++)
			student[i].average = student[i].sum / 3;
		korAvg = korSum / 4;
		engAvg = engSum / 4;
		mathAvg = mathSum / 4;
	}

	void getGrade(){
		for(int i = 0; i < 4; i++)
		{
			if(student[i].average <= 100 && student[i].average >= 90)
				student[i].grade = 'A';
			else if(student[i].average < 9 && student[i].average >= 80)
				student[i].grade = 'B';
			else if(student[i].average < 80 && student[i].average >= 70)
				student[i].grade = 'C';
			else if(student[i].average < 70 && student[i].average >= 60)
				student[i].grade = 'D';
			else 
				student[i].grade = 'F';
		}
	}

	void getRank(){
		for(int i = 0; i < 4; i++)
		{
			student[i].rank = 0;
			for(int j = 0; j < 4; j++)
			{
				if(student[i].sum <= student[j].sum)
					student[i].rank++;
			}
		}
	}

	void outPut(string txt){
		ofstream ofile(txt);
		if(ofile.is_open()){
			ofile<<"┌──┬────┬───┬───┬───┬───┬───┬──┬──┐"<<endl;
			ofile<<"│번호│  성명  │ 국어 │ 영어 │ 수학 │ 총점 │ 평균 │학점│석차│"<<endl;
		for(int i=0; i<4; i++)
		{
			ofile << "├──┼────┼───┼───┼───┼───┼───┼──┼──┤"<<endl;
			ofile << "│" << std::left << setw(4) << student[i].num<<"│"<<setw(8)<< student[i].name
				<< "│" << setw(6) << student[i].korean << "│" << setw(6) << student[i].english << "│" << setw(6) << student[i].math 
				<< "│" << setw(6) << student[i].sum << "│" << setw(6) << setprecision(4) << student[i].average 
				<< "│" << setw(4) << student[i].grade << "│" << setw(4) << student[i].rank << "│" << endl;
		}
			ofile << "└──┴────┴───┴───┴───┴───┴───┴──┴──┘" << endl;
		}
		ofile << endl;
		ofile << "[총점에 대한 막대그래프]" << endl;
		ofile << endl;
		int v = 0;
		int t = 0;
		for(int i = 0; i < 4; i++)
		{
			ofile << std::left << setw(2) << student[i].num << setw(10) << student[i].name;
			if(v = student[i].sum / 30)
			for(int i = 1; i <= v; i++)
			{
			ofile << "■";
			}
			if(t = (int)student[i].sum % 30 >= 25)
			{
			ofile << "■";
			}
			ofile << "  (" << student[i].sum << "점)" << endl;
		}
		ofile << endl;
		ofile << "┌───────┬───────┬───────┐" << endl;
		ofile << "│ 전체 국어평균│ 전체 수학평균│ 전체 수학평균│" << endl;
		ofile << "├───────┼───────┼───────┤" << endl;
		ofile << "│" << std::right << setw(12) << setprecision(4) << korAvg << "점"
		<< "│" << std::right << setw(12) << setprecision(4) << engAvg << "점"
		<< "│" << std::right << setw(12) << setprecision(4) << mathAvg << "점" << "│" << endl;
		ofile<<"└───────┴───────┴───────┘"<<endl;
		ofile.close();
		cout<<"member_score.txt파일에 출력완료!"<< endl;
	}
};
int main(){
	problem1 *p = new problem1_1();
	p -> getInput("member.txt");
	p -> getSum();
	p -> getAverage();
	p -> getGrade();
	p -> getRank();
	p -> outPut("member_score.txt");

	delete p;
	return 0;
}
#include <iostream>
#include <string>
using namespace std;

struct Data{
	char name[9];
	double korean;
	double english;
	double math;

}d[4];

class Student
{
protected :
	double sum[4];
	double avg[4];
	char grade[4];
	int rank[4];
	double kor;
	double eng;
	double mat;
	FILE *fp;
public:
	virtual void Sum() = 0;
	virtual void Average() = 0;
	virtual void Grade() = 0;
	virtual void Rank() = 0;

	void Print()
	{
			//printf("┌──┬────┬────┬────┬────┬────┬────┬──┬──┐\n");
		//printf("│번호│이    름│국    어│영    어│수    학│총    점│평    균│학점│석차│\n");
		//for(int i=0;i<4;i++)
		//{
		//	printf("├──┼────┼────┼────┼────┼────┼────┼──┼──┤\n");
		//	printf("│%4d│%8s│%8.1f│%8.1f│%8.1f│%8.1f│%8.2f│%4c│%4d│\n",i+1,d[i].name,d[i].korean,d[i].english,d[i].math,sum[i],avg[i],grade[i],rank[i]);
		//}
		//printf("└──┴────┴────┴────┴────┴────┴────┴──┴──┘\n\n");

		//printf("[총점에 대한 막대그래프]\n\n");

		//for(int i=0;i<4;i++)
		//{
		//	if(i==2)
		//		printf("%d %s\t\t",i+1,d[i].name);
		//	else
		//		printf("%d %s\t",i+1,d[i].name);

		//	if((int)sum[i]%30 >= 25)
		//		printf("■");

		//	for(int j=0;j<(int)(sum[i]/30);j++)
		//		printf("■");
	
		//	printf(" (%.1f점)\n",sum[i]);
		//}
		//printf("┌───────┬───────┬───────┐\n");
		//printf("│전체  국어평균│전체  영어평균│전체  수학평균│\n");
		//printf("├───────┼───────┼───────┤\n");
		//printf("│%11.1f 점│%11.1f 점│%11.1f 점│\n",kor,eng,mat);
		//printf("└───────┴───────┴───────┘\n");

		fp = fopen("print.txt","w");

		fprintf(fp,"┌──┬────┬────┬────┬────┬────┬────┬──┬──┐\n");
		fprintf(fp,"│번호│이    름│국    어│영    어│수    학│총    점│평    균│학점│석차│\n");
		for(int i=0;i<4;i++)
		{
			fprintf(fp,"├──┼────┼────┼────┼────┼────┼────┼──┼──┤\n");
			fprintf(fp,"│%4d│%8s│%8.1f│%8.1f│%8.1f│%8.1f│%8.2f│%4c│%4d│\n",i+1,d[i].name,d[i].korean,d[i].english,
				d[i].math,sum[i],avg[i],grade[i],rank[i]);
		}
		fprintf(fp,"└──┴────┴────┴────┴────┴────┴────┴──┴──┘\n\n");
		fprintf(fp,"[총점에 대한 막대그래프]\n\n");
		for(int i=0;i<4;i++)
		{
			if(i==2)
				fprintf(fp,"%d %s\t\t",i+1,d[i].name);
			else
				fprintf(fp,"%d %s\t",i+1,d[i].name);

			if((int)sum[i]%30 >= 25)
				fprintf(fp,"■");

			for(int j=0;j<(int)(sum[i]/30);j++)
				fprintf(fp,"■");
	
			fprintf(fp," (%.1f점)\n",sum[i]);
		}
		fprintf(fp,"┌───────┬───────┬───────┐\n");
		fprintf(fp,"│전체  국어평균│전체  영어평균│전체  수학평균│\n");
		fprintf(fp,"├───────┼───────┼───────┤\n");
		fprintf(fp,"│%11.1f 점│%11.1f 점│%11.1f 점│\n",kor,eng,mat);
		fprintf(fp,"└───────┴───────┴───────┘\n");
	}	
};

class Calculater : public Student
{
public :
	void Sum(){

		kor = 0;
		eng = 0;
		mat = 0;

		for(int i=0;i<4;i++)
			sum[i] = d[i].korean + d[i].english + d[i].math;
		for(int i=0;i<4;i++)
		{
			kor += d[i].korean;
			eng += d[i].english;
			mat += d[i].math;
		}


	}

	void Average()
	{
		for(int i=0;i<4;i++)
			avg[i] = sum[i]/3;

		kor /= 4; eng /= 4; mat /= 4;
	}

	void Grade()
	{
		for(int i=0; i<4; i++)
		{
			if(avg[i] >= 90 && avg[i] <= 100)
				grade[i] = 'A';
			else if(avg[i] >= 80)
				grade[i] = 'B';
			else if(avg[i] >= 70)
				grade[i] = 'C';
			else if(avg[i] >= 60)
				grade[i] = 'D';
			else
				grade[i] = 'F';
		}
	}

	void Rank()
	{
		for(int i=0; i<4; i++)
		{
			rank[i] = 1;
			for(int j=0; j<4; j++)
				if(sum[i] < sum[j])
					++rank[i];
		}
	}


};

int main(){
	
	FILE *input;
	 
	input = fopen("Input.txt","r");

	for(int i=0;i<4;i++)
		fscanf(input,"%s %le %le %le",&d[i].name ,&d[i].korean ,&d[i].english ,&d[i].math);

	
	fclose(input);

	Student *student = new Calculater();

	student->Sum();
	student->Average();
	student->Grade();
	student->Rank();
	student->Print();


	delete student;
	return 0;
}
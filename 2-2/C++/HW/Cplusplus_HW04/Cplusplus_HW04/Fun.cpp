#include "Data.h"

class Student
{
	FILE *fp;
public :
	Student()
	{
		fp = fopen("HW04.txt","w");
	}
	void Input()
	{
		for(int i=0;i<5;i++)
		{
			try{
				cout << i+1 << "��° �л�" << endl;
				cout << "- �̸� : ";
				cin >> d[i].name;
				cout << "- ���� : ";
				cin >> d[i].korean;
				cout << "- ���� : ";
				cin >> d[i].math;
				cout << "- ���� : ";
				cin >> d[i].english;

				if(d[i].korean > 100 || d[i].korean < 0 || d[i].math > 100 || d[i].math < 0 || d[i].english > 100 || d[i].english < 0)
					throw i;
			}catch(int e)
			{
				cout << "0�� 100������ ������ �Է����ּ���!!"<< endl;
				break;
			}
		}
	}

	void Sum()
	{
		for(int i=0;i<5;i++)
			d[i].sum = d[i].korean + d[i].math + d[i].english;
	}

	void Avg()
	{
		for(int i=0;i<5;i++)
			d[i].avg = (float)d[i].sum/3;
	}

	void Grade()
	{
		for(int i=0;i<5;i++)
		{
			switch((int)d[i].avg/10)
			{
				case 10: case 9:
					d[i].c = 'A'; break;
				case 8:
					d[i].c = 'B'; break;
				case 7:
					d[i].c = 'C'; break;
				case 6:
					d[i].c = 'D'; break;
				default:
					d[i].c = 'F'; break;
			}
		}
	}

	void Sort()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=i+1;j<5;j++)
			{
				if(d[i].sum < d[j].sum)
					swap(d[i], d[j]);
			}
		}
	}

	void Print()
	{
		fprintf(fp,"_______________________����ǥ___________________\n");
		fprintf(fp,"����������������������������������������������������\n");
		fprintf(fp,"����������  ����������Ц������������զ�������\n");
		for(int i=0;i<5;i++)
		{
			fprintf(fp,"����������������������������������������������������\n");
			fprintf(fp,"��%4d��%s��%4d��%4d��%4d��%4d��%.1f��%4c��\n",i+1,d[i].name,d[i].korean,d[i].math,d[i].english,d[i].sum,d[i].avg,d[i].c);
		}
		fprintf(fp,"����������������������������������������������������\n");
	}


};


int main()
{
	Student *student = new Student(); 

	student->Input();
	student->Sum();
	student->Avg();
	student->Grade();
	student->Sort();
	student->Print();
}
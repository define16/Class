#include <stdio.h>
#include <stdlib.h>
#include <fstream>
#include <string>
#include <vector>
using namespace std;


class VECTOR {
private :
	char target[10]; 
	char operation[10];
	float index[2]; // ���� ����
	FILE *fp2;

public:
	void Magnitude();
	void Add();
	void Subtract();
	void InnerProduct();
	void CrossProduct();
	void tostring();

	float x;
	float y;
	float z;

	
};

void VECTOR :: Magnitude() // ���� ũ�� ���
{
	float sum =0.0;
	
	FILE *fp; 
	fp2 = fopen("output_20125345.txt","wt");
	if((fp = fopen("vector_mag.txt","r")) != NULL) //fopen�� ����ؼ� ���� vector_mag.txt�� null�� �ƴҶ����� ����
	{
		
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[0],&x,&y,&z); //  fscanf�� ���Ͽ� �ִ� �������� �ҷ��´�.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f\n", target, operation, index[0],x,y,z); //�ַܼ� ����Ѵ�.
		
		sum = (x*x)+(y*y)+(z*z); //���� ũ�� ����
		fprintf(fp2,"<%2.f, %2.f, %2.f> of Magnitude : %.2f\n",x,y,z,sqrt(sum));
		
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");

}
void VECTOR :: Add()
{
	
	float sum_x=0.0,sum_y=0.0,sum_z=0.0;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
	
	if((fp = fopen("vector_add.txt","r")) != NULL) //fopen�� ����ؼ� ���� vector_add.txt�� null�� �ƴҶ����� ����
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[0],&x,&y,&z);// fscanf�� ���Ͽ� �ִ� �������� �ҷ��´�.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f\n", target, operation, index[0],x,y,z); //�ַܼ� ����Ѵ�.
		sum_x += x; sum_y += y; sum_z += z; //���͵��� ���� ���Ͽ� ���������� �����Ѵ�.
		fscanf(fp,"%f%f%f%f",& index[1],&x,&y,&z); // fscanf�� ���Ͽ� �ִ� �������� �ҷ��´�.
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x,y,z); //�ַܼ� ����Ѵ�.

		if(index[0] == index[1]) // ����üũ(������ ������ ���� ���ƾ��Ѵ�)
		{
		sum_x += x; sum_y += y; sum_z += z; // �� ���͵��� ���� ���Ѵ�.

		fprintf(fp2,"Add>\n%2.f   %2.f   %2.f\n",sum_x,sum_y,sum_z); //�� ������ ���� �ַܼ� ����Ѵ�.
		}
		else
			fprintf(fp2,"���Ұ� ���� �ʽ��ϴ�."); 
		fclose(fp); 
		fclose(fp2);
	}
	else
		printf("file Error");
	
}
void VECTOR::Subtract() // ������ ���� ���Ѵ�.
{
	float sub_x=0.0,sub_y=0.0,sub_z=0.0;
	FILE *fp; 
	fp2 = fopen("output_20125345.txt","a");
	
	if((fp = fopen("vector_sub.txt","r")) != NULL) //fopen�� ����ؼ� ���� vector_sub.txt�� null�� �ƴҶ����� ����
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[1],&x,&y,&z); // fscanf�� ���Ͽ� �ִ� �������� �ҷ��´�.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f\n", target, operation, index[1],x,y,z); //�ַܼ� ����Ѵ�.
		sub_x += x; sub_y += y; sub_z += z; //���͵��� ���� ���Ͽ� ���������� �����Ѵ�.
		fscanf(fp,"%f%f%f%f",& index[1],&x,&y,&z); 
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x,y,z);

		if(index[0] == index[1]) // ����üũ(������ ������ ���� ���ƾ��Ѵ�)
		{

		sub_x -= x; sub_y -= y; sub_z -= z;   // �� ���͵��� ���� ���Ѵ�.

		fprintf(fp2,"Subtract>\n%2.f   %2.f   %2.f\n",sub_x,sub_y,sub_z);
		}
		else
			fprintf(fp2,"���Ұ� ���� �ʽ��ϴ�."); 
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
	
}
void VECTOR::InnerProduct() // ����
{
	
	FILE *fp; 
	fp2 = fopen("output_20125345.txt","a");

	float x_1=0.0, y_1=0.0, z_1=0.0 , scalar = 0.0;

	if((fp = fopen("vector_inner.txt","r")) != NULL) //fopen�� ����ؼ� ���� vector_inner.txt�� null�� �ƴҶ����� ����
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[1],&x,&y,&z);  // ������ �ҷ��� ������ ���� �����Ѵ�.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f", target, operation, index[1],x,y,z);

		fscanf(fp,"%f%f%f%f",& index[1],&x_1,&y_1,&z_1); //������ �ҷ��� ���������� ���� �����Ѵ�.
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x_1,y_1,z_1);
		if(index[0] == index[1]) // ����üũ(������ ������ ���� ���ƾ��Ѵ�)
		{

		scalar = (x*x_1) + (y*y_1) + (z*z_1); // ������ ���ϴ� ��

		fprintf(fp2,"scalar>\n%2.f\n",scalar);
		}
		else
			fprintf(fp2,"���Ұ� ���� �ʽ��ϴ�."); 
		
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
}

void VECTOR::CrossProduct() // ����
{
	FILE *fp; fp2 = fopen("output_20125345.txt","a");

	float x_1=0.0, y_1=0.0, z_1=0.0 , scalar = 0.0;
	float cross_x=0.0, cross_y=0.0, cross_z=0.0;

	if((fp = fopen("vector_cross.txt","r")) != NULL)  //fopen�� ����ؼ� ���� vector_cross.txt�� null�� �ƴҶ����� ����
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[1],&x,&y,&z); // ������ �ҷ��� ������ ���� �����Ѵ�.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f", target, operation, index[1],x,y,z);

		fscanf(fp,"%f%f%f%f",& index[1],&x_1,&y_1,&z_1); //������ �ҷ��� ���������� ���� �����Ѵ�.
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x_1,y_1,z_1);
		
		if(index[0] == index[1]) // ����üũ(������ ������ ���� ���ƾ��Ѵ�)
		{
		cross_x = (y*z_1) - (z*y_1); // ������ ���ϴ� ��
		cross_y = (z*x_1) - (x*z_1);
		cross_z = (x*y_1) - (y*x_1);
		
		fprintf(fp2,"CrossProduct : < %2.f   %2.f   %2.f >\n",cross_x,cross_y,cross_z);
		}else
			fprintf(fp2,"���Ұ� ���� �ʽ��ϴ�."); 
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
}

void VECTOR::tostring()
{
	Magnitude();
	fprintf(fp2,"-----------------------------------------------------------\n");
	Add();
	fprintf(fp2,"-----------------------------------------------------------\n");
	Subtract();
	fprintf(fp2,"-----------------------------------------------------------\n");
	InnerProduct();
	fprintf(fp2,"-----------------------------------------------------------\n");
	CrossProduct();
	fprintf(fp2,"-----------------------------------------------------------\n");
	fclose(fp2);
}


class MATRIX {
private :
	float first_mt[4][4];
	float second_mt[4][4];
	char target[10];
	char operation[10];
	FILE *fp2;
public:
	void Add();
	void Subtract();
	void Multiply();
	void Transpose();
	void tostring();

	float ele[4][4];
	float num_of_rows; // 1�� ��Ʈ����
	float num_of_columns;
	float num_of_rows_1; // 2�� ��Ʈ����
	float num_of_columns_1;

	MATRIX()
	{
		fp2 = fopen("output_20125345.txt","a");
	}
};


void MATRIX::Add() // ����� ��
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
   
	if((fp = fopen("matrix_add.txt","r")) != NULL)  //fopen�� ����ؼ� ���� matrix_add.txt�� null�� �ƴҶ����� ����
	{
			fscanf(fp,"%s%s%f%f",target,operation,&num_of_rows,&num_of_columns); // ������ �ҷ��� ��� ���� ������ �����Ѵ�.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n",target,operation,num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows;i++) // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3��¥�� ����̶� j==2�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}
	
			fscanf(fp,"%f%f",&num_of_rows_1,&num_of_columns_1); // ������ �ҷ��� ��� ���� ������ �����Ѵ�.
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows_1,num_of_columns_1);

			for(int k=0; k< num_of_rows_1;k++) // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int p =0 ; p< num_of_columns_1;p++)
				{
					fscanf(fp,"%f",& second_mt[k][p]);
					fprintf(fp2,"%2.f   ", second_mt[k][p]);
					if(p == 2) // 3��¥�� ����̶� p==2�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}
			fprintf(fp2,"\n");


			if(num_of_rows==num_of_rows_1 && num_of_columns == num_of_columns_1)
			{
			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows; i++)  // ���� for������ ��������� ���Ѵ�.
				for(int p =0 ; p< num_of_columns;p++)
				{
					ele[i][p] =  first_mt[i][p] +  second_mt[i][p];
					fprintf(fp2,"%2.f  ",ele[i][p]);
					if(p == 2) // ���� �ص� 3��¥�� ����̶� p==2�϶� �����ٷ� �Ѿ��.
					fprintf(fp2,"\n");
				}
		fprintf(fp2,"\n");
			}else
			fprintf(fp2,"������� ���� ���� �ʽ��ϴ�."); 

		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
	
	
}
void MATRIX::Subtract() // ����� ����
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
   
	if((fp = fopen("matrix_sub.txt","r")) != NULL)  //fopen�� ����ؼ� ���� matrix_sub.txt�� null�� �ƴҶ����� ����
	{
			fscanf(fp,"%s%s%f%f", target, operation,&num_of_rows,&num_of_columns);  // ������ �ҷ��� ��� ���� ������ �����Ѵ�.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n", target, operation,num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows;i++) // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3��¥�� ����̶� j==2�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}

			fscanf(fp,"%f%f",&num_of_rows_1,&num_of_columns_1);   // ������ �ҷ��� ��� ���� ������ �����Ѵ�.
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows_1,num_of_columns_1);

			for(int k=0; k< num_of_rows_1;k++) // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int p =0 ; p< num_of_columns_1;p++)
				{
					fscanf(fp,"%f",& second_mt[k][p]);
					fprintf(fp2,"%2.f   ", second_mt[k][p]);
					if(p == 2) // 3��¥�� ����̶� p==2�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}
			fprintf(fp2,"\n");

			if(num_of_rows==num_of_rows_1 && num_of_columns == num_of_columns_1)
			{
			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows,num_of_columns);

			for(int i=0; i< num_of_rows; i++)  // ���� for������ ����� ������ ���Ѵ�.
				for(int p =0 ; p< num_of_columns;p++)
				{
					ele[i][p] =  first_mt[i][p] -  second_mt[i][p];
					fprintf(fp2,"%2.f  ",ele[i][p]);
					if(p == 2) // ������ �ص� 3��¥�� ����̶� p==2�϶� �����ٷ� �Ѿ��.
					fprintf(fp2,"\n");
				}
		fprintf(fp2,"\n");
		}else
			fprintf(fp2,"������� ���� ���� �ʽ��ϴ�."); 
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
}
void MATRIX::Multiply() // ����� ����
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
	int sum =0;
	if((fp = fopen("matrix_mult.txt","r")) != NULL)  //fopen�� ����ؼ� ���� matrix_sub.txt�� null�� �ƴҶ����� ����
	{
		
			fscanf(fp,"%s%s%f%f", target, operation,&num_of_rows,&num_of_columns); // ������ �ҷ��� ��� ���� ������ �����Ѵ�.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n", target, operation,num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows;i++)  // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3��¥�� ����̶� j==2�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}
				//fprintf(fp2,"\n");

			fscanf(fp,"%f%f",&num_of_rows_1,&num_of_columns_1);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows_1,num_of_columns_1);

			for(int k=0; k< num_of_rows_1;k++)  // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int p =0 ; p< num_of_columns_1;p++)
				{
					fscanf(fp,"%f",& second_mt[k][p]);
					fprintf(fp2,"%2.f   ", second_mt[k][p]);
					if(p == 1) // 2��¥�� ����̶� p==1�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}
			fprintf(fp2,"\n");


			if(num_of_rows_1==num_of_columns)
			{
			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows,num_of_columns_1);

			for(int i=0; i< num_of_rows_1; i++) // ù��° ����� ���
				for(int j=0; j<num_of_columns;j++) // �ι�° ����� ���� �����ϰ� ������ ����� ũ���̱⶧���� ������ �� ������ �������ش�.
					ele[i][j] = 0;  // ����ϱ����� ���� �ʱ�ȭ�� �����ش�

			// ���� for������ ����� ������ ���Ѵ�. �����Ҷ� ù��° ����� ��� �ι�° ����� ���� ���ʷ� �����ش�.
			for(int i=0; i< num_of_rows_1; i++) 
				for(int j=0; j<num_of_columns;j++) 
				{
					for(int p =0 ; p< num_of_columns;p++) // ù��° ���� ����ŭ ù��°��İ� �ι�°����� �����ش�.
						ele[i][j] +=  first_mt[i][p] *  second_mt[p][j];
				}
				

				for(int i=0; i < num_of_rows;i++) // ����� ������ ���� ����� �����ش�.
					for(int j=0; j< num_of_columns_1;j++)
					{
						fprintf(fp2,"%3.f  ",ele[i][j]);
						if(j == 1) //�����Ŀ��� 2��¥�� ����̶� j==1�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
					}
		fprintf(fp2,"\n");
		}else
			fprintf(fp2,"������� ���� ���� �ʽ��ϴ�."); 

		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");

}
void MATRIX::Transpose() //��ġ���
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
   
	if((fp = fopen("matrix_trans.txt","r")) != NULL)  //fopen�� ����ؼ� ���� matrix_sub.txt�� null�� �ƴҶ����� ����
	{
		
			fscanf(fp,"%s%s%f%f", target, operation,&num_of_rows,&num_of_columns);  // ������ �ҷ��� ��� ���� ������ �����Ѵ�.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n", target, operation,num_of_rows,num_of_columns);

			for(int i=0; i< num_of_rows;i++) // ���� for������ ����� ���� ���Ϸκ��� �޾ƿ´�.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3��¥�� ����̶� j==1�϶� �����ٷ� �Ѿ��.
						fprintf(fp2,"\n");
				}
			

			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\nresult>\n",num_of_columns,num_of_rows);

			for(int i=0; i<num_of_columns; i++) // ���� for������ ��ġ����� ����Ѵ�..
				for(int p =0 ; p<  num_of_rows;p++)
				{
					ele[i][p] =  first_mt[p][i]; // ��ġ����� ��� ���� ���� �ٲ� ����̹Ƿ� �迭�� ���Ұ����� ��ġ�� �Ű��ش�.
					fprintf(fp2,"%2.f  ",ele[i][p]);
					if(p == 1) // ��ġ��� ����Ŀ� 2��¥�� ����̶� p==1�϶� �����ٷ� �Ѿ��.
					fprintf(fp2,"\n");
				}
		fprintf(fp2,"\n");
		
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
	
}

void MATRIX::tostring()
{
	fprintf(fp2,"-----------------------------------------------------------\n");
	Add();
	fprintf(fp2,"-----------------------------------------------------------\n");
	Subtract();
	fprintf(fp2,"-----------------------------------------------------------\n");
	Multiply();
	fprintf(fp2,"-----------------------------------------------------------\n");
	Transpose();
	fprintf(fp2,"-----------------------------------------------------------\n");

	fclose(fp2);
}


int main()
{
	VECTOR *vt = new VECTOR();
	MATRIX *mt = new MATRIX();

	vt->tostring();
	
	mt->tostring(); 
	system("pause"); 

	return 0;
}
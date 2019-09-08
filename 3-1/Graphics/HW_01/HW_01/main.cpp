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
	float index[2]; // 원소 갯수
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

void VECTOR :: Magnitude() // 벡터 크기 계산
{
	float sum =0.0;
	
	FILE *fp; 
	fp2 = fopen("output_20125345.txt","wt");
	if((fp = fopen("vector_mag.txt","r")) != NULL) //fopen을 사용해서 파일 vector_mag.txt을 null이 아닐때까지 읽음
	{
		
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[0],&x,&y,&z); //  fscanf로 파일에 있는 변수들을 불러온다.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f\n", target, operation, index[0],x,y,z); //콘솔로 출력한다.
		
		sum = (x*x)+(y*y)+(z*z); //벡터 크기 계산식
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
	
	if((fp = fopen("vector_add.txt","r")) != NULL) //fopen을 사용해서 파일 vector_add.txt을 null이 아닐때까지 읽음
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[0],&x,&y,&z);// fscanf로 파일에 있는 변수들을 불러온다.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f\n", target, operation, index[0],x,y,z); //콘솔로 출력한다.
		sum_x += x; sum_y += y; sum_z += z; //벡터들을 합을 통하여 지역변수에 저장한다.
		fscanf(fp,"%f%f%f%f",& index[1],&x,&y,&z); // fscanf로 파일에 있는 변수들을 불러온다.
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x,y,z); //콘솔로 출력한다.

		if(index[0] == index[1]) // 오류체크(벡터의 원소의 갯수 같아야한다)
		{
		sum_x += x; sum_y += y; sum_z += z; // 각 벡터들의 합을 구한다.

		fprintf(fp2,"Add>\n%2.f   %2.f   %2.f\n",sum_x,sum_y,sum_z); //각 벡터의 합을 콘솔로 출력한다.
		}
		else
			fprintf(fp2,"원소가 맞지 않습니다."); 
		fclose(fp); 
		fclose(fp2);
	}
	else
		printf("file Error");
	
}
void VECTOR::Subtract() // 벡터의 차를 구한다.
{
	float sub_x=0.0,sub_y=0.0,sub_z=0.0;
	FILE *fp; 
	fp2 = fopen("output_20125345.txt","a");
	
	if((fp = fopen("vector_sub.txt","r")) != NULL) //fopen을 사용해서 파일 vector_sub.txt을 null이 아닐때까지 읽음
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[1],&x,&y,&z); // fscanf로 파일에 있는 변수들을 불러온다.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f\n", target, operation, index[1],x,y,z); //콘솔로 출력한다.
		sub_x += x; sub_y += y; sub_z += z; //벡터들을 합을 통하여 지역변수에 저장한다.
		fscanf(fp,"%f%f%f%f",& index[1],&x,&y,&z); 
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x,y,z);

		if(index[0] == index[1]) // 오류체크(벡터의 원소의 갯수 같아야한다)
		{

		sub_x -= x; sub_y -= y; sub_z -= z;   // 각 벡터들의 차을 구한다.

		fprintf(fp2,"Subtract>\n%2.f   %2.f   %2.f\n",sub_x,sub_y,sub_z);
		}
		else
			fprintf(fp2,"원소가 맞지 않습니다."); 
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
	
}
void VECTOR::InnerProduct() // 내적
{
	
	FILE *fp; 
	fp2 = fopen("output_20125345.txt","a");

	float x_1=0.0, y_1=0.0, z_1=0.0 , scalar = 0.0;

	if((fp = fopen("vector_inner.txt","r")) != NULL) //fopen을 사용해서 파일 vector_inner.txt을 null이 아닐때까지 읽음
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[1],&x,&y,&z);  // 파일을 불러와 변수에 값을 저장한다.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f", target, operation, index[1],x,y,z);

		fscanf(fp,"%f%f%f%f",& index[1],&x_1,&y_1,&z_1); //파일을 불러와 지역변수에 값을 저장한다.
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x_1,y_1,z_1);
		if(index[0] == index[1]) // 오류체크(벡터의 원소의 갯수 같아야한다)
		{

		scalar = (x*x_1) + (y*y_1) + (z*z_1); // 내적을 구하는 식

		fprintf(fp2,"scalar>\n%2.f\n",scalar);
		}
		else
			fprintf(fp2,"원소가 맞지 않습니다."); 
		
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
}

void VECTOR::CrossProduct() // 외적
{
	FILE *fp; fp2 = fopen("output_20125345.txt","a");

	float x_1=0.0, y_1=0.0, z_1=0.0 , scalar = 0.0;
	float cross_x=0.0, cross_y=0.0, cross_z=0.0;

	if((fp = fopen("vector_cross.txt","r")) != NULL)  //fopen을 사용해서 파일 vector_cross.txt을 null이 아닐때까지 읽음
	{
		fscanf(fp,"%s%s%f%f%f%f", target, operation,& index[1],&x,&y,&z); // 파일을 불러와 변수에 값을 저장한다.
		fprintf(fp2,"< %s >\n< %s >\n%2.f\n%2.f   %2.f   %2.f", target, operation, index[1],x,y,z);

		fscanf(fp,"%f%f%f%f",& index[1],&x_1,&y_1,&z_1); //파일을 불러와 지역변수에 값을 저장한다.
		fprintf(fp2,"\n%2.f\n%2.f   %2.f   %2.f\n", index[1],x_1,y_1,z_1);
		
		if(index[0] == index[1]) // 오류체크(벡터의 원소의 갯수 같아야한다)
		{
		cross_x = (y*z_1) - (z*y_1); // 외적을 구하는 식
		cross_y = (z*x_1) - (x*z_1);
		cross_z = (x*y_1) - (y*x_1);
		
		fprintf(fp2,"CrossProduct : < %2.f   %2.f   %2.f >\n",cross_x,cross_y,cross_z);
		}else
			fprintf(fp2,"원소가 맞지 않습니다."); 
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
	float num_of_rows; // 1번 매트리스
	float num_of_columns;
	float num_of_rows_1; // 2번 매트리스
	float num_of_columns_1;

	MATRIX()
	{
		fp2 = fopen("output_20125345.txt","a");
	}
};


void MATRIX::Add() // 행렬의 합
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
   
	if((fp = fopen("matrix_add.txt","r")) != NULL)  //fopen을 사용해서 파일 matrix_add.txt을 null이 아닐때까지 읽음
	{
			fscanf(fp,"%s%s%f%f",target,operation,&num_of_rows,&num_of_columns); // 파일을 불러와 행과 열의 갯수를 저장한다.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n",target,operation,num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows;i++) // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3열짜리 행렬이라서 j==2일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}
	
			fscanf(fp,"%f%f",&num_of_rows_1,&num_of_columns_1); // 파일을 불러와 행과 열의 갯수를 저장한다.
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows_1,num_of_columns_1);

			for(int k=0; k< num_of_rows_1;k++) // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int p =0 ; p< num_of_columns_1;p++)
				{
					fscanf(fp,"%f",& second_mt[k][p]);
					fprintf(fp2,"%2.f   ", second_mt[k][p]);
					if(p == 2) // 3열짜리 행렬이라서 p==2일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}
			fprintf(fp2,"\n");


			if(num_of_rows==num_of_rows_1 && num_of_columns == num_of_columns_1)
			{
			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows; i++)  // 이중 for문으로 행렬의합을 구한다.
				for(int p =0 ; p< num_of_columns;p++)
				{
					ele[i][p] =  first_mt[i][p] +  second_mt[i][p];
					fprintf(fp2,"%2.f  ",ele[i][p]);
					if(p == 2) // 합을 해도 3열짜리 행렬이라서 p==2일때 다음줄로 넘어간다.
					fprintf(fp2,"\n");
				}
		fprintf(fp2,"\n");
			}else
			fprintf(fp2,"행과열이 서로 맞지 않습니다."); 

		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
	
	
}
void MATRIX::Subtract() // 행렬의 뺄셈
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
   
	if((fp = fopen("matrix_sub.txt","r")) != NULL)  //fopen을 사용해서 파일 matrix_sub.txt을 null이 아닐때까지 읽음
	{
			fscanf(fp,"%s%s%f%f", target, operation,&num_of_rows,&num_of_columns);  // 파일을 불러와 행과 열의 갯수를 저장한다.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n", target, operation,num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows;i++) // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3열짜리 행렬이라서 j==2일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}

			fscanf(fp,"%f%f",&num_of_rows_1,&num_of_columns_1);   // 파일을 불러와 행과 열의 갯수를 저장한다.
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows_1,num_of_columns_1);

			for(int k=0; k< num_of_rows_1;k++) // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int p =0 ; p< num_of_columns_1;p++)
				{
					fscanf(fp,"%f",& second_mt[k][p]);
					fprintf(fp2,"%2.f   ", second_mt[k][p]);
					if(p == 2) // 3열짜리 행렬이라서 p==2일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}
			fprintf(fp2,"\n");

			if(num_of_rows==num_of_rows_1 && num_of_columns == num_of_columns_1)
			{
			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows,num_of_columns);

			for(int i=0; i< num_of_rows; i++)  // 이중 for문으로 행렬의 뺄셈을 구한다.
				for(int p =0 ; p< num_of_columns;p++)
				{
					ele[i][p] =  first_mt[i][p] -  second_mt[i][p];
					fprintf(fp2,"%2.f  ",ele[i][p]);
					if(p == 2) // 뺄셈을 해도 3열짜리 행렬이라서 p==2일때 다음줄로 넘어간다.
					fprintf(fp2,"\n");
				}
		fprintf(fp2,"\n");
		}else
			fprintf(fp2,"행과열이 서로 맞지 않습니다."); 
		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");
}
void MATRIX::Multiply() // 행렬의 곱셈
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
	int sum =0;
	if((fp = fopen("matrix_mult.txt","r")) != NULL)  //fopen을 사용해서 파일 matrix_sub.txt을 null이 아닐때까지 읽음
	{
		
			fscanf(fp,"%s%s%f%f", target, operation,&num_of_rows,&num_of_columns); // 파일을 불러와 행과 열의 갯수를 저장한다.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n", target, operation,num_of_rows,num_of_columns);
			for(int i=0; i< num_of_rows;i++)  // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3열짜리 행렬이라서 j==2일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}
				//fprintf(fp2,"\n");

			fscanf(fp,"%f%f",&num_of_rows_1,&num_of_columns_1);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows_1,num_of_columns_1);

			for(int k=0; k< num_of_rows_1;k++)  // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int p =0 ; p< num_of_columns_1;p++)
				{
					fscanf(fp,"%f",& second_mt[k][p]);
					fprintf(fp2,"%2.f   ", second_mt[k][p]);
					if(p == 1) // 2열짜리 행렬이라서 p==1일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}
			fprintf(fp2,"\n");


			if(num_of_rows_1==num_of_columns)
			{
			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\n",num_of_rows,num_of_columns_1);

			for(int i=0; i< num_of_rows_1; i++) // 첫번째 행렬의 행과
				for(int j=0; j<num_of_columns;j++) // 두번째 행렬의 열이 곱셈하고 나서의 행렬의 크기이기때문에 범위를 저 값으로 지정해준다.
					ele[i][j] = 0;  // 계산하기전에 먼저 초기화를 시켜준다

			// 이중 for문으로 행렬의 곱셈을 구한다. 곱셈할때 첫번째 행렬의 행과 두번째 행렬의 열이 차례로 곱해준다.
			for(int i=0; i< num_of_rows_1; i++) 
				for(int j=0; j<num_of_columns;j++) 
				{
					for(int p =0 ; p< num_of_columns;p++) // 첫번째 행의 수만큼 첫번째행렬과 두번째행렬을 곱해준다.
						ele[i][j] +=  first_mt[i][p] *  second_mt[p][j];
				}
				

				for(int i=0; i < num_of_rows;i++) // 행렬의 곱셈이 끝난 행렬을 보여준다.
					for(int j=0; j< num_of_columns_1;j++)
					{
						fprintf(fp2,"%3.f  ",ele[i][j]);
						if(j == 1) //곱셈후에도 2열짜리 행렬이라서 j==1일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
					}
		fprintf(fp2,"\n");
		}else
			fprintf(fp2,"행과열이 서로 맞지 않습니다."); 

		fclose(fp); fclose(fp2);
	}
	else
		printf("file Error");

}
void MATRIX::Transpose() //전치행렬
{
	int ch;
	FILE *fp; fp2 = fopen("output_20125345.txt","a");
   
	if((fp = fopen("matrix_trans.txt","r")) != NULL)  //fopen을 사용해서 파일 matrix_sub.txt을 null이 아닐때까지 읽음
	{
		
			fscanf(fp,"%s%s%f%f", target, operation,&num_of_rows,&num_of_columns);  // 파일을 불러와 행과 열의 갯수를 저장한다.
			fprintf(fp2,"< %s >\n< %s >\n%2.f   %2.f\n", target, operation,num_of_rows,num_of_columns);

			for(int i=0; i< num_of_rows;i++) // 이중 for문으로 행렬의 값을 파일로부터 받아온다.
				for(int j =0 ; j< num_of_columns;j++)
				{
					fscanf(fp,"%f",& first_mt[i][j]);
					fprintf(fp2,"%2.f   ", first_mt[i][j]);
					if(j == 2) // 3열짜리 행렬이라서 j==1일때 다음줄로 넘어간다.
						fprintf(fp2,"\n");
				}
			

			fprintf(fp2,"< %s >\n", target);
			fprintf(fp2,"%2.f   %2.f\nresult>\n",num_of_columns,num_of_rows);

			for(int i=0; i<num_of_columns; i++) // 이중 for문으로 전치행렬을 계산한다..
				for(int p =0 ; p<  num_of_rows;p++)
				{
					ele[i][p] =  first_mt[p][i]; // 전치행렬은 행과 열이 서로 바뀐 행렬이므로 배열의 원소값들의 위치를 옮겨준다.
					fprintf(fp2,"%2.f  ",ele[i][p]);
					if(p == 1) // 전치행렬 계산후에 2열짜리 행렬이라서 p==1일때 다음줄로 넘어간다.
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
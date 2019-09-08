#include <stdio.h>
#include <string.h>	
#include <math.h>

float vertex[10000][3];
int face[20000][3];

float polygon_normal[20000][3];
float vertex_normal[10000][3];

int v_count = 1;	//face 정보가 1부터 시작
int f_count = 0;


void readObj(char *filenames)   {
   FILE *fp;
   char ch;

   fp = fopen(filenames,"r");
   if(!fp)   {
      printf("%s는 파일을 열 수 없거나 없는 파일입니다.\n ");
   }
       
      while(!(feof(fp)))
      {
         fscanf(fp, "%c",&ch);
         if(ch == 'v')
         {
            fscanf(fp,"%f %f %f",&vertex[v_count][0],&vertex[v_count][1],&vertex[v_count][2]);
            v_count++;
         }
         if(ch == 'f')
         {
            fscanf(fp,"%d %d %d",&face[f_count][0], &face[f_count][1], &face[f_count][2]);
            f_count++;
       }
	
      }
   fclose(fp);
}


void polygonnormal(void)
{
	float a[20000][3];	//p2 - p1
	float b[20000][3];	 //p1 - p3
	float tmp[20000][3];
	float length;
	
     for(int i = 0; i < f_count; i++) {
		a[i][0] = (vertex[face[i][2]][0] - vertex[face[i][1]][0]);		//a_x
		a[i][1] = (vertex[face[i][2]][1] - vertex[face[i][1]][1]);		//a_y
		a[i][2] = (vertex[face[i][2]][2] - vertex[face[i][1]][2]);		//a_z
	
		b[i][0] = (vertex[face[i][0]][0] - vertex[face[i][1]][0]);		//b_x
		b[i][1] = (vertex[face[i][0]][1] - vertex[face[i][1]][1]);		//b_y
		b[i][2] = (vertex[face[i][0]][2] - vertex[face[i][1]][2]);		//b_z

		tmp[i][0] = (a[i][1] * b[i][2]) - (b[i][1] * a[i][2]);
		tmp[i][1] = (a[i][2] * b[i][0]) - (b[i][2] * a[i][0]);
		tmp[i][2] = (a[i][0] * b[i][1]) - (b[i][0] * a[i][1]);

		length = (float)sqrt(tmp[i][0] * tmp[i][0] + tmp[i][1] * tmp[i][1] + tmp[i][2] * tmp[i][2]);
		if(length == 0.0f)
			length = 1.0f;
		

		polygon_normal[i][0] = tmp[i][0] / length;
		polygon_normal[i][1] = tmp[i][1] / length;
		polygon_normal[i][2] = tmp[i][2] / length;

		printf("polygon_normal : %f %f %f\n", polygon_normal[i][0], polygon_normal[i][1], polygon_normal[i][2]);
      }
}

void vertexnormal(void) {
 //    for(int i = 0; i < f_count; i++) {
	//     //초기화된 배열에 각 면의 법선벡터의 좌표 모두 더하기
	//printf("%d번째 \n",i);
 //    vertex_normal[face[i][0]][0] += polygon_normal[i][0];
 //    vertex_normal[face[i][0]][1] += polygon_normal[i][1];
 //    vertex_normal[face[i][0]][2] += polygon_normal[i][2];
 //    vertex_normal[face[i][0]][3] += 1.0; // 개수 카운트
	//  printf("vertex_normal 0 : %f %f %f %f \n",  vertex_normal[face[i][0]][0],vertex_normal[face[i][0]][1],vertex_normal[face[i][0]][2], vertex_normal[face[i][0]][3]);
 //    vertex_normal[face[i][1]][0] += polygon_normal[i][0];
 //    vertex_normal[face[i][1]][1] += polygon_normal[i][1];
 //    vertex_normal[face[i][1]][2] += polygon_normal[i][2];
 //    vertex_normal[face[i][1]][3] += 1.0;
	//  printf("vertex_normal 1 : %f %f %f %f\n",  vertex_normal[face[i][1]][1],vertex_normal[face[i][1]][1],vertex_normal[face[i][1]][2], vertex_normal[face[i][1]][3]);

 //    vertex_normal[face[i][2]][0] += polygon_normal[i][0];
 //    vertex_normal[face[i][2]][1] += polygon_normal[i][1];
 //    vertex_normal[face[i][2]][2] += polygon_normal[i][2];
 //    vertex_normal[face[i][2]][3] += 1.0;
	//  printf("vertex_normal 2 : %f %f %f %f\n",  vertex_normal[face[i][2]][0],vertex_normal[face[i][2]][1],vertex_normal[face[i][2]][2], vertex_normal[face[i][2]][3]);

	// }

	 float temp[20000][3];
	 float k[3] = {1.0,1.0,1.0};

	 for(int i = 0; i< 3 ; i++)
		 for(int j = 0; j< 10000; j++)
			 temp[j][i] = 0.0;

		  printf("MY vertex_normal 0 : %f %f %f \n", k[0], k[1], k[2]);
			  for(int i = 0; i < f_count; i++) { 
				  printf("%d번째 \n",i);
					temp[face[i][0]][0] += polygon_normal[i][0]; 
					temp[face[i][0]][1] += polygon_normal[i][1];
					temp[face[i][0]][2] += polygon_normal[i][2];
					k[0] += 1.0;
					 printf("MY vertex_normal 1 : %f %f %f %f \n",  temp[face[i][0]][0], temp[face[i][0]][0], temp[face[i][0]][0], k[0]);
					temp[face[i][1]][0] += polygon_normal[i][0];
					temp[face[i][1]][1] += polygon_normal[i][1];
					temp[face[i][1]][2] += polygon_normal[i][2];
					k[1]++;
					printf("MY vertex_normal 2 : %f %f %f %f \n",  temp[face[i][1]][0], temp[face[i][1]][0], temp[face[i][1]][0], k[1]);
					temp[face[i][2]][0] += polygon_normal[i][0];
					temp[face[i][2]][1] += polygon_normal[i][1];
					temp[face[i][2]][2] += polygon_normal[i][2];
					k[2]++;
					printf("MY vertex_normal 0 : %f %f %f %f \n",  temp[face[i][2]][0], temp[face[i][2]][0], temp[face[i][2]][0], k[2]);

					vertex_normal[face[i][0]][0] =  temp[face[i][0]][0] / k[0];
					vertex_normal[face[i][0]][1] =  temp[face[i][0]][1] / k[0];
					vertex_normal[face[i][0]][2] =  temp[face[i][0]][2] / k[0];
					
					vertex_normal[face[i][1]][0] =  temp[face[i][1]][0] / k[1];
					vertex_normal[face[i][1]][1] =  temp[face[i][1]][1] / k[1];
					vertex_normal[face[i][1]][2] =  temp[face[i][1]][2] / k[1];
				
					vertex_normal[face[i][2]][0] =  temp[face[i][2]][0] / k[2];
					vertex_normal[face[i][2]][1] =  temp[face[i][2]][1] / k[2];
					vertex_normal[face[i][2]][2] =  temp[face[i][2]][2] / k[2];
			 
				  }
}

int main(int argc, char **argv) {
	readObj(argv[1]);
	polygonnormal();
	vertexnormal();

	return 0;
}

#include "glut.h"
#include <stdio.h>
#include <math.h>
#include <string.h>
float vertex[230000][3] = {};
int face[450000][3] = {};
int temp [450000][3];
int v_count = 1;	//face 정보가 1부터 시작
int f_count = 0;

void readObj(char *filenames)   {
   FILE *fp;
   char ch = '\0';
   fp = fopen(filenames,"r");
   if(!fp)   {
      printf("%s는 파일을 열 수 없거나 없는 파일입니다.\n ");
   }
       
      while(!(feof(fp)))
      {
         fscanf(fp, "%c",&ch);
         if(ch == 'v')	//점의 정보를 가져온다
         {
			fscanf(fp,"%f %f %f",&vertex[v_count][0],&vertex[v_count][1],&vertex[v_count][2]);
            v_count++;
         }
         if(ch == 'f')	//면의 정보를 가져온다
         {
            fscanf(fp,"%d %d %d %d %d %d", &face[f_count][0], &temp[f_count][0], &face[f_count][1], &temp[f_count][1], &face[f_count][2], &temp[f_count][2]);
            f_count++;
       }
	
      }
   fclose(fp);
}


int main(int argc, char **argv) {
	printf("메인이지롱\n");
	readObj(argv[1]);
	int j = 0;
	printf("%d\n", v_count);
	for(int i = 0; i < f_count; i++)
   {
		printf("vertex[0]: %d %d %d \n",vertex[face[i][0]][0] ,vertex[face[i][0]][1] ,vertex[face[i][0]][2]);
		printf("vertex[1]: %d %d %d\n",vertex[face[i][1]][0] ,vertex[face[i][1]][1] ,vertex[face[i][1]][2]);
		printf("vertex[2]: %d %d %d\n",vertex[face[i][2]][0]  ,vertex[face[i][2]][1] ,vertex[face[i][2]][2]);

     }
	printf("%d  : 메인이지롱\n");
}
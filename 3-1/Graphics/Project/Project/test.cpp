#include "glut.h"
#include <stdio.h>
#include <math.h>
#include <string.h>

float y_pos = 0.0;
float y_inc = 0.03;

float y_pos1 = 0.0;
float y_inc1 = 0.01;

float angle = 0.0;


//점과 면의 정보를 받아오는 변수
float vertex[230000][3] = {};
int face[450000][3] = {};
int temp [450000][3];	// 쓰레기값 받는 곳

int v_count = 1;	//face 정보가 1부터 시작
int f_count = 0;

////////////////////////
/// 법선 벡터 계산///
////////////////////////

float vertex_normal[230000][3] = {};

/////////////////////
///빛 주는 부분///
/////////////////////
float light0_pos[4] = {};
float light0_ambient[4] = {};
float light0_diffuse[4] = {};
float light0_specular[4] = {};

float light1_dir[4] = {};
float light1_ambient[4] = {};
float light1_diffuse[4] = {};
float light1_specular[4] = {};

float light2_pos[4] = {};
float light2_dir[4] = {};
float light2_cutoff = 0.0;
float light2_ambient[4] = {};
float light2_diffuse[4] = {};
float light2_specular[4] = {};

float mat_ambient[4] = {};
float mat_diffuse[4] = {};
float mat_specular[4] = {};
float mat_shininess[1]  = {};

int powerflag_0 = 0;
int powerflag_1 = 0;
int powerflag_2 = 0;
int cnt_0 = 0;
int cnt_1 = 0;
int cnt_2 = 0;

#define PI 3.141592



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
		 if(ch == 'n'){
			 fscanf(fp,"%f %f %f",&vertex_normal[v_count][0],&vertex_normal[v_count][1],&vertex_normal[v_count][2]);
		 }

         if(ch == 'f')	//면의 정보를 가져온다
         {
            fscanf(fp," %d %d %d %d %d %d", &face[f_count][0], &temp[f_count][0], &face[f_count][1], &temp[f_count][1], &face[f_count][2], &temp[f_count][2]);
            f_count++;
       }
	
      }
   fclose(fp);
}

//빛, 재질 정보를 얻어오는 함수
void readTxt(void)   {
   FILE *fp;
   char ch[10];
   
   fp = fopen("light_material.txt","r");
   if(!fp)   {
      printf("파일을 열 수 없거나 없는 파일입니다.\n ");
   }

      while(!feof(fp))
      {
         fscanf(fp, "%s",ch);

         if(strcmp(ch,"point") == 0)	//point light정보를 가지고온다.
       {
			 fscanf(fp,"%f %f %f",&light0_pos[0],&light0_pos[1],&light0_pos[2]);
			 fscanf(fp,"%f %f %f",&light0_ambient[0],&light0_ambient[1],&light0_ambient[2]);
			 fscanf(fp,"%f %f %f",&light0_diffuse[0],&light0_diffuse[1],&light0_diffuse[2]);
			 fscanf(fp,"%f %f %f",&light0_specular[0],&light0_specular[1],&light0_specular[2]);

			 light0_pos[3] = 1.0;	// 광원의 위치를 사용하겠다는 의미
			 light0_ambient[3] = 1.0;	//ambient을 사용하겠다는 의미
			 light0_diffuse[3] = 1.0; //diffuse을 사용하겠다는 의미
			 light0_specular[3] = 1.0; //specular 을 사용하겠다는 의미
         }
   
      if(strcmp(ch,"dir") == 0)	//directional light정보를 가지고온다.
         {
			 fscanf(fp,"%f %f %f",&light1_dir[0],&light1_dir[1],&light1_dir[2]);
			 fscanf(fp,"%f %f %f",&light1_ambient[0],&light1_ambient[1],&light1_ambient[2]);
			 fscanf(fp,"%f %f %f",&light1_diffuse[0],&light1_diffuse[1],&light1_diffuse[2]);
			 fscanf(fp,"%f %f %f",&light1_specular[0],&light1_specular[1],&light1_specular[2]);

			 light1_dir[3] = 0.0;	// 0인 이유는 (x, y, z)로부터 directional light 광원이기때문
			 light1_ambient[3] = 1.0;//ambient을 사용하겠다는 의미
			 light1_diffuse[3] = 1.0;//diffuse을 사용하겠다는 의미
			 light1_specular[3] = 1.0;//specular 을 사용하겠다는 의미
         }

       if(strcmp(ch,"spot") == 0)	//spot light 정보를 가지고 온다.
         {
			 fscanf(fp,"%f %f %f",&light2_pos[0],&light2_pos[1],&light2_pos[2]);
			 fscanf(fp,"%f %f %f",&light2_dir[0],&light2_dir[1],&light2_dir[2]);
			 fscanf(fp,"%f",&light2_cutoff);
			 fscanf(fp,"%f %f %f",&light2_ambient[0],&light2_ambient[1],&light2_ambient[2]);
			 fscanf(fp,"%f %f %f",&light2_diffuse[0],&light2_diffuse[1],&light2_diffuse[2]);
			 fscanf(fp,"%f %f %f",&light2_specular[0],&light2_specular[1],&light2_specular[2]);

			 light2_pos[3] = 1.0; // 광원의 위치를 사용하겠다는 의미
			 light2_dir[3] = 1.0;  // 광원의 방향를 사용하겠다는 의미
			 light2_ambient[3] = 1.0; //ambient을 사용하겠다는 의미
			 light2_diffuse[3] = 1.0; //diffuse을 사용하겠다는 의미
			 light2_specular[3] = 1.0;//specular 을 사용하겠다는 의미
         }

        if(strcmp(ch,"mat") == 0)	//재질에 대한 정보를 가지고 온다.
         {
			 fscanf(fp,"%f %f %f %f",&mat_ambient[0],&mat_ambient[1],&mat_ambient[2], &mat_ambient[3]);
			 fscanf(fp,"%f %f %f %f",&mat_diffuse[0],&mat_diffuse[1],&mat_diffuse[2], &mat_diffuse[3]);
			 fscanf(fp,"%f %f %f %f",&mat_specular[0],&mat_specular[1],&mat_specular[2], &mat_specular[3]);
			 fscanf(fp,"%f",&mat_shininess[0]);
         }
     }
   fclose(fp);
}

// 빛, 재질을 표현하는 함수
void light(void){
	  //0번째 빛은 point light 구현하는 함수
	  glLightfv(GL_LIGHT0, GL_POSITION, light0_pos);	// 빛의 위치
      glLightfv(GL_LIGHT0, GL_AMBIENT, light0_ambient);	//주의 빛 세기값
      glLightfv(GL_LIGHT0, GL_DIFFUSE, light0_diffuse);	//빛의 범위 값
      glLightfv(GL_LIGHT0, GL_SPECULAR, light0_specular);	//반사되는 빛의 값
	  //1번째 빛은 point light 구현하는 함수
      glLightfv(GL_LIGHT1, GL_POSITION , light1_dir);	// 빛의 위치
      glLightfv(GL_LIGHT1, GL_AMBIENT, light1_ambient);	//주의 빛 세기값
      glLightfv(GL_LIGHT1, GL_DIFFUSE, light1_diffuse);	//빛의 범위 값
      glLightfv(GL_LIGHT1, GL_SPECULAR, light1_specular);	//반사되는 빛의 값
	  //2번째 빛인 spot light 구현하는 함수
	  glLightfv(GL_LIGHT2, GL_POSITION, light2_pos);	// 빛의 위치
      glLightfv(GL_LIGHT2, GL_AMBIENT, light2_ambient);	//주의 빛 세기값
      glLightfv(GL_LIGHT2, GL_DIFFUSE, light2_diffuse);	//빛의 범위 값
      glLightfv(GL_LIGHT2, GL_SPECULAR, light2_specular);	//반사되는 빛의 값
      glLightfv(GL_LIGHT2, GL_SPOT_DIRECTION, light2_dir);	//빛의 방향값
      glLightf(GL_LIGHT2, GL_SPOT_CUTOFF, light2_cutoff);	//스팟라이트의 보호각설정
	  // 재질을 구현하는 함수
      glMaterialfv(GL_FRONT, GL_AMBIENT, mat_ambient);	//주의 빛 세기값
      glMaterialfv(GL_FRONT, GL_DIFFUSE, mat_diffuse);		//빛의 범위 값
      glMaterialfv(GL_FRONT, GL_SPECULAR, mat_specular);	//반사되는 빛의 값
      glMaterialfv(GL_FRONT, GL_SHININESS, mat_shininess);	//반짝임의 정도 설정
}

void MyDisplay(void) {
   glEnable(GL_DEPTH_TEST);	//깊이 정보에 따라 이미지를 순서대로 나줌
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // 화면을 초기화
   
   
   
   glLoadIdentity();
   
 
 //  glRotatef(1 , 0.0,y_pos ,0.0);
   gluLookAt(-5.0, 15.0, -2.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            내눈의 위치   , 바라보는 지점,  up벡터   

/*    glShadeModel(GL_SMOOTH);
	 glScalef(20,20,20);
   glPointSize(2);
   glBegin(GL_POINTS); */  // 삼각형을 그린다.
     /* for(angle = 0.0; angle < 2.0*PI; angle += PI/30.0) {
        glColor3f((0.1*angle) , 0.0 , 0.0 );
        glVertex3f( 0.5 * cos(angle) * y_pos , 0.5 * sin(angle) * y_pos, 0.0); 
		glColor3f(  0.0 ,(0.1*angle), 0.0 );
		glVertex3f( (0.5 * cos(angle) * y_pos )-0.8, 0.5 * sin(angle) * y_pos -0.8, 0.0); 
		glColor3f(  0.0 ,0.0,(0.1*angle));
		glVertex3f( 0.5 * cos(angle) * y_pos +1.3 , 0.5 * sin(angle) * y_pos +1.3, 0.0); 
   }*/
  // for(int i = 0; i< 10; i++) {
	 //   
  //     
		//// 점마다 법선벡터를 적용시킨다.
		//for(int j = 0; j< 10; j++) {
		//	 glColor3f(0.0 , 0.2 *i , 0.1 *i/2 );
		//	glVertex3f(j*(0.2)*cos(2.0), i+y_pos, 1); 
		//	 glColor3f(0.0 , 0.1 *i , 0.4 *i/2 );
		//	glVertex3f(j*(0.3), i+y_pos, 2); 
		//	 glColor3f(0.0 , 0.1 *i , 0.7 *i/2 );
		//	glVertex3f(j*(0.4) ,i+y_pos, 3); 
		//	 glColor3f(0.0 , 0.1 *i , 0.2 *i/2 );
		//	glVertex3f(j*(0.5) ,i+y_pos ,4); 
		//}

		//glColor3f(0.1 *i ,0.0 , 0.1 *i/2 );
		//	for(int j = 0; j< 10; j++) {
		//	//glColor3f(0.1 *j , 0.01 *j, 0.1 *j/2 );
		//	glVertex3f(j,i+y_pos,5);
		//	glVertex3f(j,i+y_pos,6);
		//	glVertex3f(j,i+y_pos,7);
		//	glVertex3f(j,i+y_pos,8);
		//	glVertex3f(j,i+y_pos,9);
		//	}

		//	glColor3f(0.1 *i , 0.1 *i , 0.0 );
		//	for(int j = 0; j< 10; j++) {
		//	//glColor3f(0.1 *j , 0.01 *j , 0.1 *j/2 );
		//	glVertex3f(j,i+y_pos,10);
		//	glVertex3f(j,i+y_pos,11);
		//	glVertex3f(j,i+y_pos,12);
		//	}
		//}
    //  glEnd();
   //glScalef(20,20,20);
    glShadeModel(GL_SMOOTH); // Flat 기법
	

   glEnable(GL_LIGHTING);	// 조명 효과를 설정

   if(powerflag_0 == 0)         // Point light on
	   glDisable(GL_LIGHT0);
   else							// Point light off
	   glEnable(GL_LIGHT0);
   
   if(powerflag_1 == 0)    // Directional light on
	    glDisable(GL_LIGHT1);
   else						// Directional light off
	    glEnable(GL_LIGHT1);
   
   if(powerflag_2 == 0)   // Spot light on
	    glDisable(GL_LIGHT2);
	else						// Spot light off
       glEnable(GL_LIGHT2);	//조명을 킨다.
      
	light();
	//glScalef(3.0, 3.0, 3.0);
   glBegin(GL_TRIANGLES);	   // 삼각형을 그린다.
   for(int i = 0; i < f_count; i++)
   {
		glColor3f(0.0 , 0.0, 0.0);
		glNormal3f(vertex_normal[face[i][0]][0], vertex_normal[face[i][0]][1], vertex_normal[face[i][0]][2]);	// i번째 면에서 해당하는 점 3개 가지고오기
		glVertex3f(vertex[face[i][0]][0] ,vertex[face[i][0]][1] ,vertex[face[i][0]][2]); 
	
		glNormal3f(vertex_normal[face[i][1]][0], vertex_normal[face[i][1]][1], vertex_normal[face[i][1]][2]);	// i번째 면에서 해당하는 점 3개 가지고오기
	//	glNormal3f(vertex_normal[face[i][1]][0], vertex_normal[face[i][1]][1], vertex_normal[face[i][1]][2]);
		glVertex3f(vertex[face[i][1]][0] ,vertex[face[i][1]][1] ,vertex[face[i][1]][2]);
	
		glNormal3f(vertex_normal[face[i][1]][0], vertex_normal[face[i][1]][1], vertex_normal[face[i][1]][2]);	// i번째 면에서 해당하는 점 3개 가지고오기
	//	glNormal3f(vertex_normal[i][0], vertex_normal[i][1], vertex_normal[i][2]);
		glVertex3f(vertex[face[i][2]][0]  ,vertex[face[i][2]][1] ,vertex[face[i][2]][2]);
     }
      glEnd();

  // 
   glutSwapBuffers();
}



void MyReshape(int w, int h)
{
	glOrtho(-145,145, -145, 145, -45,45);
   glMatrixMode(GL_MODELVIEW);
}


void MyIdle()
{
	if(y_pos >= 60.0 || y_pos<0.0)  y_inc *= 0.03;
		y_pos+=y_inc;

	if(y_pos1 >= 60.0 || y_pos1<0.0)  y_inc1*= -0.01;
	y_pos1+=y_inc1;



	glutPostRedisplay();
}
void MyKeyboard(unsigned char key, int x, int y)
{
   switch(key)
   {
   case '1':      //Point light on/off
	  cnt_0++;
	  if(cnt_0 == 0)
		  powerflag_0 = 0;
	  else if(cnt_0 % 2 == 0)
		  powerflag_0 = 0;
	  else
		  powerflag_0 = 1;
      break;
   case '2':      //Directional light on/off
      cnt_1++;
	  if(cnt_1 == 0)
		  powerflag_1 = 0;
	  else if(cnt_1 % 2 == 0)
		  powerflag_1 = 0;
	  else
		  powerflag_1 = 1;
      break;
   case '3':      //Spot light on/off
      cnt_2++;
	  if(cnt_2 == 0)
		  powerflag_2 = 0;
	  else if(cnt_2 % 2 == 0)
		  powerflag_2 = 0;
	  else
		  powerflag_2 = 1;
      break;
   }
   glutPostRedisplay(); // GLUT이 현재 창을 새로고침 하도록 한다

} //키보드를 눌렀을 때

int main(int argc, char **argv) {
	printf("시작\n");
	readObj(argv[1]);
	printf("obj는 성공\n");
	readTxt();	
	printf("빛도 성공\n");
	//polygonnormal();
	//printf("법선벡터 성공\n");
   glutInit(&argc, argv); // 초기화를 시켜준다.
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // 더블버퍼링와 RGB색상으로 디스플레이모드를 초기화한다.
   glutInitWindowPosition(100,100); // 화면 어느위치에 실행되는지 좌표정하기
   glutInitWindowSize(1000,1000); // 창사이즈 정하기
   glutCreateWindow("Test"); // 제목
   glClearColor(1.0, 1.0, 1.0,1.0); // 배경색 정하기
   glLoadIdentity(); // 초기화를 시켜주는 함수입니다.
   glutDisplayFunc(MyDisplay); // 도형을 불러온다.
   glutReshapeFunc(MyReshape);
   //	glutIdleFunc(MyIdle);
   glutKeyboardFunc(MyKeyboard); // 키보드함수 호출
   glutMainLoop(); // 항상 적어야한다.
}
#include "glut.h"
#include <stdio.h>
#include <string.h>
#include <math.h>

float vertex[30000][3] = {};
int face[30000][3] = {};

float polygon_normal[30000][3] = {};
float vertex_normal[30000][3] = {};

int v_count = 1;	//face 정보가 1부터 시작
int f_count = 0;

int shadingflag = 0;

int powerflag_0 = 0;
int powerflag_1 = 0;
int powerflag_2 = 0;
int cnt_0 = 0;
int cnt_1 = 0;
int cnt_2 = 0;

int x_angle = 0;
int y_angle = 0;
int z_angle = 0;

int size = 1;

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

//obj파일을 받아오는 함수
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
         if(ch == 'v')	//점의 정보를 가져온다
         {
            fscanf(fp,"%f %f %f",&vertex[v_count][0],&vertex[v_count][1],&vertex[v_count][2]);
            v_count++;
         }
         if(ch == 'f')	//면의 정보를 가져온다
         {
            fscanf(fp,"%d %d %d",&face[f_count][0], &face[f_count][1], &face[f_count][2]);
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


// 평면 법선 벡터를 계산하는 함수
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

		//외적 계산
		tmp[i][0] = (a[i][1] * b[i][2]) - (b[i][1] * a[i][2]);
		tmp[i][1] = (a[i][2] * b[i][0]) - (b[i][2] * a[i][0]);
		tmp[i][2] = (a[i][0] * b[i][1]) - (b[i][0] * a[i][1]);

		//단위벡터 계산
		length = (float)sqrt(tmp[i][0] * tmp[i][0] + tmp[i][1] * tmp[i][1] + tmp[i][2] * tmp[i][2]);
		if(length == 0.0f)
			length = 1.0f;
		

		polygon_normal[i][0] = tmp[i][0] / length;	//면에 대한 법선벡터 x
		polygon_normal[i][1] = tmp[i][1] / length;	//면에 대한 법선벡터 y
		polygon_normal[i][2] = tmp[i][2] / length;	//면에 대한 법선벡터 z
      }

}

//점에 대한 법선벡터를 그려주는 함수
void vertexnormal(void) {
     for(int i = 0; i < f_count; i++) {
	     //초기화된 배열에 각 면의 법선벡터의 좌표 모두 더하기

     vertex_normal[face[i][0]][0] += polygon_normal[i][0];		//[face[i][0]]과 같은 점의 x축을 더한다.
     vertex_normal[face[i][0]][1] += polygon_normal[i][1];		//[face[i][0]]과 같은 점의 y축을 더한다.
     vertex_normal[face[i][0]][2] += polygon_normal[i][2];		//[face[i][0]]과 같은 점의 z축을 더한다.
     vertex_normal[face[i][0]][3] += 1.0; // [face[i][0]과 같은 점의 개수 카운트

     vertex_normal[face[i][1]][0] += polygon_normal[i][0];		//[face[i][1]]과 같은 점의 x축을 더한다.
     vertex_normal[face[i][1]][1] += polygon_normal[i][1];		//[face[i][1]]과 같은 점의 y축을 더한다.
     vertex_normal[face[i][1]][2] += polygon_normal[i][2];		//[face[i][1]]과 같은 점의 z축을 더한다.
     vertex_normal[face[i][1]][3] += 1.0; // [face[i][1]] 같은 점의 개수 카운트
	 

     vertex_normal[face[i][2]][0] += polygon_normal[i][0];		//[face[i][2]]과 같은 점의 x축을 더한다.
     vertex_normal[face[i][2]][1] += polygon_normal[i][1];		//[face[i][2]]과 같은 점의 y축을 더한다.
     vertex_normal[face[i][2]][2] += polygon_normal[i][2];		//[face[i][2]]과 같은 점의 z축을 더한다.
     vertex_normal[face[i][2]][3] += 1.0; // [face[i][2]] 같은 점의 개수 카운트


	 }
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

void MyDisplay1(void) {
   glEnable(GL_DEPTH_TEST);	//깊이 정보에 따라 이미지를 순서대로 나줌
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // 화면을 초기화
   glLoadIdentity();

 

   gluLookAt(-1.0, 7.0, 20.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            내눈의 위치   , 바라보는 지점, up벡터   

      glShadeModel(GL_SMOOTH); // Gouraud 기법

	
	
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
       glEnable(GL_LIGHT2);	//빛을 킨다.
      
   
    light();

	glRotatef(x_angle, 1.0, 0.0, 0.0); //회전 x
	glRotatef(y_angle, 0.0, 1.0, 0.0);   //회전 y
	glRotatef(z_angle, 0.0, 0.0, 1.0);   //회전 z
    glScalef(size * 1, size * 1, size * 1);   //축소, 확대


   glBegin(GL_TRIANGLES);   // 삼각형을 그린다.
   for(int i = 0; i < f_count; i++)
   {
        glColor3f(i*(0.1) , 0.0, 0.0);
		// 점마다 법선벡터를 적용시킨다.
		glNormal3f(vertex_normal[face[i][0]][0] /  vertex_normal[face[i][0]][3], vertex_normal[face[i][0]][1] /  vertex_normal[face[i][0]][3], vertex_normal[face[i][0]][2] /  vertex_normal[face[i][0]][3]);		
		glVertex3f(vertex[face[i][0]][0], vertex[face[i][0]][1], vertex[face[i][0]][2]); // i번째 면에서 있는 점x,y,z 값 가지고오기

        glColor3f(0.0 , (0.1)*i, 0.0);
		glNormal3f(vertex_normal[face[i][1]][0] /  vertex_normal[face[i][1]][3], vertex_normal[face[i][1]][1] /  vertex_normal[face[i][1]][3], vertex_normal[face[i][1]][2] /  vertex_normal[face[i][1]][3]);
		glVertex3f(vertex[face[i][1]][0], vertex[face[i][1]][1], vertex[face[i][1]][2]);

        glColor3f(0.0 , 0.0, (0.1)*i);
		glNormal3f(vertex_normal[face[i][2]][0] /  vertex_normal[face[i][2]][3], vertex_normal[face[i][2]][1] /  vertex_normal[face[i][2]][3], vertex_normal[face[i][2]][2] /  vertex_normal[face[i][2]][3]);
		glVertex3f(vertex[face[i][2]][0], vertex[face[i][2]][1], vertex[face[i][2]][2]);
     }
   glEnd();
   
   glutSwapBuffers();
}


void MyDisplay2(void) {

   glEnable(GL_DEPTH_TEST);	//깊이 정보에 따라 이미지를 순서대로 나줌
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	//화면을 초기화시킨다.
   glLoadIdentity();
   

   gluLookAt(-1.0, 7.0, 20.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            내눈의 위치   , 바라보는 지점, up벡터   


    glShadeModel(GL_FLAT); // Flat 기법
	

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

	  glRotatef(x_angle, 1.0, 0.0, 0.0); //회전 x
	  glRotatef(y_angle, 0.0, 1.0, 0.0);   //회전 y
	  glRotatef(z_angle, 0.0, 0.0, 1.0);   //회전 z
      glScalef(size * 1, size * 1, size * 1);   //축소, 확대
   



   glBegin(GL_TRIANGLES);   // 삼각형을 그린다.
   for(int i = 0; i < f_count; i++)
   {
        glColor3f(i*(0.1) , 0.0, 0.0);
		// i번째 면에서 해당하는 점 3개 가지고오기
		glNormal3f(polygon_normal[i][0], polygon_normal[i][1], polygon_normal[i][2]);
        glVertex3f(vertex[face[i][0]][0], vertex[face[i][0]][1], vertex[face[i][0]][2]); 
        glColor3f(0.0 , (0.1)*i, 0.0);
		glNormal3f(polygon_normal[i][0], polygon_normal[i][1], polygon_normal[i][2]);
        glVertex3f(vertex[face[i][1]][0], vertex[face[i][1]][1], vertex[face[i][1]][2]);
        glColor3f(0.0 , 0.0, (0.1)*i);
		glNormal3f(polygon_normal[i][0], polygon_normal[i][1], polygon_normal[i][2]);
        glVertex3f(vertex[face[i][2]][0], vertex[face[i][2]][1], vertex[face[i][2]][2]);
     }
   glEnd();

   glutSwapBuffers();
}

void MyDisplay3(void) {
	
   glEnable(GL_DEPTH_TEST);	//깊이 정보에 따라 이미지를 순서대로 나줌
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	//화면을 초기화시킨다.
   glLoadIdentity();
   

   gluLookAt(-1.0, 7.0, 20.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            내눈의 위치   , 바라보는 지점, up벡터   


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

	  glRotatef(x_angle, 1.0, 0.0, 0.0); //회전 x
	  glRotatef(y_angle, 0.0, 1.0, 0.0);   //회전 y
	  glRotatef(z_angle, 0.0, 0.0, 1.0);   //회전 z
      glScalef(size * 1, size * 1, size * 1);   //축소, 확대
   

   
   for(int i = 0; i < f_count; i++)
   {
	   glBegin(GL_POINTS);   // 삼각형을 그린다.
		glColor3f(i*(0.1) , 0.0, 0.0);
		// i번째 면에서 해당하는 점 3개 가지고오기
		glNormal3f(polygon_normal[i][0], polygon_normal[i][1], polygon_normal[i][2]);
		glVertex3f(vertex[face[i][0]][0], vertex[face[i][0]][1], vertex[face[i][0]][2]); 
		glColor3f(0.0 , (0.1)*i, 0.0);
		glVertex3f(vertex[face[i][1]][0], vertex[face[i][1]][1], vertex[face[i][1]][2]);
		glColor3f(0.0 , 0.0, (0.1)*i);
		glVertex3f(vertex[face[i][2]][0], vertex[face[i][2]][1], vertex[face[i][2]][2]);
	   glEnd();
     }
   

   glutSwapBuffers();
}

void MyReshape(int w, int h)
{
   glViewport(0, 0, w, h);
   glMatrixMode(GL_PROJECTION);   //선택의 처리는 시점 좌표계에서 실시하므로, 투시 변환 행렬을 설정
   glLoadIdentity();// 초기화를 시켜주는 함수입니다.
   // 확대를 위해서 조금 작게했습니다.
   glOrtho(-2.0, 2.0, -1.5, 1.5, 0.0, 30.0);
   glMatrixMode(GL_MODELVIEW);
}

void MyKeyboard(unsigned char key, int x, int y)
{
   switch(key)
   {
   //q를 누르면 정사각기둥이나오고 w를 누르면 정팔각기둥이 나오게 한다.
   case 'g':      //Gouraud shading
   case 'G':
      glutDisplayFunc(MyDisplay1);
      break;
   case 'f':      //Flat shading
   case 'F':
      glutDisplayFunc(MyDisplay2); // 도형을 불러온다.
      break;
   case 'h':      //Wireframe
   case 'H':
       glutDisplayFunc(MyDisplay3); // 도형을 불러온다.
      break;

   case 'w':      //x축 회전 +
   case 'W':
      x_angle += 1;

      break;
   case 's':      //x축 회전 -
   case 'S':
      x_angle -= 1;
      break;
   case 'a':      //y축 회전 +
   case 'A':
      y_angle += 1;

      break;
   case 'd':      //y축 회전 -
   case 'D':
      y_angle -= 1;
      break;
   case 'q':      //z축 회전 +
   case 'Q':
      z_angle += 1;
      break;
   case 'e':      //z축 회전 -
   case 'E':
      z_angle -= 1;
      break;
   case 'z':      //축소
   case 'Z':
      if(size != 1)
         size -= 1;
      break;
   case 'x':      //확대
   case 'X':
         size += 1;
      break;
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
   readObj(argv[1]);	//obj파일을 읽어온다.
   readTxt();		//light_material.txt을 읽어온다.
   polygonnormal(); // 평면에서 법선벡터 계산
   vertexnormal(); // 각점에 대한 법선 벡터 계산
   glutInit(&argc, argv); // 초기화를 시켜준다.
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // 더블버퍼링와 RGB색상으로 디스플레이모드를 초기화한다.
   glutInitWindowPosition(100,100); // 화면 어느위치에 실행되는지 좌표정하기
   glutInitWindowSize(1000,600); // 창사이즈 정하기
   glutCreateWindow("Assignment_3"); // 제목
   glClearColor(1.0, 1.0, 1.0,1.0); // 배경색 정하기
   glLoadIdentity(); // 초기화를 시켜주는 함수입니다.
   glutDisplayFunc(MyDisplay1); // 도형을 불러온다.
   glutReshapeFunc(MyReshape);
   glutKeyboardFunc(MyKeyboard); // 키보드함수 호출
   glutMainLoop(); // 항상 적어야한다.
}
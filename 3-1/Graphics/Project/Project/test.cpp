#include "glut.h"
#include <stdio.h>
#include <math.h>
#include <string.h>

float y_pos = 0.0;
float y_inc = 0.03;

float y_pos1 = 0.0;
float y_inc1 = 0.01;

float angle = 0.0;


//���� ���� ������ �޾ƿ��� ����
float vertex[230000][3] = {};
int face[450000][3] = {};
int temp [450000][3];	// �����Ⱚ �޴� ��

int v_count = 1;	//face ������ 1���� ����
int f_count = 0;

////////////////////////
/// ���� ���� ���///
////////////////////////

float vertex_normal[230000][3] = {};

/////////////////////
///�� �ִ� �κ�///
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
      printf("%s�� ������ �� �� ���ų� ���� �����Դϴ�.\n ");
   }
       
      while(!(feof(fp)))
      {
         fscanf(fp, "%c",&ch);
         if(ch == 'v')	//���� ������ �����´�
         {
			fscanf(fp,"%f %f %f",&vertex[v_count][0],&vertex[v_count][1],&vertex[v_count][2]);
            v_count++;
         }
		 if(ch == 'n'){
			 fscanf(fp,"%f %f %f",&vertex_normal[v_count][0],&vertex_normal[v_count][1],&vertex_normal[v_count][2]);
		 }

         if(ch == 'f')	//���� ������ �����´�
         {
            fscanf(fp," %d %d %d %d %d %d", &face[f_count][0], &temp[f_count][0], &face[f_count][1], &temp[f_count][1], &face[f_count][2], &temp[f_count][2]);
            f_count++;
       }
	
      }
   fclose(fp);
}

//��, ���� ������ ������ �Լ�
void readTxt(void)   {
   FILE *fp;
   char ch[10];
   
   fp = fopen("light_material.txt","r");
   if(!fp)   {
      printf("������ �� �� ���ų� ���� �����Դϴ�.\n ");
   }

      while(!feof(fp))
      {
         fscanf(fp, "%s",ch);

         if(strcmp(ch,"point") == 0)	//point light������ ������´�.
       {
			 fscanf(fp,"%f %f %f",&light0_pos[0],&light0_pos[1],&light0_pos[2]);
			 fscanf(fp,"%f %f %f",&light0_ambient[0],&light0_ambient[1],&light0_ambient[2]);
			 fscanf(fp,"%f %f %f",&light0_diffuse[0],&light0_diffuse[1],&light0_diffuse[2]);
			 fscanf(fp,"%f %f %f",&light0_specular[0],&light0_specular[1],&light0_specular[2]);

			 light0_pos[3] = 1.0;	// ������ ��ġ�� ����ϰڴٴ� �ǹ�
			 light0_ambient[3] = 1.0;	//ambient�� ����ϰڴٴ� �ǹ�
			 light0_diffuse[3] = 1.0; //diffuse�� ����ϰڴٴ� �ǹ�
			 light0_specular[3] = 1.0; //specular �� ����ϰڴٴ� �ǹ�
         }
   
      if(strcmp(ch,"dir") == 0)	//directional light������ ������´�.
         {
			 fscanf(fp,"%f %f %f",&light1_dir[0],&light1_dir[1],&light1_dir[2]);
			 fscanf(fp,"%f %f %f",&light1_ambient[0],&light1_ambient[1],&light1_ambient[2]);
			 fscanf(fp,"%f %f %f",&light1_diffuse[0],&light1_diffuse[1],&light1_diffuse[2]);
			 fscanf(fp,"%f %f %f",&light1_specular[0],&light1_specular[1],&light1_specular[2]);

			 light1_dir[3] = 0.0;	// 0�� ������ (x, y, z)�κ��� directional light �����̱⶧��
			 light1_ambient[3] = 1.0;//ambient�� ����ϰڴٴ� �ǹ�
			 light1_diffuse[3] = 1.0;//diffuse�� ����ϰڴٴ� �ǹ�
			 light1_specular[3] = 1.0;//specular �� ����ϰڴٴ� �ǹ�
         }

       if(strcmp(ch,"spot") == 0)	//spot light ������ ������ �´�.
         {
			 fscanf(fp,"%f %f %f",&light2_pos[0],&light2_pos[1],&light2_pos[2]);
			 fscanf(fp,"%f %f %f",&light2_dir[0],&light2_dir[1],&light2_dir[2]);
			 fscanf(fp,"%f",&light2_cutoff);
			 fscanf(fp,"%f %f %f",&light2_ambient[0],&light2_ambient[1],&light2_ambient[2]);
			 fscanf(fp,"%f %f %f",&light2_diffuse[0],&light2_diffuse[1],&light2_diffuse[2]);
			 fscanf(fp,"%f %f %f",&light2_specular[0],&light2_specular[1],&light2_specular[2]);

			 light2_pos[3] = 1.0; // ������ ��ġ�� ����ϰڴٴ� �ǹ�
			 light2_dir[3] = 1.0;  // ������ ���⸦ ����ϰڴٴ� �ǹ�
			 light2_ambient[3] = 1.0; //ambient�� ����ϰڴٴ� �ǹ�
			 light2_diffuse[3] = 1.0; //diffuse�� ����ϰڴٴ� �ǹ�
			 light2_specular[3] = 1.0;//specular �� ����ϰڴٴ� �ǹ�
         }

        if(strcmp(ch,"mat") == 0)	//������ ���� ������ ������ �´�.
         {
			 fscanf(fp,"%f %f %f %f",&mat_ambient[0],&mat_ambient[1],&mat_ambient[2], &mat_ambient[3]);
			 fscanf(fp,"%f %f %f %f",&mat_diffuse[0],&mat_diffuse[1],&mat_diffuse[2], &mat_diffuse[3]);
			 fscanf(fp,"%f %f %f %f",&mat_specular[0],&mat_specular[1],&mat_specular[2], &mat_specular[3]);
			 fscanf(fp,"%f",&mat_shininess[0]);
         }
     }
   fclose(fp);
}

// ��, ������ ǥ���ϴ� �Լ�
void light(void){
	  //0��° ���� point light �����ϴ� �Լ�
	  glLightfv(GL_LIGHT0, GL_POSITION, light0_pos);	// ���� ��ġ
      glLightfv(GL_LIGHT0, GL_AMBIENT, light0_ambient);	//���� �� ���Ⱚ
      glLightfv(GL_LIGHT0, GL_DIFFUSE, light0_diffuse);	//���� ���� ��
      glLightfv(GL_LIGHT0, GL_SPECULAR, light0_specular);	//�ݻ�Ǵ� ���� ��
	  //1��° ���� point light �����ϴ� �Լ�
      glLightfv(GL_LIGHT1, GL_POSITION , light1_dir);	// ���� ��ġ
      glLightfv(GL_LIGHT1, GL_AMBIENT, light1_ambient);	//���� �� ���Ⱚ
      glLightfv(GL_LIGHT1, GL_DIFFUSE, light1_diffuse);	//���� ���� ��
      glLightfv(GL_LIGHT1, GL_SPECULAR, light1_specular);	//�ݻ�Ǵ� ���� ��
	  //2��° ���� spot light �����ϴ� �Լ�
	  glLightfv(GL_LIGHT2, GL_POSITION, light2_pos);	// ���� ��ġ
      glLightfv(GL_LIGHT2, GL_AMBIENT, light2_ambient);	//���� �� ���Ⱚ
      glLightfv(GL_LIGHT2, GL_DIFFUSE, light2_diffuse);	//���� ���� ��
      glLightfv(GL_LIGHT2, GL_SPECULAR, light2_specular);	//�ݻ�Ǵ� ���� ��
      glLightfv(GL_LIGHT2, GL_SPOT_DIRECTION, light2_dir);	//���� ���Ⱚ
      glLightf(GL_LIGHT2, GL_SPOT_CUTOFF, light2_cutoff);	//���̶���Ʈ�� ��ȣ������
	  // ������ �����ϴ� �Լ�
      glMaterialfv(GL_FRONT, GL_AMBIENT, mat_ambient);	//���� �� ���Ⱚ
      glMaterialfv(GL_FRONT, GL_DIFFUSE, mat_diffuse);		//���� ���� ��
      glMaterialfv(GL_FRONT, GL_SPECULAR, mat_specular);	//�ݻ�Ǵ� ���� ��
      glMaterialfv(GL_FRONT, GL_SHININESS, mat_shininess);	//��¦���� ���� ����
}

void MyDisplay(void) {
   glEnable(GL_DEPTH_TEST);	//���� ������ ���� �̹����� ������� ����
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // ȭ���� �ʱ�ȭ
   
   
   
   glLoadIdentity();
   
 
 //  glRotatef(1 , 0.0,y_pos ,0.0);
   gluLookAt(-5.0, 15.0, -2.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            ������ ��ġ   , �ٶ󺸴� ����,  up����   

/*    glShadeModel(GL_SMOOTH);
	 glScalef(20,20,20);
   glPointSize(2);
   glBegin(GL_POINTS); */  // �ﰢ���� �׸���.
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
		//// ������ �������͸� �����Ų��.
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
    glShadeModel(GL_SMOOTH); // Flat ���
	

   glEnable(GL_LIGHTING);	// ���� ȿ���� ����

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
       glEnable(GL_LIGHT2);	//������ Ų��.
      
	light();
	//glScalef(3.0, 3.0, 3.0);
   glBegin(GL_TRIANGLES);	   // �ﰢ���� �׸���.
   for(int i = 0; i < f_count; i++)
   {
		glColor3f(0.0 , 0.0, 0.0);
		glNormal3f(vertex_normal[face[i][0]][0], vertex_normal[face[i][0]][1], vertex_normal[face[i][0]][2]);	// i��° �鿡�� �ش��ϴ� �� 3�� ���������
		glVertex3f(vertex[face[i][0]][0] ,vertex[face[i][0]][1] ,vertex[face[i][0]][2]); 
	
		glNormal3f(vertex_normal[face[i][1]][0], vertex_normal[face[i][1]][1], vertex_normal[face[i][1]][2]);	// i��° �鿡�� �ش��ϴ� �� 3�� ���������
	//	glNormal3f(vertex_normal[face[i][1]][0], vertex_normal[face[i][1]][1], vertex_normal[face[i][1]][2]);
		glVertex3f(vertex[face[i][1]][0] ,vertex[face[i][1]][1] ,vertex[face[i][1]][2]);
	
		glNormal3f(vertex_normal[face[i][1]][0], vertex_normal[face[i][1]][1], vertex_normal[face[i][1]][2]);	// i��° �鿡�� �ش��ϴ� �� 3�� ���������
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
   glutPostRedisplay(); // GLUT�� ���� â�� ���ΰ�ħ �ϵ��� �Ѵ�

} //Ű���带 ������ ��

int main(int argc, char **argv) {
	printf("����\n");
	readObj(argv[1]);
	printf("obj�� ����\n");
	readTxt();	
	printf("���� ����\n");
	//polygonnormal();
	//printf("�������� ����\n");
   glutInit(&argc, argv); // �ʱ�ȭ�� �����ش�.
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // ������۸��� RGB�������� ���÷��̸�带 �ʱ�ȭ�Ѵ�.
   glutInitWindowPosition(100,100); // ȭ�� �����ġ�� ����Ǵ��� ��ǥ���ϱ�
   glutInitWindowSize(1000,1000); // â������ ���ϱ�
   glutCreateWindow("Test"); // ����
   glClearColor(1.0, 1.0, 1.0,1.0); // ���� ���ϱ�
   glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
   glutDisplayFunc(MyDisplay); // ������ �ҷ��´�.
   glutReshapeFunc(MyReshape);
   //	glutIdleFunc(MyIdle);
   glutKeyboardFunc(MyKeyboard); // Ű�����Լ� ȣ��
   glutMainLoop(); // �׻� ������Ѵ�.
}
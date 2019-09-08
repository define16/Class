#include "glut.h"
#include <stdio.h>
#include <math.h>
#include <string.h>

float y_pos = 0.0;
float y_inc = 0.03;

float y_pos1 = 0.0;
float y_inc1 = 0.01;

float angle = 0.0;

#define PI 3.141592

void MyDisplay(void) {
   glEnable(GL_DEPTH_TEST);	//���� ������ ���� �̹����� ������� ����
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // ȭ���� �ʱ�ȭ
   glLoadIdentity();
   
 
 //  glRotatef(1 , 0.0,y_pos ,0.0);
   gluLookAt(-5.0, 3.0, -2.0, 0.0, 0.0, 0.0, 10.0, 1.0, 0.0);
   //            ������ ��ġ   , �ٶ󺸴� ����, up����   

  glShadeModel(GL_SMOOTH);
	 glScalef(20,20,20);
   glPointSize(2);
   glBegin(GL_POINTS);   // �ﰢ���� �׸���.
      for(angle = 0.0; angle < 2.0*PI; angle += PI/30.0) {
        glColor3f((0.1*angle) , 0.0 , 0.0 );
        glVertex3f( 0.5 * cos(angle) * y_pos , 0.5 * sin(angle) * y_pos, 0.0); 
		glColor3f(  0.0 ,(0.1*angle), 0.0 );
		glVertex3f( (0.5 * cos(angle) * y_pos )-0.8, 0.5 * sin(angle) * y_pos -0.8, 0.0); 
		glColor3f(  0.0 ,0.0,(0.1*angle));
		glVertex3f( 0.5 * cos(angle) * y_pos +1.3 , 0.5 * sin(angle) * y_pos +1.3, 0.0); 
   }
   for(int i = 0; i< 10; i++) {
	    
       
		// ������ �������͸� �����Ų��.
		for(int j = 0; j< 10; j++) {
			 glColor3f(0.0 , 0.2 *i , 0.1 *i/2 );
			glVertex3f(j*(0.2)*cos(2.0), i+y_pos, 1); 
			 glColor3f(0.0 , 0.1 *i , 0.4 *i/2 );
			glVertex3f(j*(0.3), i+y_pos, 2); 
			 glColor3f(0.0 , 0.1 *i , 0.7 *i/2 );
			glVertex3f(j*(0.4) ,i+y_pos, 3); 
			 glColor3f(0.0 , 0.1 *i , 0.2 *i/2 );
			glVertex3f(j*(0.5) ,i+y_pos ,4); 
		}

		glColor3f(0.1 *i ,0.0 , 0.1 *i/2 );
			for(int j = 0; j< 10; j++) {
			//glColor3f(0.1 *j , 0.01 *j, 0.1 *j/2 );
			glVertex3f(j,i+y_pos,5);
			glVertex3f(j,i+y_pos,6);
			glVertex3f(j,i+y_pos,7);
			glVertex3f(j,i+y_pos,8);
			glVertex3f(j,i+y_pos,9);
			}

			glColor3f(0.1 *i , 0.1 *i , 0.0 );
			for(int j = 0; j< 10; j++) {
			//glColor3f(0.1 *j , 0.01 *j , 0.1 *j/2 );
			glVertex3f(j,i+y_pos,10);
			glVertex3f(j,i+y_pos,11);
			glVertex3f(j,i+y_pos,12);
			}
		}
      glEnd();
   glScalef(20,20,20);
   
   glutSwapBuffers();
}



void MyReshape(int w, int h)
{

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


int main(int argc, char **argv) {
   glutInit(&argc, argv); // �ʱ�ȭ�� �����ش�.
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // ������۸��� RGB�������� ���÷��̸�带 �ʱ�ȭ�Ѵ�.
   glutInitWindowPosition(100,100); // ȭ�� �����ġ�� ����Ǵ��� ��ǥ���ϱ�
   glutInitWindowSize(1000,1000); // â������ ���ϱ�
   glutCreateWindow("Test"); // ����
   glClearColor(1.0, 1.0, 1.0,1.0); // ���� ���ϱ�
   glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
   glutDisplayFunc(MyDisplay); // ������ �ҷ��´�.
   glutReshapeFunc(MyReshape);	
   glutIdleFunc(MyIdle);
 //  glutKeyboardFunc(MyKeyboard); // Ű�����Լ� ȣ��
   glutMainLoop(); // �׻� ������Ѵ�.
}
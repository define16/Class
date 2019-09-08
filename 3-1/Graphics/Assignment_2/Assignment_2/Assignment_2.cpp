#include "glut.h"
#include <cmath>

float root2 = sqrt(2.0); // ��Ʈ2���
float y_angle = 0.0; // ȸ����Ű�� ���ؼ� ���
bool flag = false; //���������� ���������� ��ȯ�ϴ� ������ �մϴ�

void MyDisplay1(void)
{
	glClear(GL_COLOR_BUFFER_BIT); //������ �ʱ�ȭ�Ѵ�.
	glFrontFace(GL_CW);		// �ð������ �ո����� ����
	glCullFace(GL_FRONT);		//�ո��� �����ִ� �Լ�
	glEnable(GL_CULL_FACE);		// opengl�� �Լ��� ���ش�. (glFrontFace,glCullFace);
	
	glLoadIdentity(); // ���� ��ȯ ����� �ʱ�ȭ�����ִ� �Լ��Դϴ�.

	//flag ������ �̿��ؼ� ���������� ���������� ��ȯ�ϴ� ������ �մϴ�
	if(flag) 
		glFrustum(-0.5, 0.5, -0.5, 0.5, 2, 20.0);
	else
		glOrtho(-2.0 , 2.0, -3.0, 3.0, -20,20);
	
	gluLookAt(-3.0, -3.0, -10.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0);
	//				������ ��ġ   , �ٶ󺸴� ����, up����	

	glRotatef(y_angle,0,1,0); // ��ü�� ȸ����Ű�� �Լ�

	glBegin( GL_QUADS ); // �ﰢ������ �׸���.

	// �ظ�
      glColor3f(1.0, 0.0, 0.0); 
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(-root2/2,  0.0, root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	   glVertex3f(root2/2,  0.0, -root2/2);
	 

	  // ����1
	  glColor3f(0.0, 0.0, 1.0); 
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(-root2/2, 0.0, root2/2);
	  glVertex3f(-root2/2, 2.0, root2/2);
	  glVertex3f(root2/2,  2.0, root2/2);
	  


	  //����2
	  glColor3f(0.0, 1.0, 0.0); 
	  glVertex3f(-root2/2, 2.0, root2/2);
	  glVertex3f(-root2/2,  0.0, root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  
	

	  //����3
	  glColor3f(1.0, 0.0, 1.0); 
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	  glVertex3f(root2/2, 0.0, -root2/2);
	  glVertex3f(root2/2,  2.0, -root2/2);
	  
	 
	 
	  //����4
	  glColor3f(0.0, 1.0, 1.0); 
	  glVertex3f(root2/2, 0.0, -root2/2);
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(root2/2,  2.0, root2/2);
	  glVertex3f(root2/2, 2.0, -root2/2);


	  // ����
      glColor3f(1.0, 1.0, 0.0); 
	  glVertex3f(root2/2, 2.0, root2/2);
	  glVertex3f(-root2/2,  2.0, root2/2);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	   glVertex3f(root2/2,  2.0, -root2/2);

    glEnd(); // �׸��� ��

	glutSwapBuffers();// ���� �׸��� �Լ�(�����϶�)
}

void MyDisplay2(void)
{
	glClear(GL_COLOR_BUFFER_BIT);  //������ �ʱ�ȭ�Ѵ�.
	
	glFrontFace(GL_CW);		// �ð������ �ո����� ����
	glCullFace(GL_BACK);		//�ո��� �����ִ� �Լ�
	glEnable(GL_CULL_FACE);		// opengl�� �Լ��� ���ش�. (glFrontFace,glCullFace);
	glLoadIdentity(); // ���� ��ȯ ����� �ʱ�ȭ�����ִ� �Լ��Դϴ�.

	//flag ������ �̿��ؼ� ���������� ���������� ��ȯ�ϴ� ������ �մϴ�
	if(flag)
		glFrustum(-0.5, 0.5, -0.5, 0.5, 2, 20.0);
	else
		glOrtho(-2.0 , 2.0, -2.0, 2.0, -10.0,20.0);
	
	gluLookAt(-4.0, -4.0, 4.0, 0.0, 1.5, 0.0, 0.0, 1.0, 0.0);
	//				������ ��ġ   , �ٶ󺸴� ����, up����	

	glRotatef(y_angle,0,1,0); // ��ü�� ȸ����Ű�� �Լ�

	glBegin( GL_TRIANGLES ); // �ﰢ������ �׷��� �̾� ���Դϴ�.
	// �ظ�
	 glColor3f(1.0, 0.0, 0.0); 
	 glVertex3f(root2/2, 0.0, root2/2);
     glVertex3f(1.0, 0.0, 0.0); 
	 glVertex3f(0.0, 0.0, 0.0);
	
	 glVertex3f(0.0, 0.0, 1.0);
	 glVertex3f(root2/2, 0.0, root2/2);
	 glVertex3f(0.0, 0.0, 0.0);
	 
	 glVertex3f(-root2/2, 0.0, root2/2);
	 glVertex3f(0.0, 0.0, 1.0);
	 glVertex3f(0.0, 0.0, 0.0);
	 
	 glVertex3f(-1.0, 0.0, 0.0);
	 glVertex3f(-root2/2, 0.0, root2/2);
	 glVertex3f(0.0, 0.0, 0.0);
	
	 glVertex3f(-root2/2, 0.0, -root2/2);
	 glVertex3f(-1.0, 0.0, 0.0);
	 glVertex3f(0.0, 0.0, 0.0);

	 glVertex3f(0.0, 0.0, -1.0);
	 glVertex3f(-root2/2, 0.0, -root2/2); 
	 glVertex3f(0.0, 0.0, 0.0);
	 
	 glVertex3f(root2/2, 0.0, -root2/2);
	 glVertex3f(0.0, 0.0, -1.0);
	 glVertex3f(0.0, 0.0, 0.0);
	 
	 glVertex3f(1.0, 0.0, 0.0);
	 glVertex3f(root2/2, 0.0, -root2/2);
	 glVertex3f(0.0, 0.0, 0.0);

	 glEnd(); // �׸��� ��
	
  glBegin( GL_QUADS ); // �簢������ ���� �׸���
	  // ����1
	  glColor3f(0.0, 1.0, 0.0); 
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(root2/2, 2.0, root2/2);
	  glVertex3f(0.0, 2.0, 1.0);
	  glVertex3f(0.0, 0.0, 1.0);
	
	 
	//  ����2
	  glColor3f(0.0, 1.0, 1.0); 
	  glVertex3f(0.0, 0.0, 1.0);
	  glVertex3f(0.0, 2.0, 1.0);
	  glVertex3f(-root2/2,  2.0, root2/2);
	  glVertex3f(-root2/2,  0.0, root2/2);

	//  ����3
	  glColor3f(0.0, 0.0, 1.0); 
	  glVertex3f(-root2/2,  0.0, root2/2);
	  glVertex3f(-root2/2,  2.0, root2/2);
	  glVertex3f(-1.0, 2.0, 0.0);
	  glVertex3f(-1.0, 0.0, 0.0);

	//����4
	  glColor3f(0.0, 0.5, 1.0); 
	  glVertex3f(-1.0, 0.0, 0.0);
	  glVertex3f(-1.0, 2.0, 0.0);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	 

	//  ����5
	  glColor3f(0.9, 0.9, 1.0); 
	  glVertex3f(-root2/2, 0.0, -root2/2);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  glVertex3f(0.0, 2.0, -1.0);
	  glVertex3f(0.0, 0.0, -1.0);
	  

	//  ����6
	  glColor3f(0.9, 1.0, 0.9); 
	  glVertex3f(0.0, 0.0, -1.0); 
	  glVertex3f(0.0, 2.0, -1.0);
	  glVertex3f(root2/2,  2.0, -root2/2);
	  glVertex3f(root2/2,  0.0, -root2/2);
	

	//  ����7
	  glColor3f(1.0, 0.9, 0.9); 
	  glVertex3f(root2/2,  0.0, -root2/2);
	  glVertex3f(root2/2,  2.0, -root2/2);
	  glVertex3f(1.0, 2.0, 0.0);
	  glVertex3f(1.0, 0.0, 0.0);

	//  ����8
	  glColor3f(1.0, 0.0, 1.0); 
	  glVertex3f(1.0, 0.0, 0.0);
	  glVertex3f(1.0, 2.0, 0.0);
	  glVertex3f(root2/2,  2.0, root2/2);
	  glVertex3f(root2/2, 0.0, root2/2);

	   glEnd(); // �׸��� ��

	 glBegin( GL_TRIANGLES ); // �ﰢ������ �׷��� �̾� ���Դϴ�.
	     	
	 // ����
		glColor3f(1.0, 1.0, 0.0); 
		glVertex3f(root2/2, 2.0, root2/2);
		glVertex3f(1.0, 2.0, 0.0); 
		glVertex3f(0.0, 2.0, 0.0);
	
		glVertex3f(0.0, 2.0, 1.0);
		glVertex3f(root2/2, 2.0, root2/2);
		glVertex3f(0.0, 2.0, 0.0);
	 
	 
		glVertex3f(-root2/2, 2.0, root2/2);
		glVertex3f(0.0, 2.0, 1.0);
		glVertex3f(0.0, 2.0, 0.0);
	 
		glVertex3f(-1.0, 2.0, 0.0);
		glVertex3f(-root2/2, 2.0, root2/2);
		glVertex3f(0.0, 2.0, 0.0);
	
		glVertex3f(-root2/2, 2.0, -root2/2);
		glVertex3f(-1.0, 2.0, 0.0);
		glVertex3f(0.0, 2.0, 0.0);

		glVertex3f(0.0, 2.0, -1.0);
		glVertex3f(-root2/2, 2.0, -root2/2); 
		glVertex3f(0.0, 2.0, 0.0);
	 
		glVertex3f(root2/2, 2.0, -root2/2);
		glVertex3f(0.0, 2.0, -1.0);
		glVertex3f(0.0, 2.0, 0.0);
	 
		glVertex3f(1.0, 2.0, 0.0);
		glVertex3f(root2/2, 2.0, -root2/2);
		glVertex3f(0.0, 2.0, 0.0);
		 
	glEnd(); // �׸��� ��

	glutSwapBuffers(); // ���� �׸��� �Լ�(�����϶�)
}

void MyKeyboard(unsigned char key, int x, int y)
{
	switch(key)
	{
	//q�� ������ ���簢����̳����� w�� ������ ���Ȱ������ ������ �Ѵ�.
	case 'q':
	case 'Q':
		glutDisplayFunc(MyDisplay1);
		break;
	case 'w':
	case 'W':
		glutDisplayFunc(MyDisplay2);
		break;

	//a�� ������ �������ϰ� , s�� ������ ���������� �Ѵ�.
	case 'a':
	case 'A':
		flag = true;
		break;
	case 's':
	case 'S':
		flag = false;
		break;
	
	}
	glutPostRedisplay(); // GLUT�� ���� â�� ���ΰ�ħ �ϵ��� �Ѵ�

} //Ű���带 ������ ��

void MyIdle() 
{
	y_angle += 0.01;
	glutPostRedisplay(); // GLUT�� ���� â�� ���ΰ�ħ �ϵ��� �Ѵ�
}// ��� ȸ�� ��ų ��


int main(int argc, char **argv)
{
	glutInit(&argc, argv); // �ʱ�ȭ�� �����ش�.
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // ������۸��� RGB�������� ���÷��̸�带 �ʱ�ȭ�Ѵ�.
	glutInitWindowPosition(400,200); // ȭ�� �����ġ�� ����Ǵ��� ��ǥ���ϱ�
	glutInitWindowSize(500,500); // â������ ���ϱ�
	glutCreateWindow("Assignment_2"); // ����
	glClearColor(1.0, 1.0, 1.0,1.0); // ���� ���ϱ�
	glMatrixMode(GL_PROJECTION);	//������ ó���� ���� ��ǥ�迡�� �ǽ��ϹǷ�, ���� ��ȯ ����� ����
	glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
	glutDisplayFunc(MyDisplay1); // ������ �ҷ��´�.
	glutIdleFunc(MyIdle); //�ƹ� �̺�Ʈ�� �߻����� ������ �۵��Ǵ� �Լ�
	glutKeyboardFunc(MyKeyboard); // Ű�����Լ� ȣ��
	glutMainLoop(); // �׻� ������Ѵ�.
}

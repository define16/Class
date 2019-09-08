#include "glut.h"
#include <cmath>

float root2 = sqrt(2.0); // 루트2계산
float y_angle = 0.0; // 회전시키기 위해서 사용
bool flag = false; //원근투영과 직교투영을 전환하는 역할을 합니다

void MyDisplay1(void)
{
	glClear(GL_COLOR_BUFFER_BIT); //배경색을 초기화한다.
	glFrontFace(GL_CW);		// 시계방향을 앞면으로 설정
	glCullFace(GL_FRONT);		//앞면을 보여주는 함수
	glEnable(GL_CULL_FACE);		// opengl의 함수를 켜준다. (glFrontFace,glCullFace);
	
	glLoadIdentity(); // 투시 변환 행렬을 초기화시켜주는 함수입니다.

	//flag 변수를 이용해서 원근투영과 직교투영을 전환하는 역할을 합니다
	if(flag) 
		glFrustum(-0.5, 0.5, -0.5, 0.5, 2, 20.0);
	else
		glOrtho(-2.0 , 2.0, -3.0, 3.0, -20,20);
	
	gluLookAt(-3.0, -3.0, -10.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0);
	//				내눈의 위치   , 바라보는 지점, up벡터	

	glRotatef(y_angle,0,1,0); // 물체를 회전시키는 함수

	glBegin( GL_QUADS ); // 삼각형으로 그린다.

	// 밑면
      glColor3f(1.0, 0.0, 0.0); 
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(-root2/2,  0.0, root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	   glVertex3f(root2/2,  0.0, -root2/2);
	 

	  // 옆면1
	  glColor3f(0.0, 0.0, 1.0); 
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(-root2/2, 0.0, root2/2);
	  glVertex3f(-root2/2, 2.0, root2/2);
	  glVertex3f(root2/2,  2.0, root2/2);
	  


	  //옆면2
	  glColor3f(0.0, 1.0, 0.0); 
	  glVertex3f(-root2/2, 2.0, root2/2);
	  glVertex3f(-root2/2,  0.0, root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  
	

	  //옆면3
	  glColor3f(1.0, 0.0, 1.0); 
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	  glVertex3f(root2/2, 0.0, -root2/2);
	  glVertex3f(root2/2,  2.0, -root2/2);
	  
	 
	 
	  //옆면4
	  glColor3f(0.0, 1.0, 1.0); 
	  glVertex3f(root2/2, 0.0, -root2/2);
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(root2/2,  2.0, root2/2);
	  glVertex3f(root2/2, 2.0, -root2/2);


	  // 윗면
      glColor3f(1.0, 1.0, 0.0); 
	  glVertex3f(root2/2, 2.0, root2/2);
	  glVertex3f(-root2/2,  2.0, root2/2);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	   glVertex3f(root2/2,  2.0, -root2/2);

    glEnd(); // 그리기 끝

	glutSwapBuffers();// 모델을 그리는 함수(더블일때)
}

void MyDisplay2(void)
{
	glClear(GL_COLOR_BUFFER_BIT);  //배경색을 초기화한다.
	
	glFrontFace(GL_CW);		// 시계방향을 앞면으로 설정
	glCullFace(GL_BACK);		//앞면을 보여주는 함수
	glEnable(GL_CULL_FACE);		// opengl의 함수를 켜준다. (glFrontFace,glCullFace);
	glLoadIdentity(); // 투시 변환 행렬을 초기화시켜주는 함수입니다.

	//flag 변수를 이용해서 원근투영과 직교투영을 전환하는 역할을 합니다
	if(flag)
		glFrustum(-0.5, 0.5, -0.5, 0.5, 2, 20.0);
	else
		glOrtho(-2.0 , 2.0, -2.0, 2.0, -10.0,20.0);
	
	gluLookAt(-4.0, -4.0, 4.0, 0.0, 1.5, 0.0, 0.0, 1.0, 0.0);
	//				내눈의 위치   , 바라보는 지점, up벡터	

	glRotatef(y_angle,0,1,0); // 물체를 회전시키는 함수

	glBegin( GL_TRIANGLES ); // 삼각형으로 그려서 이어 붙입니다.
	// 밑면
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

	 glEnd(); // 그리기 끝
	
  glBegin( GL_QUADS ); // 사각형으로 옆면 그리기
	  // 옆면1
	  glColor3f(0.0, 1.0, 0.0); 
	  glVertex3f(root2/2, 0.0, root2/2);
	  glVertex3f(root2/2, 2.0, root2/2);
	  glVertex3f(0.0, 2.0, 1.0);
	  glVertex3f(0.0, 0.0, 1.0);
	
	 
	//  옆면2
	  glColor3f(0.0, 1.0, 1.0); 
	  glVertex3f(0.0, 0.0, 1.0);
	  glVertex3f(0.0, 2.0, 1.0);
	  glVertex3f(-root2/2,  2.0, root2/2);
	  glVertex3f(-root2/2,  0.0, root2/2);

	//  옆면3
	  glColor3f(0.0, 0.0, 1.0); 
	  glVertex3f(-root2/2,  0.0, root2/2);
	  glVertex3f(-root2/2,  2.0, root2/2);
	  glVertex3f(-1.0, 2.0, 0.0);
	  glVertex3f(-1.0, 0.0, 0.0);

	//옆면4
	  glColor3f(0.0, 0.5, 1.0); 
	  glVertex3f(-1.0, 0.0, 0.0);
	  glVertex3f(-1.0, 2.0, 0.0);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  glVertex3f(-root2/2, 0.0, -root2/2);
	 

	//  옆면5
	  glColor3f(0.9, 0.9, 1.0); 
	  glVertex3f(-root2/2, 0.0, -root2/2);
	  glVertex3f(-root2/2, 2.0, -root2/2);
	  glVertex3f(0.0, 2.0, -1.0);
	  glVertex3f(0.0, 0.0, -1.0);
	  

	//  옆면6
	  glColor3f(0.9, 1.0, 0.9); 
	  glVertex3f(0.0, 0.0, -1.0); 
	  glVertex3f(0.0, 2.0, -1.0);
	  glVertex3f(root2/2,  2.0, -root2/2);
	  glVertex3f(root2/2,  0.0, -root2/2);
	

	//  옆면7
	  glColor3f(1.0, 0.9, 0.9); 
	  glVertex3f(root2/2,  0.0, -root2/2);
	  glVertex3f(root2/2,  2.0, -root2/2);
	  glVertex3f(1.0, 2.0, 0.0);
	  glVertex3f(1.0, 0.0, 0.0);

	//  옆면8
	  glColor3f(1.0, 0.0, 1.0); 
	  glVertex3f(1.0, 0.0, 0.0);
	  glVertex3f(1.0, 2.0, 0.0);
	  glVertex3f(root2/2,  2.0, root2/2);
	  glVertex3f(root2/2, 0.0, root2/2);

	   glEnd(); // 그리기 끝

	 glBegin( GL_TRIANGLES ); // 삼각형으로 그려서 이어 붙입니다.
	     	
	 // 윗면
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
		 
	glEnd(); // 그리기 끝

	glutSwapBuffers(); // 모델을 그리는 함수(더블일때)
}

void MyKeyboard(unsigned char key, int x, int y)
{
	switch(key)
	{
	//q를 누르면 정사각기둥이나오고 w를 누르면 정팔각기둥이 나오게 한다.
	case 'q':
	case 'Q':
		glutDisplayFunc(MyDisplay1);
		break;
	case 'w':
	case 'W':
		glutDisplayFunc(MyDisplay2);
		break;

	//a를 누르면 원투영하고 , s를 누르면 직교투영을 한다.
	case 'a':
	case 'A':
		flag = true;
		break;
	case 's':
	case 'S':
		flag = false;
		break;
	
	}
	glutPostRedisplay(); // GLUT이 현재 창을 새로고침 하도록 한다

} //키보드를 눌렀을 때

void MyIdle() 
{
	y_angle += 0.01;
	glutPostRedisplay(); // GLUT이 현재 창을 새로고침 하도록 한다
}// 계속 회전 시킬 때


int main(int argc, char **argv)
{
	glutInit(&argc, argv); // 초기화를 시켜준다.
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // 더블버퍼링와 RGB색상으로 디스플레이모드를 초기화한다.
	glutInitWindowPosition(400,200); // 화면 어느위치에 실행되는지 좌표정하기
	glutInitWindowSize(500,500); // 창사이즈 정하기
	glutCreateWindow("Assignment_2"); // 제목
	glClearColor(1.0, 1.0, 1.0,1.0); // 배경색 정하기
	glMatrixMode(GL_PROJECTION);	//선택의 처리는 시점 좌표계에서 실시하므로, 투시 변환 행렬을 설정
	glLoadIdentity(); // 초기화를 시켜주는 함수입니다.
	glutDisplayFunc(MyDisplay1); // 도형을 불러온다.
	glutIdleFunc(MyIdle); //아무 이벤트가 발생하지 않을때 작동되는 함수
	glutKeyboardFunc(MyKeyboard); // 키보드함수 호출
	glutMainLoop(); // 항상 적어야한다.
}

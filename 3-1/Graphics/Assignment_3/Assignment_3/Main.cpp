#include "glut.h"
#include <stdio.h>
#include <string.h>
#include <math.h>

float vertex[30000][3] = {};
int face[30000][3] = {};

float polygon_normal[30000][3] = {};
float vertex_normal[30000][3] = {};

int v_count = 1;	//face ������ 1���� ����
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

//obj������ �޾ƿ��� �Լ�
void readObj(char *filenames)   {
   FILE *fp;
   char ch;

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
         if(ch == 'f')	//���� ������ �����´�
         {
            fscanf(fp,"%d %d %d",&face[f_count][0], &face[f_count][1], &face[f_count][2]);
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


// ��� ���� ���͸� ����ϴ� �Լ�
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

		//���� ���
		tmp[i][0] = (a[i][1] * b[i][2]) - (b[i][1] * a[i][2]);
		tmp[i][1] = (a[i][2] * b[i][0]) - (b[i][2] * a[i][0]);
		tmp[i][2] = (a[i][0] * b[i][1]) - (b[i][0] * a[i][1]);

		//�������� ���
		length = (float)sqrt(tmp[i][0] * tmp[i][0] + tmp[i][1] * tmp[i][1] + tmp[i][2] * tmp[i][2]);
		if(length == 0.0f)
			length = 1.0f;
		

		polygon_normal[i][0] = tmp[i][0] / length;	//�鿡 ���� �������� x
		polygon_normal[i][1] = tmp[i][1] / length;	//�鿡 ���� �������� y
		polygon_normal[i][2] = tmp[i][2] / length;	//�鿡 ���� �������� z
      }

}

//���� ���� �������͸� �׷��ִ� �Լ�
void vertexnormal(void) {
     for(int i = 0; i < f_count; i++) {
	     //�ʱ�ȭ�� �迭�� �� ���� ���������� ��ǥ ��� ���ϱ�

     vertex_normal[face[i][0]][0] += polygon_normal[i][0];		//[face[i][0]]�� ���� ���� x���� ���Ѵ�.
     vertex_normal[face[i][0]][1] += polygon_normal[i][1];		//[face[i][0]]�� ���� ���� y���� ���Ѵ�.
     vertex_normal[face[i][0]][2] += polygon_normal[i][2];		//[face[i][0]]�� ���� ���� z���� ���Ѵ�.
     vertex_normal[face[i][0]][3] += 1.0; // [face[i][0]�� ���� ���� ���� ī��Ʈ

     vertex_normal[face[i][1]][0] += polygon_normal[i][0];		//[face[i][1]]�� ���� ���� x���� ���Ѵ�.
     vertex_normal[face[i][1]][1] += polygon_normal[i][1];		//[face[i][1]]�� ���� ���� y���� ���Ѵ�.
     vertex_normal[face[i][1]][2] += polygon_normal[i][2];		//[face[i][1]]�� ���� ���� z���� ���Ѵ�.
     vertex_normal[face[i][1]][3] += 1.0; // [face[i][1]] ���� ���� ���� ī��Ʈ
	 

     vertex_normal[face[i][2]][0] += polygon_normal[i][0];		//[face[i][2]]�� ���� ���� x���� ���Ѵ�.
     vertex_normal[face[i][2]][1] += polygon_normal[i][1];		//[face[i][2]]�� ���� ���� y���� ���Ѵ�.
     vertex_normal[face[i][2]][2] += polygon_normal[i][2];		//[face[i][2]]�� ���� ���� z���� ���Ѵ�.
     vertex_normal[face[i][2]][3] += 1.0; // [face[i][2]] ���� ���� ���� ī��Ʈ


	 }
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

void MyDisplay1(void) {
   glEnable(GL_DEPTH_TEST);	//���� ������ ���� �̹����� ������� ����
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // ȭ���� �ʱ�ȭ
   glLoadIdentity();

 

   gluLookAt(-1.0, 7.0, 20.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            ������ ��ġ   , �ٶ󺸴� ����, up����   

      glShadeModel(GL_SMOOTH); // Gouraud ���

	
	
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
       glEnable(GL_LIGHT2);	//���� Ų��.
      
   
    light();

	glRotatef(x_angle, 1.0, 0.0, 0.0); //ȸ�� x
	glRotatef(y_angle, 0.0, 1.0, 0.0);   //ȸ�� y
	glRotatef(z_angle, 0.0, 0.0, 1.0);   //ȸ�� z
    glScalef(size * 1, size * 1, size * 1);   //���, Ȯ��


   glBegin(GL_TRIANGLES);   // �ﰢ���� �׸���.
   for(int i = 0; i < f_count; i++)
   {
        glColor3f(i*(0.1) , 0.0, 0.0);
		// ������ �������͸� �����Ų��.
		glNormal3f(vertex_normal[face[i][0]][0] /  vertex_normal[face[i][0]][3], vertex_normal[face[i][0]][1] /  vertex_normal[face[i][0]][3], vertex_normal[face[i][0]][2] /  vertex_normal[face[i][0]][3]);		
		glVertex3f(vertex[face[i][0]][0], vertex[face[i][0]][1], vertex[face[i][0]][2]); // i��° �鿡�� �ִ� ��x,y,z �� ���������

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

   glEnable(GL_DEPTH_TEST);	//���� ������ ���� �̹����� ������� ����
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	//ȭ���� �ʱ�ȭ��Ų��.
   glLoadIdentity();
   

   gluLookAt(-1.0, 7.0, 20.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            ������ ��ġ   , �ٶ󺸴� ����, up����   


    glShadeModel(GL_FLAT); // Flat ���
	

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

	  glRotatef(x_angle, 1.0, 0.0, 0.0); //ȸ�� x
	  glRotatef(y_angle, 0.0, 1.0, 0.0);   //ȸ�� y
	  glRotatef(z_angle, 0.0, 0.0, 1.0);   //ȸ�� z
      glScalef(size * 1, size * 1, size * 1);   //���, Ȯ��
   



   glBegin(GL_TRIANGLES);   // �ﰢ���� �׸���.
   for(int i = 0; i < f_count; i++)
   {
        glColor3f(i*(0.1) , 0.0, 0.0);
		// i��° �鿡�� �ش��ϴ� �� 3�� ���������
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
	
   glEnable(GL_DEPTH_TEST);	//���� ������ ���� �̹����� ������� ����
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	//ȭ���� �ʱ�ȭ��Ų��.
   glLoadIdentity();
   

   gluLookAt(-1.0, 7.0, 20.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   //            ������ ��ġ   , �ٶ󺸴� ����, up����   


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

	  glRotatef(x_angle, 1.0, 0.0, 0.0); //ȸ�� x
	  glRotatef(y_angle, 0.0, 1.0, 0.0);   //ȸ�� y
	  glRotatef(z_angle, 0.0, 0.0, 1.0);   //ȸ�� z
      glScalef(size * 1, size * 1, size * 1);   //���, Ȯ��
   

   
   for(int i = 0; i < f_count; i++)
   {
	   glBegin(GL_POINTS);   // �ﰢ���� �׸���.
		glColor3f(i*(0.1) , 0.0, 0.0);
		// i��° �鿡�� �ش��ϴ� �� 3�� ���������
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
   glMatrixMode(GL_PROJECTION);   //������ ó���� ���� ��ǥ�迡�� �ǽ��ϹǷ�, ���� ��ȯ ����� ����
   glLoadIdentity();// �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
   // Ȯ�븦 ���ؼ� ���� �۰��߽��ϴ�.
   glOrtho(-2.0, 2.0, -1.5, 1.5, 0.0, 30.0);
   glMatrixMode(GL_MODELVIEW);
}

void MyKeyboard(unsigned char key, int x, int y)
{
   switch(key)
   {
   //q�� ������ ���簢����̳����� w�� ������ ���Ȱ������ ������ �Ѵ�.
   case 'g':      //Gouraud shading
   case 'G':
      glutDisplayFunc(MyDisplay1);
      break;
   case 'f':      //Flat shading
   case 'F':
      glutDisplayFunc(MyDisplay2); // ������ �ҷ��´�.
      break;
   case 'h':      //Wireframe
   case 'H':
       glutDisplayFunc(MyDisplay3); // ������ �ҷ��´�.
      break;

   case 'w':      //x�� ȸ�� +
   case 'W':
      x_angle += 1;

      break;
   case 's':      //x�� ȸ�� -
   case 'S':
      x_angle -= 1;
      break;
   case 'a':      //y�� ȸ�� +
   case 'A':
      y_angle += 1;

      break;
   case 'd':      //y�� ȸ�� -
   case 'D':
      y_angle -= 1;
      break;
   case 'q':      //z�� ȸ�� +
   case 'Q':
      z_angle += 1;
      break;
   case 'e':      //z�� ȸ�� -
   case 'E':
      z_angle -= 1;
      break;
   case 'z':      //���
   case 'Z':
      if(size != 1)
         size -= 1;
      break;
   case 'x':      //Ȯ��
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
   glutPostRedisplay(); // GLUT�� ���� â�� ���ΰ�ħ �ϵ��� �Ѵ�

} //Ű���带 ������ ��

int main(int argc, char **argv) {
   readObj(argv[1]);	//obj������ �о�´�.
   readTxt();		//light_material.txt�� �о�´�.
   polygonnormal(); // ��鿡�� �������� ���
   vertexnormal(); // ������ ���� ���� ���� ���
   glutInit(&argc, argv); // �ʱ�ȭ�� �����ش�.
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // ������۸��� RGB�������� ���÷��̸�带 �ʱ�ȭ�Ѵ�.
   glutInitWindowPosition(100,100); // ȭ�� �����ġ�� ����Ǵ��� ��ǥ���ϱ�
   glutInitWindowSize(1000,600); // â������ ���ϱ�
   glutCreateWindow("Assignment_3"); // ����
   glClearColor(1.0, 1.0, 1.0,1.0); // ���� ���ϱ�
   glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
   glutDisplayFunc(MyDisplay1); // ������ �ҷ��´�.
   glutReshapeFunc(MyReshape);
   glutKeyboardFunc(MyKeyboard); // Ű�����Լ� ȣ��
   glutMainLoop(); // �׻� ������Ѵ�.
}
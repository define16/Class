#include <stdlib.h>
#include <glut.h>
#include <Windows.h>
#include <math.h>
#include <stdio.h>
#define PI 3.141592
#define M 36
#define N 18

float radius = 5;
float theta;
float phi;
float delta_theta;
float delta_phi;

struct Point3D
{
   float x;
   float y;
   float z;
};

Point3D vertex[M+1][N+1];

float cameraX = 10;
float cameraY = 10;
float cameraZ = 10;

void init(void)
{
   glClearColor(0.0, 0.0, 0.0, 0.0);
   glColor3f(1.0, 1.0, 0.0);
   glEnable(GL_DEPTH_TEST);
}

void reshape(int w, int h)
{
   glViewport(0, 0, w, h);
   glMatrixMode(GL_PROJECTION);
   glLoadIdentity();
   gluPerspective(60.0, 1.0, 1.0, 100.0);
}

void display(void)
{
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glMatrixMode(GL_MODELVIEW);
   glLoadIdentity();
   gluLookAt(cameraX, cameraY, cameraZ, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   
   glBegin(GL_LINES);
   glColor3f(1.0, 0.0, 0.0);
   glVertex3f(0.0, 0.0, 0.0);
   glVertex3f(10.0, 0.0, 0.0);

   glColor3f(0.0, 1.0, 0.0);
   glVertex3f(0.0, 0.0, 0.0);
   glVertex3f(0.0, 10.0, 0.0);

   glColor3f(0.0, 0.0, 1.0);
   glVertex3f(0.0, 0.0, 0.0);
   glVertex3f(0.0, 0.0, 10.0);
   glEnd();

   delta_theta = 2 * PI / M;
   delta_phi = PI / N;

   int i = 0, j = 0;
   for(i=0; i<M; i++)
   {
      for(i=0; j<N; j++)
      {
         theta = i * delta_theta;
         phi = j * delta_phi - (PI / 2);
         vertex[i][j].x = radius * cos(theta) * cos(phi);
         vertex[i][j].y = radius * sin(theta) * cos(phi);
         vertex[i][j].z = radius * sin(phi);
      }
   }

   for(i=0; i<M; i++)
   {
      for(j=0; j<N; j++)
      {
         theta = i * delta_theta;
         phi = j * delta_phi - (PI/2);
         glBegin(GL_POLYGON);
            glVertex3f(vertex[i][j].x, vertex[i][j].y, vertex[i][j].z);
            glVertex3f(vertex[i+1][j].x, vertex[i+1][j].y, vertex[i+1][j].z);
            glVertex3f(vertex[i][j+1].x, vertex[i][j+1].y, vertex[i][j+1].z);
            glVertex3f(vertex[i+1][j+1].x, vertex[i+1][j+1].y, vertex[i+1][j+1].z);
         glEnd();
      }
   }

   glFlush();
   glutSwapBuffers();
}

void SpecialKey(int key, int x, int y)
{
   switch(key)
   {
   case GLUT_KEY_LEFT:
      theta -= 0.1;
      break;
   case GLUT_KEY_RIGHT:
      theta += 0.1;
      break;   
   case GLUT_KEY_DOWN:
      phi -= 0.1;
      break;
   case GLUT_KEY_UP:
      phi += 0.1;
      break;
   case GLUT_KEY_F1:
      glMatrixMode(GL_PROJECTION);
      glLoadIdentity();
      glOrtho(-1.0*radius, radius, -1.0*radius, radius, -1.0*radius, radius);
      break;
   case GLUT_KEY_F2:
      glMatrixMode(GL_PROJECTION);
      glLoadIdentity();
      gluPerspective(60.0, 1.0, 1.0, 100.0);
      break;
   default:
      break;
   }

   if(theta > 2.0 * PI)
      theta -= (2.0 * PI);
   else if(theta < 0.0)
      theta += (2.0 * PI);
}

void main(int argc, char** argv)
{
   glutInit(&argc, argv);
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
   glutInitWindowPosition(100, 100);
   glutInitWindowSize(500, 500);
   glutCreateWindow("Project");
   init();
   glutDisplayFunc(display);
   glutReshapeFunc(reshape);
   glutIdleFunc(display);
   glutMainLoop();
}
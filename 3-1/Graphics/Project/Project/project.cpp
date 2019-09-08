#include <stdlib.h>
#include "glut.h"
#include <math.h>
#include <stdio.h>

#define MAX_PARTICLES 5000 // ��ƼŬ ����


///////////////////////////////////////////////////////////
// Ŀ���� �Ϳ� �Ѱ踦 �ξ���Ѵ�
// Ÿ�̸� �Լ��� �̿��ؼ� �߰��� ���־��Ѵ�.
// ��ƼŬ�� �̵��� �����ؾ��Ѵ�.
//////////////////////////////////////////////////////////

typedef struct                  // Create A Structure For Particle
{
   float   life;               // Particle Life
   float   fade;               // Fade Speed
   float   x;                  // X Position
   float   y;                  // Y Position
   float   z;                  // Z Position
   float   xi;                  // X Direction
   float   yi;                  // Y Direction
   float   zi;                  // Z Direction
}
particles;                     // Particles Structure

particles particle[MAX_PARTICLES];   // Particle Array (Room For Particle Info)

int loop;
float V, Angle;
int cnt = 1;

#define PI 3.141592
float angle = 0.0f;
float x_pos = 0.0;
float x_inc = 0.03;

float y_pos = 0.0;
float y_inc = 0.03;


void DoTimer2(int value);

void MyDisplay1(void)
{
   int i= 0;
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
  
   glShadeModel(GL_SMOOTH);

   
   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position

 //1��
       glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop),0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22 , (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();


      particle[loop].x +=particle[loop].xi/255;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/255;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/255;  // Move On The Z Axis By Z Speed

      // Slow down the particles
      particle[loop].xi *= .99f;  
      particle[loop].yi *= .66f;
      particle[loop].zi *= .99f;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.5f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade= float(rand()%40)/300 + 0.00005f; // Random Fade Value
        particle[loop].x= 30; // Center On X Axis
        particle[loop].y = (loop)*(0.1); // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);


        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
        particle[loop].zi = ((rand()%10)-5)/5;
      } 
   

//2��
        glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop),0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22 , (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y+0.02) * y_pos, z); // Top Right
      glEnd();


      particle[loop].x +=particle[loop].xi/255;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/255;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/255;  // Move On The Z Axis By Z Speed

      // Slow down the particles
      particle[loop].xi *= .99f;  
      particle[loop].yi *= .66f;
      particle[loop].zi *= .99f;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.5f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade= float(rand()%40)/300 + 0.00005f; // Random Fade Value
        particle[loop].x= -30 ; // Center On X Axis
        particle[loop].y = (loop)*(0.1); // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);


        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
        particle[loop].zi = ((rand()%10)-5)/5;
      } 
  
//2��
        glBegin(GL_QUADS);
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop),0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22 , (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y+0.02) * y_pos, z); // Top Right
      glEnd();


      particle[loop].x +=particle[loop].xi/255;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/255;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/255;  // Move On The Z Axis By Z Speed

      // Slow down the particles
      particle[loop].xi *= .99f;  
      particle[loop].yi *= .66f;
      particle[loop].zi *= .99f;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.5f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade= float(rand()%40)/300 + 0.00005f; // Random Fade Value
        particle[loop].x= -10 ; // Center On X Axis
        particle[loop].y = (loop)*(0.1); // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);


        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
        particle[loop].zi = ((rand()%10)-5)/5;
      } 
  

	  //2��
        glBegin(GL_QUADS);
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop),0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.01 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos -22 , (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos -22, (y+0.02) * y_pos, z); // Top Rigth
      glEnd();


      particle[loop].x +=particle[loop].xi/255;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/255;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/255;  // Move On The Z Axis By Z Speed

      // Slow down the particles
      particle[loop].xi *= .99f;  
      particle[loop].yi *= .66f;
      particle[loop].zi *= .99f;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.5f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade= float(rand()%40)/300 + 0.00005f; // Random Fade Value
        particle[loop].x= 10 ; // Center On X Axis
        particle[loop].y = (loop)*(0.1); // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);


        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
        particle[loop].zi = ((rand()%10)-5)/5;
      } 
  



	}
    glutSwapBuffers();
}



void MyDisplay2(void)
{
   int i= 0; 			
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   //glShadeModel(GL_SMOOTH);

   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position
     
       glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();


      particle[loop].x +=particle[loop].xi/255;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/255;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/255;  // Move On The Z Axis By Z Speed

      // Slow down the particles
      particle[loop].xi *= .99f;  
      particle[loop].yi -= .66f;
      particle[loop].zi *= .99f;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.5f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade= float(rand()%40)/300 + 0.00005f; // Random Fade Value
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= 10; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);


        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
        particle[loop].zi = ((rand()%10)-5)/5;
      } 
     }      

   glutSwapBuffers();
}


void MyDisplay3(void)
{
    int i= 0;
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   glShadeModel(GL_SMOOTH);

   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position
     
      glBegin(GL_QUADS);
      
 
        glColor4f(0.0, 0.01 *(loop), 0.01 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

 
         glVertex3f((x-0.02) * x_pos, (y+0.02) * y_pos, z); // Bottom Right
      
 
        
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/255;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/255;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/255;  // Move On The Z Axis By Z Speed

      // Slow down the particles
      particle[loop].xi *=.99f;  
      particle[loop].yi *= .99f;
      particle[loop].zi *= .99f;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.5f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade= float(rand()%40)/300 + 0.00005f; // Random Fade Value
        particle[loop].x = 0; // Center On X Axis
        particle[loop].y = 10; // Center On Y Axis
        particle[loop].z = 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);


        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
        particle[loop].zi = ((rand()%10)-5)/5;
      } 
     }      

   glutSwapBuffers();
}

void MyDisplay4(void)
{
   int i= 0;
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position

	  
//1����
	 glBegin(GL_QUADS);
      
 
			glColor4f( 0.0,0.0 , 0.1 *(rand()),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.0, 0.01 *(rand()) , 0.1 *(rand()),particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -7; // Center On X Axis

        particle[loop].y= 18; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
	  
//2����
      
      glBegin(GL_QUADS);
      
 
		  glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		  glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 
         glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -13; // Center On X Axis

        particle[loop].y= 15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
//3����
     
      glBegin(GL_QUADS);
      
 
		 glColor4f(0.1 *(loop), 0.1 *(loop),0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		 glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -7; // Center On X Axis

        particle[loop].y= 12; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

//4����
     
      glBegin(GL_QUADS);
      
 
		 glColor4f(0.1 *(loop), 0.1 *(loop),0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		 glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -7; // Center On X Axis

        particle[loop].y= 8; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

//5����
     
      glBegin(GL_QUADS);
      
 
		 glColor4f(0.1 *(loop), 0.1 *(loop),0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		 glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  5; // Center On X Axis

        particle[loop].y= 8; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
	  
	  
//6����
      glBegin(GL_QUADS);
      
 
		 glColor4f( 0.0, 0.1 *(loop), 0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) *y_pos, z); // Top Left
      
 
		 glColor4f( 0.0, 0.3 *(loop), 0.3 *(loop),particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) * y_pos, z); // Bottom Right
      
  
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();

	  particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  7; // Center On X Axis

        particle[loop].y= 12; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 


//7����
      glBegin(GL_QUADS);
		
 
		 glColor4f( 0.1 *(loop),0.0, 0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * (y_pos), z); // Top Left
      
 
		 
         glVertex3f((x-0.02) * x_pos, (y-0.02) * (y_pos), z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) * (y_pos), z); // Bottom Right
      
  
         glVertex3f((x+0.02) * x_pos, (y+0.02) * (y_pos), z); // Top Right
      
      glEnd();

	  particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  13; // Center On X Axis

        particle[loop].y= 15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

//8����
      glBegin(GL_QUADS);
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * (y_pos), z); // Top Left
      
 
         glVertex3f((x-0.02) * x_pos, (y-0.02) * (y_pos), z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) * (y_pos), z); // Bottom Right
      
  
         glVertex3f((x+0.02) * x_pos, (y+0.02) * (y_pos ), z); // Top Right
      
      glEnd();


      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.55;  
      particle[loop].yi*=.55;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 5; // Center On X Axis

        particle[loop].y= 18; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      }
     }            
	 
   glutSwapBuffers();
}

void MyDisplay7(void)
{
   int i= 0;
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position

	  
//1����
	 glBegin(GL_QUADS);
      
 
			glColor4f( 0.0,0.0 , 0.1 *(rand()),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.0, 0.01 *(rand()) , 0.1 *(rand()),particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -7; // Center On X Axis

        particle[loop].y= 18; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
	  
//2����
      
      glBegin(GL_QUADS);
      
 
		  glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		  glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 
         glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -13; // Center On X Axis

        particle[loop].y= 15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
//3����
     
      glBegin(GL_QUADS);
      
 
		 glColor4f(0.1 *(loop), 0.1 *(loop),0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		 glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -7; // Center On X Axis

        particle[loop].y= 12; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

//4����
     
      glBegin(GL_QUADS);
      
 
		 glColor4f(0.1 *(loop), 0.1 *(loop),0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		 glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  -7; // Center On X Axis

        particle[loop].y= 8; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

//5����
     
      glBegin(GL_QUADS);
      
 
		 glColor4f(0.1 *(loop), 0.1 *(loop),0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
		 glVertex3f((x-0.02) * x_pos, (y+0.02) *y_pos , z); // Bottom Right
      
         glTexCoord2f(1,1);
		 glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();
	   particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  5; // Center On X Axis

        particle[loop].y= 8; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
	  
	  
//6����
      glBegin(GL_QUADS);
      
 
		 glColor4f( 0.0, 0.1 *(loop), 0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) *y_pos, z); // Top Left
      
 
		 glColor4f( 0.0, 0.3 *(loop), 0.3 *(loop),particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) * y_pos, z); // Bottom Right
      
  
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();

	  particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  7; // Center On X Axis

        particle[loop].y= 12; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 


//7����
      glBegin(GL_QUADS);
		
 
		 glColor4f( 0.1 *(loop),0.0, 0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * (y_pos), z); // Top Left
      
 
		 
         glVertex3f((x-0.02) * x_pos, (y-0.02) * (y_pos), z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) * (y_pos), z); // Bottom Right
      
  
         glVertex3f((x+0.02) * x_pos, (y+0.02) * (y_pos), z); // Top Right
      
      glEnd();

	  particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x =  13; // Center On X Axis

        particle[loop].y= 15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

//8����
      glBegin(GL_QUADS);
      
 
		 glColor4f( 0.1 *(loop), 0.1 *(loop), 0.1 *(loop),particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * (y_pos), z); // Top Left
      
 
         glVertex3f((x-0.02) * x_pos, (y-0.02) * (y_pos), z); // Bottom Left

  
         glVertex3f((x-0.02) * x_pos, (y+0.02) * (y_pos), z); // Bottom Right
      
  
         glVertex3f((x+0.02) * x_pos, (y+0.02) * (y_pos ), z); // Top Right
      
      glEnd();


      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.55;  
      particle[loop].yi-=.55;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/100 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 5; // Center On X Axis

        particle[loop].y= 18; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%20))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      }
     }            
	 
   glutSwapBuffers();
}

void MyDisplay5(void)
{
   int i= 0;
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position

      // Draw The Particle Using Our RGB Values, Fade The Particle Based On It's Life

      glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= 13; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

      // Draw The Particle Using Our RGB Values, Fade The Particle Based On It's Life

      glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4,  y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4,  y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4,  y_pos, z); // Bottom Right
      
  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos +4,  y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -3; // Center On X Axis
        particle[loop].y= 15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      }
     
      // Draw The Particle Using Our RGB Values, Fade The Particle Based On It's Life
      
      glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 3; // Center On X Axis
        particle[loop].y= 15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
     
    
   glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -6; // Center On X Axis
        particle[loop].y= 13; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 


     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 6; // Center On X Axis
        particle[loop].y= 13; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -5; // Center On X Axis
        particle[loop].y= 9; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 5; // Center On X Axis
        particle[loop].y= 9; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -3; // Center On X Axis
        particle[loop].y= 6; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

      glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 3; // Center On X Axis
        particle[loop].y= 6; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

      glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= 3; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

	  glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= 9; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
   }
   glutSwapBuffers();
}

void MyDisplay6(void)
{
   int i= 0;
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glLoadIdentity();

   gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   for (loop=0; loop<MAX_PARTICLES; loop++) // Loop Through All The Particles
    {
      float x=particle[loop].x; // Grab Our Particle X Position
      float y=particle[loop].y; // Grab Our Particle Y Position
      float z=0; // Grab Our Particle Z Position

      // Draw The Particle Using Our RGB Values, Fade The Particle Based On It's Life

      glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y-0.02) * y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y-0.02) * y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos, (y+0.02) * y_pos, z); // Bottom Right
      
  
        glColor4f( 0.0, 0.1 *(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos, (y+0.02) * y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi*=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

      // Draw The Particle Using Our RGB Values, Fade The Particle Based On It's Life

      glBegin(GL_QUADS);
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4,  y_pos, z); // Top Left
      
 
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4,  y_pos, z); // Bottom Left

  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4,  y_pos, z); // Bottom Right
      
  
        glColor4f(0.01 *(loop), 0.0, 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos +4,  y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -3; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      }
     
      // Draw The Particle Using Our RGB Values, Fade The Particle Based On It's Life
      
      glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 3; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
     
    
   glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -6; // Center On X Axis
        particle[loop].y=  -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 


     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 6; // Center On X Axis
        particle[loop].y=  -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -5; // Center On X Axis
        particle[loop].y=  -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 5; // Center On X Axis
        particle[loop].y=  -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

     glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= -3; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

      glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 3; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

      glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 

	  	  glBegin(GL_QUADS);
      
        glTexCoord2f(1,0);
      glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Left
      
 
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Left

  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x-0.02) * x_pos + 4, y_pos, z); // Bottom Right
      
  
       glColor4f(0.01 *(loop), 0.1*(loop), 0.0,particle[loop].life);
         glVertex3f((x+0.02) * x_pos + 4, y_pos, z); // Top Right
      
      glEnd();

      particle[loop].x +=particle[loop].xi/120;  // Move On The X Axis By X Speed
      particle[loop].y +=particle[loop].yi/120;  // Move On The Y Axis By Y Speed
      particle[loop].z +=particle[loop].zi/120;  // Move On The Z Axis By Z Speed

      // Slow down the particles   // '��ħ����
      particle[loop].xi*=.99;  
      particle[loop].yi-=.99;
      particle[loop].zi*=.99;

      particle[loop].life-=particle[loop].fade; // Reduce Particles Life By 'Fade'

      if (particle[loop].life<0.7f) // If Particle Is Burned Out
      {
        particle[loop].life=1.0f; // Give It New Life
        particle[loop].fade=float(rand()%2)/300 + 0.005f; // �������� �ѷ����� ��ü ����
        particle[loop].x= 0; // Center On X Axis
        particle[loop].y= -15; // Center On Y Axis
        particle[loop].z= 0; // Center On Z Axis
        V = (float((rand()%9))+1);
        Angle = float(rand()%360);

        particle[loop].xi = sin(Angle) * V;
        particle[loop].yi = cos(Angle) * V;
       particle[loop].zi = ((rand()%10)-5)/5;
      } 
   }
   glutSwapBuffers();
}
void MyReshape(int w, int h)
{
   glViewport(0,0, w, h);	//
   glMatrixMode(GL_PROJECTION);  //������ ó���� ���� ��ǥ�迡�� �ǽ��ϹǷ�, ���� ��ȯ ����� ����
   gluPerspective(45.0f, (GLfloat)w/(GLfloat)h, 0.1f, 100.0f);	
   glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
	glFrustum(-50.0, 50.0, -10.0,80.0, 1.5, 20.0);
   glMatrixMode(GL_MODELVIEW);
}

void MyIdle() {
	  cnt++;
   		glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.

	   if(x_pos >= 30.0 || x_pos<0.0) 
	   {
		  x_inc *= 0.03;
	   }
	   x_pos+=x_inc;

	   if(y_pos >= 30.0 || y_pos<0.0) 
	   {
		  y_inc *= 0.03;
	   }

	   y_pos+=y_inc;

	//  particle[loop].life = 1.0f;

		if(cnt >= 0 && cnt <300) {
			particle[loop].life = 0.0f;
			printf("����1\n");
			glutPostRedisplay();
		}

		else if(cnt >= 300 && cnt < 550) {
			particle[loop].life = 0.0;
			MyDisplay2();
			printf("����2\n");
		}
		
		else if(cnt >= 550 && cnt < 750) {
			particle[loop].life = 0.0;
			MyDisplay3();
			printf("����3\n");
		}
		else if(cnt >= 750 && cnt <950) {
			particle[loop].life = 0.0f;
			MyDisplay4();
			printf("����4\n");
		}
		else if(cnt >= 950 && cnt <1000) {
			particle[loop].life = 0.0f;
			MyDisplay7();
			printf("����4\n");
		}
		else  if(cnt >= 1000 && cnt <1200){
			particle[loop].life = 0.0f;
			MyDisplay5();
			printf("����5\n");
		}
		else {
			particle[loop].life = 0.0f;
			MyDisplay6();
			printf("����6\n");
		}

}
int main(int argc, char **argv) {
   glutInit(&argc, argv); // �ʱ�ȭ�� �����ش�.
   glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB); // ������۸��� RGB�������� ���÷��̸�带 �ʱ�ȭ�Ѵ�.
   glutInitWindowPosition(200,100); // ȭ�� �����ġ�� ����Ǵ��� ��ǥ���ϱ�
   glutInitWindowSize(800,600); // â������ ���ϱ�
   glutCreateWindow("Project"); // ����
   glClearColor(0.0, 0.0, 0.0,0.0); // ���� ���ϱ�
   glLoadIdentity(); // �ʱ�ȭ�� �����ִ� �Լ��Դϴ�.
   glutDisplayFunc(MyDisplay1); // ������ �ҷ��´�.
   glutReshapeFunc(MyReshape);
	glutIdleFunc(MyIdle);
   glutMainLoop(); // �׻� ������Ѵ�.

   return 0;
}
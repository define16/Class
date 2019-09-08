import java.applet.*;
import java.awt.*;

public class CApp extends Applet {
	Rectangle r1 = new Rectangle(0,8,100,150);
	int x,y;
	class Rectangle {
		private int x;
		private int y;
		private int width;
		private int height;
		public Rectangle(){
			x = y = width = height = 0;
		}
	public Rectangle(int x, int y, int width, int height){
		this.x = x;  this.y = y; this.width = width;  this.height = height;
	}
	public void draw(Graphics g)
	{
		g.drawRect(x, y, width, height);
		g.drawLine(x , y, width, height);
		g.drawLine(x, y+height, x+width, height );
	}
	public void draw(){
		System.out.println("Rectangle: " + x + ", " + y + ", " + width + ", " + height );
		
	}
	}
	public void paint(Graphics g){
		r1.draw(g);
		r1.draw();
		
	}

}

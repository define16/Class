import java.awt.*;
abstract class Shape
{
	protected Color color;
	protected int m_x;
	protected int m_y;
		
	public Shape(Color c, int x, int y)
	{
		color = c;
		m_x = x;
		m_y = y;
	}
	abstract public void draw();
}
 class CRectangle extends Shape
 {
	 private int width;
	 private int height;
	 public CRectangle(Color c, int x, int y, int width, int height)
	 {
		 super(c,x,y);
		 this.width = width;
		 this.height = height;
	 }
	 public void draw()
	 {
		 System.out.println("Rectangle : " + m_x + " + " + m_y + " , " + width + " , " + height);
	 }
	 class Circle extends Shape
	 {
		 private int radius;
		 public Circle(Color c, int x, int y, int radius)
		 {
			 super(c,x,y);
			 this.radius = radius;
		 }
		 
		 public void draw()
		 {
			 System.out.println("Circle : " + m_x + " , " + m_y + " , " + radius);
		 }
		 public class GraphicsProgram
		 {
			 public void main(String agrs[])
			 {
			 Shape s1 = new CRectangle(Color.red,0,5,200,300);
			 Shape s2 = new Circle(Color.green,10,30,100);
			
			 s1.draw();
			 s2.draw();
			
			 		 }
		 

		 }
	 }
 }
 

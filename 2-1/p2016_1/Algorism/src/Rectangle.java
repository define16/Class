
class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	public Rectangle() {
		x = y = width = height = 0;
		
	}
	public Rectangle(int x, int y, int width, int height){
		this.x=x; this.y=y; this.width=width; this.height = height;
	}
	public void draw(){
		System.out.println("Rectangle: " + x +", " + y + ", " + width + ", " + height);
		
	}

	public static void main(String[] agrs){
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(0, 8, 100, 150);
		r1.draw();
		r2.draw();
		
	}
}

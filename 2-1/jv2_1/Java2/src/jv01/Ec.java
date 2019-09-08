package jv01;

public class Ec {
	int ver;
	
	public void setInt(int ver)
	{
		this.ver = ver;
	}
	public int getInt()
	{
		int i;
		
		i = ver * 2;
		
		return i;
	}
	public static void main(String []args)
	{
		Ec me = new Ec();
		me.setInt(1000);
		
		System.out.println("var : " + me.getInt());
		
	}

}

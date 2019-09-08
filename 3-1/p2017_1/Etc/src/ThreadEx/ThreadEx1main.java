package ThreadEx;

public class ThreadEx1main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx1 th = new ThreadEx1();
		
		th.start();
		
		for(int i = 0; i<10;i++)
		{
			System.out.println("메인메소드 작동");
			
		}
	}

}

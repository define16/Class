package ThreadEx;

public class ThreadEx1 extends Thread {

	public void run()
	{
		
		for(int i = 0;i<6; i++)
		{
			try{
				System.out.println("스레드 시작");
				sleep(3000);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}

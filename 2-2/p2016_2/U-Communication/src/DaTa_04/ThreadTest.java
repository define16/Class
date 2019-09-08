package DaTa_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ThreadTest extends Thread {

	int cnt = 0;
	
	public void run()
	{
		while(true)
		{
			cnt++;
			System.out.println("new thread sec : "+cnt);
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();				
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest t1 = new ThreadTest();
		
		t1.start();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("main ¾²·¹µå");
				String str = in.readLine();
				System.out.println("["+t1.cnt+"]");
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}

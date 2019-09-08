package DaTa_04_ver2;

import java.util.Vector;

import javax.swing.JLabel;


public class ThreadOperation extends Thread
{
	private int cnt = 0,cnt_m=0,cnt_h=0,c=0;
	private JLabel count = null;
	private boolean flag = false;

	public ThreadOperation(JLabel label)
	{
		this.count = label;
	}
	
	
	public void threadFlag()
	{
		cnt = 0;
		cnt_m=0;
		cnt_h=0;
		flag = !flag;
	}
	
	public void run()
	{
		while(true)
		{
			if(flag)
			{
				cnt++;
				
				if(cnt == 60)
				{
					cnt = 0;
					cnt_m++;
				}
				if(cnt_m==60)
				{
					cnt_m=0;
					cnt_h++;
				}
				count.setText(String.format("%02dh : %02dm : %02ds",cnt_h,cnt_m,cnt));
			}	

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	

	
}

package  jv10;
import java.util.*;

public class QueueTest {
	public static void main(String[] args) throws InterruptedException {
		int time=10;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=time;i>=0;i--)
			q.add(i);
		
		while(!q.isEmpty())
		{
			System.out.print(q.remove() + " ");
			Thread.sleep(1000);   //1초간 재우기
		}
	}
}

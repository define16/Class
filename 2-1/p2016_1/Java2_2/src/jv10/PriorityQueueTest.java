package  jv10;
import java.util.*;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		p.add(30);
		p.add(80);
		p.add(20);
		p.add(10);
		p.add(50);
		p.add(100);
		
		for(Integer i:p)
			System.out.println(i);
		
		System.out.println("원소의 삭제");
		while(!p.isEmpty())
			System.out.println(p.remove());

	}
}

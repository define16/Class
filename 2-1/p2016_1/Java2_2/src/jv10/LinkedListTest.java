package  jv10;
import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTest {
	public static void main(String[] args)
	{
		LinkedList<String> s=new LinkedList<String>();
		
		s.add("MILK");
		s.add("BREAD");
		s.add("BUTTER");
		s.add(1, "APPLE");
		s.set(2,"GRAPE");
		s.remove(3);
		
		for(int i=0; i<s.size(); i++)
			System.out.println(s.get(i));
		
		System.out.println("=============================");
		
		String str;
		Iterator<String> e= s.iterator();
	
		while(e.hasNext())
		{
			str=(String)e.next();
			System.out.println(str);
		}
	}
}

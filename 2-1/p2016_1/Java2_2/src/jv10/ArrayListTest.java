package jv10;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args)
	{
		ArrayList<String> s=new ArrayList<String>();
		
		s.add("MILK");
		s.add("BREAD");
		s.add("BUTTER");
		s.add(1, "APPLE");
		s.set(3,"GRAPE");
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

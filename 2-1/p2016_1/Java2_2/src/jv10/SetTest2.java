package jv10;
import java.util.*;

public class SetTest2 {
	public static void main(String[] args)
	{
		Set<String> s = new HashSet<String>();
		
		String[] sample = {"단어","중복","구절","중복"};
		
		for(String a:sample)
		{
			if(!s.add(a))
				System.out.println("중복되는 단어는 :" + a);
			
		}
		System.out.println(s.size() + "가지 단어는 : " + s);
		
	}
}

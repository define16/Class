package jv10;
import java.util.*;

public class SetTest2 {
	public static void main(String[] args)
	{
		Set<String> s = new HashSet<String>();
		
		String[] sample = {"�ܾ�","�ߺ�","����","�ߺ�"};
		
		for(String a:sample)
		{
			if(!s.add(a))
				System.out.println("�ߺ��Ǵ� �ܾ�� :" + a);
			
		}
		System.out.println(s.size() + "���� �ܾ�� : " + s);
		
	}
}

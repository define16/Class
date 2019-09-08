package  jv10;
import java.util.*;

public class SetTest3 {
	public static void main(String[] args) {
		Set<String>	s1 = new HashSet<String>();
		Set<String>	s2 = new HashSet<String>();
		
		s1.add("A");
		s1.add("B");
		s1.add("C");
		
		s2.add("A");
		s2.add("D");
		
		Set<String> uni = new HashSet<String>(s1);
		uni.addAll(s2);
		Set<String> inter = new HashSet<String>(s1);
		inter.retainAll(s2);
		
		System.out.println("합집합" + uni);
		System.out.println("교집합" + inter);
		
	}
}

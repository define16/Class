package  jv10;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Totreeset {
	public static void main(String[] args)
	{
		Set<String> set=new HashSet<String>();
		set.add(new String("1..."));
		set.add(new String("2..."));
		set.add(new String("3..."));
		set.add(new String("4..."));
		set.add(new String("5..."));
		set.add(new String("6..."));
		System.out.println("HashSet : " + set);
		
		//HashSet을 TreeSet으로 변환하기
		TreeSet<String> treeset = new TreeSet<String>();
		treeset.addAll(set);
		System.out.println("TreeSet : " + treeset);
	}
}

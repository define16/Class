package  jv10;
import java.util.TreeSet;
import java.util.Iterator;

public class Totreeset1 {
	public static void main(String[] args) {
	   TreeSet<String> ts = new TreeSet<String>();
	   ts.add("홍길동");
	   ts.add("차범근");
	   ts.add("유재석");
	   ts.add("유재석");
	   ts.add("박명수");
	   ts.add("김유신");
	   ts.add("홍길동");
	
	   Iterator<String> ite = ts.iterator();
	   System.out.println("오름차순으로 출력하기");
	   while(ite.hasNext()) {
		   System.out.println(ite.next());
	   }
	
	
	   Iterator<String> ite2 = ts.descendingIterator();
	   System.out.println("내림차순으로 출력하기");
	   while(ite2.hasNext()) {
		   System.out.println(ite2.next());
	   }
	
	   System.out.println(ts);
	
	 }
}

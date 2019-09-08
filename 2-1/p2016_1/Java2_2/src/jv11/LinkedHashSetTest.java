package  jv11;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) 
	 {
	  LinkedHashSet set= new LinkedHashSet();
	  HashSet s = new HashSet();
	  s.add("가");
	  s.add("나");
	  s.add("다");
	  s.add("라");
	  s.add("마");
	  s.add("바");//String
	  s.add(27.5);//doublie
	  s.add(50);//int

	  System.out.println("HashSet : " + s);
	  
	  set.add("가");
	  set.add("나");
	  set.add("다");
	  set.add("라");
	  set.add("마");
	  set.add("바");//String
	  set.add(27.5);//doublie
	  set.add(50);//int

	//HashSet<E> 클래스와는 달리,
	//LinkedHashSet<E>는 저장순서가 유지가 됨.
	

	  System.out.println("LinkedHashSet: " + set);
	 }
}


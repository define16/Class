package  jv11;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) 
	 {
	  LinkedHashSet set= new LinkedHashSet();
	  HashSet s = new HashSet();
	  s.add("��");
	  s.add("��");
	  s.add("��");
	  s.add("��");
	  s.add("��");
	  s.add("��");//String
	  s.add(27.5);//doublie
	  s.add(50);//int

	  System.out.println("HashSet : " + s);
	  
	  set.add("��");
	  set.add("��");
	  set.add("��");
	  set.add("��");
	  set.add("��");
	  set.add("��");//String
	  set.add(27.5);//doublie
	  set.add(50);//int

	//HashSet<E> Ŭ�����ʹ� �޸�,
	//LinkedHashSet<E>�� ��������� ������ ��.
	

	  System.out.println("LinkedHashSet: " + set);
	 }
}


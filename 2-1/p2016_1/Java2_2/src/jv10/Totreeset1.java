package  jv10;
import java.util.TreeSet;
import java.util.Iterator;

public class Totreeset1 {
	public static void main(String[] args) {
	   TreeSet<String> ts = new TreeSet<String>();
	   ts.add("ȫ�浿");
	   ts.add("������");
	   ts.add("���缮");
	   ts.add("���缮");
	   ts.add("�ڸ��");
	   ts.add("������");
	   ts.add("ȫ�浿");
	
	   Iterator<String> ite = ts.iterator();
	   System.out.println("������������ ����ϱ�");
	   while(ite.hasNext()) {
		   System.out.println(ite.next());
	   }
	
	
	   Iterator<String> ite2 = ts.descendingIterator();
	   System.out.println("������������ ����ϱ�");
	   while(ite2.hasNext()) {
		   System.out.println(ite2.next());
	   }
	
	   System.out.println(ts);
	
	 }
}

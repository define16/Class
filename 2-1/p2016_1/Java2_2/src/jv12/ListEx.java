package jv12;
import java.awt.*;

public class ListEx{
	public static void main(String[] arsg){

		Frame f=new Frame("����Ʈ �׽�Ʈ");
		Panel p=new Panel();
		
		List list1=new List(0,true);
		
		list1.add("����");
		list1.add("�뱸");
		list1.add("����");
		list1.add("�λ�");
		list1.add("��õ");
		list1.add("����");
		list1.add("����");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300,200);
		f.setVisible(true);
	}
}
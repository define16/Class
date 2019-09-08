package jv12;
import java.awt.*;

public class ListEx{
	public static void main(String[] arsg){

		Frame f=new Frame("리스트 테스트");
		Panel p=new Panel();
		
		List list1=new List(0,true);
		
		list1.add("서울");
		list1.add("대구");
		list1.add("대전");
		list1.add("부산");
		list1.add("춘천");
		list1.add("강릉");
		list1.add("원주");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300,200);
		f.setVisible(true);
	}
}
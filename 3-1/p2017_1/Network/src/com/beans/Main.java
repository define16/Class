package com.beans;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/////////////////////////////////////////////////////////////////////////////
/*		ArrayList<String> list = new ArrayList<String>();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		System.out.println(list.get(1));
		
		list.remove(0);
		
		System.out.println(list.get(1));
		
		System.out.println(list.size());*/
		
		/*ArrayList<Member> list = new ArrayList<Member>();
		
		list.add(new Member("M17055", "������", "1234"));
		
		Member member = new Member("1111", "test", "pwd");
		
		list.add(member);
		
		System.out.println(list.size());
		System.out.println(list.get(1));
		System.out.println(list.get(1).getName());
		
		list.remove(0);
		
		System.out.println(list.get(1).getName());
		System.out.println(list.size());*/
//////////////////////////////////////////////////////////////////////////////		
/*		Member m1 = new Member("1234", "ȫ�浿", "pwd");
		Member m2 = new Member("1226", "���ǽ�", "pwd");
		Member m3 = new Member("1234", "ȫ�浿", "pwd");
		
		System.out.println("Id : " + m1.getId() + ", Name : " + m1.getName() + ",Password : " + m1.getPasswd());
		System.out.println(String.format("Id : %s, Name : %s, Password : %s",m2.getId(),m2.getName(),m2.getPasswd()));
		System.out.println(m3.toString());
		System.out.println(m3);
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		*/
////////////////////////////////////////////////////////////////////////////////		
		Member m1 = new Member("1234", "ȫ�浿", "pwd");
		Member m2 = new Member("1226", "���ǽ�", "pwd");
		Member m3 = new Member("1234", "ȫ�浿", "pwd");
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m3);
		
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		list.get(2).setName("change");
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		/*
1. Data.java �� �����Ͽ� ������ ���� ó���� �Ѵ�(5��).
String keyword, link; //  ��� ���� ����
���� 2���� ���� ���� ������, Getter, Setter ����
equals, toString �Լ��� �������̵� �Ͽ� �� �� ��� ��� �߰�

2. ���� �ð� ������ �̾� a �±��� �Ӽ��� href ���� ���� ���� �� �ֵ��� �Ѵ�(5��). 
�ش� Ű���带 �˻����ִ� link �� ����Ǵ� �ּ� ���� ���´�. 
select �� ���� a �±��� ��href�� ��� attr ���� ������ �ȴ�. (jsoup �� attr(��herf��) �̿�, ���� �ð��� ��¦ ���
3. [1, 2] �� ������ �Ϸ��� ��, Parser.java ������ ������ �� ������ ���� ó���� �Ѵ�(5��).
public static ArrayList<Data> getNaver(), public static ArrayList<Data> getDaum() �Լ��� �����. 
ArrayList<Data> ���� Ű���� �� link ���� ����� ArrayList �� ��ȯ�ϸ� ��. 
������ ���� Main ������ ����� �� �Լ��� ��ȯ�ϴ� ����� �����ϸ� �ȴ�. 
���� �Լ��� ���� �����ϴ� ���� ����. 
������ �Լ��� Main.java ���� ���� �Լ��� ȣ���Ͽ� ArrayList �� ���� ���� ����, ����Ʈ�� ������ ���� ����غ���.


30�� ������ ���� �ǽð� ����Ʈ ��ũ �ѹ� ������ �ϱ� 
������� ĸ���ؼ� ���� �ø���
		 */
		
	}
	


}

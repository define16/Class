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
		
		list.add(new Member("M17055", "조준형", "1234"));
		
		Member member = new Member("1111", "test", "pwd");
		
		list.add(member);
		
		System.out.println(list.size());
		System.out.println(list.get(1));
		System.out.println(list.get(1).getName());
		
		list.remove(0);
		
		System.out.println(list.get(1).getName());
		System.out.println(list.size());*/
//////////////////////////////////////////////////////////////////////////////		
/*		Member m1 = new Member("1234", "홍길동", "pwd");
		Member m2 = new Member("1226", "강의실", "pwd");
		Member m3 = new Member("1234", "홍길동", "pwd");
		
		System.out.println("Id : " + m1.getId() + ", Name : " + m1.getName() + ",Password : " + m1.getPasswd());
		System.out.println(String.format("Id : %s, Name : %s, Password : %s",m2.getId(),m2.getName(),m2.getPasswd()));
		System.out.println(m3.toString());
		System.out.println(m3);
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		*/
////////////////////////////////////////////////////////////////////////////////		
		Member m1 = new Member("1234", "홍길동", "pwd");
		Member m2 = new Member("1226", "강의실", "pwd");
		Member m3 = new Member("1234", "홍길동", "pwd");
		
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
1. Data.java 를 생성하여 다음과 같은 처리를 한다(5점).
String keyword, link; //  멤버 변수 생성
위의 2가지 값에 대한 생성자, Getter, Setter 생성
equals, toString 함수를 오버라이딩 하여 비교 및 출력 기능 추가

2. 지난 시간 숙제에 이어 a 태그의 속성인 href 값도 같이 얻어올 수 있도록 한다(5점). 
해당 키워드를 검색해주는 link 로 연결되는 주소 값을 얻어온다. 
select 로 얻은 a 태그의 “href” 라는 attr 값을 얻어오면 된다. (jsoup 의 attr(“herf”) 이용, 수업 시간에 살짝 배움
3. [1, 2] 번 숙제를 완료한 후, Parser.java 파일을 생성한 후 다음과 같은 처리를 한다(5점).
public static ArrayList<Data> getNaver(), public static ArrayList<Data> getDaum() 함수를 만든다. 
ArrayList<Data> 에는 키워드 및 link 값이 저장된 ArrayList 를 반환하면 됨. 
기존의 만든 Main 에서의 기능을 이 함수로 변환하는 기능을 수행하면 된다. 
위의 함수를 전부 구현하는 것이 목적. 
구현된 함수를 Main.java 에서 위의 함수를 호출하여 ArrayList 를 각각 얻어온 다음, 리스트의 정보를 전부 출력해보자.


30초 스레드 빼고 실시간 리스트 링크 한번 나오게 하기 
결과물을 캡쳐해서 같이 올리기
		 */
		
	}
	


}

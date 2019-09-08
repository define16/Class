package  jv10;

import java.util.*;

class Student{
	int number;
	String name;
	
	public Student(int number, String name){
		this.number = number;
		this.name = name;
	}
	public String toString(){
		return name;
	}
}

public class MapTest {
	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<String, Student>();
		 st.put("1",new Student(2001, "홍길동"));
		 st.put("2",new Student(2002, "이순자"));
		 st.put("3",new Student(2003, "박자기"));
		 
		  System.out.println("모든 항목 출력" + st);
		  
		  st.remove("2");
		  
		  st.put("4", new Student(2004,"소이정"));
		  System.out.println(st.get("4"));
		  
		  for(Map.Entry<String, Student> s: st.entrySet()){
			  String key = s.getKey();
			  Student value = s.getValue();
			  System.out.println("Key= " + key +", value = " + value);
		  }
	}
}
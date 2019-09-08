package jv04;

class C1 {
	  static int x;
	  static int y;
}

class C2 extends C1 {
	  static String x;
}

public class Inte3 {
	  public static void main(String args[]) {
	    C2.x = "자바";
	   
	    C1.x = 30000;
	    C1.y = 20000;
	    System.out.println("클래스 변수 C2.x 값 : " + C2.x);
	    System.out.println("클래스 변수 C2.y 값(C1으로부터 상속) : "  + C2.y);
	    System.out.println("클래스 변수 C1.x 값 : " + C1.x);
	  }
}

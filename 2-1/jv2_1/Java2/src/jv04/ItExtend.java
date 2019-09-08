package jv04;

interface Aa {
	  void ameth1(); 
	  void ameth2();
}

interface Bb {
	  void bmeth1();
}

interface Cc extends Aa,Bb {  // 두 개의 인터페이스 상속
	  void cmeth1();
}

class InterfaceClass implements Cc {
	  public void ameth1() {
	    System.out.println("ameth1() 메소드의 구현");
	  }
	  public void ameth2() {
	    System.out.println("ameth2() 메소드의 구현");
	  }
	  public void bmeth1() {
	    System.out.println("bmeth1() 메소드의 구현");
	  }
	  public void cmeth1() {
	    System.out.println("cmeth1() 메소드의 구현");
	  }
}	

public class ItExtend {
	  public static void main(String arg[]) {
	    InterfaceClass ic = new InterfaceClass();

	    ic.ameth1();
	    ic.ameth2();
	    ic.bmeth1();
	    ic.cmeth1();
	  }
}

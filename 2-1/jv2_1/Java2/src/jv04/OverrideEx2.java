package jv04;

class Aoo {
	  void show() {
	    System.out.println("상위클래스의 메소드 show(String str) 수행");
	  }
}

class Boo extends Aoo {
	  void show() {
	    System.out.println("하위클래스의 메소드 show() 수행");
	  }
}
	  
public class OverrideEx2 {
	  public static void main(String args[]) {
	    Boo over = new Boo();
	    over.show(); 
	  }
}

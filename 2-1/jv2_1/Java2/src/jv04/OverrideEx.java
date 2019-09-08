package jv04;

class Ao {
	  void show(String str) {
	    System.out.println("상위클래스의 메소드 show(String str)수행 " + str);
	  }
}

class Bo extends Ao {
	  void show() {
	    System.out.println("하위클래스의 메소드 show() 수행");
	  }
}
	  
public class OverrideEx{
	  public static void main(String args[]) {
	    Bo over = new Bo();
	    over.show("자바"); 
	    over.show();
	  }
}

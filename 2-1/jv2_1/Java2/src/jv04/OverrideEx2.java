package jv04;

class Aoo {
	  void show() {
	    System.out.println("����Ŭ������ �޼ҵ� show(String str) ����");
	  }
}

class Boo extends Aoo {
	  void show() {
	    System.out.println("����Ŭ������ �޼ҵ� show() ����");
	  }
}
	  
public class OverrideEx2 {
	  public static void main(String args[]) {
	    Boo over = new Boo();
	    over.show(); 
	  }
}

package jv04;

class Ao {
	  void show(String str) {
	    System.out.println("����Ŭ������ �޼ҵ� show(String str)���� " + str);
	  }
}

class Bo extends Ao {
	  void show() {
	    System.out.println("����Ŭ������ �޼ҵ� show() ����");
	  }
}
	  
public class OverrideEx{
	  public static void main(String args[]) {
	    Bo over = new Bo();
	    over.show("�ڹ�"); 
	    over.show();
	  }
}

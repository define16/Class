package jv04;

class AA1 {
	  int i; 
	  int j; 

	  void setij(int x, int y) {
	    i = x;
	    j = y;
	  }
}

class BB1 extends AA1 {
	  int total;

	  void sum() {
	    total = i + j; 
	  }	
}
	  
public class Inte4 {
	  public static void main(String args[]) {
	    BB1 subOb = new BB1();

	    subOb.setij(10, 12);  
	    subOb.sum();           
	    System.out.println("두 수의 합계는 : " + subOb.total);
	  }
}

package Report2;

public class Hanoitowers {
	 static int cnt = 1;
	 public static void main(String[] args) {
   int num=100;
   hanoi(num,'A','B','C');
	
 }
 	static void hanoi(int n, char x, char y, char z) {
	 
   if (n==1){
   	System.out.println(cnt +" th disk "+ x + " -> " + y);  // base
   	cnt++;
   }
   else {
 
   	hanoi(n-1,x,z,y);
   	System.out.println(cnt + " th disk " + x + "-->" + y);
   	cnt++;
   	hanoi(n-1,z,y,x);
   	
   	  	    	  }
   	}
   
					
 }
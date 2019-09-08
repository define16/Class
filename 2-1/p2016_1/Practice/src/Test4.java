
public class Test4 {
 public static void main(String []args){
	 int cnt = 0, sum = 0;
	 
	 int i = 1;
	 while(i<=100){
		 if(i%5==0){
			 System.out.print(i + " ");
			 cnt++;
			 sum += i;
			 if(i%7==0)
				 System.out.println();
		 }
		 i++;
		 
	 }
	 System.out.println("5의 배수의 갯수 : " + cnt);
	 System.out.println("5의 배수의 합: " + sum);
 }
}

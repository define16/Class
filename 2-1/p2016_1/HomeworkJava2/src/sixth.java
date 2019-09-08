
public class sixth {
	public static void main(String []agrs){
		int a = 0,b = 1, c = 0;
		int sum = 0;
		
		
		for(int i=0 ; i<=20; i++){
			
		
			a=b;
			b=c;
			c=a+b;
			
			sum += c;
			
		
		}
		
		System.out.println("피보나치 수열의 20번째 항의 합계는 " + sum);
		
		
	}
}

   
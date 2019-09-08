
public class Test3 {
	public static void main(String []args){
		int cnt = 0, sum = 0;
		
	for(int i=1;i<=100;i++){
		if(i%5==0){
			System.out.print(i + " ");
			cnt++;
			sum += i;
			if(cnt%7==0)
				System.out.println();
				
			}

		}
	System.out.println("5의 배수의 갯수 : " + cnt);
	System.out.println("5의 배수의 합 : " + sum);
	}

}

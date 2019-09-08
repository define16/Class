
public class Third {
	public static void main(String [] args){
		int[][] arr = new int[6][6]; // 배열 선언
		int result; // 출력값 변수
		for(int i = 0; i<5; i++){ //i행부터 시작 (행하나씩 선언한다)
			if(i==0)
			{	 result = 0;
				for(int j=0;j<=5; j++)// j가 0부터5까지 
				{
					result += 1; // 출력값이 1씩 추가 된다.
					arr[i][j] =  result;
				}
			}
			if(i==1)
		{	result = 4;// 전에 출력값이 5까지 되었기 때문에 4로 초기값 지정한다.
			for(int j=5;j>=0; j--)//j가 5부터 0까지 출력
				
			{
				result += 1;
				arr[i][j] =  result;
			}
		}
			if(i==2)
			{	 result = 10;
				for(int j=0;j<=5; j++)
				{
					result += 1;
					arr[i][j] =  result;
				}
			}
			if(i==3)
			{	result = 14;
				for(int j=5;j>=0; j--)
				{
					result += 1;
					arr[i][j] =  result;
				}
			}
			if(i==4)
			{	 result = 20;
				for(int j=0;j<=5; j++)
				{
					result += 1;
					arr[i][j] =  result;
				}
			}
		}
		
		System.out.println("┌──┬──┬──┬──┬──┐");
	    for(int i=0;i<5;i++){
	       System.out.print("│");
	       for(int j=0;j<5;j++){
	          System.out.format("%-2s│",arr[i][j]);
	       }
	       System.out.println();
	       if(i==4)
	          System.out.println("└──┴──┴──┴──┴──┘");
	       else
	          System.out.println("├──┼──┼──┼──┼──┤");

		
}
		
	
	}
}



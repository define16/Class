
public class Third {
	public static void main(String [] args){
		int[][] arr = new int[6][6]; // �迭 ����
		int result; // ��°� ����
		for(int i = 0; i<5; i++){ //i����� ���� (���ϳ��� �����Ѵ�)
			if(i==0)
			{	 result = 0;
				for(int j=0;j<=5; j++)// j�� 0����5���� 
				{
					result += 1; // ��°��� 1�� �߰� �ȴ�.
					arr[i][j] =  result;
				}
			}
			if(i==1)
		{	result = 4;// ���� ��°��� 5���� �Ǿ��� ������ 4�� �ʱⰪ �����Ѵ�.
			for(int j=5;j>=0; j--)//j�� 5���� 0���� ���
				
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
		
		System.out.println("��������������������������������");
	    for(int i=0;i<5;i++){
	       System.out.print("��");
	       for(int j=0;j<5;j++){
	          System.out.format("%-2s��",arr[i][j]);
	       }
	       System.out.println();
	       if(i==4)
	          System.out.println("��������������������������������");
	       else
	          System.out.println("��������������������������������");

		
}
		
	
	}
}




public class Second {
	public static void main(String [] args){
		int[][] arr = new int[6][6];
		int result = 0;
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j<=i){
				result = result + 1;
				arr[i][j] = result;
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


	


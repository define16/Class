
public class First {
	public static void main(String []args){

		int arr[][]=new int [5][5];
	    
	    int cnt = 0;
	    int result = 1;
	    for(int i=0; i<5; i++)
	    {
	          for(int j=0; j<5; j++)
	          {
	         
	             arr[i][j] = result;
	             result += 1;
	          }
	       }
	    
	     
	    System.out.println("��������������������������������");
	    for(int i=0;i<5;i++){
	       System.out.print("��");
	       for(int j=0;j<5;j++){
	          System.out.format("%-3s��",arr[i][j]);
	       }
	       System.out.println();
	       if(i==4)
	          System.out.println("��������������������������������");
	       else
	          System.out.println("��������������������������������");


	    }
	}
}

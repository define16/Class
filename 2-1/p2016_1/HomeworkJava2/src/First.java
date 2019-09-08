
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
	    
	     
	    System.out.println("忙式式成式式成式式成式式成式式忖");
	    for(int i=0;i<5;i++){
	       System.out.print("弛");
	       for(int j=0;j<5;j++){
	          System.out.format("%-3s弛",arr[i][j]);
	       }
	       System.out.println();
	       if(i==4)
	          System.out.println("戌式式扛式式扛式式扛式式扛式式戎");
	       else
	          System.out.println("戍式式托式式托式式托式式托式式扣");


	    }
	}
}

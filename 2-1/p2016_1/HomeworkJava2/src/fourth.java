
public class fourth {
	public static void main(String []args){

	int arr[][]=new int [5][5];
    
    int cnt = 0;
    int result = 0;
    for(int i=0; i<5; i++)
    {
       if(i<3)
       {
          if(result == 5)
        	  result = 0;
          for(int j=0; j<(i-1)+1; j++)
          {
         
             arr[i][result++] = 0;
          }

          for(int k = 0; k<-2*(i+1)+7; k++)
          {
           
             arr[i][result++] = ++cnt;
          }
       
       }
       result = 0;
       if(i>2)
       {
          if(result == 5)
        	  result = 0;
          for(int l = 0; l<-i+4; l++)
          {
        
             arr[i][result++] = 0;
          }
          for(int m=0; m<2*i-3; m++)
          {
           
             arr[i][result++] = ++cnt;
          }
       
       }
       result = 0;
    }
    System.out.println("忙式式成式式成式式成式式成式式忖");
    for(int i=0;i<5;i++){
       System.out.print("弛");
       for(int j=0;j<5;j++){
          System.out.format("%-2s弛",arr[i][j]);
       }
       System.out.println();
       if(i==4)
          System.out.println("戌式式扛式式扛式式扛式式扛式式戎");
       else
          System.out.println("戍式式托式式托式式托式式托式式扣");


    }
}
}

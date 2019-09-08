package jv07;

import java.util.Scanner;

public class Scn0999 {
   
   private String msg = "";
   public void Calculation(String[] spiResult)
   {
      int sum = 0,avg=0;
      char c = ' ';
      String strValue = spiResult[0];
      int intValue = Integer.parseInt(spiResult[1]);
      int intValue1 = Integer.parseInt(spiResult[2]);
      int intValue2 = Integer.parseInt(spiResult[3]);
      
      
      
      for(int k = 1;k<=spiResult.length;k++)
      {
         sum = intValue + intValue1 + intValue2 ;
         avg = sum/3;
         switch(avg/10)
         {
            case 10:
            case 9:
               c = 'A';
               break;
            case 8:
               c = 'B';
               break;
            case 7:
               c = 'C';
               break;
            case 6:
               c = 'D';
               break;
            default:
                  c = 'F';
               
         }
      }
      this.msg= "[" + strValue + "]" + "님의 점수은 ["  + intValue + "],[" + intValue1 + "],[" + intValue2 + "]이고,"+"\n"+
            "총점["+sum+"]이고" + "평균은[" + avg + "]이고 " + "학점은[" + c + "]입니다.";
   }
   
   
   public String[] getValues()
   {
      Scanner i = new Scanner(System.in);

      System.out.print("문자열을 입력하세요 : ");

      String spi = i.nextLine();
      String[] spiResult = spi.split(" ");
    

      i.close();

      return spiResult;
   }

   public void print()
   {
      System.out.print(this.msg);
   }
   
   public static void main(String[] args)
   {
	   Scn0999 s = new Scn0999();
      s.Calculation(s.getValues());
      s.print();
   }

}

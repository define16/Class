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
      this.msg= "[" + strValue + "]" + "���� ������ ["  + intValue + "],[" + intValue1 + "],[" + intValue2 + "]�̰�,"+"\n"+
            "����["+sum+"]�̰�" + "�����[" + avg + "]�̰� " + "������[" + c + "]�Դϴ�.";
   }
   
   
   public String[] getValues()
   {
      Scanner i = new Scanner(System.in);

      System.out.print("���ڿ��� �Է��ϼ��� : ");

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

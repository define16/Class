package jv01;

public class Test9 {

	public static void main(String[] args) {
	   /*
		C:\>java Test9 1  // 영문 대문자 출력
		C:\>java Test9 2  // 영문 소문자 출력
		*/
	
		int i=1,d;
		char c; 
		
		d = Integer.parseInt(args[0]);
		switch(d)
		{
			case 1:
				c = 65;
				while(i<=26)
				{

					System.out.print(c++ + " ");
					i++;
				}
				break;
				
			case 2:
				c = 97;
				while(i<=26)
				{
					System.out.print(c++ + " ");
					i++;
				}
				break;
		
		}

	}
}


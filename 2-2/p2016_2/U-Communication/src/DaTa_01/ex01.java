package DaTa_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class ex01 {
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Function function = new Function();
		BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("메뉴를 입력하세요 (1.회원가입, 2. 로그인, 3. 정보출력[종료 : x]): ");
				String menu = in.readLine();
				int sel = -1;
				try{
					sel = Integer.parseInt(menu);
				}catch(NumberFormatException e)
				{
					if(menu.equals("x"))
					{
						in.close();
						System.out.println("[종료]");
						System.exit(0);
					}
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				
				switch(sel)
				{
					case 1: 
						function.register(); break;
					case 2: 
						if(function.login())
							System.out.println("로그인 성공"); 
						else 
							System.out.println("로그인 실패"); 
							break;
					case 3: 
						function.printMembers(); break;
					default :
						System.out.println("잘못된 값을 입력하셨습니다.");
				}
			}
		}
		catch (Exception e1) 
		{
		}
	}
}




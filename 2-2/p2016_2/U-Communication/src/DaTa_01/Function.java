package DaTa_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Function {
	private final String DATA_FILE = "data.txt";
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String id2;
	
	private Member inputMember()
	{
		String id = null, passwd = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("ID : ");
			id = in.readLine();
			System.out.print("PASSWD : ");
			passwd = in.readLine();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(id == null || passwd == null || id.isEmpty() || passwd.isEmpty())
			return null;
		
		return new Member(id, passwd);
	}
	
	public void register(){
		System.out.println("====[회원가입] 아이디와 비밀번호를 입력하세요.====");
		Member member = inputMember();
		String line;
		
		if(member == null)
		{
			System.out.println("====회원가입에 실패하였습니다. 입력을 다시해주세요====");
			return;
		}
		
		try {
			out = new PrintWriter(new FileWriter(DATA_FILE,true));
			/** 숙제1*/
			boolean a = true;
			in = new BufferedReader(new FileReader(DATA_FILE)); 
			while((line=in.readLine())!=null)
			{
				String search[] = line.split("/"); 
				if(search[0].equals(member.getId()))
				{
					System.out.println("중복된 아이디 입니다.");
					a = false;
				}
			}	
	
			if(a)
				out.println(member.getId() + "/" + member.getPasswd());
			out.close();

		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		}
	
	public boolean login()
	{
		System.out.println("====[로그인]아이디와 비밀번호를 입력하세요====");
		Member member = inputMember();
		if(member == null)
			return false;
		String line = null;
		
		try {
			in = new BufferedReader(new FileReader(DATA_FILE));
			while((line = in.readLine()) != null)
			{
				String[] split_line = line.split("/");
				String id = split_line[0];
				String passwd = split_line[1];
				
				if(split_line[0].equals(member.getId()) && split_line[1].equals(member.getPasswd()))
				return true;
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return false;
	}
	
	public void printMembers()
	{
		System.out.println("========[회원출력]========");
		/** 숙제3*/
		String line = "";
		int cnt=0;
		try {
			in = new BufferedReader(new FileReader(DATA_FILE));
			while((line=in.readLine())!=null)
			{
				String[] split_line = line.split("/");
				String id2 = split_line[0];
				String pw2 = split_line[1];
				cnt++;
				System.out.println("회원넘버" + cnt + ") ID : " + id2 + "PASSWD : " + pw2);		
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}

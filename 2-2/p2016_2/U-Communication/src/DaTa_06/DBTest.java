package DaTa_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DRIVER = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysqul://localhost:3306/CJH";
		String ID = "root";
		String PASSWD = "0000";
		
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		BufferedReader in = null;
		
		System.out.println("아이디/비번/이름/나이");
		in = new BufferedReader(new InputStreamReader(System.in));
		String fields = in.readLine();
		String values[] = fields.split("/");
		
		String query = String.format("insert into member values('%s','%s','%s','%d'", values[0],values[1],values[2],Integer.parseInt(values[3]));
		Class.forName(DRIVER);
		conn =  DriverManager.getConnection(URL, ID, PASSWD);
		stmt =  conn.createStatement();
		stmt.executeUpdate(query);
		
		while(true)
		{
			System.out.println("1.회원가입 2.아이디중복확인 3.로그인 4.회원삭제 5.정보수정 6.회원목록");
			in = new BufferedReader(new InputStreamReader(System.in));
			String sel = in.readLine();
			switch(Integer.parseInt(sel))
			{
			case 1:{
				System.out.println("아이디/비번 /이름/나이 입력");		// 본인이 생성한 테이블의 필드 값 순서대로 입력
				String input = in.readLine();
				String datas[] = input.split("/");
				stmt.executeUpdate(String.format("insert into member values('%s','%s','%s','%d');", datas[0],datas[1],datas[2],Integer.parseInt(datas[3])));
			}break;
			case 2:{
				System.out.println("아이디 입력");
				System.out.println("DB에서 현재 입력한 아이디와 동일한 아이디를 갖는 데이터가 있는지 확인 한 후 결과 알려주기");
			}break;
			case 3:{
				System.out.println("아이디/비번 입력");
				System.out.println("테이블에 현재 입력한 아이디/비번 모두 일치하는 행이 있다면 로그인 성공 없다면 실패");
			}break;
			case 4:{
				System.out.println("회원삭제 - 아이디 입력");
				System.out.println("테이블에 현재 입력한 아이디값과 같은 값을 갖는 행이 있다면 삭제");
			}break;
			case 5:{
				System.out.println("정보수정 - 아이디/이름 입력");
				System.out.println("테이블에서 현재 입력한 아이디와 같은 값을 갖은 행이 있다면 그 행의 이름 속성 값을 입력한 값으로 변경");
			}break;
			case 6:{
				System.out.println("회원목록");
				System.out.println("현재 테이블에 있는 모든 값을 속성 마다 다 출력하면 됨");
			}break;
			default: System.out.println("없는 목록");break;
			}
		}
		
	}

}

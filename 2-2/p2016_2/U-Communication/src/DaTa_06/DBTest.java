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
		
		System.out.println("���̵�/���/�̸�/����");
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
			System.out.println("1.ȸ������ 2.���̵��ߺ�Ȯ�� 3.�α��� 4.ȸ������ 5.�������� 6.ȸ�����");
			in = new BufferedReader(new InputStreamReader(System.in));
			String sel = in.readLine();
			switch(Integer.parseInt(sel))
			{
			case 1:{
				System.out.println("���̵�/��� /�̸�/���� �Է�");		// ������ ������ ���̺��� �ʵ� �� ������� �Է�
				String input = in.readLine();
				String datas[] = input.split("/");
				stmt.executeUpdate(String.format("insert into member values('%s','%s','%s','%d');", datas[0],datas[1],datas[2],Integer.parseInt(datas[3])));
			}break;
			case 2:{
				System.out.println("���̵� �Է�");
				System.out.println("DB���� ���� �Է��� ���̵�� ������ ���̵� ���� �����Ͱ� �ִ��� Ȯ�� �� �� ��� �˷��ֱ�");
			}break;
			case 3:{
				System.out.println("���̵�/��� �Է�");
				System.out.println("���̺� ���� �Է��� ���̵�/��� ��� ��ġ�ϴ� ���� �ִٸ� �α��� ���� ���ٸ� ����");
			}break;
			case 4:{
				System.out.println("ȸ������ - ���̵� �Է�");
				System.out.println("���̺� ���� �Է��� ���̵𰪰� ���� ���� ���� ���� �ִٸ� ����");
			}break;
			case 5:{
				System.out.println("�������� - ���̵�/�̸� �Է�");
				System.out.println("���̺��� ���� �Է��� ���̵�� ���� ���� ���� ���� �ִٸ� �� ���� �̸� �Ӽ� ���� �Է��� ������ ����");
			}break;
			case 6:{
				System.out.println("ȸ�����");
				System.out.println("���� ���̺� �ִ� ��� ���� �Ӽ� ���� �� ����ϸ� ��");
			}break;
			default: System.out.println("���� ���");break;
			}
		}
		
	}

}

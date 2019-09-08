package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.autoCon;

public class mysql implements autoCon {
	String DBName = "ChunCheonStatisticsTest"; // db이름
	String url = "jdbc:mysql://localhost:3306/" + DBName + "?characterEncoding=UTF-8&serverTimezone=UTC";
	String strUser = ""; // 계정 id
	String strPassword = ""; // 계정 패스워드
	String strMySQLDriver = "com.mysql.cj.jdbc.Driver";
	Connection con = null; // db 연결
	Statement stmt = null; // db 삽입시 이용
	PreparedStatement pstmt = null;

	String tableName = null;
	String[][] attr = null;

	public mysql() {
		try {
			Class.forName(strMySQLDriver); // db드라이버설정

		} catch (Exception e) { // try
			System.out.println(e.getMessage());
		}
	}

	public void setadmin(String strUser, String strPassword) {
		this.strUser = strUser;
		this.strPassword = strPassword;
		System.out.println("Set Mysql Administrator.");
	}

	public void connect() {
		try {
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			System.out.println("Mysql DB Connection.");
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 연결

	}

	public void disconnect() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void insertData(String tableName, String[][] data) {
		String query = "";
//		try {
		for (int c = 1; c < data.length; c++) {
			if (m.isNumeric(data[c][1])) {
				query = "insert into " + tableName + " values(" + "'" + data[c][0] + "', '";
				for (int j = 1; j < data[c].length; j++) {
					if (m.isHyphen(data[c][j])) {
						data[c][j] = "0.0";
					}
					if ((data[c].length - 1) == j)
						query += (Double.parseDouble(data[c][j]) + "')");
					else
						query += (Double.parseDouble(data[c][j]) + "', '");
				}

			} else {
				if (data[c][0].equals(""))
					data[c][0] = data[c - 1][0];
				query = "insert into " + tableName + " values(" + "'" + data[c][0] + "', '" + data[c][1] + "', '";
				for (int j = 2; j < data[c].length; j++) {
					if (m.isHyphen(data[c][j])) {
						data[c][j] = "0.0";
					}
					if ((data[c].length - 1) == j)
						query += (Double.parseDouble(data[c][j]) + "')");
					else
						query += (Double.parseDouble(data[c][j]) + "', '");
				}
			}

			System.out.println(query);
//			int rss = stmt.executeUpdate(query);
		}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	}

	public void insertData_Exception(String tableName, String[][] data) {
		String query = "";
		try {
			try {
				for (int c = 1; c < data.length; c++) {

					query = "insert into " + tableName + " values(" + "'" + data[c][0] + "', '";
					for (int j = 1; j < data[c].length; j++) {
						if (m.isHyphen(data[c][j])) {
							data[c][j] = "0.0";
						}
						if ((data[c].length - 1) == j)
							query += (Double.parseDouble(data[c][j]) + "')");
						else
							query += (Double.parseDouble(data[c][j]) + "', '");
					}
					System.out.println(query);
					int rss = stmt.executeUpdate(query);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NumberFormatException e1) {
			try {
				for (int c = 1; c < data.length; c++) {
					if (data[c][0].equals(""))
						data[c][0] = data[c - 1][0];
					query = "insert into " + tableName + " values(" + "'" + data[c][0] + "', '" + data[c][1] + "', '";
					for (int j = 2; j < data[c].length; j++) {
						if (m.isHyphen(data[c][j])) {
							data[c][j] = "0.0";
						}
						if ((data[c].length - 1) == j)
							query += (Double.parseDouble(data[c][j]) + "')");
						else
							query += (Double.parseDouble(data[c][j]) + "', '");
					}
					System.out.println(query);
					int rss = stmt.executeUpdate(query);
				}
				System.out.println(tableName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void insertData_attr(String tableName, String[][] data) {
		String query = "";
		try {
			for (int c = 0; c < data.length; c++) {
				query = "insert into " + tableName
						+ " (table_ID, korean_table_name, english_table_name, korean_table_attr, english_table_attr) values("
						+ "'" + Integer.parseInt(data[c][0]) + "', '";
				for (int j = 1; j < data[c].length; j++) {
					if ((data[c].length - 1) == j)
						query += (data[c][j] + "')");
					else
						query += (data[c][j] + "', '");
				}

				System.out.println(query);
				int rss = stmt.executeUpdate(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTable(String tableName) {
		try {
			String query = "CREATE TABLE " + tableName + " ( " + "Category	int(2)			NULL, "
					+ "Year 			int(2)			NULL, " + "Quarter		int(20)			NULL, "
					+ "Keyword    	varchar(1000)			CHARACTER SET utf8 COLLATE utf8_general_ci 	NULL, "
					+ "Count		int(20)			NULL " + " );";

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 테이블 중복
	public boolean isTable(String tableName) {
		boolean result;
		try {
			String query = "SELECT EXISTS ( SELECT 1 FROM Information_schema.tables WHERE table_schema = '" + DBName
					+ "' AND table_name = '" + tableName + "') AS flag";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				if (rs.getInt("flag") == 1)
					result = true;
				else
					result = false;
			} else {

				System.err.println("error");
				result = false;
				return result;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public void selectAttr(String name) {
		String[] attrTemp;
		String[][] attr;
		String query, rowCntQuery;
		ResultSet rs;
		int cnt = 0;
		
		try {
			rowCntQuery = "SELECT count(korean_table_name) AS cnt FROM Attribute_GB WHERE korean_table_name='"
					+ name + "'";
			query = "SELECT korean_table_name, english_table_name, korean_table_attr, english_table_attr FROM Attribute_GB WHERE korean_table_name='"
					+ name + "' ORDER BY korean_table_attr";
			attrTemp = new String[4];		
			
			rs = stmt.executeQuery(rowCntQuery);
//			System.out.println("select : " + query);

			while (rs.next()) {
				cnt = rs.getInt("cnt");
//				System.out.println(cnt);
			}
	
			attr = new String[cnt][];
			
			rs = stmt.executeQuery(query);

			// 객체의 값이 있으면 TRUE
			int a = 0;
			while (rs.next()) {
				attrTemp[0] = rs.getString("korean_table_name");
				attrTemp[1] = rs.getString("english_table_name");
				attrTemp[2] = rs.getString("korean_table_attr");
				attrTemp[3] = rs.getString("english_table_attr");

				System.out.println(
						"rs : " + attrTemp[0] + "   " + attrTemp[1] + "  "
								+ attrTemp[2] + "  " + attrTemp[3]);
				
				System.out.println(a);
				for(int j=0;j<4;j++) {
					attr[a][j] = attrTemp[j];
				}
				a++;
			}
			System.out.println(attr[0].length);
			for(int i=0;i<attr.length;i++) {
				for(int j=0;j<attr[i].length;j++) {
				System.out.println("i : "+ i + " j : " + j + " attr[][] : " + attr[i][j]);
				}
			}
			
			setAttribute(attr);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void updatedata() {
		try {
			String query = "";
			pstmt = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 데이터 삭제
	public void DeleteDuplication(String tablename, String y, String q, String c, String k, String cnt) {
		String query = "DELETE From " + tablename + " WHERE Category='" + (int) Double.parseDouble(c) + "' and Year='"
				+ (int) Double.parseDouble(q) + "' and Quarter='" + (int) Double.parseDouble(y);

		System.out.println(query);

		try {
			int rss = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[][] getAttribute() {
		return attr;
	}

	public void setAttribute(String[][] attr) {
		this.attr = attr;
	}

	public Statement getStatement() {
		return stmt;
	}

	public PreparedStatement getPreparedStatement() {
		return pstmt;
	}

}

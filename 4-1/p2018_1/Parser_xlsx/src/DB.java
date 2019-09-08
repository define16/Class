import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	// String DBName = "FTP"; // db이름
	String DBName = "FTP_TEST"; // 테스트용 db이름
	String url = "jdbc:mysql://210.115.229.252:3306/" + DBName + "?autoReconnect=true&useSSL=false";// user테이블을 수정하면
	String strUser = "root"; // 계정 id
	String strPassword = "tmdwid123"; // 계정 패스워드
	String strMySQLDriver = "com.mysql.jdbc.Driver"; // 드라이버 이름 따로 만들어줌
	Connection con = null; // db 연결
	Statement stmt = null; // db 삽입시 이용
	Statement stmt2 = null; // db 삽입시 이용
	PreparedStatement pstmt = null;

	public DB() {
		try {
			Class.forName(strMySQLDriver); // db드라이버설정
		} catch (Exception e) { // try
			System.out.println(e.getMessage());
		}
	}

	public void connect() {
		try {
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			System.out.println("Mysql DB Connection.");
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			System.out.println("연결완료!");
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
		
		if (stmt2 != null) {
			try {
				stmt2.close();
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

		System.out.println("연결해제!");
	}

	// 테이블끼리 참조시키기
	// ALTER TABLE Main
	// ADD CONSTRAINT CustomerID
	// FOREIGN KEY (Fkey)
	// REFERENCES "Keyword" (Keyword);

	public void updatedata(String query) {
		try {
			pstmt = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AlterTable(String tableName, String f) {
		// try {
		// String sql = "ALTER TABLE "+tableName + " ADD CONSTRAINT fk_id " + "FOREIGN
		// KEY (" + f + ") REFERENCES '" + Keyword +"' ("+Keyword+")";
		// stmt.executeUpdate(sql);
		//
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void insertData(String tableName, Data d) {
		try {
			for (int i = 0; i < d.getKeywordset().size(); i += 5) {
				for (int j = 0; j < d.getKeywordset().get(i).length; j++) {
					String sql = "insert into " + tableName + " values(" + "'"
							+ Integer.parseInt(d.getKeywordset().get(i + 2)[j]) + "', '"
							+ Integer.parseInt(d.getKeywordset().get(i)[j]) + "', '"
							+ Integer.parseInt(d.getKeywordset().get(i + 1)[j]) + "', '"
							+ d.getKeywordset().get(i + 3)[j] + "', '"
							+ Integer.parseInt(d.getKeywordset().get(i + 4)[j]) + "')";
					// Category(int) Quarter(int) Year(int) Keyword(String) Count(int)
					// System.out.println(sql);

					int rss = stmt.executeUpdate(sql);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertGameData(ArrayList<String[]> d) {
		try {
			for (int i = 0; i < d.size(); i += 7) {
				for (int j = 0; j < d.get(i).length; j++) {
									
					String sql = "insert into TempGameData values(" + "'"
							+ d.get(i)[j] + "', '"
							+ (int)Double.parseDouble(d.get(i + 1)[j]) + "', '"
							+ (int)Double.parseDouble(d.get(i + 2)[j]) + "', '"
							+ Double.parseDouble(String.format("%.1f", Double.parseDouble(d.get(i + 3)[j]))) + "', '"
							+ d.get(i + 4)[j] + "', '"
							+ d.get(i + 5)[j] + "', '"
							+ d.get(i + 6)[j] + "')";
					// Category(int) Quarter(int) Year(int) Keyword(String) Count(int)
					//System.out.println(sql);

					
					int rss = stmt.executeUpdate(sql);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void createTable(String tableName) throws SQLException {
		String CREATEsql = "CREATE TABLE " + tableName + " ( " + "Category	int(2)			NULL, "
				+ "Year 			int(2)			NULL, " + "Quarter		int(20)			NULL, "
				+ "Keyword    	varchar(1000)			CHARACTER SET utf8 COLLATE utf8_general_ci 	NULL, "
				+ "Count		int(20)			NULL " + " );";

		stmt.executeUpdate(CREATEsql);
	}

	// 테이블 중복
	public boolean isTable(String tablename) {
		boolean result = false;

		return result;
	}

	// 데이터 중복
	public void DeleteDuplication(String tablename, String y, String q, String c, String k, String cnt) {
		String sql = "DELETE From " + tablename + " WHERE Category='" + (int) Double.parseDouble(c) + "' and Year='"
				+ (int) Double.parseDouble(q) + "' and Quarter='" + (int) Double.parseDouble(y);

		System.out.println(sql);

		try {
			int rss = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public ArrayList<String[]> TestselectData(String query) {
		ResultSet rs;
		ArrayList<String[]> data = new ArrayList<String[]>();
		ArrayList<String> category = new ArrayList<String>();
		ArrayList<String> year = new ArrayList<String>();
		ArrayList<String> quarter = new ArrayList<String>();
		ArrayList<String> keyword = new ArrayList<String>();
		ArrayList<String> count = new ArrayList<String>();

		String[] category_temp = null;
		String[] year_temp = null;
		String[] quarter_temp = null;
		String[] keyword_temp = null;
		String[] count_temp = null;

		try {
			rs = stmt.executeQuery(query);

			if (!rs.next()) {
				System.out.println("해당하는 정보가 없습니다");
			}

			// 객체의 값이 있으면 TRUE
			while (rs.next()) {
				category.add(String.valueOf(rs.getInt("Category")));
				year.add(String.valueOf(rs.getInt("Year")));
				quarter.add(String.valueOf(rs.getInt("Quarter")));
				keyword.add(rs.getString("Keyword"));
				count.add(String.valueOf(rs.getInt("Count")));
			}

			year_temp = new String[year.size()];
			quarter_temp = new String[quarter.size()];
			category_temp = new String[category.size()];
			keyword_temp = new String[keyword.size()];
			count_temp = new String[count.size()];

			for (int i = 0; i < category.size(); i++) {
				category_temp[i] = category.get(i);
				year_temp[i] = year.get(i);
				quarter_temp[i] = quarter.get(i);
				keyword_temp[i] = keyword.get(i);
				count_temp[i] = count.get(i);
			}

			data.add(category_temp);
			data.add(year_temp);
			data.add(quarter_temp);
			data.add(keyword_temp);
			data.add(count_temp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<String[]> TestKeywordSelectData(DB db, String y[], String q[]) {
		
		db.connect();
		
		ResultSet rs;
		ResultSet rs2;
		ArrayList<String[]> data = new ArrayList<String[]>();
		ArrayList<String> category = new ArrayList<String>();
		ArrayList<String> year = new ArrayList<String>();
		ArrayList<String> quarter = new ArrayList<String>();
		ArrayList<String> keyword = new ArrayList<String>();
		ArrayList<String> count = new ArrayList<String>();

		String[] category_temp = null;
		String[] year_temp = null;
		String[] quarter_temp = null;
		String[] keyword_temp = null;
		String[] count_temp = null;

		try {
			for (int a = 0; a < y.length; a++) {
				String query = "Select  * From Main Where Year= " + y[a] + " and Quarter="+ q[a] ;
				rs = stmt.executeQuery(query);

				if (!rs.next()) {
					System.out.println("해당하는 정보가 없습니다");
				}

				// 객체의 값이 있으면 TRUE
				while (rs.next()) {
					category.add(String.valueOf(rs.getInt("Category")));
					year.add(String.valueOf(rs.getInt("Year")));
					quarter.add(String.valueOf(rs.getInt("Quarter")));
					keyword.add(rs.getString("Keyword"));
					count.add(String.valueOf(rs.getInt("Count")));
					
					System.out.println("첫 rs "+rs.getInt("Category") + "   "+ rs.getInt("Year") + "  " + rs.getInt("Quarter") + "  " + rs.getString("Keyword") + "  " + rs.getInt("Count"));
				}

				System.out.println("1");
				category_temp = new String[category.size()];
				year_temp = new String[year.size()];
				quarter_temp = new String[quarter.size()];
				keyword_temp = new String[keyword.size()];
				count_temp = new String[count.size()];

				for (int i = 0; i < year.size(); i++) {
					category_temp[i] = category.get(i);
					year_temp[i] = year.get(i);
					quarter_temp[i] = quarter.get(i);
					keyword_temp[i] = keyword.get(i);
					count_temp[i] = count.get(i);
				}

				data.add(keyword_temp);
				data.add(count_temp);

				data = new ArrayList<String[]>();
				category = new ArrayList<String>();
				year = new ArrayList<String>();
				quarter = new ArrayList<String>();
				keyword = new ArrayList<String>();
				count = new ArrayList<String>();
				System.out.println("2");

				
				for (int i = 0; i < keyword_temp.length; i++) {

					
					query = "Select Keyword, Count From " + keyword_temp[i] + " Where Year=" +  Integer.parseInt(quarter_temp[i]) 
							+  " and Quarter=" + Integer.parseInt(year_temp[i]) + " and Category=" + Integer.parseInt(category_temp[i]) +" Order by Count DESC LIMIT 5" ;
					
					System.out.println(query);
					rs2 = stmt2.executeQuery(query);

					System.out.println();
					while (rs2.next()) {
						year.add(String.valueOf(rs2.getInt("Quarter")));
						quarter.add(String.valueOf(rs2.getInt("Year")));
						keyword.add(rs2.getString("Keyword"));
						count.add(String.valueOf(rs2.getInt("Count")));

						System.out.println("두번째 rs"+ rs2.getInt("Quarter") + "  " + rs2.getInt("Year") + "  " + rs2.getString("Keyword") + "  " + rs2.getInt("Count"));
						
						
						keyword_temp = new String[keyword.size()];
						count_temp = new String[count.size()];

						for (int j = 0; j < year.size(); i++) {
							keyword_temp[i] = keyword.get(i);
							count_temp[i] = count.get(i);
						}
						data.add(keyword_temp);
						data.add(count_temp);
					}

				}
			}
			db.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}

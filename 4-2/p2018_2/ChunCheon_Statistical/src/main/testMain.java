package main;

import org.apache.poi.util.SystemOutLogger;

import DB.mysql;

/**
 * @author H
 * 테이블명 뽑아낼때 숫자만 있는부분을 삭제하게 변경하기
 * 이유 : 산업중분류_및_연도별_주요지표_10인이상, 산업중분류_및_연도별_주요지표_5인이상 때문
 */

public class testMain implements autoCon {
//	private mysql db;
//	private xlsxParser parsing;
	private static mysql db; 

	private String strUser = "root";
	private String strPassword = "1234";

	public testMain() {
		db = new mysql();
		db.setadmin(strUser, strPassword);
	}
	// 합계까지 가지고 와야하는 것 - 강수량

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		String[][] data = null;
		String[][] attr = null;

		String[] files;

//		String path = "C:\\Users\\H\\Documents\\문서1\\춘천시통계\\춘천시 통계자료";
//		String path = "C:\\Users\\H\\Documents\\문서1\\춘천시통계";
		String path = "C:\\Users\\H\\Documents\\문서1\\춘천시통계\\테스트1";
		testMain t = new testMain();
		
		db.connect(); // 데이터베이스 연결

		w.setFolderPath(path); // 초기 주소값 설정
		files = w.readFolder();

			for (int c = 0; c < files.length; c++) {
				if(files[c].equals("desktop.ini")) continue;
				xparsing.xlsx(path + "\\" + files[c] ); // 파일로 접근
				String year = xparsing.getYear();
				csql.createTableName(year, files[c]);
//				System.out.println(csql.getTableName() + "_" + year);
				
				db.selectAttr(csql.getTableName());
				attr = db.getAttribute();
				System.out.println(attr[0][1]);
				System.out.println("-------------------------");
				csql.setTableName(attr[0][1] + "_" + year);
				

				data = xparsing.getData();
//				csql.getAttribute(data[0],attr, false);
				

//				System.out.println("테이블의 존재 여부 : " + db.isTable(csql.getTableName()));
				if(!db.isTable(csql.getTableName())) {	//테이블이 존재하는지 파악
					/*
					 * 
					 *  속성명 만들어주는 곳
					 *  
					 */		
//					db.createTable(csql.getTableName()); //테이블 생성
				}
				
//				db.insertData(csql.getTableName(), data);
			}
		System.out.println("The End");
	}

}

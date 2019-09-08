package main;

import DB.mysql;

public class testAtt implements autoCon{
	private static mysql db; 

	private String strUser = "root";
	private String strPassword = "1234";
	
	public testAtt() {
		db = new mysql();
		db.setadmin(strUser, strPassword);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] data = null;
		String path = "C:\\Users\\H\\Documents\\문서1\\춘천시통계\\text_index.xlsx";
		testAtt ta = new testAtt();
		
		xparsing.xlsxAttridute(path);
		
		data = xparsing.getData();
		
//		for(int c=0;c<data.length;c++) {
//			for(int j=0; j<data[c].length;j++)
//				System.out.println(data[c][j]);
//		}
		db.connect();
		db.insertData_attr("Attribute_GB", data);
	}

}

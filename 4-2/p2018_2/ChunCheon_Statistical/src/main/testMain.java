package main;

import org.apache.poi.util.SystemOutLogger;

import DB.mysql;

/**
 * @author H
 * ���̺�� �̾Ƴ��� ���ڸ� �ִºκ��� �����ϰ� �����ϱ�
 * ���� : ����ߺз�_��_������_�ֿ���ǥ_10���̻�, ����ߺз�_��_������_�ֿ���ǥ_5���̻� ����
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
	// �հ���� ������ �;��ϴ� �� - ������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		String[][] data = null;
		String[][] attr = null;

		String[] files;

//		String path = "C:\\Users\\H\\Documents\\����1\\��õ�����\\��õ�� ����ڷ�";
//		String path = "C:\\Users\\H\\Documents\\����1\\��õ�����";
		String path = "C:\\Users\\H\\Documents\\����1\\��õ�����\\�׽�Ʈ1";
		testMain t = new testMain();
		
		db.connect(); // �����ͺ��̽� ����

		w.setFolderPath(path); // �ʱ� �ּҰ� ����
		files = w.readFolder();

			for (int c = 0; c < files.length; c++) {
				if(files[c].equals("desktop.ini")) continue;
				xparsing.xlsx(path + "\\" + files[c] ); // ���Ϸ� ����
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
				

//				System.out.println("���̺��� ���� ���� : " + db.isTable(csql.getTableName()));
				if(!db.isTable(csql.getTableName())) {	//���̺��� �����ϴ��� �ľ�
					/*
					 * 
					 *  �Ӽ��� ������ִ� ��
					 *  
					 */		
//					db.createTable(csql.getTableName()); //���̺� ����
				}
				
//				db.insertData(csql.getTableName(), data);
			}
		System.out.println("The End");
	}

}

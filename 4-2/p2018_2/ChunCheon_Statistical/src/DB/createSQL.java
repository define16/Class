package DB;

import java.util.Arrays;

import Parser.windowParser;
import main.autoCon;

public class createSQL implements autoCon {
	windowParser wp;
	private String tableName;

	public createSQL() {
		wp = new windowParser();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void createTableName(String folderName, String fileName) {

		String tableNameTemp[] = fileName.split("_");
		tableName = "";
		for (int a = 0; a < tableNameTemp.length; a++) {
			if (m.isEnglishs(tableNameTemp[a]) || (m.isStringDouble(tableNameTemp[a]) && !tableNameTemp[a].contains("119")) )
				continue;
			else
				tableName += tableNameTemp[a];
		}
	}

	// �Ӽ��� ������ ����
	public void getAttribute(String[] data, String[][] attr, boolean isSave) {
		int index = 1;
		String[] tableAttr = new String[data.length + 1];
		Arrays.sort(data);
		for (int c = 0; c < data.length; c++) {
			System.out.println(data[c] + " | " + attr[c][2]);
		}
		System.out.println("  "+ attr.length +"  " + data.length);
		for (int c = 0; c < data.length; c++) {
			tableAttr[0] = csql.getTableName();
			if(attr[c][2].equals(data[c])) {
				tableAttr[index] = attr[c][3];
				index++;
				System.out.println(data[c] + "\t" + tableAttr[index]);
			}
		}
		// txt���Ͽ� ����
		if(isSave) {
			tf.setPath("C:\\Users\\H\\Documents\\����1\\");
			tf.setFileName("��õ�����_�Ӽ�����.txt");
			tf.txtWrite(tableAttr);
		}
		
		
		
	}
	
	public void makeAttribute() {
		
	}
}

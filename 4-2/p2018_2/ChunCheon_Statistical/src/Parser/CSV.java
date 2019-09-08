package Parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class CSV {
	public void createCSV(String filepath, String filename) {


		ArrayList<String[]> data = new ArrayList<String[]>();
		
		//C:\Users\User\Desktop\
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(filepath + "\\" + filename + ".csv", true));

			for (int i = 0; i < data.size(); i += 2) {
				for (int j = 0; j < data.get(i).length; j++) {
					fw.write(data.get(i)[j] + "," + data.get(i + 1)[j]);
					fw.newLine();
				}
			}

			fw.flush();
			// ��ü �ݱ�
			fw.close();

		} catch (Exception e) {

			// TODO: handle exception

			e.printStackTrace();

		}

	}
	
		public static void main(String[] args) {
			CSV csv = new CSV();
			String filePath = "C:\\Users\\H\\Documents\\����1\\��õ�����\\�Ӽ������";
			String fileName = "��õ�����_�Ӽ�����(Ȯ��).txt";
			

			csv.createCSV(filePath,fileName);

		}

}

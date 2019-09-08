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
			// 객체 닫기
			fw.close();

		} catch (Exception e) {

			// TODO: handle exception

			e.printStackTrace();

		}

	}
	
		public static void main(String[] args) {
			CSV csv = new CSV();
			String filePath = "C:\\Users\\H\\Documents\\문서1\\춘천시통계\\속성만들기";
			String fileName = "춘천시통계_속성값들(확정).txt";
			

			csv.createCSV(filePath,fileName);

		}

}

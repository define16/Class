import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class CSV {
	public void createCSV(String filepath, String filename, String[] year, String[] quarter) {
		DB db = new DB();


		ArrayList<String[]> data = db.TestKeywordSelectData(db, year, quarter);
		
		for(int i=0; i< data.size(); i+=2)
			for(int j =0; j<data.get(i).length;j++)
				System.out.println(data.get(i)[j] + "  " +data.get(i+1)[j]);

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
			db.disconnect();
		} catch (Exception e) {

			// TODO: handle exception

			e.printStackTrace();

		}

	}
	
		public static void main(String[] args) {
			CSV csv = new CSV();
			String []year = {"2016", "2014"};
			String []qut = {"1","4"};
			csv.createCSV("C:\\Users\\User\\Desktop", "test", year, qut);

		}

}

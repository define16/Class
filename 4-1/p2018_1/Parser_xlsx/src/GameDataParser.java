import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GameDataParser {

	public ArrayList<String[]> xlsx_kind_data() {

		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		ArrayList<String[]> data = new ArrayList<String[]>();
		String name[] = null;
		String kind1[] = null;
		String kind2[] = null;
		String kind3[] = null;

		String[] CheckKeyword = null;
		int CheckKeywordIndex = 0;

		int xlsxRows = 0;

		try {
			xlsxFile = new FileInputStream(new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\기타\\통합 문서1.xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow;

			name = new String[xlsxRows - 1];
			kind1 = new String[xlsxRows - 1];
			kind2 = new String[xlsxRows - 1];
			kind3 = new String[xlsxRows - 1];

			System.out.println("엑셀 읽기 시작");
			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				xlsxRow = sheet.getRow(rownum); // 셀정보

				name[rownum - 1] = xlsxRow.getCell(0).toString();
				kind1[rownum - 1] = xlsxRow.getCell(1).toString();
				kind2[rownum - 1] = xlsxRow.getCell(2).toString();
				kind3[rownum - 1] = xlsxRow.getCell(3).toString();

				System.out.println(kind1[rownum - 1] + " " + kind2[rownum - 1] + " " + kind3[rownum - 1]);

				// System.out.println(name);
			}

			data.add(name);
			data.add(kind1);
			data.add(kind2);
			data.add(kind3);

			xlsxFile.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("끝");
		return data;
	}

	public void xlsx_data(ArrayList<String[]> d) {
		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		SaveXlsx save = new SaveXlsx();
		ArrayList<String[]> data = new ArrayList<String[]>();
		String name_temp = null;
		String name[] = null;
		String year[] = null;
		String quarter[] = null;
		String users[] = null;
		String kind1[] = null;
		String kind2[] = null;
		String kind3[] = null;

		int xlsxRows = 0;
		int index = 0;
		// System.out.print("main");
		// for (int a = 0; a < d.size(); a += 4) {
		// for (int b = 0; b < d.get(a).length; b++) {
		// System.out.print(d.get(a)[b] + " ");
		// System.out.print(d.get(a + 1)[b] + " ");
		// System.out.print(d.get(a + 2)[b] + " ");
		// System.out.println(d.get(a + 3)[b] + " ");
		//
		// }
		// }

		try {
			xlsxFile = new FileInputStream(new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\기타\\통합 문서2.xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow;

			System.out.println("엑셀 읽기 시작");

			name = new String[xlsxRows];
			year = new String[xlsxRows];
			quarter = new String[xlsxRows];
			users = new String[xlsxRows];
			kind1 = new String[xlsxRows];
			kind2 = new String[xlsxRows];
			kind3 = new String[xlsxRows];

			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				xlsxRow = sheet.getRow(rownum); // 셀정보
				name_temp = xlsxRow.getCell(0).toString().trim();
				for (int b = 0; b < d.get(0).length; b++) {
					// System.out.println("2 : " + d.get(0)[b]);
					// System.out.println(name_temp.equals(d.get(0)[b].trim()));
					if (name_temp.equals(d.get(0)[b].trim())) {
						name[index] = name_temp;
						String year_tmep[] = xlsxRow.getCell(2).toString().split(" ");
						year[index] = year_tmep[1];
						quarter[index] = xlsxRow.getCell(1).toString();
						users[index] = xlsxRow.getCell(3).toString();
						kind1[index] = d.get(1)[b];
						kind2[index] = d.get(2)[b];
						kind3[index] = d.get(3)[b];
						// System.out.println(kind1[index] + " " + kind2[index] + " " + kind3[index]);
						index++;
					}
					// System.out.println(nAame);
				}
			}

			data.add(name);
			data.add(year);
			data.add(quarter);
			data.add(users);
			data.add(kind1);
			data.add(kind2);
			data.add(kind3);

			save.xlsxWiter(data);
			xlsxFile.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void fianl_xlsx_data() {
		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		SaveXlsx save = new SaveXlsx();
		Mining m = new Mining();
		ArrayList<String[]> data = new ArrayList<String[]>();

		String name[] = null;
		String year[] = null;
		String quarter[] = null;
		String users[] = null;
		String kind1[] = null;
		String kind2[] = null;
		String kind3[] = null;

		String name_s[] = null;
		String year_s[] = null;
		int quarter_i[] = null;
		double users_d[] = null;
		String users_s[] = null;
		String kind1_s[] = null;
		String kind2_s[] = null;
		String kind3_s[] = null;

		int xlsxRows = 0;
		int index = 0;

		try {
			xlsxFile = new FileInputStream(new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\기타\\통합 문서3.xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow;

			System.out.println("엑셀 읽기 시작");

			name_s = new String[xlsxRows];
			year_s = new String[xlsxRows];
			quarter_i = new int[xlsxRows];
			users_d = new double[xlsxRows];
			kind1_s = new String[xlsxRows];
			kind2_s = new String[xlsxRows];
			kind3_s = new String[xlsxRows];

			name = new String[xlsxRows];
			year = new String[xlsxRows];
			quarter = new String[xlsxRows];
			users = new String[xlsxRows];
			kind1 = new String[xlsxRows];
			kind2 = new String[xlsxRows];
			kind3 = new String[xlsxRows];

			String asd = null;
			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				xlsxRow = sheet.getRow(rownum); // 셀정보
				name_s[rownum - 1] = xlsxRow.getCell(0).toString();
				year_s[rownum - 1] = xlsxRow.getCell(1).toString();
				quarter_i[rownum - 1] = (int) Double.parseDouble(xlsxRow.getCell(2).toString());
				asd = xlsxRow.getCell(3).toString().replace(",", "");
				users_d[rownum - 1] = Double.parseDouble(asd);
				kind1_s[rownum - 1] = xlsxRow.getCell(4).toString();
				kind2_s[rownum - 1] = xlsxRow.getCell(5).toString();
				kind3_s[rownum - 1] = xlsxRow.getCell(6).toString();

				// System.out.println(nAame);
			}
			int ab = 0;
			System.out.println(name_s.length);
			for (int a = 0; a < name_s.length - 1; a++) {
				for (int b = a + 1; b < name_s.length; b++) {
					//System.out.println(name_s[a] + "  " + name_s[b] + "  " + name_s[a].equals(name_s[b]));

					//System.out.println(name_s[a].equals(name_s[b]) && quarter_i[a] == quarter_i[b] && year_s[a].equals(year_s[b]));
					if (name_s[a].equals(name_s[b]) && quarter_i[a] == quarter_i[b] && year_s[a].equals(year_s[b])) {
						users_d[a] += users_d[b];
						users_d[b] = 0.0;
						ab++;
						System.out.println(a + "   " + b);
					}
				}
			}
			for (int a = 0; a < name_s.length ; a++) {
			System.out.println(name_s[a] + "  " + year_s[a] + "  "+quarter_i[a]+ "  "+ users_d[a] +"  "+kind1_s[a]+"  "+ kind2_s[a] + "  " +kind3_s[a]);
			}
			System.out.println(ab);
			System.out.println(name_s.length);
			for (int a = 0; a < name_s.length; a++) {
				if (users_d[a] != 0.0) {
					name[index] = name_s[a];
					year[index] = year_s[a];
					quarter[index] = String.valueOf(quarter_i[a]);
					users[index] = String.valueOf(users_d[a]);
					kind1[index] = kind1_s[a];
					kind2[index] = kind2_s[a];
					kind3[index] = kind3_s[a];
					System.out.println(name[index] + "  " + year[index] + "  "+quarter[index]+ "  "+ users[index] +"  "+kind1[index]+"  "+ kind2[index] + "  " +kind3[index]);
					index++;
					
				}
			}
			System.out.println(index);
			System.out.println("================================================================");
			data.add(name);
			data.add(year);
			data.add(quarter);
			data.add(users);
			data.add(kind1);
			data.add(kind2);
			data.add(kind3);

			save.xlsxWiter(data);
			xlsxFile.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void fianl_data_save_DB() {
		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		DB db = new DB();
		Mining m = new Mining();
		ArrayList<String[]> data = new ArrayList<String[]>();

		String name[] = null;
		String year[] = null;
		String quarter[] = null;
		String users[] = null;
		String kind1[] = null;
		String kind2[] = null;
		String kind3[] = null;

		int xlsxRows = 0;
		int index = 0;

		try {
			xlsxFile = new FileInputStream(new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\정재된 자료\\게임계량데이터.xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow;

			System.out.println("엑셀 읽기 시작");
			db.connect();
			name = new String[xlsxRows];
			year = new String[xlsxRows];
			quarter = new String[xlsxRows];
			users = new String[xlsxRows];
			kind1 = new String[xlsxRows];
			kind2 = new String[xlsxRows];
			kind3 = new String[xlsxRows];

			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				xlsxRow = sheet.getRow(rownum); // 셀정보
				name[rownum - 1] = xlsxRow.getCell(0).toString();
				year[rownum - 1] = xlsxRow.getCell(1).toString();
				quarter[rownum - 1] = xlsxRow.getCell(2).toString();
				users[rownum - 1] = xlsxRow.getCell(3).toString();
				kind1[rownum - 1] = xlsxRow.getCell(4).toString();
				kind2[rownum - 1] = xlsxRow.getCell(5).toString();
				kind3[rownum - 1] = xlsxRow.getCell(6).toString();

			}

			data.add(name);
			data.add(year);
			data.add(quarter);
			data.add(users);
			data.add(kind1);
			data.add(kind2);
			data.add(kind3);

			db.insertGameData(data);
			
			xlsxFile.close();
			db.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

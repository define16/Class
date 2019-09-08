import java.util.ArrayList;

import test.linkedList;

public class main {
	public static void main(String[] args) {
		// sava_data();
		 //save_test_data();
		//correlation_test_data();
		game_main();
	}

	public static void sava_data() {
		Parser p = new Parser();
		Data d = new Data();
		Mining m = new Mining();
		// DB db = new DB();
		SaveXlsx save = new SaveXlsx();

		String[] kind = { "정치", "경제", "IT과학", "문화", "사회" };
		String[] year = { "2013", "2014", "2015", "2016", "2017", "2018" };
		String fileName = "";
		// String fileName = "IT과학_2014";

		// db.connect();

		System.out.println("시작");
		// for (int i = 3; i < kind.length; i++) {
		for (int j = 0; j < year.length; j++) {
			for (int k = 1; k < 5; k++) {
				fileName = kind[4] + "_" + year[j] + "_" + k + "분기";
				System.out.println(fileName + "시작");
				p.xlsx(d, m, fileName);

				// d.setKeywordset(m.repeated(d.getKeywordset())); // return으로 받기
				d.setKeywordset(m.repeated_NoQuarter(d.getKeywordset())); // 사회분야만

				// for (int i = 0; i < d.getKeywordset().size(); i+=5) {
				// for (int j = 0; j < d.getKeywordset().get(i).length; j++) {
				// System.out.print("연도 : " + d.getKeywordset().get(i)[j]);
				// System.out.print("\t분기 : " + d.getKeywordset().get(i + 1)[j]);
				// System.out.print("\t종류 : " + d.getKeywordset().get(i + 2)[j]);
				// System.out.print("\t키워드 : " + d.getKeywordset().get(i + 3)[j]);
				// System.out.println("\t빈도수 : " + d.getKeywordset().get(i + 4)[j]);
				// }
				// }

				save.xlsxWiter(fileName, d.getKeywordset());
				d = new Data();
				System.out.println(fileName + "완료 ");
			}
		}

		// 데이터베이스 저장하는 부분
		// db.insertData("Main", d, m);
		// db.TestselectData("select * from test1");
		System.out.println("끄읏");
	}

	public static void save_test_data() {
		Parser p = new Parser();
		DB db = new DB();
		String fileName = "중복제거";

		System.out.println(fileName + "시작");
		p.xlsx_data(db, fileName);
	}

	public static void correlation_test_data() {
		Parser p = new Parser();
		Mining m = new Mining();
		DB db = new DB();

		String[] kind = { "정치", "경제", "IT과학", "문화", "사회" };
		String[] year = { "2013", "2014", "2015", "2016", "2017", "2018" };
		String fileName = "";

		db.connect();
		int stopoint =0;
		System.out.println("시작");
		for (int i = 0; i < kind.length; i++) {
			if (i==0) {
				stopoint = 4;
			}else {
				stopoint = 3;
			}
			for (int j =stopoint ; j < year.length; j++) {
				if (i == 4) {
					for (int k = 1; k < 5; k++) {
						fileName = kind[i] + "_" + year[j] + "_" + k + "분기";
						System.out.println(fileName + "시작");
						p.xlsx_correlation(m,db, fileName);
					}
				} else {
					fileName = kind[i] + "_" + year[j];
					System.out.println(fileName + "시작");
					p.xlsx_correlation(m,db, fileName);
				}
				System.out.println(fileName + "완료 ");
			}
		}

		// 데이터베이스 저장하는 부분
		db.disconnect();
		System.out.println("끄읏");
	}

	public static void game_main() {
		GameDataParser g = new GameDataParser();
		
//		ArrayList<String[]> data = g.xlsx_kind_data();
//		g.xlsx_data(data);
		
		
		
		//g.fianl_data_save_DB();
		System.out.println("끄읏");
		
	}
}

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author JunHyeong Cho
 *
 *         목표 : 어레이리스트에 날짜, 키워드, 키워드 갯수 저장 1. 분기마다 키워드를 합치고, 같은 키워드는 갯수세기 2. 같은
 *         키워드 삭제 3. 데이터베이스 연동(새로운 클래스 만들기)
 */

public class Parser {

	public void xlsx(Data d, Mining m, String fileName) {
		// xlsx

		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		String[] date = null;
		String[] year = null;
		String[] quarter = null;
		String[] category = null;
		String[] keyword = null;
		String[] count = null;

		int xlsxRows = 0;

		try {
			xlsxFile = new FileInputStream(
					new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\기사(5년)\\" + fileName + ".xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로

			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);

			xlsxRows = sheet.getPhysicalNumberOfRows();
			date = new String[xlsxRows];

			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				XSSFRow xlsxRow = sheet.getRow(rownum); // 셀정보

				keyword = d.makeKeywords(xlsxRow.getCell(14).toString());

				// 키워드 정제(한자, 영어, 숫자제거)
				for (int i = 0; i < keyword.length; i++) {
					if (m.Englishs(keyword[i]) || m.Chinese_Character(keyword[i]) || m.isStringDouble(keyword[i])) {
						keyword[i] = "0a0";
					}
				}

				d.setKeywords(keyword);

				date = new String[keyword.length];
				year = new String[keyword.length];
				quarter = new String[keyword.length];
				category = new String[keyword.length];
				count = new String[keyword.length];

				for (int i = 0; i < keyword.length; i++) {

					date[i] = xlsxRow.getCell(1).toString();
					year[i] = date[i].substring(0, 4);
					count[i] = null;

					quarter[i] = m.Find_Quarter(date[i]); // 분기 계산
					category[i] = m.Find_Category(fileName); // 신문 분류

				}

				d.setYear(year);
				d.setQuarter(quarter);
				d.setCategory(category);

				d.makeKeywordset(d.getYear(), d.getQuarter(), d.getCategory(), keyword, count); // save in arrayList
			}

			// System.out.println("1 " + d.getKeywordset().size());
			// for(int i = 0; i< d.getKeywordset().size(); i++) {
			// for(int j = 0 ; j < d.getKeywordset().get(i).length; j++)
			// System.out.print(d.getKeywordset().get(i)[j] + " ");
			// System.out.println();
			// }

			xlsxFile.close();
		} catch (Exception a) {

		}

	}

	public void xlsx_data(DB db, String fileName) {

		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		 String year = null;
		 String quarter = null;
		 String category = null;
		String keyword = null;
		 String count = null;

		String[] CheckKeyword = null;
		int CheckKeywordIndex = 0;

		int xlsxRows = 0;
		db.connect();
		try {
//			xlsxFile = new FileInputStream(
//					new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\정재된 자료\\" + fileName + ".xlsx"));
			
			xlsxFile = new FileInputStream(new File("C:\\Users\\User\\Desktop\\별이\\" + fileName + ".xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow;

			CheckKeyword = new String[xlsxRows];
			System.out.println("엑셀 읽기 시작");
			for (int rownum = 0; rownum < xlsxRows; rownum++) {
				xlsxRow = sheet.getRow(rownum); // 셀정보

				 year = xlsxRow.getCell(0).toString();
				 quarter = xlsxRow.getCell(1).toString();
				 category = xlsxRow.getCell(2).toString();
				keyword = xlsxRow.getCell(3).toString();
				 count = xlsxRow.getCell(4).toString();
				 System.out.println(keyword);

//				if (Arrays.asList(CheckKeyword).contains(keyword)) {
//					continue; // 중복
//				} else { // 중복아님
//					CheckKeyword[CheckKeywordIndex] = keyword;
//					CheckKeywordIndex++;
//					db.createTable(keyword);
//				}

				// db.insertData("Main", year, quarter, category, keyword, count);
				db.DeleteDuplication("Main", year, quarter, category, keyword, count);
			}
			xlsxFile.close();
			db.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void xlsx_correlation(Mining m, DB db, String fileName) {
		// xlsx
		Data d = null;
		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		String[] date = null;
		String[] year = null;
		String[] quarter = null;
		String[] category = null;
		String[] keyword = null;
		String[] count = null;

		int xlsxRows = 0;
		String[] file = fileName.split("_");
		boolean alreadyFlag = true;

		try {
			xlsxFile = new FileInputStream(
					new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\기사(5년)\\" + fileName + ".xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로

			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);

			xlsxRows = sheet.getPhysicalNumberOfRows();
			date = new String[xlsxRows];

			file[0] = m.Find_Category(file[0]); // 신문 분류

			String sql = "select * from Main Where Year = " + Integer.parseInt(file[1]) + " AND Category = "
					+ Integer.parseInt(file[0]);
			System.out.println(sql);
			ArrayList<String[]> standard = db.TestselectData(sql);

			// db읽기
//			System.out.println("size : " + standard.get(0).length);
			for (int row = 0; row < standard.get(0).length; row++) {
				d = new Data();
				ArrayList<Integer> indexOfKeyword = new ArrayList<Integer>();
				
//				System.out.println(row + " " + standard.get(0)[row]); // 종류
//				System.out.println(row + " " + standard.get(1)[row]);// 연도
//				System.out.println(row + " " + standard.get(2)[row]);// 분기
//				System.out.println(row + " " + standard.get(3)[row]);// 키워드(=테이블이름)
//				System.out.println(row + " " + standard.get(4)[row]); // 빈도수

				// 엑셀 읽기
				for (int rownum = 1; rownum < xlsxRows; rownum++) {
					XSSFRow xlsxRow = sheet.getRow(rownum); // 셀정보

					keyword = d.makeKeywords(xlsxRow.getCell(14).toString());

					date = new String[xlsxRows];
					quarter = new String[xlsxRows];

					date[rownum] = xlsxRow.getCell(1).toString();

					quarter[rownum] = m.Find_Quarter(date[rownum]); // 분기 계산
					// 키워드 정제(한자, 영어, 숫자제거) + 기준키워드를 가지고 있는 기사의 인덱스를 저장
					for (int i = 0; i < keyword.length; i++) {

						if (m.Englishs(keyword[i]) || m.Chinese_Character(keyword[i]) || m.isStringDouble(keyword[i])) {
							keyword[i] = "0a0";
						}
					}

					for (int i = 0; i < keyword.length; i++) {
						// System.out.println(rownum+" keyword안 :" + keyword[i]);
						if (standard.get(3)[row].equals(keyword[i]) && standard.get(2)[row].equals(quarter[rownum])) {
							if(Integer.parseInt(standard.get(2)[row]) < 4 && Integer.parseInt(standard.get(0)[row]) == 0) {
								alreadyFlag = false;
								break;
						}
							else {
							indexOfKeyword.add(rownum);
//							 System.out.println(rownum +" 데이터베이스 : " + standard.get(3)[row] + " 키워드 : "
//							 +keyword[i]);
							alreadyFlag = true;
							break;
						}
						}
					}

				}

//				System.out.println("indexOfKeyword.size() : " + indexOfKeyword.size());
				
				for (int a = 0; a < indexOfKeyword.size(); a++) {
					//System.out.println(indexOfKeyword.get(a));
					XSSFRow xlsxRow = sheet.getRow(indexOfKeyword.get(a)); // 셀정보
					d.setKeywords(keyword);

					date = new String[keyword.length];
					year = new String[keyword.length];
					quarter = new String[keyword.length];
					category = new String[keyword.length];
					count = new String[keyword.length];

					for (int i = 0; i < keyword.length; i++) {

						date[i] = xlsxRow.getCell(1).toString();
						year[i] = date[i].substring(0, 4);
						count[i] = null;

						quarter[i] = m.Find_Quarter(date[i]); // 분기 계산
						category[i] = m.Find_Category(fileName); // 신문 분류

					}

					d.setYear(year);
					d.setQuarter(quarter);
					d.setCategory(category);

					d.makeKeywordset(d.getYear(), d.getQuarter(), d.getCategory(), keyword, count); // save in
																									// arrayList

				}
				if(alreadyFlag) {
					d.setKeywordset(m.correlation(db, d.getKeywordset(), fileName, standard.get(3)[row])); //정재
					db.insertData(standard.get(3)[row],d);	//데이터베이스에 저장
					System.out.println(standard.get(3)[row]);
				}
			}

			xlsxFile.close();
		} catch (Exception a) {

		}

	}

	public void xls() {
		// xls 방법 1
		try {
			FileInputStream xlsFile = new FileInputStream(new File("c:\\hh.xls")); // 파일 스트림을 XSSFWorkbook 객체로 생성
			HSSFWorkbook workbook2 = new HSSFWorkbook(xlsFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			HSSFSheet sheet2 = workbook2.getSheetAt(0);
			int xlsRows = sheet2.getPhysicalNumberOfRows();
			for (int rownum = 1; rownum < xlsRows; rownum++) {
				HSSFRow xlsRow = sheet2.getRow(rownum);
				xlsRow.getCell(1).toString();
				xlsRow.getCell(2).toString();
				System.out.println("================================");
				for (int i = 0; i < xlsRow.getLastCellNum(); i++)
					System.out.println(i + "번째 열: " + xlsRow.getCell(i));
			}

			xlsFile.close();
		} catch (Exception a) {

		}

	}

}

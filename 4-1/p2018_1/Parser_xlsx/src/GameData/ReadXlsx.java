package GameData;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadXlsx {
	static String file_name = "Test_최종본";
	static String file_name2 = "Test_category";

	public Vector<String> xread() {
		File file = new File(file_name);
		XSSFWorkbook wb = null;

		try {//���� ���� ����
			wb = new XSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//���� ���� �ӽ� ����
		Vector<String> tmpContent = new Vector<String>();
		boolean isNull = false;

		for( Row row : wb.getSheetAt(0) ) {// �� ����
			String str = new String();
			for( Cell cell : row ) { // ������
				isNull = false;

				// ���� Ÿ�� ���� �޾Ƽ� �������� �޵� �� ���� �ϳ��� ��Ʈ������ ����
				switch( cell.getCellType()) {
				case Cell.CELL_TYPE_STRING :
					str = str + cell.getRichStringCellValue().getString();
					//System.out.print(str);
					break;

				case Cell.CELL_TYPE_NUMERIC :
					if(DateUtil.isCellDateFormatted(cell))
						str = str + cell.getDateCellValue().toString();
					else
						str = str + Integer.toString((int)cell.getNumericCellValue());
					//System.out.print(str);
					break;

				case Cell.CELL_TYPE_BOOLEAN :
					str = str + cell.getBooleanCellValue();
					//System.out.print(str);
					break;

				case Cell.CELL_TYPE_FORMULA :
					str = str + cell.getCellFormula();
					//System.out.print(str);
					break;

				default: // ���� ���� ���� ���Ե��� �ʰ� ��. 
					isNull = true;
				}                
				if(isNull != true)
				{
					str = str + " ";
					//System.out.print(str + "  ");
				}
				//System.out.println();
			}
			// �� ���� ���� ���� ���Ϳ� �߰�
			tmpContent.add(str);
		}

		Vector<String> Content = new Vector<String>();

		//�� �྿ �����鼭 ������ �迭�� space�� �߰��ǰ��� ���� ��Ŵ.
		//�̺κ��� space�� �������� ����մϴ�.
		for(int i=0; i< tmpContent.size(); i++)
		{	
			String str = tmpContent.get(i);
			str = str.substring(0, str.length());
			System.out.println(str);
			Content.add(str);
		}
		return Content;

	}
	public void xlsx_data(String fileName) {

		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		// String year = null;
		// String quarter = null;
		// String category = null;
		//String keyword = null;
		// String count = null;
		String game_name = null;

		String[] CheckKeyword = null,CheckKeyword2 = null;
		int CheckKeywordIndex = 0,CheckKeywordIndex2 = 0;

		int xlsxRows = 0;
		//  db.connect();
		try {
			xlsxFile = new FileInputStream(
					new File("D://Test/" + fileName + ".xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow;

			CheckKeyword = new String[xlsxRows];
			System.out.println("엑셀 읽기 시작");
			for (int rownum = 0; rownum < xlsxRows; rownum++) {
				xlsxRow = sheet.getRow(rownum); // 셀정보

				game_name = xlsxRow.getCell(0).toString();
				// quarter = xlsxRow.getCell(1).toString();
				// category = xlsxRow.getCell(2).toString();
				//keyword = xlsxRow.getCell(3).toString();
				// count = xlsxRow.getCell(4).toString();
				// System.out.println(keyword);

				if (Arrays.asList(CheckKeyword).contains(game_name)) {
					continue; // 중복
				} else { // 중복아님
					CheckKeyword[CheckKeywordIndex] = game_name;
					//System.out.println(CheckKeyword[CheckKeywordIndex]);
					CheckKeywordIndex++;
					// db.createTable(keyword);
				}

				// System.out.println(game_name);
				// db.insertData("Main", year, quarter, category, keyword, count);
			}
			
			xlsxFile.close();
			xlsxRows = 0;
			System.out.println(">>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<");
			xlsxFile = new FileInputStream(
					new File("D://Test/" + file_name2 + ".xlsx"));
			// 파일 스트림을 XSSFWorkbook 객체로
			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();

			XSSFRow xlsxRow1;

			CheckKeyword2 = new String[xlsxRows];
			System.out.println("엑셀 읽기 시작");
			for (int rownum = 0; rownum < xlsxRows; rownum++) {
				xlsxRow1 = sheet.getRow(rownum); // 셀정보

				game_name = xlsxRow1.getCell(0).toString();
				// quarter = xlsxRow.getCell(1).toString();
				// category = xlsxRow.getCell(2).toString();
				//keyword = xlsxRow.getCell(3).toString();
				// count = xlsxRow.getCell(4).toString();
				// System.out.println(keyword);
				if (Arrays.asList(CheckKeyword2).contains(game_name)) {
					
					continue; // 중복
				} else { // 중복아님
					CheckKeyword2[CheckKeywordIndex2] = game_name;
				
					//System.out.println("3 "+CheckKeyword2[CheckKeywordIndex2]);
					
						
					//System.out.println(CheckKeyword[CheckKeywordIndex]);
					CheckKeywordIndex2++;
				}
				
			}
			xlsxFile.close();
			System.out.println( "            CheckKeyword2    CheckKeyword " );
			for(int i = 0; i < CheckKeywordIndex; i++)
				for(int j = 0; j < CheckKeywordIndex2; j++) {
					if(CheckKeyword[i].equals(CheckKeyword2[j]))
						System.out.println( "index [ "+i + " ]  "+ CheckKeyword2[j] + " : " + CheckKeyword[i]);
				}




			// db.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		ReadXlsx rex = new ReadXlsx();
		rex.xlsx_data(file_name);
		//System.out.println(rex.xread());
	}
}

package Parser;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import main.autoCon;

/**
 * @author JunHyeong Cho
 *
 */

public class xlsxParser implements autoCon {
	private String[][] data;
	private String year;
	
	public void xlsx(String path) {
		// xlsx

		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		int xlsxRows = 0;
		int xlsxCols = 0;
		
		String cellData = null;
		String[] smallData = null;
		
		try {
			xlsxFile = new FileInputStream(
					new File(path));
			// 파일 스트림을 XSSFWorkbook 객체로

			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();
			data = new String[xlsxRows-1][];
			
			XSSFRow xlsxFirstRow = sheet.getRow(0); 
			
			// 연도 추출
			if (m.isNumeric(xlsxFirstRow.getCell(1).toString()))
				setYear(xlsxFirstRow.getCell(1).toString());
			else 
				setYear(xlsxFirstRow.getCell(2).toString());
				
			

			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				XSSFRow xlsxRow = sheet.getRow(rownum); // 셀정보
				xlsxCols = xlsxRow.getPhysicalNumberOfCells();
				smallData = new String[xlsxCols];
				cellData = "abc";
				for(int colnum = 0; colnum < xlsxCols; colnum++) {
					cellData = xlsxRow.getCell(colnum).toString();
					smallData[colnum] = cellData;
//					System.out.print(smallData[colnum] + "\t\t\t");
				}
				data[rownum-1] = smallData;
//				System.out.println();
			}
			

			xlsxFile.close();
		} catch (Exception a) {

		}

	}
	
	public void xlsxAttridute(String path) {
		FileInputStream xlsxFile;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		int xlsxRows = 0;
		int xlsxCols = 0;
		int table_id = 1;
		String tempName = "";
		String cellData = null;
		String[] smallData = null;
		
		try {
			xlsxFile = new FileInputStream(
					new File(path));
			// 파일 스트림을 XSSFWorkbook 객체로

			workbook = new XSSFWorkbook(xlsxFile); // XSSFWorkbook 의 첫번째 시트를 가져옴
			sheet = workbook.getSheetAt(0);
			xlsxRows = sheet.getPhysicalNumberOfRows();
			data = new String[xlsxRows-1][];			

			for (int rownum = 1; rownum < xlsxRows; rownum++) {
				XSSFRow xlsxRow = sheet.getRow(rownum); // 셀정보
				xlsxCols = xlsxRow.getPhysicalNumberOfCells();
				smallData = new String[xlsxCols+1];
				cellData = "abc";

				
				for(int colnum = 0; colnum < xlsxCols; colnum++) {
					cellData = xlsxRow.getCell(colnum).toString();
					if(colnum == 0)
						cellData = cellData.split("_")[0];

					smallData[colnum+1] = cellData;
				}
				if(!tempName.equals(smallData[1]) && !tempName.equals(""))
					table_id++;
				tempName = smallData[1];
				smallData[0] = Integer.toString(table_id);
				
//				for(int i=0;i<xlsxCols+1;i++)
//					System.out.print(smallData[i] + "\t\t\t");
//				System.out.println();
			
				data[rownum-1] = smallData;
			}
			

			xlsxFile.close();
		} catch (Exception a) {

		}

	}

	public void xls() {
		// xls
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
	
	public String[][] getData() {		
		return data;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
//	public static void main(String args[]) {
//	String fileName = "행정구역_20180801091718";
//	xp.xlsx(fileName);
//	xp.getData();
//}
	
}

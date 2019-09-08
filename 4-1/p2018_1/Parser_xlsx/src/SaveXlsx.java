import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class SaveXlsx {
	 public void xlsxWiter(String filename, ArrayList<String[]> dataset) {
	        int rowIdx=0;
	        // 워크북 생성
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // 워크시트 생성
	        XSSFSheet sheet = workbook.createSheet();
	        // 행 생성
	        XSSFRow row = sheet.createRow(0);
	        // 쎌 생성
	        XSSFCell cell;
	        
	        // 헤더 정보 구성
	        cell = row.createCell(0);
	        cell.setCellValue("연도");
	        
	        cell = row.createCell(1);
	        cell.setCellValue("분기");
	        
	        cell = row.createCell(2);
	        cell.setCellValue("카테고리");
	        
	        cell = row.createCell(3);
	        cell.setCellValue("키워드");
	        
	        cell = row.createCell(4);
	        cell.setCellValue("빈도수");
	        

	        
	 		for(int i = 0; i< dataset.size(); i+=5) {
	 			for(int j = 0 ; j < dataset.get(i).length; j++) {
	 				
	 				cell = row.createCell(0);
	 	            cell.setCellValue(dataset.get(i)[j]);
	 	            
	 	            cell = row.createCell(1);
	 	            cell.setCellValue(dataset.get(i+1)[j]);
	 	            
	 	            cell = row.createCell(2);
	 	            cell.setCellValue(dataset.get(i+2)[j]);
	 	            
	 	            cell = row.createCell(3);
	 	            cell.setCellValue(dataset.get(i+3)[j] );
	 	            
	 	            cell = row.createCell(4);
	 	            cell.setCellValue(Integer.parseInt(dataset.get(i+4)[j]));
	 	            
	 	            rowIdx++;
		            row = sheet.createRow(rowIdx);

	 				}
				}
	 		
	        
	        // 입력된 내용 파일로 쓰기
	        File file = new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\"+filename+".xlsx");
	        FileOutputStream fos = null;
	        
	        try {
	            fos = new FileOutputStream(file);
	            workbook.write(fos);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(workbook!=null) workbook.close();
	                if(fos!=null) fos.close();
	                
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	 }

	 
	 public void xlsxWiter(ArrayList<String[]> dataset) {
	        int rowIdx=0;
	        // 워크북 생성
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // 워크시트 생성
	        XSSFSheet sheet = workbook.createSheet();
	        // 행 생성
	        XSSFRow row = sheet.createRow(0);
	        // 쎌 생성
	        XSSFCell cell;
	        
	        
	 		for(int i = 0; i< dataset.size(); i+=7) {
	 			for(int j = 0 ; j < dataset.get(i).length; j++) {
	 				
	 				cell = row.createCell(0);
	 	            cell.setCellValue(dataset.get(i)[j]);
	 	            
	 	            cell = row.createCell(1);
	 	            cell.setCellValue(dataset.get(i+1)[j]);
	 	            
	 	            cell = row.createCell(2);
	 	            cell.setCellValue(dataset.get(i+2)[j]);
	 	            
	 	            cell = row.createCell(3);
	 	            cell.setCellValue(dataset.get(i+3)[j] );
	 	            
	 	            cell = row.createCell(4);
	 	            cell.setCellValue(dataset.get(i+4)[j]);
	 	            
	 	            cell = row.createCell(5);
	 	            cell.setCellValue(dataset.get(i+5)[j]);
	 	            
	 	            cell = row.createCell(6);
	 	            cell.setCellValue(dataset.get(i+6)[j]);
	 	            
	 	            
	 	            rowIdx++;
		            row = sheet.createRow(rowIdx);

	 				}
				}
	 		
	        
	        // 입력된 내용 파일로 쓰기
	        File file = new File("D:\\대학교\\4학년 1학기\\U-캡스톤디자인\\기타\\자료\\기타\\통합 문서4.xlsx");
	        FileOutputStream fos = null;
	        
	        try {
	            fos = new FileOutputStream(file);
	            workbook.write(fos);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(workbook!=null) workbook.close();
	                if(fos!=null) fos.close();
	                
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	 }

	 
}

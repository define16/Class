package GameData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Categorys {

	static String filename = "Test_category";
	int rowIdx=0;
	ArrayList<SteamFIle> list = new ArrayList<SteamFIle>();
	//SteamFIle sf= new SteamFIle();
	dump_remove dr= new dump_remove();
	SteamFIle sf = new SteamFIle();
	List<String> name= new ArrayList<String>();
	List<String> category= new ArrayList<String>();
	public void File_Readers() throws InterruptedException {
		BufferedReader br = null;
		FileReader fr = null;
		//SaveXlsx sex = new SaveXlsx();

		try {
			fr = new FileReader("C://Users/dldor/Documents/카카오톡 받은 파일/steam3.txt");
			br = new BufferedReader(fr);

			String sCurrentLine;

			String s ;
			int count = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				s = sCurrentLine;


				if(s.equals("aaaaaaaaaaaa") || s.equals("bbbbbbbbbbbb") || s.equals("aaaaaaaaaa"))
					continue;


				if(s.contains("steam_name"))
				{
					String temp_name = s.replaceAll("steam_name", "");
					sf.setGame_name(temp_name);

				}
				else
				{
					String categorys = s;
					sf.setCategory(categorys);
					category.add(categorys);
					name.add(sf.getGame_name());


				}

			}


		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public void xlsxWiter() {

		// ��ũ�� ����
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ��ũ��Ʈ ����
		XSSFSheet sheet = workbook.createSheet();
		// �� ����
		XSSFRow row = sheet.createRow(0);
		// ��� ���� ����
		if(rowIdx == 0)
		{
			XSSFCell cell;
			// �� ����
			cell = row.createCell(0);
			cell.setCellValue("게임이름");

			cell = row.createCell(1);
			cell.setCellValue("종류");
			

			rowIdx++;
			row = sheet.createRow(rowIdx);
		}

		System.out.println("엑셀 시작");
		XSSFCell cell;

		for(int i = 0; i < name.size(); i++)
		{
			cell = row.createCell(0);
			cell.setCellValue(name.get(i));


			cell = row.createCell(1);
			cell.setCellValue(category.get(i));



			rowIdx++;
			row = sheet.createRow(rowIdx);

		}
		// �Էµ� ���� ���Ϸ� ����
		File file = new File("D://Test/"+filename+".xlsx");
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
				System.out.println("엑셀 끝");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String args[]) throws InterruptedException {
		Categorys sex = new Categorys();

		System.out.println("시작");
		sex.File_Readers();
		sex.xlsxWiter();
		System.out.println("끝");
	}



}

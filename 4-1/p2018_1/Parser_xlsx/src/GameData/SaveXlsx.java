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

public class SaveXlsx {

	static String filename = "Test";
	int rowIdx=0;
	ArrayList<SteamFIle> list = new ArrayList<SteamFIle>();
	//SteamFIle sf= new SteamFIle();
	dump_remove dr= new dump_remove();
	SteamFIle sf = new SteamFIle();
	List<String> name= new ArrayList<String>();
	List<String> dates= new ArrayList<String>();
	List<Integer> quarter= new ArrayList<Integer>();
	List<String> players= new ArrayList<String>();
	public void File_Readers() {
		BufferedReader br = null;
		FileReader fr = null;
		//SaveXlsx sex = new SaveXlsx();

		int i = 0;
		try {
			fr = new FileReader("steam.txt");
			br = new BufferedReader(fr);

			String sCurrentLine;

			String s ;
			while ((sCurrentLine = br.readLine()) != null) {
				s = sCurrentLine;
				if( s.equals("aaaaaaaaaa") || s.equals("bbbbbbbbbb") || s.contains("bbbbbbbbbb"))
					continue;
				else if(s.contains("-") || s.contains("'")){

					String names = s.replaceAll("- Steam Charts", "");
					sf.setGame_name(new String(names.getBytes("utf8")));
					
					//System.out.println("1 : " + getGame_name());
				}else {
					if(dr.Month_name(s))
					{
						String date = null ;

						quarter.add(dr.Month_collection(s));
						if(s.contains("March"))
							date = s.replaceAll("March", "");
						else if(s.contains("April"))
							date = s.replaceAll("April", "");
						else if(s.contains("February"))
							date = s.replaceAll("February", "");
						else if(s.contains("January"))
							date = s.replaceAll("January", "");
						else if(s.contains("December"))
							date = s.replaceAll("December", "");
						else if(s.contains("November"))
							date = s.replaceAll("November", "");
						else if(s.contains("October"))
							date = s.replaceAll("October", "");
						else if(s.contains("September"))
							date = s.replaceAll("September", "");
						else if(s.contains("August"))
							date = s.replaceAll("August", "");
						else if(s.contains("July"))
							date = s.replaceAll("July", "");
						else if(s.contains("June"))
							date = s.replaceAll("June", "");
						else if(s.contains("May"))
							date = s.replaceAll("May", "");
						
						
						dates.add(date);
						//System.out.println("2 :" + getDate_year());
					}
					if(dr.isStringDouble(s) && s.contains(",")) {
						String player = s;
						sf.setGame_Player(player);
						players.add(player);
						name.add(sf.getGame_name());
						i++;
						//System.out.println("3 :"+getGame_Player());
					}
					//list.add(new SteamFIle(sf.getGame_name(), sf.getDate_year(), sf.getGame_Player()));

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

		// 占쏙옙크占쏙옙 占쏙옙占쏙옙
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 占쏙옙크占쏙옙트 占쏙옙占쏙옙
		XSSFSheet sheet = workbook.createSheet();
		// 占쏙옙 占쏙옙占쏙옙
		XSSFRow row = sheet.createRow(0);
		// 占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙
		if(rowIdx == 0)
		{
			XSSFCell cell;
			// 占쏙옙 占쏙옙占쏙옙
			cell = row.createCell(0);
			cell.setCellValue("게임이름");

			cell = row.createCell(1);
			cell.setCellValue("년도");

			cell = row.createCell(2);
			cell.setCellValue("분기");

			cell = row.createCell(3);
			cell.setCellValue("게임이용자수");
			rowIdx++;
			row = sheet.createRow(rowIdx);
		}

		System.out.print(">>>>>>>");
		XSSFCell cell;
		ArrayList<SteamFIle> list2 = new ArrayList<SteamFIle>();
		list2 = list;
		System.out.println(list2.size());

		for(int i = 0; i < players.size() ; i++) {

			cell = row.createCell(0);
			cell.setCellValue(name.get(i));

			cell = row.createCell(1);
			cell.setCellValue(dates.get(i));

			cell = row.createCell(2);
			cell.setCellValue(quarter.get(i));


			cell = row.createCell(3);
			cell.setCellValue(players.get(i));
			rowIdx++;
			row = sheet.createRow(rowIdx);
		}

		// 占쌉력듸옙 占쏙옙占쏙옙 占쏙옙占싹뤄옙 占쏙옙占쏙옙
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

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		SaveXlsx sex = new SaveXlsx();

		System.out.println("�떆�옉");
		sex.File_Readers();
		sex.xlsxWiter();
		System.out.println("�걹");
	}


}

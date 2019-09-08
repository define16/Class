package Hw2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CharEx1 {
	
	public static void main(String args[]){
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Date d = null;
		
		try{
	
			fr = new FileReader("ReadFile.txt");
			br = new BufferedReader(fr);
		
			fw = new FileWriter("CopyFile.txt", false);
			bw = new BufferedWriter(fw);
			
			String s = null;
			d = new Date();
			
			
			long start = d.getTime();
			
			
			while((s=br.readLine())!=null){
				
			
				bw.write(s);
				bw.newLine();
			}
			
			
			d = new Date();
			long end = d.getTime();
			
			System.out.println("복사 시간 : " + (end-start));
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
			
			if(br != null) try{br.close();}catch(IOException e){}
			if(fr != null) try{fr.close();}catch(IOException e){}
			
			
			if(bw != null) try{bw.close();}catch(IOException e){}
			if(fw != null) try{fw.close();}catch(IOException e){}
			
		}
		
	}

}
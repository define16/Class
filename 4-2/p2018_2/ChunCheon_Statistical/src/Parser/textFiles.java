package Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class textFiles {
	private String path;
	private String fileName;
	
	public void txtWrite(String txt) {
        try{
            // 파일 객체 생성
            File file = new File(path + fileName) ;
             
            // true 지정시 파일의 기존 내용에 이어서 작성
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true)) ;
             
            // 파일안에 문자열 쓰기
            out.write(txt);
            out.newLine();
            out.flush();
 
            // 객체 닫기
            out.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void txtWrite(String[] txt) {
        try{
            // 파일 객체 생성
            File file = new File(path + fileName) ;
             
            // true 지정시 파일의 기존 내용에 이어서 작성
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true)) ;
             
            // 파일안에 문자열 쓰기
            for(int c = 0; c < txt.length; c++) {
            	out.write(txt[c]);
            	out.newLine();
            }
        	out.flush();
            // 객체 닫기
            out.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
         
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}

package Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class textFiles {
	private String path;
	private String fileName;
	
	public void txtWrite(String txt) {
        try{
            // ���� ��ü ����
            File file = new File(path + fileName) ;
             
            // true ������ ������ ���� ���뿡 �̾ �ۼ�
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true)) ;
             
            // ���Ͼȿ� ���ڿ� ����
            out.write(txt);
            out.newLine();
            out.flush();
 
            // ��ü �ݱ�
            out.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void txtWrite(String[] txt) {
        try{
            // ���� ��ü ����
            File file = new File(path + fileName) ;
             
            // true ������ ������ ���� ���뿡 �̾ �ۼ�
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true)) ;
             
            // ���Ͼȿ� ���ڿ� ����
            for(int c = 0; c < txt.length; c++) {
            	out.write(txt[c]);
            	out.newLine();
            }
        	out.flush();
            // ��ü �ݱ�
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

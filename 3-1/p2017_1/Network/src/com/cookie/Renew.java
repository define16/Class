package com.cookie;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Renew extends Thread {
	
	private ArrayList<String> v;
	
	public void run()
	{
		String url = "http://www.naver.com/";
		
		InputStream in = URLManager.getURLInputStream(url);
		
		
	
			try{
				//System.out.println(Jsoup.parse(in, URLManager.ENCODING_UTF8,"").html());
		
				Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
				Elements root = doc.select("ol[id=realrank]");
				Elements rankList = root.select("a");
				
				ArrayList<String> tittles = new ArrayList<>();		// ��̸���Ʈ�� ���� �Ѵ�.
				
				
				try{
					
					for(int i=0; i< 6; i++)
					{
						System.out.println((30*i) + "�� �˻����Ʈ");
						for(int j = 0; j<rankList.size();++j)
							tittles.add(rankList.get(j).attr("title")); 	//��� ����Ʈ�� �˻�� String������ ����
						
						HashSet hscheck = new HashSet(tittles);		//�콬���� �����ؼ� �ߺ��� Ű���� ���� ����
						ArrayList<String> checkArrList = new ArrayList<String>(hscheck);	//���ο� ��̸���Ʈ�� �ٽ� ����
						
						for (int k = 0; k<checkArrList.size(); k++) 
				            System.out.println((k+1) + "�� " + checkArrList.get(k));		// 30�ʸ��� ���ο� �˻����� ���
						// �˻�� 30�ʸ��� ����� �����ϴ��� üũ
						
						System.out.println();
						sleep(100); // 30�ʰ������� ������ ����
					}
						HashSet hs = new HashSet(tittles); //�콬���� �����ؼ� �ߺ��� Ű���� ���� ����
						
						ArrayList<String> newArrList = new ArrayList<String>(hs); //���ο� ��̸���Ʈ�� �ٽ� ����
						
						
						//v = newArrList;
						System.out.println("���� �˻���");
						  for (int i = 0; i<newArrList.size(); i++) {
					            System.out.println((i+1) + "�� " + newArrList.get(i));
					        } // ���α׷��� �����ϰ� 3���� ���� �˻��� ���.


				
					//System.out.println(newArrList);
					
				}catch (Exception e) {
					// TODO: handle exceptions
					e.printStackTrace();
				}
			
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
			
	
		
	}







	
}

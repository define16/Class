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
				
				ArrayList<String> tittles = new ArrayList<>();		// 어레이리스트를 선언 한다.
				
				
				try{
					
					for(int i=0; i< 6; i++)
					{
						System.out.println((30*i) + "초 검색어리스트");
						for(int j = 0; j<rankList.size();++j)
							tittles.add(rankList.get(j).attr("title")); 	//어레이 리스트에 검색어를 String값으로 저장
						
						HashSet hscheck = new HashSet(tittles);		//헤쉬셋을 선언해서 중복된 키워드 값을 제거
						ArrayList<String> checkArrList = new ArrayList<String>(hscheck);	//새로운 어레이리스트에 다시 저장
						
						for (int k = 0; k<checkArrList.size(); k++) 
				            System.out.println((k+1) + "위 " + checkArrList.get(k));		// 30초마다 새로운 검색어을 출력
						// 검색어가 30초마다 제대로 실행하는지 체크
						
						System.out.println();
						sleep(100); // 30초간격으로 스레드 실행
					}
						HashSet hs = new HashSet(tittles); //헤쉬셋을 선언해서 중복된 키워드 값을 제거
						
						ArrayList<String> newArrList = new ArrayList<String>(hs); //새로운 어레이리스트에 다시 저장
						
						
						//v = newArrList;
						System.out.println("최종 검색어");
						  for (int i = 0; i<newArrList.size(); i++) {
					            System.out.println((i+1) + "위 " + newArrList.get(i));
					        } // 프로그램을 시작하고 3분후 나온 검색어 출력.


				
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

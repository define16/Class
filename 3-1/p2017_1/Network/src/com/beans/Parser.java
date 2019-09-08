package com.beans;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cookie.URLManager;

public class Parser {

	public static ArrayList<Data> getNaver()
	{
	
		ArrayList<Data> da = new ArrayList<>();
		da.clear();

		String link = null; // 주소 저장할 변수
		String title = null; // 검색어를 저장할 변수

			try{				
				String url = "https://www.naver.com/";
				
				InputStream in = URLManager.getURLInputStream(url);
		
				Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
				Elements root = doc.select("div[class=ah_list PM_CL_realtimeKeyword_list_base]");
				Elements list = root.select("li[class=ah_item]");
				Elements text = list.select("span[class=ah_k]");


				for(int j = 0; j<text.size();++j){
			
					title = text.get(j).text(); // 검색어만 추출
					link = "https://search.naver.com/search.naver?where=nexearch&sm=tab_lve&ie=utf8&query=" + title; // 링크만 추철

					Data d = new Data(title,link); // Data를 객체 생성해서 매개변수 2개 갖는 생성자에 넣어준다.
					da.add(d); // 어레이리스트 da에 추가해준다.
				}

	
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		return da; // 어레이리스트 da을 리턴
	}
	
	public static ArrayList<Data> getDaum(){
		
		ArrayList<Data> da = new ArrayList<Data>();
		
		String link = null;
		String title = null;

		
		
		String url = "https://www.daum.net/";
		int j = 1;
		InputStream in = URLManager.getURLInputStream(url);
		
		try{
			Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
			
			Elements root = doc.select("ol[id=realTimeSearchWord]");
			Elements rankList = root.select("a");

			for(int i = 0; i<rankList.size();i+=2)
			{
				title = rankList.get(i).text(); // 검색어만 추출
				link = rankList.get(i).attr("href"); // 링크만 추철
				Data d = new Data(title,link); // Data를 객체 생성해서 매개변수 2개 갖는 생성자에 넣어준다.
				da.add(d); // 어레이리스트 da에 추가해준다.
			}
			
		} catch(IOException e){
			
			e.printStackTrace();
		}
		
		
		return da;  // 어레이리스트 da에 추가해준다.
	}
}

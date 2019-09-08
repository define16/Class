package com.bean;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cookie.URLManager;

public class Parser {
	private static boolean flag = true;
	
	public void setflag(boolean flag)
	{
		this.flag = flag;
	}
	
	public static ArrayList<Data>goodsSearch(String keyword)
	{
		ArrayList<Data> da = new ArrayList<>();
		String query = URLEncoder.encode(keyword);
		String url = "http://cafe.naver.com/ArticleSearchList.nhn?search.clubid=10050146&search.searchBy=0&search.query=" + query;
		String Slink = null;
		String title = null;
		
		InputStream in = URLManager.getURLInputStream(url, URLManager.USER_AGENT_PC);
		
		try{
			Document doc = Jsoup.parse(in, URLManager.ENCODING_EUCKR,"");
			Elements root = doc.select("span.aaa");
			Elements rankList = root.select("a");
		
			
			for(int j = 0; j<rankList.size();++j){
				title = rankList.get(j).text();
				Slink = "http://cafe.naver.com" +rankList.get(j).attr("href");
				
				Data d = new Data(title,Slink); // Data를 객체 생성해서 매개변수 2개 갖는 생성자에 넣어준다.
				Data d2 = new Data(title);
				if(flag)
					da.add(d);
				else
					da.add(d2);
			}
			
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}    
		
		return da;
	}
	


}

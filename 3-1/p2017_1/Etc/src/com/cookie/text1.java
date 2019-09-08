package com.cookie;

import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class text1 {
	public static void main(String[] args)
	   {
		String url = "http://zangsisi.net/?p=25207";	// 이미지가 있는 url입력
		InputStream in = URLManager.getURLInputStream(url, URLManager.USER_AGENT_PC);
		String Slink = null;
		try{
			Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
			
			//div[class=separator] 되는 부분 
			Elements root = doc.select("div[class=separator]");
			Elements rankList = root.select("a");
			
			//p로 되는거 한 부분
			Elements root2 = doc.select("p");
			Elements rankList2 = root2.select("a");
			
			Slink = rankList.get(0).attr("href");
			
			if(Slink.equals(null)) {
				Slink = rankList2.get(0).attr("href");
				
			}
			
			System.out.println(Slink);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			
	   }
}
	

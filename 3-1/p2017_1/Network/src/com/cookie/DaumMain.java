package com.cookie;

import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.beans.Parser;

public class DaumMain {
	public static void main(String[] args) {
		
		 Parser p = new Parser();

		 System.out.println("다음 실시간 검색어");
		 for (int i = 0; i< 10; i++)
	            System.out.println((i+1) + "위 " + p.getDaum().get(i));  // getDaum()에서 리턴한 어레이리스트를 출력.
		 
		
	}

	
}

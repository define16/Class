package com.bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cookie.URLManager;

public class Renew extends Thread{
	String keyword;
	ArrayList<Data> newcheckArrList,oldList;
	int gap;
	public void setkeyword(String keyword)
	{
		this.keyword = keyword;
	}
	
	public void setarray( ArrayList<Data> oldList)
	{
		this.oldList = oldList;
	}
	
	public void run()
	{
		Parser p = new Parser();
		
				try{
					for(int i=0; i< 10; i++)	
					{
						System.out.println(i*100 + "초 경과");
						HashSet hscheck = new HashSet(p.goodsSearch(keyword));		//헤쉬셋을 선언해서 중복된 키워드 값을 제거
						newcheckArrList = new ArrayList<Data>(hscheck);	//새로운 어레이리스트에 다시 저장
					
						if(oldList.size() < newcheckArrList.size())
						{
							//gap =  newcheckArrList.size() - oldList.size();
						
						for(int j=newcheckArrList.size(); j<oldList.size(); j++)
							System.out.println(newcheckArrList.get(j));
						}
						
						sleep(100000); // 30초간격으로 스레드 실행
					}
				}catch (Exception e) {
					// TODO: handle exceptions
					e.printStackTrace();
				}
	}
	

}

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
						System.out.println(i*100 + "�� ���");
						HashSet hscheck = new HashSet(p.goodsSearch(keyword));		//�콬���� �����ؼ� �ߺ��� Ű���� ���� ����
						newcheckArrList = new ArrayList<Data>(hscheck);	//���ο� ��̸���Ʈ�� �ٽ� ����
					
						if(oldList.size() < newcheckArrList.size())
						{
							//gap =  newcheckArrList.size() - oldList.size();
						
						for(int j=newcheckArrList.size(); j<oldList.size(); j++)
							System.out.println(newcheckArrList.get(j));
						}
						
						sleep(100000); // 30�ʰ������� ������ ����
					}
				}catch (Exception e) {
					// TODO: handle exceptions
					e.printStackTrace();
				}
	}
	

}

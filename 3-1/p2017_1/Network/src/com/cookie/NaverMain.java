package com.cookie;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.beans.Data;
import com.beans.Parser;

public class NaverMain  {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
//		Thread  rn = new Renew();
//		rn.start();
		 Parser p = new Parser();
		 
		 System.out.println("���̹� �ǽð� �˻���");
		 for (int i = 0; i< 20; i++)
	            System.out.println((i+1) + "�� " + p.getNaver().get(i)); // getNaver()���� ������ ��̸���Ʈ�� ���.
		 

		
		
	}
	
}


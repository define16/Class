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

		 System.out.println("���� �ǽð� �˻���");
		 for (int i = 0; i< 10; i++)
	            System.out.println((i+1) + "�� " + p.getDaum().get(i));  // getDaum()���� ������ ��̸���Ʈ�� ���.
		 
		
	}

	
}

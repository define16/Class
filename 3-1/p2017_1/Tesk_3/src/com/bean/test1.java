package com.bean;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		int s;
		s = p.goodsSearch("��Ʈ").size();

		for(int i = 0;i<s;++i)
		{
		    System.out.println(p.goodsSearch("��Ʈ").get(i));
			
		}
	}

}

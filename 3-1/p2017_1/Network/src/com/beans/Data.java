package com.beans;

public class Data {
	String keyword, link;

	public Data(String keyword, String link)
	{
		this.keyword = keyword;
		this.link = link;
	}
	
	public Data(String link)
	{
		this.link = link;
	}
	
	public String getkeyword()
	{
		return keyword;
	}
	public void setkeyword(String keyword)
	{
		this.keyword = keyword;
	}
	
	public String getLink()
	{
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}

	public boolean equals(Object obj)
	{
		Data d = (Data)obj;
		return d.getkeyword().equals(keyword) &&
				d.getLink().equals(link);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("인기 검색어  : %s, 링크 : %s",keyword,link);
	} // toString을 오버라이딩헤서 출력되는 값의 형태를 바뀌준다.

}

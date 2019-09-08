package GameData;

import java.util.ArrayList;

public class Data {
	private String[] date;
	private ArrayList<String[]> keywordset;
	private String[] keywords;
	private String[] count;
	private ArrayList<String[]> skeywordset;
	
	public Data () {
		keywordset = new ArrayList<String[]>();
		skeywordset = new ArrayList<String[]>();
	}
	
	public String[] getDate() {
		return date; //
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public ArrayList<String[]> getKeywordset() { //
		return keywordset;
	}
	public void makeKeywordset(String[] keyword, String[] count) { // �뜲�씠�꽣瑜� 吏묒뼱�꽔�쓣�븣 1:1 留ㅼ묶 
		keywordset.add(keyword);
		keywordset.add(count);
		for(int i = 0; i < keyword.length; i++)
			System.out.println(keyword[i] + " : " + (count[i]) );
		
	}

	public String[] getCount() {
		return count;
	}

	public void setCount(String[] count) {
		this.count = count;
	}

	
	public ArrayList<String[]> getSkeywordset() { // 
		return skeywordset;
	}
	public void setSkeyword(String[] skeyword) {
		keywordset.add(skeyword);
	}
	
	
	public String[] makeKeywords(String keyword) {
		keywords = keyword.split(",");
//		for(int i = 0; i < keywords.length; i++) {
//            System.out.println("one index " + i + " : value " + keywords[i]);
//        }
		return keywords;
	}

	public String[] getKeywords() {
		return keywords;
	}

	
	
	
}

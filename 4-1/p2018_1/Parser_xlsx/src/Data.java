import java.util.ArrayList;

public class Data {
	private String[] year;
	private String[] quarter;
	private String[] category;
	private String[] keywords;
	private String[] count;
	
	private ArrayList<String[]> keywordset;
	private ArrayList<String[]> skeywordset;
	
	public Data () {
		keywordset = new ArrayList<String[]>();
		skeywordset = new ArrayList<String[]>();
	}
	
	public String[] getYear() {
		return year;
	}

	public void setYear(String[] year) {
		this.year = year;
	}

	public String[] getQuarter() {
		return quarter;
	}

	public void setQuarter(String[] quarter) {
		this.quarter = quarter;
	}
	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public String[] getCount() {
		return count;
	}

	public void setCount(String[] count) {
		this.count = count;
	}

	public String[] getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public ArrayList<String[]> getKeywordset() {
		return keywordset;
	}
	
	public void setKeywordset(ArrayList<String[]> keywordset) {
		this.keywordset = keywordset;
	}

	public void makeKeywordset(String[] year, String[] quarter, String[] category, String[] keyword, String[] count) {
		keywordset.add(year);
		keywordset.add(quarter);
		keywordset.add(category);
		keywordset.add(keyword);
		keywordset.add(count);
	}
	
	public void makeKeywordset(String[] keyword) {
		keywordset.add(keyword);
	}
	
	public ArrayList<String[]> getSkeywordset() {
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
	
	
}

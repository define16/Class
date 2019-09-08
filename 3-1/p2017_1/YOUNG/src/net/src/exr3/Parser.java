package exr3;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
	// public static ArrayList<Data> goodSearcha = new ArrayList<Data>();
	public static String url = "http://finance.daum.net/item/main.daum?code=";
	public static String keyword = "";
	public static String keyword2 = "";
	public static Elements root2 = null;
	public static Elements currentr = null;
	public static Elements dealr = null;
	public static Elements stock = null;
	public static Elements price = null;
	public static Elements price2 = null;
	public static Elements price3 = null;
	public static Elements eprice = null;
	public static Elements imgr = null;
	public static String im = null;

	public static void goodSearch() {
		String result = url + keyword;
		InputStream in = URLManager.getURLInputStream(result, URLManager.ENCODING_UTF8);
		int flag = 0;
		keyword2 = keyword;
		try {
			Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8, "");
			Elements root = doc.select("a");
			Elements roott = doc.select("em[class=team_lft]");
	
			roott.get(0).text();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

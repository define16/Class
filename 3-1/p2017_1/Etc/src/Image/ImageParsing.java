package Image;

import java.io.InputStream;

import javax.swing.ImageIcon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cookie.URLManager;

public class ImageParsing {

	
	public static void main(String[] args)
	{
		String url = "http://zangsisi.net/";
		InputStream in = URLManager.getURLInputStream(url, URLManager.USER_AGENT_PC);
		
		try{
			Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
			Elements root = doc.select("div[class=separator]");
			Elements rankList = root.select("a");
			String Slink = null;
			byte[] image = URLManager.getImage(
		            //"http://imgcomic.naver.net/webtoon/626907/150/20170530222449_dde31e05da4adb37afe9667b09ce4651_IMAG01_31.jpg",
		            //"http://comic.naver.com/"
					Slink,
		    		  "http://zangsisi.net/"
		    		  );
			
	
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}

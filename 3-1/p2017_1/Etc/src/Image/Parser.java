package Image;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cookie.URLManager;

public class Parser {

	public static ArrayList<Data>webview()
	{
		ArrayList<Data> da = new ArrayList<>();
		String url = "http://zangsisi.net/?p=118515";
		InputStream in = URLManager.getURLInputStream(url, URLManager.USER_AGENT_PC);
		
		try{
			Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
			Elements root = doc.select("div[class=separator]");
			Elements rankList = root.select("a");
			String Slink = null;
			System.out.println(rankList.first());
			for(int j = 0; j<rankList.size();++j){
				Slink = rankList.get(j).attr("href");
				System.out.println(Slink);
				byte[] img_data = URLManager.getImage(
			            //"http://imgcomic.naver.net/webtoon/626907/150/20170530222449_dde31e05da4adb37afe9667b09ce4651_IMAG01_31.jpg",
			            //"http://comic.naver.com/"
						Slink,
						url
			    		  );
				Data d = new Data(img_data);
				da.add(d);
			}
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}    
		
		return da;
	}
}

package Practice;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ww {
public static void main(String[] args) throws UnsupportedEncodingException{
   String temp = "¾Æ±¸";
   temp = URLEncoder.encode(temp, "utf-8");
   String Url = "http://library.hallym.ac.kr/search/tot/result?st=FRNT"
   		+ "&commandType=advanced&si=1&q="+temp+"&b0=and&wei"
   				+ "ght0=&si=2&q=&b1=and&weight1=&si=3&q=&weight2"
   				+ "=&lmt0=TOTAL&_lmt0=on&lmtsn=000000000001&lmtst=OR&_lmt0=on&_lm"
   				+ "t0=on&_lmt0=on&_lmt0=on&_lmt0=on&_lmt0=on&inc=TOTAL&_inc=on&_inc"
   				+ "=on&_inc=on&_inc=on&_inc=on&_inc=on&lmt1=TOTAL&lmtsn=000000000003"
   				+ "&lmtst=OR&lmt2=TOTAL&lmtsn=000000000015&lmtst=FRNT&rf=&rt=&range=0"
   				+ "00000000021&cpp=10&msc=500";
   Hiper.openUrl(Url);
   
}
}
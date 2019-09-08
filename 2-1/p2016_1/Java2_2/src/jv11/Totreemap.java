package  jv11;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Totreemap {
	public static void main(String[] args)
	{
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("이순자",new Integer(1));
		map.put("김홍길",new Integer(2));
		map.put("박철호",new Integer(3));
		map.put("최자인",new Integer(4));
		map.put("장자순",new Integer(5));
		System.out.println("HashMap : " + map);
		
		//HashMap을 TreeMap으로 변환하기
		Map<String, Integer> stmap = new TreeMap<String, Integer>();
		stmap.putAll(map);
		System.out.println("TreeMap : " + stmap);
	}
}

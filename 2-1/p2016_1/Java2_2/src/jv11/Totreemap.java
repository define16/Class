package  jv11;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Totreemap {
	public static void main(String[] args)
	{
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("�̼���",new Integer(1));
		map.put("��ȫ��",new Integer(2));
		map.put("��öȣ",new Integer(3));
		map.put("������",new Integer(4));
		map.put("���ڼ�",new Integer(5));
		System.out.println("HashMap : " + map);
		
		//HashMap�� TreeMap���� ��ȯ�ϱ�
		Map<String, Integer> stmap = new TreeMap<String, Integer>();
		stmap.putAll(map);
		System.out.println("TreeMap : " + stmap);
	}
}

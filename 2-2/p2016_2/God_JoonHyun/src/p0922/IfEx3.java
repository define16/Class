package p0922;

public class IfEx3 
{
	public static void main(String[] args) 
	{
		int su1 = 10;
		String res;

		if(su1 >= 41)
			res = "���";
		else if(su1 >= 11)
			res = "�߱�";
		else if(su1 >= 0)
			res = "�ʱ�";
		else
			res = "����";

		System.out.println(res + "�Դϴ�.");
	}
}

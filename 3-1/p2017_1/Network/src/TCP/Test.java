package TCP;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1)
		{
			System.out.println("IP �ּҳ� ������ �ּҸ�  ���ڷ� ���ϼ���");
			System.exit(0);
		}
		
		InetAddress inetaddr[] = null;
		try{
			inetaddr = InetAddress.getAllByName(args[0]);
		}catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for(int i = 0; i<inetaddr.length; i++)
		{
			System.out.println(inetaddr[i].getHostName());
			System.out.println(inetaddr[i].getHostAddress());
			System.out.println(inetaddr[i].toString());
			System.out.println("-----------------------------------");
		}
	
	}

}

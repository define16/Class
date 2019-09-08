package beans;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPadress {
	String IPAdress;
	
	public IPadress() throws SocketException {
		 
		 Enumeration<NetworkInterface> nienum = NetworkInterface.getNetworkInterfaces();
		  int i = 0;
		        while (nienum.hasMoreElements()) {
		            NetworkInterface ni = nienum.nextElement();
		            Enumeration<InetAddress> kk = ni.getInetAddresses();
		            
		            while (kk.hasMoreElements()) {
		       InetAddress inetAddress = (InetAddress) kk.nextElement();
		       if(i == 2) {
		    	   IPAdress = inetAddress.getHostAddress();
			    }
		       	i++; 
			     
		       }

		   }
	}
	public String getIPAdress() {
		return IPAdress;
	}

	public void setIPAdress(String iPAdress) {
		IPAdress = iPAdress;
	}


	
	
}

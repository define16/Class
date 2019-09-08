package beans;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class test {
	  
	public static void main(String args[]){
		
		String birthday = "19921230";

		System.out.println(birthday.substring (0,4)+"/");
		System.out.println(birthday.substring (4,6)+"/");
		System.out.println(birthday.substring (6,7)+"/");
		System.out.println(birthday.substring (7,8)+"/");
		
		
		if(!birthday.substring (0,2).equals("19")  && !birthday.substring (0,2).equals("20")) {
			
			System.out.println("앞에 2글자오류!");
		}
		else if(!birthday.substring (4,5).equals("0")  && !birthday.substring (4,5).equals("1")) {
			
			System.out.println("월이 잘못됨!");
		}
		else if(!birthday.substring (6,7).equals("0")  && !birthday.substring (6,7).equals("1") && !birthday.substring (6,7).equals("2") && !birthday.substring (6,7).equals("3")) {
			
			System.out.println("일이 잘못됨!");
		}
		
		else {
			if(birthday.substring (4,5).equals("1") && !birthday.substring (5,6).equals("0") && !birthday.substring (5,6).equals("1") && !birthday.substring (5,6).equals("2")) {
				System.out.println("12월 초과함!");
			}
			else if(birthday.substring (4,5).equals("0") && birthday.substring (5,6).equals("0")) {
				System.out.println("월이 잘못됨!");
				
			}
			else if(birthday.substring (6,7).equals("3") && !birthday.substring (7,8).equals("0") && !birthday.substring (7,8).equals("1")) {
				System.out.println("31일 초과함!");
			}
			else if(birthday.substring (6,7).equals("0") && birthday.substring (7,8).equals("0")) {
				System.out.println("일이 잘못됨!");
			}
			else if(!birthday.substring (0,4).equals("1988") && !birthday.substring (0,4).equals("1992") && !birthday.substring (0,4).equals("1996") &&
					!birthday.substring (0,4).equals("2000") && birthday.substring (4,6).equals("02")) {
				if(birthday.substring (6,8).equals("29") || birthday.substring (6,7).equals("3")) {
					System.out.println("28일까지 있다.");
				}
				else {
					System.out.println("오류없음1");
				}
			}
			else if(birthday.substring (0,4).equals("1988") || birthday.substring (0,4).equals("1992") || birthday.substring (0,4).equals("1996") ||
					birthday.substring (0,4).equals("2000") ) {
				if(birthday.substring (4,6).equals("02") && !birthday.substring (6,7).equals("0") && !birthday.substring (6,7).equals("1") && !birthday.substring (6,7).equals("2")) {
					System.out.println("29일까지 있다.");
				}
				else {
					System.out.println("오류없음3"); 
				}
				
			}
			else if(birthday.substring (4,6).equals("04") || birthday.substring (4,6).equals("06") || birthday.substring (4,6).equals("09") || birthday.substring (4,6).equals("11")) {
				if(birthday.substring (6,7).equals("3") && !birthday.substring (7,8).equals("0")) {
					System.out.println("31일이 업슴");
				}else {
					System.out.println("오류없음2"); 
				}
			}
			
			else {
				System.out.println("오류없음"); 
			}
		}
	}
	
	
}

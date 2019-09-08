package chat;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		long endTime =  System.currentTimeMillis() + 5;
		System.out.println(startTime);
		System.out.println(endTime);
		
		System.out.println(endTime == startTime);
		for(int i = 0; i<5; i++) {
			startTime++;
		}
		System.out.println(endTime);
		System.out.println(startTime);
		System.out.println(endTime == startTime);
	}

}

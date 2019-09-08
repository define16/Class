package jv01;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data;
		char c;

		data=78;

		if(data>=90 && data<=100)
			c = 'A';
		else if(data>=80 && data<=89)
			c = 'B';
		else if(data>=70 && data<=79)
			c = 'C';
		else if(data>=60 && data<=69)
			c = 'D';
		else
			c = 'F';

		System.out.println("당신의 학점은 " + c + "입니다.");
	}

}

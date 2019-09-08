package p0927;

public class ExIf5 {
	public static void main(String[] args) {

		int sum, data1, data2, data3;
		char c;
		double data;

		// 메인 함수의 매개변수에 의해 인수값을 3개 입력한 후
		// 세 수의 합과 평균, 학점을 출력하세요.

		data1 = Integer.parseInt(args[0]);
		data2 = Integer.parseInt(args[1]);
		data3 = Integer.parseInt(args[2]);

		sum = data1 + data2 + data3;
		data = sum / 3;
		//data = 78;
		data = (double)sum/3;

		if(data >= 90 && data <= 100)
			c = 'A';
		else if(data >= 80 && data <= 89)
			c = 'B';
		else if(data >= 70 && data <= 79)
			c = 'C';
		else if(data >= 60 && data <= 69)
			c = 'D';
		else
			c = 'F';


		System.out.println("세 수의 합 : " + sum + "점 입니다.");
		System.out.format("평균은 %.2f, ",data);
		System.out.println("당신의 학점은 " + c + "입니다.");
	}
}

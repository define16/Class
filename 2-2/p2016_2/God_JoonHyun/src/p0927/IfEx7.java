package p0927;

public class IfEx7 {
	public static void main(String[] args) {

		int sum, data1, data2, data3;
		char c;
		double data;
		String name;

		name = args[0];
		data1 = Integer.parseInt(args[1]);
		data2 = Integer.parseInt(args[2]);
		data3 = Integer.parseInt(args[3]);

		sum = data1 + data2 + data3;
		data = sum / 3;
		data = (double)sum/3;

		if(data >= 90 && data <= 100)
			c = 'A';
		else if(data >= 80 && data < 90)
			c = 'B';
		else if(data >= 70 && data < 80)
			c = 'C';
		else if(data >= 60 && data < 70)
			c = 'D';
		else
			c = 'F';


		System.out.println(name + "님 당신의 성적은 " + data1 + ", " + data2 + ", " + data3 + "이고,");
		System.out.println("입력하신 데이터의 합은 " + sum);
		System.out.format("평균은 %.2f, ",data);
		System.out.println("학점은 " + c + "입니다.");
	}
}

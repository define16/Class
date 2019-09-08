package p0927;

public class SwitchEx1 {
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


		switch((int)data/10)
		{
			case 10:
			case 9:
				c = 'A'; break;
			case 8:
				c = 'B'; break;
			case 7:
				c = 'C'; break;
			case 6:
				c = 'D'; break;
			default :
				c = 'F'; break;
		}


		System.out.println(name + "님 당신의 성적은 " + data1 + ", " + data2 + ", " + data3 + "이고,");
		System.out.println("입력하신 데이터의 합은 " + sum);
		System.out.format("평균은 %.2f, ",data);
		System.out.println("학점은 " + c + "입니다.");
	}
}

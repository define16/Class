package p1006;
import java.util.Scanner;

public class Te4 {
	public static void main(String[] args) {

		String name; //이름
		float[] num;
		float sum, avr; //합, 평균

		num = new float[3];
		sum = 0; avr = 0;

		//Scanner 선언
		Scanner sc = new Scanner(System.in);


		System.out.print("이름을 입력하세요. : ");
		name = sc.nextLine(); //이름 입력

		for(int i = 0; i<3; i++)
		{
			System.out.print(i+1 + "번째 실수를 입력하세요. : ");
			num[i] = sc.nextFloat(); //실수 입력1, 2, 3
			sum += num[i];
		}

		avr = sum / 3;

		System.out.println("이름 : " + name);
		System.out.printf("세 실수 값의 합 : %.2f", sum);
		System.out.println();
		System.out.printf("세 실수 값의 평균 : %.2f", avr);

	}
}


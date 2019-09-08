package A160922;


public class Test {
	public static void main(String[] args) {
		String a = "æ»≥Á«œººø‰";
		char[] as = a.toCharArray();

		for (int i = 0; i < as.length; i++) {
			System.out.println(as[i]);
		}
	}
}


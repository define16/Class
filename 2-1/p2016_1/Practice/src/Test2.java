
public class Test2 {
	public static void main(String []args){
		int i;
		char c;
		i = 78;
		
	switch(i/10){
	case 10:
	case 9:
		c = 'A';
	break;
	case 8:
		c = 'B';
	break;
	case 7:
		c = 'C';
	break;
	case 6:
		c = 'D';
	break;
	default:
		c = 'F';
	break;
		}
	System.out.println("ÇÐÁ¡ = " + c);
	}
}
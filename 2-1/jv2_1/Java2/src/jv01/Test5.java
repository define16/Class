package jv01;

public class Test5 {

	public static void main(String[] args) {
		// C:\>java Test5 ±èÀºÁÖ 78 100 90
		// ±èÀºÁÖ ´Ô ´ç½ÅÀÇ ¼ºÀûÀº ÃÑÁ¡[   ], Æò±Õ[   ], ÇÐÁ¡ [  ]ÀÔ´Ï´Ù.		
		
		int d1, d2, d3;
		int data, sum;
		char c;

		d1 = Integer.parseInt(args[1]);
		d2 = Integer.parseInt(args[2]);
		d3 = Integer.parseInt(args[3]);
		
		sum  = d1+d2+d3;
		data = sum/(args.length-1);
		
		switch(data/10)
		{
			case 10:
			case 9: c='A'; break;
			case 8: c='B'; break;
			case 7: c='C'; break;
			case 6: c='D'; break;
			default :
				c = 'F';
		}
		System.out.print(args[0] + "´Ô ´ç½ÅÀÇ ¼ºÀûÀº ÃÑÁ¡[" +sum +"],");
		System.out.println("Æò±Õ[" + data + "],ÇÐÁ¡["+ c +"]ÀÔ´Ï´Ù.");
		
	}

}
package Report2;

class calculation
{
	static void Equation(int n,double x)
	{
		
		double sum = 1;
		for(int i = n; i > 0; i--)
		{
		sum = 1 + (sum * x);
		}
		
		System.out.println("n = " + n + " ÇÔ¼ö°ª  : " + sum);
		}
}
public class Horner extends calculation {
	
		public static void main(String[] args){
			
			Horner hor = new Horner();
			hor.Equation(10,1.1);
			hor.Equation(100,1.1);
			hor.Equation(1000,1.1);
		}
	}

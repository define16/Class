package Report3;

public class Polynomial 
{
	
	private int[] coef; 
    private int deg;  

    public Polynomial(int a, int b) 
    {
        coef = new int[b+1];
        coef[b] = a;
        deg = degree();
	}

	public void polynomial(int a, int b) 
    {
        coef = new int[b+1];
        coef[b] = a;
        deg = degree();
    }

    public int degree()
    {
        int d = 0;
        for (int i = 0; i < coef.length; i++)
            if (coef[i] != 0) d = i;
        return d;
    }

    // 문자열 표현
    public String toString() 
    {
        if (deg ==  0) return "" + coef[0];
        if (deg ==  1) return coef[1] + "x + " + coef[0];
        String s = coef[deg] + "x^" + deg;
        for (int i = deg-1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + ( coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }
    
    
    public Polynomial polynomialAdd(Polynomial b)
    {
    	Polynomial a = this;
    	Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
    	
        for (int i = 0; i <= a.deg; i++) 
        	c.coef[i] += a.coef[i];
        
        for (int i = 0; i <= b.deg; i++)
        	c.coef[i] += b.coef[i];
        
        c.deg = c.degree();
        return c;
    }
    
    public Polynomial polynomialMuti(Polynomial b)
    {
    	Polynomial a = this;
    	Polynomial c = new Polynomial(0, a.deg + b.deg);
	        for (int i = 0; i <= a.deg; i++)
	            for (int j = 0; j <= b.deg; j++)
	                c.coef[i+j] += (a.coef[i] * b.coef[j]);
	        c.deg = c.degree();
	        return c;
    }
    
    public int polynomialeEvaluate(int x) {
        int p = 0;
        for (int i = deg; i >= 0; i--)
            p = coef[i] + (x * p);
        return p;
    }
    
    public static void main(String[] args) { 
    	Polynomial p0 = new Polynomial(0, 0);
    	Polynomial p1   = new Polynomial(4, 5);
    	Polynomial p2   = new Polynomial(6, 2);
    	Polynomial p3   = new Polynomial(9, 0);
    	Polynomial p4   = new Polynomial(1, 1);
    	Polynomial p    = p1.polynomialAdd(p2).polynomialAdd(p3).polynomialAdd(p4);   

    	Polynomial q1   = new Polynomial(3, 2);
    	Polynomial q2   = new Polynomial(3, 0);
    	Polynomial q    = q1.polynomialAdd(q2);                    


    	Polynomial r    = p.polynomialAdd(q);
    	Polynomial s    = p.polynomialMuti(q);

        System.out.println("p(0) = " + p0);
        System.out.println("p(x) = " + p);
        System.out.println("q(x) = " + q);
        System.out.println("p(x) + q(x) = " + r);
        System.out.println("p(x) * q(x) = " + s);
        System.out.println("p(4) = " + p.polynomialeEvaluate(4));
   }

}

    


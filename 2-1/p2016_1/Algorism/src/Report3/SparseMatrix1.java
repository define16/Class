package Report3;

public class SparseMatrix1 {
	int Nrows, Ncols, Nterms, idx;
	Triple1[] a;
	
	public SparseMatrix1(int rows, int cols, int terms){
		Nrows = rows; Ncols = cols; Nterms = terms;
		idx = 0;
		a= new Triple1[Nterms];
	}
	
	public void displayMatrix(){
		
		System.out.println("Number of rows : "+Nrows);
		System.out.println("Number of columns : "+Ncols);
		System.out.println("Number of non-zero terms : "+Nterms);
		
		for ( int i =0; i < Nterms; i++)
			System.out.println("["+i+"]"+" "+a[i].row+" "+a[i].col+" " +a[i].value);
	}
	
	public void storeTriple(int r, int c, int v) {
		if (idx >= Nterms){
			System.out.println("Error : too many terms..");
			System.exit(-1);
		}
		a[idx++] = new Triple1(r,c,v);
	}
	
	public SparseMatrix1 transpose(){
		int i,j;
		int [] RowTerms = new int[Ncols];
		int [] RowBegins = new int[Ncols];
		SparseMatrix1 b = new SparseMatrix1( Ncols, Nrows, Nterms);
		if (Nterms > 0) {
			for ( i=0; i< Ncols; i++) RowTerms[i] = 0;
			for (i=0; i<Nterms; i++) RowTerms[a[i].col]++;
			RowBegins[0] = 0;
			for(i=1; i <Ncols; i++)
				RowBegins[i] = RowBegins[i-1]+RowTerms[i-1];
			for(i=0; i< Nterms; i++){
				j = RowBegins[a[i].col]++;
				b.a[j] =
						new Triple1(a[i].col,a[i].row, a[i].value);
			}
		}
		return b;
	}
}
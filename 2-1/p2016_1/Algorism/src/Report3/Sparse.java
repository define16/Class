package Report3;

 class MatrixTrio
{
	int row, col, value;
	
	public MatrixTrio()
	{
		row = col = value = 0;
	}
	
	public MatrixTrio(int r, int c, int val)
	{
		row = r;
		col = c; 
		value = val;
	}
}

 class Sparse {
	
	int Nrow, Ncol, Ntrio, Index;
	MatrixTrio[] spArray;

	
	public Sparse(int row_arg, int col_arg, int trio_arg)
	{
		Nrow = row_arg;
		Ncol = col_arg;
		Ntrio = trio_arg;
		Index = 0;
		spArray = new MatrixTrio[Ntrio];
	}
	
	public void displayMatrix()
	{
		System.out.println("Number of rows : " + Nrow);
		System.out.println("Number of cols : " + Ncol);
		System.out.println("Number of non-zero elemnts : " + Ntrio);
		
		for(int i = 0; i<Ntrio;i++)
		{
			System.out.println("["+ i + "] " + spArray[i].row + spArray[i].col + spArray[i].value);
			
		}
		
	}
	
	public void storeTrio(int r, int c, int val)
	{
		if(Index >= Ntrio)
		{
			System.out.println("ERROR : Too many Trios..");
			System.exit(-1);
			
		}
		spArray[Index++] = new MatrixTrio( r, c, val);
		
	}
	
	public Sparse spTransPose() 
	{
		int i,j;
		int [] RowTrios = new int[Ncol];
		int [] RowStart = new int[Ncol];
		Sparse b = new Sparse(Ncol,Nrow,Ntrio);
		
		if(Ntrio > 0)
		{
			for( i = 0; i <Ncol; i++)
				RowTrios[i] = 0;
			for( i = 0; i<Ncol; i++)
				RowTrios[spArray[i].col] = 0;
			RowStart[0] = 0;
			
			for( i = 0; i<Ncol; i++)
				RowTrios[i] = 0;
			
			for( i = 0; i<Ncol; i++)
				RowStart[i] = RowStart[i-1]+RowTrios[i-1];
			for( i = 0; i<Ncol; i++)
			{
				j = RowStart[spArray[i].col];
			b.spArray[j] = new MatrixTrio(spArray[i].col, spArray[i].row, spArray[i].value);
			}
		}
		return b;
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sparse b;
		Sparse a = new Sparse(7,6,8);
		
		a.storeTrio(0, 0,76);
		a.storeTrio(0, 4,13);
		a.storeTrio(2, 5,3);
		a.storeTrio(3, 1,25);
		a.storeTrio(4, 0,-19);
		a.storeTrio(4, 3,56);
		a.storeTrio(5, 5,13);
		a.storeTrio(6, 2,3);
		
		a.displayMatrix();
		b = a.spTransPose();
		b.displayMatrix();
		
	}
}



package Report3;

public class SparseTrans1 {
	public static void main(String[] args) {
		SparseMatrix1 b;
		SparseMatrix1 a= new SparseMatrix1(7,6,8);
		// TODO Auto-generated method stub
		
		a.storeTriple(0, 0, 76);
		a.storeTriple(0, 4, 13);
		a.storeTriple(2, 5, 3);
		a.storeTriple(3, 1, 25);
		a.storeTriple(4, 0, -19);
		a.storeTriple(4, 3, 56);
		a.storeTriple(5, 5, 13);
		a.storeTriple(6, 2, 3);
		
		a.displayMatrix();
		b = a.transpose();
		b.displayMatrix();
	}
}


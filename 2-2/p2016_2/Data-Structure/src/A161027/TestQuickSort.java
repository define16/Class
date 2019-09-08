package A161027;


public class TestQuickSort {
	public TestQuickSort() {
		int[] a = IntArrays.randomInts(50000000, 500000000);
		//IntArrays.print(a);
		System.out.println("sorted: " + IntArrays.isSorted(a));
	    Quicksort(a, 0, a.length-1); //a.length=7
	   //IntArrays.print(a);
		System.out.println("sorted: " + IntArrays.isSorted(a));
	}
	
	void Quicksort(int[] a, int p, int r) {
		int m;
		if(p>=r)
			return;
		m = partition(a, p, r);
		Quicksort(a,p,m-1);
		Quicksort(a,m+1,r);
		
	}

	int partition(int[] a, int p, int r) {
		int i, middle, pivot,temp;
		
		middle = (p+r)/2;
		pivot = a[middle];
		a[middle] = a[p];
		a[p] = pivot;
		i = p;
		
		for(int k = p+1;k<=r;k++)
		{
			if(a[k] < pivot)
			{
				i++;
				temp = a[i];
				a[i] = a[k];
				a[k] = temp;
			}
		}
		temp = a[p];
		a[p] = a[i];
		a[i] = temp;
		
		return i;
	}
}
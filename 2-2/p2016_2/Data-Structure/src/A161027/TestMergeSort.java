package A161027;


public class TestMergeSort {
	public TestMergeSort() {
		int[] a = IntArrays.randomInts(20, 100);
		IntArrays.print(a);
		System.out.println("sorted: " + IntArrays.isSorted(a));

		Mergesort(a, 0, a.length);

		IntArrays.print(a);
		System.out.println("sorted: " + IntArrays.isSorted(a));
		

	    
	}

	void Mergesort(int[] a, int p, int q) {

		if (q - p < 2)
			return;
		int m = (p + q) / 2;
		Mergesort(a, p, m);
		Mergesort(a, m, q);
		merge(a, p, m, q);
	}

	void merge(int[] a, int p, int q, int r) {
		if (a[q - 1] <= a[q])
			return;
		int i = p, j = q, k = 0;
		int[] aa = new int[r-p];
		while (i < q && j < r)
		{
			// ºóÄ­À» Ã¤¿ì½Ã¿À
			if (i < q)
				aa[k++] = a[i++];
			else
				aa[k++] = a[j++];
		}
		while(i<=q)
			aa[k++] = a[i++];
		while(j<=r)
			aa[k++] = a[i++];
		
		i = p;
		k = 0;
	
		while(i<r)
			a[i++] = aa[k++];
		
		System.arraycopy(aa, 0, a, p, k);
	}
}

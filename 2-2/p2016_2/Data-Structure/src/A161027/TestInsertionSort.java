package A161027;


public class TestInsertionSort {
  public TestInsertionSort() {
	 int[] a = IntArrays.randomInts(10000000,10000000);
    IntArrays.print(a);
    System.out.println("sorted: " + IntArrays.isSorted(a));

    Insertionsort(a);

    IntArrays.print(a);
    System.out.println("sorted: " + IntArrays.isSorted(a));
    

  }

  void Insertionsort(int[] a) {
    for (int i=1; i<a.length; i++) {
      int ai=a[i], j=i-1;
     while(j>=0 && ai <a[j])
     {
    	 a[j+1] = a[j];
    	 j--;
     }
     a[j+1] = ai;
    }
  }

}
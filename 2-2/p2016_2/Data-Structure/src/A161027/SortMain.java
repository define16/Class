package A161027;

public class SortMain {
	public static void main(String[] args) {
		long start, end;
		
	/*	System.out.println("The Insertion Sort");	
		start = System.currentTimeMillis();
        new TestInsertionSort();
        end = System.currentTimeMillis();
        System.out.println("정렬시 걸리는 시간 : " + (end - start) + "(milli Second)");
   */
		

/*		System.out.println("The Merge Sort");	
		start = System.currentTimeMillis();
        new TestMergeSort();
        end = System.currentTimeMillis();
        System.out.println("정렬시 걸리는 시간 : " + (end - start) + "(milli Second)");
		*/
	
  		System.out.println("The Quick Sort");	
		start = System.currentTimeMillis();
        new TestQuickSort();
        end = System.currentTimeMillis();
        System.out.println("정렬시 걸리는 시간 : " + (end - start) + "(milli Second)");
 
	}
}

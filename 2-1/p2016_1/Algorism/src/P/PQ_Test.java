package P;

import java.util.Scanner;

public class PQ_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue PQ = new PriorityQueue();
		//
		PQ.insert(25);
		PQ.insert(15);
		PQ.insert(7);
		PQ.insert(13);
		PQ.insert(8);
		PQ.insert(3);
		PQ.insert(5);
		PQ.insert(4);
		PQ.insert(9);
		PQ.insert(2);
		//
		System.out.println("initial heap");
		PQ.print_Heap();
		PQ.delete(); //
		System.out.println("the heap after deleting 1st maximum");
		PQ.print_Heap();
		PQ.delete();
		System.out.println("the heap after deleting 2nd maximum");
		PQ.print_Heap();
		PQ.delete();

		int no_of_data = 10;
		int out[] = new int[no_of_data];
		for (int i = 0; i <= no_of_data - 1; i++) {
			// 后沫阑 盲快技夸
		}
		
		
		// Print data in decreasing order
		System.out.println("Print data in decreasing order ");
		for ( 后沫阑 盲快技夸 ) {
			System.out.print(out[i] + " ");
		}
		System.out.println();
	
		// Print data in increasing order
		System.out.println("Print data in increasing order ");
		for ( 后沫阑 盲快技夸 ) {
			System.out.print(out[i] + " ");
		} // end of for

		
		Scanner input = new Scanner(System.in);
		System.out.println("\nWhat is the no of elements into the heap?");
		int no_of_data = input.nextInt();
		int out[] = new int[no_of_data];

		System.out.println("Insert n elements into the heap");
		for ( 后沫阑 盲快技夸 ) {
			 后沫阑 盲快技夸 
		}

		for (int i = 0; i <= no_of_data - 1; i++) {
			out[i] = PQ.delete();
		}

		// Print data in decreasing order
		System.out.println("Print data in decreasing order ");
		for ( 后沫阑 盲快技夸 ) {
			System.out.print(out[i] + " ");
		}
		System.out.println();

		// Print data in increasing order
		System.out.println("Print data in increasing order ");
		for ( 后沫阑 盲快技夸 ) {
			System.out.print(out[i] + " ");
		} // end of for

	}

}

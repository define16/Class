package week_9;

public class QAmain {
	public static void main(String args[]) {
		int i;
		// Queue Q = new Queue(); // error !!!
		ArrayQueue Q = new ArrayQueue();

		System.out.print("Queue�� �����ϴ� �͵�: ");
		for (i = 0; i < 10; i++) {
			Integer data = new Integer(i);
			System.out.print(data + " ");
			Q.enqueue(data);
			// Q.enqueue(i); // error !!!
		}
		System.out.print("\nQueue���� �����ϴ� �͵�: ");
		for (i = 0; i < 10; i++) {
			System.out.print(Q.dequeue() + " ");
			 // if (!Q.isEmpty()) { System.out.println(" not empty "); }
		}
		// System.out.println();
	} // end of main
} // end of QueueArray
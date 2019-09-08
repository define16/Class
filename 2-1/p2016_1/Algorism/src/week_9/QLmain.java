package week_9;

public class QLmain {

	public static void main(String args[]) {
		int i;
		ListQueue Q = new ListQueue();

		Q.enqueue("A");
		System.out.println("Q.peek: " + Q.peek());
		Q.enqueue("B");
		Q.enqueue("C");
		System.out.println("Q.dequeue: "+ Q.dequeue());
		Q.enqueue("D");
		System.out.println("Q.dequeue: "+ Q.dequeue());
		System.out.println("Q.dequeue: "+ Q.dequeue());
		System.out.println("Q.dequeue: "+ Q.dequeue());
		System.out.println("Q.peek: " + Q.peek());
		
		/*
		System.out.println("큐에서 삽입하는 것..\n");

		for (i = 0; i < 19; i++) {
			Integer data = new Integer(i);
			System.out.print(data + " ");
			Q.enqueue(data);
		}

		System.out.println("\n" + Q.peek());
		System.out.println("큐에서 삭제하는 것..\n");
		for (i = 0; i < 19; i++) {
			System.out.print(Q.dequeue() + " ");
		}
		*/
	}
}

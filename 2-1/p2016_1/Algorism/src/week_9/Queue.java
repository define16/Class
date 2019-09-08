package week_9;

public interface Queue {
	boolean isEmpty();
	void enqueue(Object x);
	Object dequeue();
	void remove();
	Object peek();
}
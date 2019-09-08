
package week_9;

public class ArrayQueue implements Queue {
	public int front; // 큐의 삭제 장소
	public int rear; // 큐의 삽입 장소
	public int count; // 큐의 원소 소
	public int queueSize; // 큐의(배열) 크기
	public int increment; // 배열 확장시의 배열의 크기
	public Object[] itemArray; // 객체 타입의 큐 원소를 위한 배열

	public ArrayQueue() // 무인자 큐 생성자  Create 메소드역할
	{
		front = 0;
		rear = 0;
		count = 0;
		queueSize = 5; // 초기화 큐의 크기
		increment = 10; // 배열의 확장 단위
		itemArray = new Object[queueSize];
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public void enqueue(Object x) // 큐에 새로운 원소 삽입
	{
		// 빈칸1을 채우시오 : mod 연산을 이용해 rear을 1증가
		rear = (rear + 1) % queueSize;
		if (count == queueSize)
			queueFull(); // 원소가 꽉 촸을 때
		// 빈칸2를 채우시오: rear 위치에 원소 x 삽입 // 새로운 원소 삽입
		itemArray[rear] = x;

		count++;
	}

	public void queueFull() // 배열이 만원일 때
	{
		int oldsize = queueSize; // 현재의 배열 크기를 기록
		queueSize += increment; // 새로운 배열 크기
		Object[] tempArray = new Object[queueSize]; // 확장된 크기의 임시 배열
		for (int i = 0; i < count; i++) // 임시 배열로 원소를 이동시킨다
		{
			// 빈칸3을 채우시오: front를 1씩 증가시킴
			front = (front+1) % oldsize;
			// 빈칸4를 채우시오: tempArray에 itemArray를 하나의 원소씩 복사
			tempArray[i] = itemArray[front];
		}
		itemArray = tempArray;
		front = queueSize - 1; //0이아님
		rear = count;
	}

	public Object dequeue() // 큐에서 원소를 삭제하고 반환한다
	{
		if (isEmpty()) return null;
		// 빈칸 5를 채우시오: mod 연산을 이용해 front를 1증가
		front = (front + 1) % queueSize;
		Object item = itemArray[front]; // 큐가 공백이 아닐 때
		count--;
		return item;
	}

	public void remove() {
		if (isEmpty())
			return;
		else
			count--;
	}

	public Object peek() // 큐에서 원소 값을 반환
	{
		if (isEmpty())
			return null;
		else
			return itemArray[(front+1) % queueSize];
	}
	
	public void print()
	{
		for(int i=0; i<queueSize; i++)
			System.out.println("itemArray[" + i + "]: " + itemArray[i]);
	}
}

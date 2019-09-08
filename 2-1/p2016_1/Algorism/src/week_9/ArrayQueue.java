
package week_9;

public class ArrayQueue implements Queue {
	public int front; // ť�� ���� ���
	public int rear; // ť�� ���� ���
	public int count; // ť�� ���� ��
	public int queueSize; // ť��(�迭) ũ��
	public int increment; // �迭 Ȯ����� �迭�� ũ��
	public Object[] itemArray; // ��ü Ÿ���� ť ���Ҹ� ���� �迭

	public ArrayQueue() // ������ ť ������  Create �޼ҵ忪��
	{
		front = 0;
		rear = 0;
		count = 0;
		queueSize = 5; // �ʱ�ȭ ť�� ũ��
		increment = 10; // �迭�� Ȯ�� ����
		itemArray = new Object[queueSize];
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public void enqueue(Object x) // ť�� ���ο� ���� ����
	{
		// ��ĭ1�� ä��ÿ� : mod ������ �̿��� rear�� 1����
		rear = (rear + 1) % queueSize;
		if (count == queueSize)
			queueFull(); // ���Ұ� �� �u�� ��
		// ��ĭ2�� ä��ÿ�: rear ��ġ�� ���� x ���� // ���ο� ���� ����
		itemArray[rear] = x;

		count++;
	}

	public void queueFull() // �迭�� ������ ��
	{
		int oldsize = queueSize; // ������ �迭 ũ�⸦ ���
		queueSize += increment; // ���ο� �迭 ũ��
		Object[] tempArray = new Object[queueSize]; // Ȯ��� ũ���� �ӽ� �迭
		for (int i = 0; i < count; i++) // �ӽ� �迭�� ���Ҹ� �̵���Ų��
		{
			// ��ĭ3�� ä��ÿ�: front�� 1�� ������Ŵ
			front = (front+1) % oldsize;
			// ��ĭ4�� ä��ÿ�: tempArray�� itemArray�� �ϳ��� ���Ҿ� ����
			tempArray[i] = itemArray[front];
		}
		itemArray = tempArray;
		front = queueSize - 1; //0�̾ƴ�
		rear = count;
	}

	public Object dequeue() // ť���� ���Ҹ� �����ϰ� ��ȯ�Ѵ�
	{
		if (isEmpty()) return null;
		// ��ĭ 5�� ä��ÿ�: mod ������ �̿��� front�� 1����
		front = (front + 1) % queueSize;
		Object item = itemArray[front]; // ť�� ������ �ƴ� ��
		count--;
		return item;
	}

	public void remove() {
		if (isEmpty())
			return;
		else
			count--;
	}

	public Object peek() // ť���� ���� ���� ��ȯ
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

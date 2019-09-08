package week_9;

class ListNode {
	Object data;
	ListNode link;
}

public class ListQueue implements Queue {
	private ListNode front;// ť���� front ����
	private ListNode rear;// ť���� rear ����
	private int count;// ť�� ���Ҽ�

	public ListQueue() {// ListQueue�� ���� ���� ������ Create �޼ҵ忪��
		front = null;
		rear = null;
		count = 0;
	}

	public boolean isEmpty() {// �������� �ƴ��� �˻�
		return (count == 0);
	}

	public void enqueue(Object x) {// ť�� ���� x�� �����Ѵ�
		ListNode newNode = new ListNode();
		newNode.data = x;
		newNode.link = null;

		if (count == 0) {// ť�� ������ ��
			front = rear = newNode;
		} else {// ������ �ƴ� ��		
			// ��ĭ1�� ä��ÿ�: rear�� link�� newNode�� ����Ŵ
			rear.link = newNode;
			// ��ĭ2�� ä��ÿ�: rear�� newNode�� ����Ŵ
			rear = newNode;
		}
		count++;
	}

	public Object dequeue() {// ť���� ���Ҹ� �����ϰ� ��ȯ
		if (count == 0)
			return null;
		// ��ĭ3�� ä��ÿ�: Object Ÿ���� ������ front�� data�� ����
		Object item =  front.data;
		// ��ĭ4�� ä��ÿ�: front�� ���� ���Ҹ� ����Ŵ 
		front = front.link;
		if (front == null) {// ����Ʈ�� ��带 ���� �� ������ �� ���
			rear = null;
		}
		count--;
		return item;
	}

	public void remove() {// ť���� ���Ҹ� ����
		if (isEmpty())
			return;// ť���� ���� ������ �������� �ƴ��� �˻��Ͽ� ��ȯ�Ѵ�
		
		// ť���� ���Ҹ� �����ϴ� �κ��� �����Ͻÿ�.
		// ��ĭ5�� ä��ÿ�.
		Object item = front.data;
		front = front.link;
		// ��ĭ6�� ä��ÿ�: if�� ���
		if(front == null)
			rear = null;
		// ��ĭ7�� ä��ÿ�.
		count--;
	}

	public Object peek() {// ť���� �� ���Ҹ� Ž���Ѵ�

		if (count == 0)
			return null;// �� ���Ҽ��� 0���̸� null ��ȯ
		else
			return front.data;// �׷��� ������ data�� ��ȯ�Ѵ�.
	}
}

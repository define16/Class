package week_9;

class ListNode {
	Object data;
	ListNode link;
}

public class ListQueue implements Queue {
	private ListNode front;// 큐에서 front 원소
	private ListNode rear;// 큐에서 rear 원소
	private int count;// 큐의 원소수

	public ListQueue() {// ListQueue에 대한 무인 생성자 Create 메소드역할
		front = null;
		rear = null;
		count = 0;
	}

	public boolean isEmpty() {// 공백인지 아닌지 검사
		return (count == 0);
	}

	public void enqueue(Object x) {// 큐에 원소 x를 삽입한다
		ListNode newNode = new ListNode();
		newNode.data = x;
		newNode.link = null;

		if (count == 0) {// 큐가 공백일 때
			front = rear = newNode;
		} else {// 공백이 아닐 때		
			// 빈칸1을 채우시오: rear의 link가 newNode를 가리킴
			rear.link = newNode;
			// 빈칸2를 채우시오: rear가 newNode를 가리킴
			rear = newNode;
		}
		count++;
	}

	public Object dequeue() {// 큐에서 원소를 삭제하고 반환
		if (count == 0)
			return null;
		// 빈칸3을 채우시오: Object 타입의 변수에 front의 data를 저장
		Object item =  front.data;
		// 빈칸4를 채우시오: front가 다음 원소를 가리킴 
		front = front.link;
		if (front == null) {// 리스트이 노드를 삭제 후 공백이 된 경우
			rear = null;
		}
		count--;
		return item;
	}

	public void remove() {// 큐에서 원소를 삭제
		if (isEmpty())
			return;// 큐에서 원소 삭제시 공백인지 아닌지 검사하여 반환한다
		
		// 큐에서 원소를 삭제하는 부분을 구현하시오.
		// 빈칸5를 채우시오.
		Object item = front.data;
		front = front.link;
		// 빈칸6을 채우시오: if문 사용
		if(front == null)
			rear = null;
		// 빈칸7을 채우시오.
		count--;
	}

	public Object peek() {// 큐에서 톰 원소를 탐색한다

		if (count == 0)
			return null;// 톱 원소수가 0개이면 null 반환
		else
			return front.data;// 그렇지 않으면 data를 반환한다.
	}
}

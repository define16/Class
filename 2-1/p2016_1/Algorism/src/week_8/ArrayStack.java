
package week_8;
interface Stack
	{
		boolean empty();
		void push(Object x);
		Object pop();
		void remove();
		Object peek();
		boolean isEmpty();
	}

public class ArrayStack implements Stack
	{
		private int top;
		private int stackSize;
		private int increment;

		private Object[] itemArray;

		public ArrayStack()
		{
			top = -1;
			stackSize = 50;
			increment = 10;
			itemArray = new Object[stackSize];
		}

		public boolean empty()
		{
			return top == -1;
		}

		public void push(Object x)
		{
			if(top==stackSize-1)
				stackFull();

			itemArray[++top]=x;
		}

		public void stackFull()
		{
			stackSize += increment;
			Object[] tempArray = new Object[stackSize];

			for(int i=0; i<=top; i++)
				tempArray[i] = itemArray[i];

			itemArray = tempArray;
		}

		public Object pop()
		{
			if(empty()) return null;
			else return itemArray[top--];
		}

		public void remove()
		{
			if(empty()) return;
			else top--;
		}

		public Object peek()
		{
			if(empty()) return null;
			else return itemArray[top];
		}
		
		public void print()
		{
			for(int i = 0; i <= top; i++)
				System.out.print(itemArray[i]);
			System.out.println("");
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
	}


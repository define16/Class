package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class linkedList {
	listNode head; 
	int list_size = 0;

	public void addFirstNode(String x) {
		listNode newNode = new listNode();
		newNode.data = x;
		newNode.link = head;

		head = newNode;

	}
	public void addLastNode(String x) {
		listNode newNode = new listNode();
		newNode.data = x;
		newNode.link = null;
		if(head == null) { 
			head = newNode;
			return ;
		}

		listNode p = head; 
		while(p.link != null) {
			p = p.link;
			list_size++;
		}
		p.link = newNode;
		
	

	}

	public void deleteLastNode() {
		listNode previousNode, currentNode;

		if(head == null) 
			return;
		if(head.link == null) {
			head = null;
			return;
		}
		else {
			previousNode = head;
			currentNode = head.link;

			while(currentNode.link != null) {
				previousNode = currentNode;
				currentNode = currentNode.link;
			}
			previousNode.link = null;
		}
	}
	public void deleteNext(String x) {
		listNode p = searchNode(x);
		listNode q = new listNode();

		if(head == null)
			return ;
		if(p == null) {
			q = head;
			head = head.link;
		}else {
			q = p.link;
			if(q == null)
				return;
			p.link = q.link;
		}

	}
	public listNode searchNode(String x) {
		listNode p = head;
		if(p == null)
			addFirstNode(p.data);
		while(p != null) {
			if(x.equals(p.data))
				return p;
			p = p.link;
		}
		return p;
	}
	public void insertNode(String x, String y) {
		listNode newNode = new listNode();
		listNode p = searchNode(x); // head
		newNode.data = y;
		if(head == null) {
			head = newNode;
			newNode.link = null;
		} else if(p == null) {
			newNode.link = p;
			p = newNode;
		} else {
			newNode.link = p.link;
			p.link = newNode;
		}

	}

	public void reverse() {
		listNode p = head;
		listNode q = null;
		listNode r = null;

		while(p != null) {
			r = q;
			q = p;
			p = p.link;
			q.link = r;
		}
		head = q;
	}

	public static linkedList addList(linkedList L1, linkedList L2) {
		if(L1 == null) {
			return L2;
		} else if (L2 == null) {
			return L1;
		} else {
			listNode p = new listNode();
			p = L1.head;
			while(p.link != null) {
				p = p.link;
			}
			p.link = L2.head;
			return L1;
		}
	}
	public void printList() {
		listNode p;

		System.out.print("(");
		p = head;
		int i = 0, cnt = 1;
		String cnts[] = new String[list_size];
		String temp = null;
		while(p != null) {
			cnts[i] = p.data;
			if(cnts[i].contains(p.data))
			{
				for(int j = 0; j < i; j++ )
					if(cnts[j].equals(cnts[i]))
					{
						cnt++;
					}
						
				
				System.out.print(cnts[i] + " --> " + cnt);
			}
			cnt = 1;
			p = p.link; 
			if(p != null)
				System.out.println(", ");
			i++;
		}
		System.out.println(")");
	}

}

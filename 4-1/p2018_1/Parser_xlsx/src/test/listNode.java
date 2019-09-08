package test;


public class listNode {

	String data; 
	listNode link; 
	
	public listNode() { 
		data = null;
		link = null;
	}
	
	public listNode(String val) { 
		data = val;
		link = null;
	}
	
	public listNode(String val, listNode p) {
		
		data = val;
		link = p;
	}
}

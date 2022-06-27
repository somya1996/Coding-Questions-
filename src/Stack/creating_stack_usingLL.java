package Stack;

class Node{
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
}
public class creating_stack_usingLL {
	Node head;
	creating_stack_usingLL(){
		head = null;
	}
	void push(int d){
		// insert head
		if(head == null){
			head = new Node(d);
		}
		else{
			Node n = new Node(d);
			n.next = head;
			head = n;
		}
	}
	void pop(){
		if(head!= null)
			head = head.next;
	}
	int top(){
		return head.data;
	}

	boolean empty(){
		return head == null;
	}
}

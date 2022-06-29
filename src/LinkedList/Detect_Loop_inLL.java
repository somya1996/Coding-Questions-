package LinkedList;

import java.util.HashSet;

public class Detect_Loop_inLL {
	static  Node head;
	static class Node{
		int data;
		Node next;
		Node(int x){
			data = x;
			next = null;
		}
	}
	static public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	//One way
	static boolean detectLoop(Node h)
	{
		HashSet<Node> s = new HashSet<Node>();
		while (h != null) {
			if (s.contains(h))
				return true;
			s.add(h);
			h = h.next;
		}
		return false;
	}

	public static boolean detectLoop(Node head){
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow)
				return true;
		}
		return false;
	}
}

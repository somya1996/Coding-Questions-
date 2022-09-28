package LinkedList.Medium;

import java.util.Scanner;

public class Delete_odd_nodes {
	public static Node head;
	static class Node{
		int data;
		Node next;
		Node(int x){
			data = x;
			next = null;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			if(head == null) {
				Node new_node = new Node(x);
				head = new_node;
				new_node.next = head;
			}
			else
				insert(head , x);
		}
		// Deleting Odd positioned nodes
		display(head);

		System.out.println("\nAfter deleting Odd position nodes: ");
		head = DeleteAllOddNode(head);
		display(head);
	}
	static Node insert(Node head, int data){
		Node current = head;
		Node newNode = new Node(data);
		if (head == null)
		{
			newNode.next = newNode;
			head = newNode;
			return head;
		}
		else{
			while (current.next != head){
				current = current.next;
			}
			newNode.next = head;
			current.next = newNode;
		}
		return head;
	}

	public static void display(Node head){
		Node curr = head;
		do{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}while(curr != head);
	}

	public static Node DeleteAllOddNode(Node head){
		if(head == null)
			return null;
		int len = Length(head);
		int count = 0;
		Node previous = head;
		if(len == 1){
			head = Delete_first_Node(head);
			return head;
		}
		while(count < len){
			if(count == 0){
				head = Delete_first_Node(head);
			}
			else{
				if(count % 2 == 0 && count!=0){
					head = DeleteNode(head , previous);
				}
			}
			//System.out.println(" previous data "+previous.data);
			previous = previous.next;
			count++;
		}
		return head;

	}
	public static Node DeleteNode(Node head , Node del){
		Node temp = head;
		// If node to be deleted is head node
		if (head == del){
			head = del.next;
		}
		// traverse list till not found
		// delete node
		while (temp.next != del){
			temp = temp.next;
		}
		// copy address of node
		temp.next = del.next;
		return head;
	}
	public static Node Delete_first_Node(Node head){
		Node prev = head , next = head;
		if(head == null)
			return head;
		if (prev.next == prev){
			head = null;
			return head;
		}
		while(prev.next != head ){
			prev = prev.next;
			//next = prev.next;
		}
		prev.next = head.next;
		head = prev.next;
		return head;
	}
	public static int Length(Node head){
		int len = 0;
		Node curr = head;
		while(curr.next != head){
			len++;
			curr = curr.next;
		}
		len++;
		return len;
	}
}

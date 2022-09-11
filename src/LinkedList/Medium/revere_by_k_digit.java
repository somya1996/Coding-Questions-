package LinkedList.Medium;

import java.util.Scanner;

public class revere_by_k_digit {
	static Node head;
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
			int data = sc.nextInt();
			if(head == null){
				head = new Node(data);
				head.next = null;
			}
			else{
				insert_node(head , data);
			}
		}
		int k = sc.nextInt();
		printList(head);
		reverseKNode(head , k);
		printList(head);
	}

	public static Node reverseKNode(Node head , int k) {
		System.out.println(size(head));
		if (size(head) < k)
			return head;
		int cnt = 0;
		Node prev = null;
		Node next_ = null;
		Node curr = head;
		while (cnt < k && curr != null) {
			next_ = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next_;
			cnt++;
		}
		if(next_ != null){
			head.next = reverseKNode(next_ , k);
		}
		return prev;
	}

	public static int size(Node head){
		int cnt = 0;
		while(head != null){
			head = head.next;
			cnt++;
		}
		return cnt;
	}

	public static Node insert_node(Node head , int data){
		if(head == null){
			head = new Node(data);
		}

		Node n = new Node(data);
		n.next = null;
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		return head;
	}
	private static void printList(Node head) {
		System.out.println("Linked List");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}

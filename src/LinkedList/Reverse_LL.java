package LinkedList;

import java.util.Scanner;

public class Reverse_LL {
	static Node head;
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}
	private static void printList(Node head) {
		System.out.println("Linked List");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static Node reverseLL(Node head){
		/*
		Node temp1 = head;
		Node temp2 = temp1.next;
		head.next = null ;
		temp1 = temp2;
		while(temp2 != null){
			temp2 = temp2.next;
			temp1.next = head;
			head = temp1;
			temp1 = temp2;
		}

		return head;*/
		Node current = head;
		Node previous = null;
		Node next = null;

		while (current != null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	public static void main(String[] args) {
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
		head = reverseLL(head);
		printList(head);
	}
	public static Node insert_node(Node head , int data){
		//if(head == null)
		//	return new Node(data);
		Node n = new Node(data);
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		n.next = null;
		return head;
	}
}

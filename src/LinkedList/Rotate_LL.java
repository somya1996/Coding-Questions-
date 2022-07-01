package LinkedList;

import java.util.Scanner;

public class Rotate_LL {
	static Node head;
	static class Node{
		int data ;
		Node next;

		Node(int x){
			data = x;
			next = null;
		}
	}
	public static Node inserting_Node(int x){
		if(head == null)
			return new Node(x);
		Node newmode = new Node(x);
		newmode.next = null;
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = newmode;
		return head;
	}
	public static Node rotate(Node head, int k) {
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = head;
		Node start = head;
		while(k-- > 0){
			start = head;
			head = head.next;
		}
		start.next = null;
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
				inserting_Node(data);
			}
		}
		int k = sc.nextInt();
		head = rotate(head , k);
		printList(head);
	}
}

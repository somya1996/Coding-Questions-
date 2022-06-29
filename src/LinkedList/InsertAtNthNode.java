package LinkedList;

import java.util.Scanner;

public class InsertAtNthNode {
	static Node head;
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
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
		printList(head);
		int idx = sc.nextInt();
		System.out.println(getNthFromLast(head , idx));
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
	}private static void printList(Node head) {
		System.out.println("Linked List");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static int getNthFromLast(Node head, int n){
		Node temp = head;
		int total = 0;
		while(temp != null){
			total++;
			temp = temp.next;
		}
		if(total < n)
			return -1;
		int idx = total - n;
		temp = head;
		int count = 0;
		while(count < idx && temp != null){
			count++;
			temp = temp.next;
		}
		int ans = temp.data;
		return ans;
	}
}

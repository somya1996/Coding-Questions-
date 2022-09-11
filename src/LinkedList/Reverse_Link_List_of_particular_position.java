package LinkedList;

import java.util.Scanner;

public class Reverse_Link_List_of_particular_position {
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int x){
			data = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			if(head == null){
				head = new Node(x);
				head.next = null;
			}
			else{
				insert(head , x);
			}
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		printList(head);
		reverseBetween(head ,B , C);
		printList(head);
	}
	public static Node insert(Node head , int x){
		if(head == null){
			head = new Node(x);
			head.next = null;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		Node n = new Node(x);
		temp.next = n;
		n.next = null;
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
	public static Node reverseBetween(Node A, int B, int C) {
		if(B==C)
			return A;
		int i=1;
		Node prev = null;  Node last = null;
		Node revstart = null ; Node revend = null;
		Node curr = head;
		while(curr != null && i<=C){
			if(i<B)
				prev = curr;
			if(i == B){
				revstart = curr;
			}
			if(i == C){
				revend = curr;
				last = curr.next;
			}
			curr = curr.next;
			i++;
		}
		revend = reverse(revstart , last);
		if(prev != null)
			prev.next = revend;
		else
			head = revend;
		revstart.next = last;
		return head;
	}
	public static Node reverse(Node start , Node last){
		Node prev = null ;
		Node curr = start;

		while(curr != last){
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		start = prev;
		printList(start);
		return start;
	}
}

package LinkedList.HARD;

import java.util.Scanner;

public class ReverseKnodes_with_varying_K {
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
		int no = sc.nextInt();
		int b[] = new int[no];
		for(int i=0; i<no; i++){
			b[i] = sc.nextInt();
		}
		printList(head);
		reverseKNode(head , no , b);
		printList(head);
	}

	public static Node reverseKNode(Node head , int no , int[] b) {
		if(b[0] == 0)
			return head;
		return revere_k_group(head , 0 , no , b);
	}
	public static Node revere_k_group(Node head , int i , int n , int[] b){
		if(head == null || head.next == null)
			return head;
		if(head != null && i == n)
			return head;
		int cnt = 0;
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(b[i] == 0){
			i = i+1;
		}
		while (curr != null && cnt < b[i]) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			cnt++;
		}
		if(curr != null){
			head.next = revere_k_group(curr ,i+1 , n , b);
		}
		else
			head.next = curr;
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

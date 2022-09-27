package LinkedList.Medium;

import java.util.Scanner;

public class Delete_odd_pos_nodes_CLL {
	static Node head;
	static class Node{
		int val;
		Node next;
		Node(int x){
			val = x;
			next = null;
		}
	}
	public static Node insert(Node head , int data){
		Node current = head;
		// Create a new node
		Node newNode = new Node(data);
		System.out.println(newNode.val);
		// check node is created or not
		if (newNode == null) {
			System.out.printf("\nMemory Error\n");
			return null;
		}
		//newNode.val = data;
		if (head == null){
			newNode.next = newNode;
			head = newNode;
			return head;
		}
		// if list have already some node
		else
		{
			// move first node to last node
			while (current.next != head) {
				current = current.next;
			}
			// put first or head node address in new node link
			newNode.next = head;
			// put new node address into last node link(next)
			current.next = newNode;
		}
		return head;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
				insert(head , x);
			}
		printll(head);
		deleteOddNode(head);
		printll(head);
	}
	public static void printll(Node head){
		Node temp = head;
		while(temp != head) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void deleteOddNode(Node head){
		int len = size(head);
		int count = 0;
		Node previous = head, next = head;
		if (head == null){
			return;
		}
		if (len == 1){
			headdel(head);
			return;
		}
		while (len > 0){
			if (count == 0){
				headdel(head);
			}
			if (count % 2 == 0 && count != 0){
				delNodes(head, previous);
			}
			previous = previous.next;
			next = previous.next;

			len--;
			count++;
		}
		return;
	}
	public static int size(Node head){
		Node temp = head;
		int count = 0;
		while(temp != head){
			count++;
			temp = temp.next;
		}
		return count;
	}
	public static Node headdel(Node head){
		Node t1 = head;
		Node t2 = t1.next;
		while(t1.next != head){
			t1 = t1.next;
		}
		t1.next = t2;
		head = t2;
		return head;
	}
	public static Node delNodes(Node head, Node del){
		Node temp = head;
		if (head == del){
			head = del.next;
		}
		while (temp.next != del){
			temp = temp.next;
		}
		temp.next = del.next;
		return head;
	}

}

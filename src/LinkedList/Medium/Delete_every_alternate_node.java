package LinkedList.Medium;

import java.util.Scanner;

public class Delete_every_alternate_node {
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int x){
			data = x;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			if(head == null){
				Node newNode = new Node(x);
				newNode.next = newNode;
				head = newNode;
			}
			else{
				insert(head , x);
			}
		}
		printcll(head);
		System.out.println("Del alt nodes");
		head = del_alternate_node(head);
		printcll(head);
	}
	public static Node insert(Node head , int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			newNode.next = head;
			return head;
		}
		else{
			Node curr = head;
			while(curr.next != head){
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.next = head;
		}
		return head;
	}
	public static Node del_alternate_node(Node head){
		if(head == null){
			return null;
		}
		Node temp = head;
		while(true){
			temp.next = temp.next.next;
			temp = temp.next;
			if(temp == head || temp.next == head)
				break;
		}
		return head;
	}
	public static void printcll(Node head){
		Node curr = head;
		do{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}while(curr != head);
	}
}

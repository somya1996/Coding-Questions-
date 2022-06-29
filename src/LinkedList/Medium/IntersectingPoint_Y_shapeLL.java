package LinkedList.Medium;

import java.util.Scanner;

public class IntersectingPoint_Y_shapeLL {
	static class Node{
		int data ;
		Node next;
		Node(int x){
			data = x;
			next = null;
		}
	}
	static Node head1;
	static Node head2;
	public static Node insert_ele(Node head , int data){
		if(head == null)
			return new Node(data);
		Node n = head;
		while(n.next!=null){
			n = n.next;
		}
		Node new_node = new Node(data);
		n.next = new_node;
		new_node.data = data;
		return head;
	}
	public static int intersectPoint(Node head1, Node head2){
		/*int len1 = length(head1);
        int len2 = length(head2);
        Node temp1 = head1;
        Node temp2 = head2;
        while(len1 > len2){
            temp1 = temp1.next;
            len1--;
        }
        while(len2 > len1){
            temp2 = temp2.next;
            len2--;
        }
        while(temp1 != null && temp2 != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1 == temp2)
                return temp1.data;
        }
        return -1;*/
		int c1 = length(head1);
		int c2 = length(head2);
		int d;

		// If first is greater
		if (c1 > c2) {
			d = c1 - c2;
			return _getIntesectionNode(d, head1, head2);
		}
		else {
			d = c2 - c1;
			return _getIntesectionNode(d, head2, head1);
		}
		/*while (head2 != null) {
			Node temp = head1;
			while (temp!=null) {
				// if both Nodes are same
				if (temp == head2)
					return head2.data;
				temp = temp.next;
			}
			head2 = head2.next;
		}*/
		// intersection is not present between the lists
	}
	public static int _getIntesectionNode(int d, Node head1, Node head2) {
		Node current1 = head1;
		Node current2 = head2;

		// Move the pointer forward
		for (int i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}


		while (current1 != null && current2 != null) {
			if (current1 == current2)
				return current1.data;
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}
	public static int length(Node head){
		Node temp = head;
		int l = 0;
		while(temp!=null){
			l++;
			temp = temp.next;
		}
		return l;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println(" Enter the size 1");
		int n = sc.nextInt();

		//System.out.println(" Enter the size 1 elements");
		for (int i = 0; i < n; i++) {
			int data = sc.nextInt();
			if (head1 == null) {
				head1 = new Node(data);
				head1.next = null;
			}
			else
				insert_ele(head1, data);
		}
		printList(head1);
		//System.out.println(" Enter the size 2");
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int data = sc.nextInt();
			if (head2 == null) {
				head2 = new Node(data);
				head2.next = null;
			} else
				insert_ele(head2, data);
		}
		printList(head2);
		System.out.println(intersectPoint(head1 , head2));
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

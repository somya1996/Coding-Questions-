package LinkedList.HARD;

import LinkedList.Reorder_list;

import java.util.LinkedList;
import java.util.Scanner;

public class Merge_sort_linkedlist {
	static ListNode head;
	static class ListNode{
		int data ;
		ListNode next;
		ListNode(int x){
			this.data = x;
			next = null;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			if(head == null){
				head = new ListNode(x);
				head.next = null;
			}
			else{
				insert(head , x);
			}
		}
		printList(head);
		ListNode res = sortList(head);
		printList(res);
	}
	public static ListNode sortList(ListNode A){
		if(A == null || A.next == null)
			return A;

		ListNode a = A;
		ListNode b = findMidNode(A);

		a = sortList(a);
		b = sortList(b);
		ListNode res = mergeNodes(a , b);
		return res;
	}
	/*public static ListNode mergeNodes(ListNode node1, ListNode node2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (node1 != null && node2 != null) {
			if (node1.data <= node2.data) {
				dummy.next = node1;
				node1 = node1.next;
			} else {
				dummy.next = node2;
				node2 = node2.next;
			}
			dummy = dummy.next;
		}
		dummy = addNodes(dummy, node1);
		addNodes(dummy, node2);
		head = head.next;
		return head;
	}
	*/
	public static ListNode mergeNodes(ListNode a , ListNode b){
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(a != null && b != null){
			if(a.data <= b.data){
				dummy.next = a;
				a = a.next;
			}
			else{
				dummy.next = b;
				b = b.next;
			}
			dummy = dummy.next;
		}
		while(a != null && b == null){
			dummy.next = a;
			a = a.next;
			dummy = dummy.next;
		}
		while(a == null && b != null){
			dummy.next = b;
			b = b.next;
			dummy = dummy.next;
		}
		head = head.next;
		return head;
	}

	public static ListNode findMidNode(ListNode node){
		if (node == null || node.next == null)
			return node;

		ListNode fast = node;
		ListNode slow = node;
		while (fast.next != null && fast.next.next != null) {
			slow = node;
			node = node.next;
			fast = fast.next.next;
		}
		slow = node;
		node = node.next;
		slow.next = null;
		return node;
	}

	/*public static ListNode addNodes(ListNode node, ListNode node1) {
		while (node1 != null) {
			node.next = node1;
			node1 = node1.next;
			node = node.next;
		}
		return node;
	}*/
	public static ListNode insert(ListNode head , int data){
		//if(head == null)
		//	return new Node(data);
		ListNode n = new ListNode(data);
		ListNode temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		n.next = null;
		return head;
	}
	public static void printList(ListNode head){
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
}

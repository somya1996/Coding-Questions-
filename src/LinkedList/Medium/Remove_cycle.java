package LinkedList.Medium;

import LinkedList.InsertAtNthNode;
import LinkedList.Reorder_list;

import java.util.Scanner;

public class Remove_cycle {
	static ListNode head;
	static class ListNode {
		int data;
		ListNode next;

		ListNode(int x) {
			data = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(50);
		head.next = new ListNode(20);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(10);

		// Create a loop for testing
		head.next.next.next.next.next = head.next.next;

		//printList(head);
		ListNode res = solve(head);
		printList(res);
	}
	public static ListNode solve(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = A;
		ListNode prev = null;
		while(slow != fast){
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = null;
		return A;
	}
	public static void printList(ListNode head){
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode insert_node(ListNode head , int data){
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
}

package LinkedList.Medium;

import java.util.Scanner;

public class DeleteNode_without_given_head {
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
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int data = sc.nextInt();
			if (head == null) {
				head = new ListNode(data);
				head.next = null;
			} else {
				insert_node(head, data);
			}
		}
		ListNode del = new ListNode(2);
		deletenode(del);
		printlln(head);
	}

	public static ListNode insert_node(ListNode head, int x) {
		if (head == null) {
			head = new ListNode(x);
			head.next = null;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		ListNode n = new ListNode(x);
		temp.next = n;
		n.next = null;
		return head;
	}

	private static void printlln(ListNode head) {
		System.out.println("Linked List");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void deletenode(ListNode node) {
		ListNode  NextNode = node.next;
		node.data = NextNode.data;
		node.next = NextNode.next;
		NextNode.next = null;
	}
}

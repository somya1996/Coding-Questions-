package LinkedList.Medium;

import java.util.Scanner;
	public class Remove_Duplicates_from_Sorted_List {
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
			deleteDuplicates(head);
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

		public static ListNode deleteDuplicates(ListNode A) {
			ListNode slow = A;
			while (slow != null && slow.next != null) {
				ListNode fast = slow;
				while(fast.next != null) {
					if (slow.data == fast.data) {
						fast.next = fast.next.next;
						System.gc();
					} else {
						fast = fast.next;
					}
				}
				slow = slow.next;
			}
			return A;
		}
}

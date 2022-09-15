package LinkedList.HARD;

import java.util.List;
import java.util.Scanner;

public class reverse_using_O_1_space {
	static ListNode head;
	static class ListNode{
		int data;
		ListNode next;
		ListNode(int x){
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
				head = new ListNode(data);
				head.next = null;
			}
			else{
				insert_node(head , data);
			}
		}
		int k = sc.nextInt();
		reverseKGroup(head , k);
		printList(head);
	}

	public static int size(ListNode head){
		int cnt = 0;
		while(head != null){
			head = head.next;
			cnt++;
		}
		return cnt;
	}

	public static ListNode insert_node(ListNode head , int data){
		if(head == null){
			head = new ListNode(data);
		}

		ListNode n = new ListNode(data);
		n.next = null;
		ListNode temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		return head;
	}
	private static void printList(ListNode head) {
		System.out.println("Linked List");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.next == null) return head;
		if (k == 1) return head;

		int l = 1;
		int r = k;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode nodeBeforeSubList = dummy;
		ListNode left = head;

		int lengthOfLL = size(head);
		int NumberOfTimesToReverseGroups = lengthOfLL / k;


		for (int i = 0; i < NumberOfTimesToReverseGroups; i++) {
			while (l < r) {
				ListNode nodeToBeExtracted = left.next;
				left.next = nodeToBeExtracted.next;
				nodeToBeExtracted.next = nodeBeforeSubList.next;
				nodeBeforeSubList.next = nodeToBeExtracted;
				l++;
			}

			nodeBeforeSubList = left;
			left = left.next;
			l = 1;
		}

		return dummy.next;
	}
}

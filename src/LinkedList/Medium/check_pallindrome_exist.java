package LinkedList.Medium;

import java.util.List;
import java.util.Scanner;

public class check_pallindrome_exist {
	static ListNode head;
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if (head == null) {
				head = new ListNode(x);
				head.next = null;
			} else {
				insert(head, x);
			}
		}
		printll(head);
		boolean ans = check_pall(head);
		System.out.println(ans);
	}
	public static ListNode insert(ListNode head , int data){
		ListNode n = new ListNode(data);
		ListNode temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		n.next = null;
		return head;
	}
	public static void printll(ListNode head){
		while(head != null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
	public static boolean check_pall(ListNode head){
		// to get mid
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev;
		ListNode temp;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		prev = slow;
		slow = slow.next;
		prev.next = null;
		// to reverse the elements after mid
		while (slow != null) {
			temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}
		fast = head;
		slow = prev;

		while (slow != null) {
			if (fast.val != slow.val)
				return false;
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}
}

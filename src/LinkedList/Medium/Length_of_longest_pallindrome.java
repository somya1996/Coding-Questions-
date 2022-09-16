package LinkedList.Medium;

import LinkedList.HARD.Merge_sort_linkedlist;

import java.util.Scanner;

public class Length_of_longest_pallindrome {
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
		int len = length_of_longest_pallindrome(head);
		System.out.println(len);
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
	public static int length_of_longest_pallindrome(ListNode head){
		int length = 0;
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			length = Math.max(length , 2*(count(prev , next))+1); // for odd pallindrome
			length = Math.max(length , 2*(count(curr,next))); // for even pallindr
			prev = curr;
			curr = next;
		}

		return length;
	}
	public static int count(ListNode h1 , ListNode h2){
		int count = 0;
		while(h1 != null && h2 != null){
			if(h1.val == h2.val){
				count++;
				h1 = h1.next;
				h2 = h2.next;
			}
			else{
				break;
			}
		}
		return count;
	}
}

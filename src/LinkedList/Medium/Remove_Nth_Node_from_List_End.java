package LinkedList.Medium;

import LinkedList.Middle_element_of_linked_list;
import LinkedList.Reverse_Link_List_of_particular_position;

import java.util.Scanner;

public class Remove_Nth_Node_from_List_End {
	static ListNode head;
	static class ListNode{
		int data ;
		ListNode next;
		ListNode(int x){
			data = x;
			next = null;
		}
	}
	public static void main(String[] args) {
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
		int B = sc.nextInt();
		removeNthFromEnd(head , B);
		printlln(head);
	}
	public static ListNode insert_node(ListNode head , int x){
		if(head == null){
			head = new ListNode(x);
			head.next = null;
		}
		ListNode temp = head;
		while(temp.next != null){
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
	public static ListNode removeNthFromEnd(ListNode head, int B) {
		int cnt = size(head);
		System.out.println(cnt);
		ListNode curr = head;
		if(cnt < B && curr != null && curr.next != null){
			return head.next;
		}

		int val = cnt - B;
		int i = 0;
		if (B == 1 && cnt == 1) { // when there is only one node.
			return null;
		}
		if (val == 0 && cnt > 0) { // When we need to remove the first node.
			return head.next;
		}

		while(curr != null && i<val){
			curr = curr.next;
			i++;
		}
		if (curr != null && curr.next != null)
			curr.next = curr.next.next;
		return head;
	}

	public static int size(ListNode head){
		int cnt = 0;
		while(head!=null){
			cnt++;
			head = head.next;
		}
		return  cnt;
	}
}

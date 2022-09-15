package LinkedList;

import java.util.Scanner;

public class Reorder_list {
	static ListNode head;
	static class ListNode{
		int data;
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
		printList(head);
		reorderList(head);
		printList(head);
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
	public static ListNode reorderList(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head1 = A;
		ListNode head2 = slow.next;
		slow.next = null;
		printList(head1);
		printList(head2);

		head2 = reverse(head2);

		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		int cnt = 0;
		while(head1 != null && head2 != null){
			if(cnt%2 == 0){
				temp.next = head1;
				head1 = head1.next;
			}
			else{
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
			cnt++;
		}
		if( head1 == null && head2 != null){
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		if( head1 != null && head2 == null){
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		return dummy.next;
	}
	public static ListNode reverse(ListNode A){
		ListNode current = A;
		ListNode previous = null;
		ListNode next = null;

		while (current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}

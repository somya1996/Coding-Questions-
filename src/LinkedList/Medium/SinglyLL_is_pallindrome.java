package LinkedList.Medium;


import java.util.Scanner;

public class SinglyLL_is_pallindrome {
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
		//printList(head);
		System.out.println(checkPallindrome(head));

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
	public static ListNode findMid(ListNode node){
		ListNode slow = node;
		ListNode fast = node;
		while(fast.next != null && fast.next.next != null){
			slow = node;
			node = node.next;
			fast = fast.next.next;
		}
		slow = node;
		node = node.next;
		slow.next = null;
		return node;

	}
	public static int checkPallindrome(ListNode A) {
		if(A == null || A.next == null)
			return 1;
		ListNode head1 = A;
		ListNode head2 = findMid(A);

		printList(head1);
		System.out.println("Mid is");
		printList(head2);
		System.out.println("After reverse");
		head2 = reverse(head2);
		printList(head2);

		int diff = 0;
		if(head1.next == null && head2.next == null){
			if(head1.data == head2.data)
				return 1;
			else
				return 0;
		}
		while(head1 != null && head2 != null){
			if(head1.data == head2.data){
				head1 = head1.next;
				head2 = head2.next;
			}
			else{
				diff += 2;
				System.out.println(" count "+diff);
				if(diff>=2)
					return 0;
			}
		}
		while(head1 != null && head2 == null){
			head1 = head1.next;
			if(diff>=2)
				return 0;
			diff++;
		}
		while(head1 == null && head2 != null){
			head2 = head2.next;
			if(diff >= 2)
				return 0;
			diff++;
		}

		return 1;
	}
	public static ListNode reverse(ListNode A){
		if(A == null || A.next == null)
			return A;
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

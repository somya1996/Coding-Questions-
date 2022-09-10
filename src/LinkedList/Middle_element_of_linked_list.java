package LinkedList;

import java.util.Scanner;

public class Middle_element_of_linked_list {
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int x){
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
				head = new Node(data);
				head.next = null;
			}
			else{
				insert_node(head , data);
			}
		}

		int val = solve(head);
		System.out.println(val);
	}
	public static int solve(Node A) {
		// Brute force -> O(n) but using two loops
        /*
        int cnt = size(A);
        if(cnt == 1)
            return A.val;
        int mid;
        if(cnt%2 == 0)
           mid = cnt/2;
        else
            mid = cnt/2;
        while(mid!=0){
            A = A.next;
            mid--;
        }
        return A.val;    */
		// optimal approach
		// using tortroise rabbit algo
		if(A.next == null)
			return A.data;
		Node fast = A;
		Node slow = A;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}
	/*public static int size(ListNode A){
		int cnt = 0;
		while(A != null){
			cnt++;
			A = A.next;
		}
		return cnt;
	}*/
	public static Node insert_node(Node head , int data){
		if(head == null){
			head = new Node(data);
		}

		Node n = new Node(data);
		n.next = null;
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		return head;
	}
	private static void printList(Node head) {
		System.out.println("Linked List");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}

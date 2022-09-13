package LinkedList.Medium;

public class Detect_first_node_loop {
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
		ListNode head = new ListNode(50);
		head.next = new ListNode(20);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(10);

		// Create a loop for testing
		head.next.next.next.next.next = head.next.next;

		ListNode res = detectLoopNode(head);
		System.out.print("Loop starting node is " +  res);
	}
	static void printList(ListNode head){
		while (head != null)
		{
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	static ListNode detectLoopNode(ListNode head){
		if(head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		//slow = slow.next;
		//fast = fast.next.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		if(slow != fast)
			return null;
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}

package LinkedList.Medium;

import java.util.Scanner;

public class Delete_odd_pos_nodes_CLL {
	static class Node
	{
		int data;
		Node next;
		Node(int x){
			data = x;
			next = null;
		}
	};

	// Function return number of nodes present in list
	static int Length(Node head)
	{
		Node current = head;
		int count = 0;

		// if list is empty simply return length zero
		if (head == null) return 0;
		// traverse first to last node
		else
		{
			do
			{
				current = current.next;
				count++;
			} while (current != head);
		}
		return count;
	}

	// Function print data of list
	static void Display( Node head){
		Node current = head;
		if (head == null){
			System.out.printf("\nDisplay List is empty\n");
			return;
		}
		else{
			do{
				System.out.printf("%d ", current.data);
				current = current.next;
			} while (current != head);
		}
	}

	/* Function to insert a node at the end of
	a Circular linked list */
	static Node Insert(Node head, int data){
		Node current = head;
		Node newNode = new Node(data);
		if (head == null)
		{
			newNode.next = newNode;
			head = newNode;
			return head;
		}
		else{
			while (current.next != head){
				current = current.next;
			}
			newNode.next = head;
			current.next = newNode;
		}
		return head;
	}

	// Utility function to delete a Node
	static Node deleteNode(Node head_ref, Node del)
	{
		Node temp = head_ref;

		// If node to be deleted is head node
		if (head_ref == del)
		{
			head_ref = del.next;
		}

		// traverse list till not found
		// delete node
		while (temp.next != del)
		{
			temp = temp.next;
		}

		// copy address of node
		temp.next = del.next;
		return head_ref;
	}

	// Function to delete First node of
// Circular Linked List
	static Node DeleteFirst(Node head)
	{
		Node previous = head, next = head;
		// check list have any node
		// if not then return
		if (head == null){
			return head;
		}

		// check list have single node
		// if yes then delete it and return
		if (previous.next == previous)
		{
			head = null;
			return head;
		}

		// traverse second to first
		while (previous.next != head)
		{
			previous = previous.next;
			next = previous.next;
		}

		// now previous is last node and
		// next is first node of list
		// first node(next) link address
		// put in last node(previous) link
		previous.next = next.next;

		// make second node as head node
		head = previous.next;
		return head;
	}

	// Function to delete odd position nodes
	static Node DeleteAllOddNode(Node head)
	{
		int len = Length(head);
		int count = 0;
		Node previous = head, next = head;
		if (head == null){
			return null;
		}

		// if list have single node means
		// odd position then delete it
		if (len == 1)
		{
			head = DeleteFirst(head);
			return head;
		}

		// traverse first to last if
		// list have more than one node
		while (len > 0)
		{
			// delete first position node
			// which is odd position
			if (count == 0)
			{

				// Function to delete first node
				head = DeleteFirst(head);
			}

			// check position is odd or not
			// if yes then delete node
			// Note: Considered 1 based indexing
			if (count % 2 == 0 && count != 0)
			{
				head = deleteNode(head, previous);
			}

			previous = previous.next;
			next = previous.next;

			len--;
			count++;
		}
		return head;
	}

	// Function to delete all even position nodes
	static Node DeleteAllEvenNode( Node head)
	{
		// Take size of list
		int len = Length(head);

		int count = 1;
		Node previous = head, next = head;

		// Check list is empty
		// if empty simply return
		if (head == null)
		{
			System.out.printf("\nList is empty\n");
			return null;
		}

		// if list have single node
		// then return
		if (len < 2)
		{
			return null;
		}

		// make first node is previous
		previous = head;

		// make second node is current
		next = previous.next;

		while (len > 0)
		{

			// check node number is even
			// if node is even then
			// delete that node
			if (count % 2 == 0)
			{
				previous.next = next.next;
				previous = next.next;
				next = previous.next;
			}

			len--;
			count++;
		}
		return head;
	}

	// Driver Code
	public static void main(String args[])
	{
		Node head = null;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			head = Insert(head , x);
		}
		// Deleting Odd positioned nodes
		System.out.printf("Initial List: ");
		Display(head);

		System.out.printf("\nAfter deleting Odd position nodes: ");
		head = DeleteAllOddNode(head);
		Display(head);

		// Deleting Even positioned nodes
		System.out.printf("\n\nInitial List: ");
		Display(head);

		System.out.printf("\nAfter deleting even position nodes: ");
		head = DeleteAllEvenNode(head);
		Display(head);
	}
}

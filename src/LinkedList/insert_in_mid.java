package LinkedList;

public class insert_in_mid {
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int x){
			data = x;
			next = null;
		}
	}
	public static void insertAtMid(Node head, int data){
		if (head == null)
			head = new Node(data);

		Node newNode = new Node(data);
		Node temp = head;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		int count = ((len % 2) == 0) ? (len / 2) : (len + 1) / 2;
		temp = head;

		while (count-- > 1)
			temp = temp.next;

		newNode.next = temp.next;
		temp.next = newNode;
	}
	static void display()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		head = null;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);

		System.out.println("Linked list before "+ "insertion: ");
		display();

		int x = 3;
		insertAtMid(head , x);

		System.out.println("\nLinked list after"+ " insertion: ");
		display();
	}
}

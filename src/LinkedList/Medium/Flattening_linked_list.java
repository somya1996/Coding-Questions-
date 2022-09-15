package LinkedList.Medium;

public class Flattening_linked_list {
	static ListNode head;
	static  class  ListNode{
		int val;
		ListNode right;
		ListNode down;
		ListNode(int x){
			val = x;
			right = null;
			down = null;
		}
	}
	ListNode push(ListNode head_ref, int data)
	{
        /* 1 & 2: Allocate the Node & Put in the data*/
		ListNode new_node = new ListNode(data);
		/* 3. Make next of new Node as head */
		new_node.down = head_ref;
		/* 4. Move the head to point to new Node */
		head_ref = new_node;
		/*5. return to link it back */
		return head_ref;
	}
	public static void main(String[] args) {
		Flattening_linked_list L = new Flattening_linked_list();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.right = L.push(L.head.right, 20);
		L.head.right = L.push(L.head.right, 10);

		L.head.right.right = L.push(L.head.right.right, 50);
		L.head.right.right = L.push(L.head.right.right, 22);
		L.head.right.right = L.push(L.head.right.right, 19);

		L.head.right.right.right
				= L.push(L.head.right.right.right, 45);
		L.head.right.right.right
				= L.push(L.head.right.right.right, 40);
		L.head.right.right.right
				= L.push(L.head.right.right.right, 35);
		L.head.right.right.right
				= L.push(L.head.right.right.right, 20);

		// Function call
		L.head = L.flatten(L.head);

		L.printList();
	}
	void printList()
	{
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.down;
		}
		System.out.println();
	}
	public static ListNode flatten(ListNode head){
		if(head == null || head.right == null)
			return head;
		head.right = flatten(head.right);
		head = merge(head , head.right);
		return head;
	}
	public static ListNode merge(ListNode a , ListNode b){
		if(a == null)
			return b;
		if(b == null)
			return a;
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		while(a != null && b != null){
			if(a.val < b.val){
				temp.down = a;
				temp = temp.down;
				a = a.down;
			}
			else{
				temp.down = b;
				temp = temp.down;
				b = b.down;
			}
		}
		while(a!= null) {
			temp.down = a;
			a = a.down;
			temp = temp.down;
		}
		while( b != null){
			temp.down = b;
			b = b.down;
			temp = temp.down;
		}
		return dummy.down;
	}
}

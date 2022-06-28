/*
Given a linked list of size N and a key. The task is to insert the key in the middle of the linked list.

Example 1:

Input:
LinkedList = 1->2->4
key = 3
Output: 1 2 3 4
Explanation: The new element is inserted after the current middle element in the linked list.
*/
public Node insertInMid(Node head, int data){
        if (head == null)
            head = new Node(x);
      
        Node newNode = new Node(x);
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

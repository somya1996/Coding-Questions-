package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;
class Node{
	int data;
	Node next;

}
public class TryLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		Node n1 = new Node();
		n1.data = a;
		Node n2 = new Node();
		n2.data = b;
		n1.next = n2;
		System.out.println(n1.data);
		System.out.println(n1.next);

	}
}

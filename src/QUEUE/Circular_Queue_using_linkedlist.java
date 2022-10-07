package QUEUE;

import com.sun.source.doctree.SummaryTree;

import java.util.Scanner;

public class Circular_Queue_using_linkedlist {
	Node front , rear ;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	public void enqueue(int x){
		Node n = new Node(x);
		n.next = front;
		if(front == null)
			front = n;
		else
			rear.next = n;
		rear = n;
		//rear.next = front;
	}
	public boolean deque(){
		if (front == null) {
			return false;
		}
		// If this is the last node to be deleted
		// Value to be dequeued
		if (front == rear) {
			front = null;
			rear = null;
		}
		else // There are more than one nodes
		{
			front = front.next;
			rear.next = front;
		}
		return true;
	}
	public int Front(){
		return front.data;
	}
	public int Rear(){
		return rear.data;
	}
}
class Myclass{
	public static void main(String[] args) {
		Circular_Queue_using_linkedlist cq = new Circular_Queue_using_linkedlist();
		cq.enqueue(5);
		cq.enqueue(8);
		cq.enqueue(12);
		cq.deque();
		System.out.println(cq.Front());
		System.out.println(cq.Rear());
	}
}

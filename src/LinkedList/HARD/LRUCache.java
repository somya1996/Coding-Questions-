package LinkedList.HARD;

import java.security.Key;
import java.util.HashMap;
public class LRUCache {
	static class Node{
		int key;
		int data;
		Node pre;
		Node next;
		Node(int k , int value){
			key = k;
			data = value;
		}
	}
	static HashMap<Integer , Node> hm ;
	static int Max , count ;
	static Node head , tail;
	LRUCache(int capacity){
		Max = capacity;
		hm = new HashMap<Integer , Node>();
		head = null;
		tail = null;
		count = 0;
	}
	/*public static void addToHead(Node node){
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}
	public static void deleteNode(Node node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}*/
	public static void set(int key , int value){
		if(hm.containsKey(key)){
			Node node = hm.get(key);
			if(head.key == key){
				node.data = value;
				return;
			}
			if(tail.key == key){
				tail = tail.pre;
			}
			// this is to delete the node
			Node temp = node.pre;
			temp.next = node.next;
			temp = node.next;
			if(temp != null){
				temp.pre = node.pre;
			}
			// Now add that node at head
			node.next = head;
			head.pre = node;
			node.pre = null;
			head = node;

			node.data = value;
			return;
		}
		if(count == Max){
			// if count == max means my capacity of cache is already full so remove LRU(last node)
			if(tail != null) {
				hm.remove(tail.key);
				tail = tail.pre;
				if(tail != null){
					tail.next.pre = null; // remove the link of deleted node
					tail.next = null;
				}
				count--;
			}
		}
		// Now add the node at head
		Node node = new Node(key , value);
		node.next = head;
		if (head != null)
			head.pre = node;

		head = node;
		count++;

		if (count == 1)
			tail = head;

		hm.put(key, node);
	}
	public static int get(int key){
		if(hm.containsKey(key)){
			Node node = hm.get(key);
			if(head.key == key)
				return head.data;
			if(tail.key == key){
				tail = tail.pre;
			}
			// to delete node
			Node temp = node.pre;
			temp.next = node.next;
			temp = node.next;
			if(temp != null){
				temp.pre = node.pre;
			}
			// to add to head
			node.next = head;
			head.pre = node;
			node.pre = null;
			head = node;
			return head.data;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		System.out.println("Going to test the LRU "
				+ " Cache Implementation");
		LRUCache cache = new LRUCache(2);

		// it will store a key (1) with value
		// 10 in the cache.
		cache.set(1, 10);

		// it will store a key (1) with value 10 in the
		// cache.
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

		// evicts key 2 and store a key (3) with
		// value 30 in the cache.
		cache.set(3, 30);

		System.out.println(
				"Value for the key: 2 is "
						+ cache.get(2)); // returns -1 (not found)

		// evicts key 1 and store a key (4) with
		// value 40 in the cache.
		cache.set(4, 40);
		System.out.println(
				"Value for the key: 1 is "
						+ cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is "
				+ cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is "
				+ cache.get(4)); // return 40
	}
}

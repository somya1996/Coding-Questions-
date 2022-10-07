package QUEUE.Hard;

import java.util.HashMap;

public class Least_recently_used {
	class Node{
		int key , value;
		Node next;
		Node prev;
		Node(int k , int val){
			key = k;
			value = val;
		}
	}
	HashMap<Integer , Node> cache ;
	int max , count;
	Node head , tail;
	Least_recently_used(int capacity){
		cache = new HashMap<>();
		max = capacity;
		head = null ;
		tail = null;
		count = 0;
	}
	public int get(int key){
		if(cache.containsKey(key)){
			Node n = cache.get(key);
			if(head.key == key)
				return head.value;
			if(tail.key == key)
				tail = tail.prev;

			// if any other position remove this
			Node temp = n.prev;
			temp.next = n.next;
			temp = n.next;
			if(temp!= null)
				temp.prev = n.prev;

			//Now add the node to head as most recently used
			n.next = head;
			head.prev = n;
			n.prev = null;
			head = n;
			return head.value;
		}
		return -1;
	}
	public void put(int key , int val){
		if(cache.containsKey(key)) {
			Node n = cache.get(key);
			if (head.key == key) {
				head.value = val;
				return;
			}
			if (tail.key == key) {
				tail = tail.prev;
			}
			// to del the node if not in head
			Node temp = n.prev;
			temp.next = n.next;
			temp = n.next;
			if (temp != null)
				temp.prev = n.prev;

			//Now add the node to head as most recently used
			n.next = head;
			head.prev = n;
			n.prev = null;
			head = n;
			head.value = val;
			return;
		}
		if(count == max) { // capacity is FULL
			if (tail != null) {
				cache.remove(tail.key);
				tail = tail.prev;
				if (tail != null) {
					tail.next.prev = null;
					tail.next = null;
				}
				count--;
			}
		}
		Node n = new Node(key , val);
		n.next = head;
		if(head != null){
			head.prev = n;
		}
			head = n;
			count++;
			if(count == 1){
				tail = head ;
			}
			cache.put(key , n);
	}
}
class LRU{
	public static void main(String[] args) {
		Least_recently_used lru = new Least_recently_used(2);
		lru.put(1,10);
		lru.put(2,20);
		System.out.println(lru.get(1));
		lru.put(3,30);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		System.out.println(lru.get(1));
	}
}

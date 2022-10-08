package LinkedList.HARD;

import java.util.HashMap;
/*
 * capacity: total capacity of LFU Cache
 * curSize: current size of LFU cache
 * minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
 * cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
 * frequencyMap: a hash map that has key to linked list mapping, which used for storing all
 * double linked list by their frequencies
 * */
public class LFUCACHE {
	int capacity;
	HashMap<Integer , DoubleLinkedNode> cache ;
	HashMap<Integer , DoubleLinkedListList> freq_Map;
	int min_frequency;
	int curr_size;
	LFUCACHE(int capacity){
		this.capacity = capacity;
		cache = new HashMap<>();
		freq_Map = new HashMap<>();
		curr_size = 0;
		min_frequency = 0;
	}
	/** get node value by key, and then update node frequency as well as relocate that node **/
	public int get(int key){
		DoubleLinkedNode temp = cache.get(key);
		if(temp == null)
			return -1;
		updateNode(temp);// as this node is accessed so increase its frequency
		return temp.value;
	}

	public void updateNode(DoubleLinkedNode currNode){
		int current_frequency = currNode.frequency;
		DoubleLinkedListList current_list = freq_Map.get(current_frequency);
		current_list.removeNode(currNode);

		// if current list the the last list which has lowest frequency and current node is the only node in that list
		// we need to remove the entire list and then increase min frequency value by 1
		if(min_frequency == current_frequency && current_list.listsize == 0)
			min_frequency++;

		currNode.frequency++;
		// add current node to another list has current frequency + 1,
		// if we do not have the list with this frequency, initialize it
		DoubleLinkedListList newlist = freq_Map.getOrDefault(current_frequency,new DoubleLinkedListList());
		newlist.addNode(currNode);
		freq_Map.put(currNode.frequency , newlist);
	}
	/**
	 * add new node into LFU cache, as well as double linked list
	 * condition 1: if LFU cache has input key, update node value and node position in list
	 * condition 2: if LFU cache does NOT have input key
	 *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
	 *  in minimum frequency list, then add new node
	 *  - sub condition 2: if LFU cache has enough space, add new node directly
	 * **/
	public void put(int key , int value){
		// corner case: check cache capacity initialization
		if (capacity == 0)
			return;
		if (cache.containsKey(key)) {
			DoubleLinkedNode curNode = cache.get(key);
			curNode.value = value;
			updateNode(curNode);
		}
		else {
			curr_size++;
			if (capacity < curr_size) {
				// get minimum frequency list
				DoubleLinkedListList min_freq_list = freq_Map.get(min_frequency);
				min_freq_list.removeNode(min_freq_list.tail.prev);
				cache.remove(min_freq_list.tail.prev.key);
				curr_size--;
			}
			// every time new node is added at frequency 1
			min_frequency = 1;
			DoubleLinkedNode new_node = new DoubleLinkedNode(key, value);

			// get the list with frequency 1, and then add new node into the list, as well as into LFU cache
			cache.put(key, new_node);
			DoubleLinkedListList newlist = freq_Map.getOrDefault(new_node.frequency, new DoubleLinkedListList());
			newlist.addNode(new_node);
			freq_Map.put(new_node.frequency, newlist);
		}
		//System.out.println(cache);
		//System.out.println("2nd hashmap");
		//System.out.println(freq_Map);
	}
}

class DoubleLinkedNode {
	int key;
	int value;
	int frequency;
	DoubleLinkedNode prev;
	DoubleLinkedNode next;

	DoubleLinkedNode(int k, int v) {
		key = k;
		value = v;
		this.frequency = 1;
	}
}
class DoubleLinkedListList{
	int listsize;
	DoubleLinkedNode head;
	DoubleLinkedNode tail;
	DoubleLinkedListList(){
		this.listsize = 0;
		head = new DoubleLinkedNode(0 , 0);
		tail = new DoubleLinkedNode(0 , 0);
		head.next = tail;
		tail.prev = head;
	}
	/** add new node into head of list and increase list size by 1 **/
	public void addNode(DoubleLinkedNode currnode){
		DoubleLinkedNode nextNode = head.next;
		currnode.next = nextNode;
		currnode.prev = head;
		head.next = currnode;
		nextNode.prev = currnode;
		listsize++;
	}
	/** remove input node and decrease list size by 1**/
	public void removeNode(DoubleLinkedNode currNode){
		DoubleLinkedNode prevNode = currNode.prev;
		DoubleLinkedNode nextNode = currNode.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		listsize--;
	}
}
class LFU{
	public static void main(String[] args) {
		LFUCACHE lfu = new LFUCACHE(2);
		lfu.put(1,1);
		lfu.put(2,2);
		lfu.get(1);
		lfu.put(3,3);
		lfu.get(2);
		lfu.get(3);
		lfu.put(4,4);
		lfu.get(1);
		lfu.get(3);
		lfu.get(4);
	}
}

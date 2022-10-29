package BInaryTree;

import groovy.transform.TailRecursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigZag_Level_order_Traversal {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println("Zig-Zag Order traversal is");
		List<List<Integer>> ans = iteratuvely(root);
		System.out.println(ans);
	}
	public static List<List<Integer>> iteratuvely(Node root){
		List<List<Integer>> res = new ArrayList<>();
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		int l = 0;
		while(queue.size()!=0){
			int size = queue.size();
			List<Integer> level_node = new ArrayList<>();
			for(int i=0; i<size; i++){
				Node curr = queue.poll();
				level_node.add(curr.data);
				if(curr.left != null){
					queue.add(curr.left);
				}
				if(curr.right != null)
					queue.add(curr.right);
			}
			if(l%2 != 0)
				Collections.reverse(level_node);
			l++;
			res.add(level_node);

		}
		return res;
	}
}

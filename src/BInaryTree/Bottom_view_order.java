package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Bottom_view_order {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		System.out.println("Bottom Order traversal is");
		ArrayList<Integer> ans = print_bottom_view(root);
		System.out.println(ans);
	}
	// Recursive
	public static ArrayList<Integer> print_bottom_view(TreeNode root){
		ArrayList<Integer> al = new ArrayList<>();
		bottomview(root , al);
		return al;
	}
	public static void bottomview(TreeNode root , ArrayList<Integer> ans){
		LinkedList<Integer> level = new LinkedList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		HashMap<Integer,Integer> hm = new HashMap<>();
		int minvalue = 0 , maxvalue = 0;
		queue.offer(root);
		level.add(0);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int dist = level.poll();
			maxvalue = Math.max(maxvalue , dist);
			System.out.println(maxvalue);
			minvalue = Math.min(minvalue , dist);
			System.out.println(minvalue);
			if(hm.containsKey(dist))
				hm.replace(dist , node.data);
			else
				hm.put(dist, node.data);
			if(node.left != null){
				queue.add(node.left);
				level.add(dist-1);
			}
			if(node.right != null){
				queue.add(node.right);
				level.add(dist+1);
			}
		}
		System.out.println(hm);
		for(int i= minvalue; i<=maxvalue; i++){
			if(hm.containsKey(i))
				ans.add(hm.get(i));
		}
	}
}

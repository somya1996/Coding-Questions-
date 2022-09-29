package BInaryTree;

import java.util.ArrayList;
import java.util.TreeMap;

public class Vertical_level_order {
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
		System.out.println("Vertical Order traversal is");
		ArrayList<ArrayList<Integer>> ans = printVerticalOrder(root);
		System.out.println(ans);
	}

	public static ArrayList<ArrayList<Integer>> printVerticalOrder(Node root) {
		TreeMap<Integer , ArrayList<Integer>> tm = new TreeMap<>();
		getVerticalOrder(root,0,tm);
		System.out.println(tm);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int x : tm.keySet()){
			ArrayList<Integer> ds = new ArrayList<>();
			for(int i=0; i<tm.get(x).size(); i++){
				ds.add(tm.get(x).get(i));
			}
			System.out.println(ds);
			ans.add(ds);
			//System.out.println(getValue());
		}
		return ans;
	}

	public static void getVerticalOrder(Node root, int dist, TreeMap<Integer, ArrayList<Integer>> tm) {
		if(root == null)
			return;
		//tm.getOrDefault(dist , new ArrayList<>()).add(root.data);
		ArrayList<Integer> al = tm.get(dist);

		// Store current node in map 'm'
		if(al == null)
		{
			al = new ArrayList<>();
			al.add(root.data);
		}
		else
			al.add(root.data);

		tm.put(dist, al);

		getVerticalOrder(root.left , dist-1 , tm);
		getVerticalOrder(root.right, dist+1 , tm);
	}
}

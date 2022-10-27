package BInaryTree;

import java.util.ArrayList;

public class Left_view_order {
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
		System.out.println("Left view Order traversal is");
		ArrayList<Integer> ans = print_left_view(root);
		System.out.println(ans);
	}
	// Recursive
	public static ArrayList<Integer> print_left_view(TreeNode root){
		ArrayList<Integer> al = new ArrayList<>();
		leftview(root , 0 , al);
		return al;
	}
	public static void leftview(TreeNode root , int level , ArrayList<Integer> ans){
		if(root == null)
			return;
		if(ans.size() == level)
			ans.add(root.data);

		leftview(root.left , level+1 , ans);
		leftview(root.right , level+1 , ans);
	}
}

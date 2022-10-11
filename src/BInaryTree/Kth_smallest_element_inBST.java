package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Kth_smallest_element_inBST {
	static TreeNode root;
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			data = x;
			left = null;
			right = null;
		}
	}
	public static void main(String[] args) {
		// create root
		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		int B = 3;
		System.out.println("recursive");
		int ans = recursive_kth_element(root , B);
		System.out.println(ans);

		int ans1 = iterative_kth_element(root , B);
		System.out.println(ans1);
	}
	public static int recursive_kth_element(TreeNode root , int B){
		ArrayList<Integer> al = new ArrayList<>();
		inorderBST(root , al);
		return al.get(B-1);
	}
	public static void inorderBST (TreeNode root , ArrayList<Integer> al){
		if(root == null)
			return;
		inorderBST(root.left , al);
		al.add(root.data);
		inorderBST(root.right , al);
	}
	public static int iterative_kth_element(TreeNode root , int k){
		LinkedList<TreeNode> stack = new LinkedList<>();

		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) return root.data;
			root = root.right;
		}
	}
	public static void printll(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		printll(root.left);
		printll(root.right);
	}
}

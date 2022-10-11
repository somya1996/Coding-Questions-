package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class invert_binary_tree {
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
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("recursive");
		recursive(root);
		printll(root);

		System.out.println();

		System.out.println("Iterative");
		iterative(root);
		printll(root);
	}
	public static TreeNode recursive(TreeNode root){
		if(root == null)
			return root;
		TreeNode left = recursive(root.left);
		TreeNode right = recursive(root.right);

		TreeNode temp = left;
		root.left = right;
		root.right = temp;

		return  root;
	}

	public static void printll(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		printll(root.left);
		printll(root.right);
	}

	public static void iterative(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		// Do BFS. While doing BFS, keep swapping
		// left and right children
		while(!q.isEmpty()){
			// pop top node from queue
			TreeNode curr = q.poll();

			// swap left child with right child
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;

			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
	}
}

package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class preOrder_Traversal_binary_tree_iterative {
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
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		root.left.left.right = new TreeNode(5);
		root.left.left.right.left = new TreeNode(5);

		//recursive way traversal
		print(root);
		// one way for preorder traversal
		printll1(root);
		System.out.println();
		//second way for preorder traversal arraylist
		printll(root);
	}
	//recursive way
	public static void print(TreeNode root){
		if(root == null)
			return;
		System.out.println(root.left);
		print(root.left);
		print(root.right);
	}
	//one way
	public static void printll1(TreeNode root){
		TreeNode temp = root;
		Stack<TreeNode> s = new Stack<>();
		if(temp == null) return;
		s.push(root);
		while(!s.isEmpty()){
			TreeNode t = s.pop();
			System.out.print(t.data+" ");

			if(t.right!= null)
				s.push(t.right);
			if(t.left != null)
				s.push(t.left);
		}
	}
	// other way
	public static void printll(TreeNode root){
		Stack<TreeNode> s = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();
		if(root == null)
			return;

		while(root != null || !s.isEmpty()){
			if(root!=null) {
				while (root != null) {
					System.out.print(root.data+" ");
					s.push(root);
					al.add(root.data);
					root = root.left;
				}
			}
			else {
				TreeNode temp = s.pop();
				root = temp.right;
			}
		}
	}

}

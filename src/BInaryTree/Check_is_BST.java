package BInaryTree;

import java.util.ArrayList;

public class Check_is_BST {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(13);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(7);
		root.left.right = new Node(12);
		root.right.left = new Node(14);
		root.right.right = new Node(17);
		root.left.left.right = new Node(9);
		root.right.right.right = new Node(10);
		root.left.left.right.left = new Node(20);
		System.out.println("Vertical Order traversal is");
		if(isValidBST(root) == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	public static int isValidBST(Node A) {
		if (isValid(A, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return 1;
		return 0;
	}
	public static boolean isValid(Node A, int l, int r) {
		if (A == null)
			return true;
		if (A.data > l && A.data < r) {
			boolean left = isValid(A.left, l, A.data);
			boolean right = isValid(A.right, A.data, r);
			return (left && right);
		}
		else
			return false;
	}
}
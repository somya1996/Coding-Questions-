package BInaryTree;

import java.util.Scanner;

public class Binary_Tree_RLcase {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int x){
			data = x;
			left = null;
			right = null;
		}
	}
	Node root;
	Binary_Tree_RLcase(){
		Scanner sc = new Scanner(System.in);
		root = buildTree(sc);
	}

	Node buildTree(Scanner sc){
		int data = sc.nextInt();
		if(data == -1)
			return null;
		Node temp = new Node(data);
		temp.left = buildTree(sc);
		temp.right = buildTree(sc);
		return temp;
	}
	void print(){
		this.preOrderprint(root);
		System.out.println();
		this.inOrderprint(root);
		System.out.println();
		this.postOrderprint(root);
	}
	void preOrderprint(Node root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrderprint(root.left);
		preOrderprint(root.right);
	}

	void inOrderprint(Node root){
		if(root == null)
			return;
		inOrderprint(root.left);
		System.out.print(root.data+" ");
		inOrderprint(root.right);
	}
	void postOrderprint(Node root){
		if(root == null)
			return;

		postOrderprint(root.left);
		postOrderprint(root.right);
		System.out.print(root.data+" ");
	}

	int getheight(){
		return height(root);
	}
	int height(Node root){
		if(root == null)
			return 0;
		int l = height(root.left);
		int r = height(root.left);
		return Math.max(l , r) + 1;
	}
	int sum(){
		return sum_of_Node(root);
	}
	int sum_of_Node(Node root){
		if(root == null)
			return 0;
		return root.data + sum_of_Node(root.left) + height(root.left);
	}
}

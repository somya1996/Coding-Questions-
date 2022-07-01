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
	}
	void preOrderprint(Node root){
		if(root == null)
			return;
		System.out.println(root.data);
		preOrderprint(root.left);
		preOrderprint(root.right);
	}
}

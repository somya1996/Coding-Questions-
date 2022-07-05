package BInaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Path_to_given_node{
	static Node root;
	static class Node{
		int data ;
		Node left;
		Node right;
		Node(int x){
			data = x;
			left = null;
			right = null;
		}
	}
	//Node root;
	Path_to_given_node() {
		Scanner sc = new Scanner(System.in);
		root = buildtree(sc);
	}
	public Node buildtree(Scanner sc){
		int data = sc.nextInt();
		if(data == -1)
			return null;
		Node temp = new Node(data);
		temp.left = buildtree(sc);
		temp.right = buildtree(sc);
		return temp;
	}
	void print(){
		this.preOrderprint(root);
		System.out.println();
	}
	void preOrderprint(Node root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrderprint(root.left);
		preOrderprint(root.right);
	}

	public static void main(String[] args) {
		Path_to_given_node p = new Path_to_given_node();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = p.path_of_node(root , n);
	}

	private ArrayList<Integer> path_of_node(Node root, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		path_check(root , n , ans);
		return ans;
	}
	public static boolean path_check(Node root , int n , ArrayList<Integer> ans){
		if(root == null)
			return false;
		ans.add(root.data);
		if(root.data == n)
			return true;
		if(path_check(root.left , n, ans) || path_check(root.right , n , ans))
			return true;
		ans.remove(ans.size()-1);
		return false;
	}
}

package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Serialized {
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
		root.right.right = new TreeNode(6);


		//System.out.println("Vertical Order traversal is");
		ArrayList<Integer> ans = solve(root);
		System.out.println(ans);
	}
	public static ArrayList<Integer> solve(TreeNode A) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		queue.add(A);
		al.add(A.data);
		//TreeNode dummy = new TreeNode(-1);
		while(queue.size() > 0){
			TreeNode t = queue.poll();
			TreeNode tleft = t.left;
			TreeNode tright = t.right;

			if(tleft != null){
				queue.add(tleft);
				al.add(tleft.data);
			}
			else {
				al.add(-1);
			}
			if(t.right != null){
				queue.add(t.right);
				al.add(tright.data);
			}
			else
				al.add(-1);
			}
		return al;
	}
}

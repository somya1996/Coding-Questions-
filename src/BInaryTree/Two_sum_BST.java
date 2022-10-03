package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;
import org.codehaus.groovy.util.StringUtil;

import java.util.HashSet;

public class Two_sum_BST {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			data = x;
		}
	}
	public static void main(String[] args){
		/*
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		int B =  33;
		*/
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		int B = 40;
		int ans  = t2Sum(root , B);
		System.out.println(ans);
	}
	public static int t2Sum(TreeNode A, int B) {
		HashSet<Integer>hs = new HashSet<>();
		if(is_pair_present(A , B , hs) == true)
			return 1;
		return 0;
	}
	public static boolean is_pair_present(TreeNode root , int B , HashSet<Integer> hs){
		//preorder traversal [root left right]
		if (root == null) return false;
		if(hs.contains(B - root.data))
			return true;
		else {
			hs.add(root.data);
		}
		return (is_pair_present(root.left, B, hs) || is_pair_present(root.right, B, hs));
	}

}

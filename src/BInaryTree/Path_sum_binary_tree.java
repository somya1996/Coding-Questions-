package BInaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;

public class Path_sum_binary_tree{
	static  TreeNode root;
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	public static void main(String[] args) {
		// create root
		root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(9);
		root.right.left.left = new TreeNode(-17);
		root.right.left.right = new TreeNode(27);
		root.right.left.right.left = new TreeNode(10);
		root.right.right = new TreeNode(13);
		root.right.right.left = new TreeNode(15);

		int target = 11;
		System.out.println(" sum of nodes ");
		if(path_sum(root , target) == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	public static boolean path_sum(TreeNode root , int target){
		if(root == null)
			return false;
		if(root.left == null && root.right == null){
			if(target - root.data == 0)
				return true;
		}
		return path_sum(root.left, target-root.data)||path_sum(root.right, target- root.data);
	}
}

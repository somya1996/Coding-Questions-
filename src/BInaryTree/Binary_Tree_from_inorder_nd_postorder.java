package BInaryTree;

import java.util.HashMap;

public class Binary_Tree_from_inorder_nd_postorder {
	static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

	public static void main(String[] args) {
		int inorder[] = {6 , 1 , 3 , 2};
		int postorder[] = {6 , 3 , 2 , 1};
		TreeNode root = buildTree(inorder , postorder);
		printll(root);
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length != postorder.length || inorder == null || postorder == null)
			return null;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i = 0; i<inorder.length; i++){
			hm.put(inorder[i] , i);
		}
		TreeNode root = buildtree(inorder , 0 , inorder.length-1 , postorder , 0 , postorder.length-1 , hm);
		return root;
	}
	public static TreeNode buildtree(int[] inorder , int instart ,int inend , int[] postorder , int poststart , int postend , HashMap<Integer , Integer> hm){
		if(instart > inend || poststart > postend){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postend]);
		int inroot = hm.get(postorder[postend]);
		int totalnode = inroot - instart;
		root.left = buildtree(inorder , instart , inroot-1 , postorder , poststart , poststart+totalnode - 1 , hm);
		root.right = buildtree(inorder , inroot+1 , inend , postorder , poststart+totalnode , postend-1 , hm);
		return root;
	}
	public static void printll(TreeNode root){
		if(root == null)
			return;
		System.out.println(root.val);
		printll(root.left);
		printll(root.right);
	}
}

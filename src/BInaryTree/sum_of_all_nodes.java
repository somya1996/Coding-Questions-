package BInaryTree;

public class sum_of_all_nodes {
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
		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		System.out.println(" sum of nodes ");
		int ans = sum_of_nodes(root);
		System.out.println(ans);

	}
	public static int sum_of_nodes(TreeNode root){
		if(root == null)
			return 0;
		int left = sum_of_nodes(root.left);
		int right = sum_of_nodes(root.right);
		return root.data+left+right;
	}
}

package BInaryTree;

public class equal_tree_partition_possible {
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
	static int possible = 0;
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
		int ans = equal_tree_partition(root);
		System.out.println(ans);

	}

	public static int tree_sum_of_nodes(TreeNode root){
		if(root == null)
			return 0;
		int left = tree_sum_of_nodes(root.left);
		int right = tree_sum_of_nodes(root.right);
		return root.data+left+right;
	}

	private static int equal_tree_partition(TreeNode root) {
		int totSum = tree_sum_of_nodes(root);
		isPossible(root , totSum);
		return possible;
	}
	public static int findTotalSum(TreeNode A) {
		if(A==null) {
			return 0;
		}
		return A.data+findTotalSum(A.right)+findTotalSum(A.left);
	}
	public static boolean isPossible(TreeNode root,int totalSum) {
		if(root==null) {
			return false;
		}
		int leftSum = findTotalSum(root.left);
		int rightSum = findTotalSum(root.right);
		if(leftSum*2==totalSum || rightSum*2==totalSum) {
			possible = 1;
			return true;
		} else {
			return isPossible(root.left,totalSum) || isPossible(root.right,totalSum);
		}
	}

}

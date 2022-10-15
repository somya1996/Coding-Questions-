package BInaryTree;

public class Find_closest_to_target_in_BST {
	static TreeNode root;
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
	static int mindif = Integer.MAX_VALUE;
	static int value = 0;
	public static void main(String[] args) {
		// create root
		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(1);

		root.right = new TreeNode(15);
		root.right.left = new TreeNode(12);
		root.right.left.right = new TreeNode(14);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(18);
		root.right.right.right = new TreeNode(22);

		int target = 17;
		int ans = nearest_target_iteratively(root , target);
		System.out.println(ans);
		ans = nearest_target_recursively(root , target);
		System.out.println(ans);
	}
	//iterative
	public static int nearest_target_iteratively(TreeNode root , int target){
		TreeNode temp = root;
		int ans = temp.data;
		int min_diff = Integer.MAX_VALUE;
		while(temp != null){
			int d = Math.abs(temp.data - target);
			if(d < min_diff){
				ans = temp.data;
				min_diff = d;
			}

			if(temp.data < target){
				temp = temp.right;
			}

			else if(temp.data > target){
				temp = temp.left;
			}

			else
				return temp.data;
		}
		return ans;

	}
	public static int nearest_target_recursively(TreeNode root  , int target){
		// base case
		if(root == null)
			return 0;
		// rec case
		int d = Math.abs(root.data - target);
		if(d < mindif){
			mindif = d;
			value = root.data;
		}

		if(root.data > target && root.left != null)
			return nearest_target_recursively(root.left , target);
		else if(root.data < target && root.right != null)
			return nearest_target_recursively(root.right , target);
		else
			return value;
	}
}

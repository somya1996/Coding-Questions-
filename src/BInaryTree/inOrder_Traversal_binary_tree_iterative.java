package BInaryTree;

import java.sql.SQLOutput;
import java.util.Stack;

public class inOrder_Traversal_binary_tree_iterative {
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
		root = new TreeNode(1);
        /* following is the tree after above statement
              1
            /   \
          null  null     */
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */
		root.left.left = new TreeNode(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
		System.out.println("recursive");
		recursive(root);
		System.out.println();
		System.out.println("Iterative");
		printll(root);
	}
	public static void recursive(TreeNode root){
		if(root == null)
			return;
		recursive(root.left);
		System.out.print(root.data+" ");
		recursive(root.right);
	}

	public static void printll(TreeNode root){
		Stack<TreeNode> s = new Stack<>();
		while(root != null || !s.isEmpty()){
			if(root != null) {
				s.push(root);
				root = root.left;
			}
			else{
				TreeNode curNode = s.pop();
				System.out.print(curNode.data+" ");
				root = curNode.right;
			}
		}

		/*Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode temp = stack.pop();
				System.out.println(temp.data);
				root = temp.right;
			}
		}*/
	}
}

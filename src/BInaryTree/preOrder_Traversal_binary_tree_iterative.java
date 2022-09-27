package BInaryTree;

import java.util.Stack;

public class preOrder_Traversal_binary_tree_iterative {
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
		printll(root);
	}
	public static void printll(TreeNode root){
		TreeNode temp = root;
		Stack<TreeNode> s = new Stack<>();
		if(temp == null) return;
		s.push(root);
		while(!s.isEmpty()){
			TreeNode t = s.pop();
			System.out.print(t.data+" ");

			if(t.right!= null)
				s.push(t.right);
			if(t.left != null)
				s.push(t.left);
		}
	}

}

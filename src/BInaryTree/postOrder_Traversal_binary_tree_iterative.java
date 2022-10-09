package BInaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class postOrder_Traversal_binary_tree_iterative {
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
	/*public static void printll(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			ans.add(node.data);
			if(node.left!=null)
				stack.push(node.left);
			if(node.right!=null)
				stack.push(node.right);
		}
		Collections.reverse(ans);
		System.out.println(ans);
	}*/
	public static void printll(TreeNode root){
		Stack<TreeNode> s = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();
		if(root == null)
			return;
		while (root != null || !s.isEmpty()){
			if(root != null){
				while(root != null){
					s.push(root);
					al.add(root.data);
					root = root.right;
				}
			}
			else{
				TreeNode curr = s.pop();
				root = curr.left;
			}
		}
		Collections.reverse(al);
		for(int i=0; i<al.size(); i++)
			System.out.print(al.get(i)+" ");
	}
}

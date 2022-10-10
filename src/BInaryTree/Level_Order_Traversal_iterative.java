package BInaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Traversal_iterative {
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
		System.out.println("Iterative");
		levelOrder(root);
	}
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ds = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = A;

		q.add(A);
		q.add(null);

		while(q.size()>1){
			TreeNode t = q.poll();
			if(t == null){
				q.add(null);
				ans.add(ds);
				ds = new ArrayList<>();
			}
			else{
				ds.add(t.data);

				if(t.left != null)
					q.add(t.left);

				if(t.right != null)
					q.add(t.right);
			}
		}
		ans.add(ds);
		return ans;
	}
}

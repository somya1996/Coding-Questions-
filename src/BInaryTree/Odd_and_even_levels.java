package BInaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Odd_and_even_levels {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(8);

		//System.out.println("Vertical Order traversal is");
		int ans = solve(root);
		System.out.println(ans);
	}
	public static int solve(TreeNode A) {
		if(A == null) return 0 ;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> level = new LinkedList<Integer>();

		q.add(A);
		q.add(null);
		level.add(1);

		int sumodd = 0 , sumeven = 0;

		while(q.size()>1){
			TreeNode t = q.poll();
			//System.out.println("node val "+t.data);
			int l = level.peek();
			//System.out.println("level is "+l);
			if(t == null){
				q.add(null);
				int lvl = level.poll();
				level.add(lvl + 1);
			}
			else{
				if(l%2 != 0){
					sumodd +=  t.data;
				}
				if(l%2 == 0){
					sumeven += t.data;
				}
				if(t.left != null)
					q.add(t.left);

				if(t.right != null)
					q.add(t.right);

			}

		}

		return sumodd - sumeven ;
	}
}

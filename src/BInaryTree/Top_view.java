package BInaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Top_view {
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
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		System.out.println("Vertical Order traversal is");
		ArrayList<Integer> ans = print_top_View_Order(root);
		System.out.println(ans);
	}
	public static ArrayList<Integer> print_top_View_Order(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> level = new LinkedList<Integer>();

		int minvalue = 0;
		int maxvalue = 0;

		queue.offer(root);
		level.offer(0);
		ans.add(root.data);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int l = level.poll();

			if(l < minvalue){
				minvalue = l;
				ans.add(node.data);
			}

			if(l > maxvalue){
				maxvalue = l;
				ans.add(node.data);
			}

			if(node.left != null){
				queue.offer(node.left);
				level.offer(l - 1);
			}
			if(node.right != null){
				queue.offer(node.right);
				level.offer(l + 1);
			}
		}
		return ans;
	}

}

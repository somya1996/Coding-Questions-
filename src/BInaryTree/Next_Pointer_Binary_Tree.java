package BInaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Next_Pointer_Binary_Tree {
	static TreeLinkNode root;
	static class TreeLinkNode{
		int data;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		TreeLinkNode(int x){
			data = x;
			left = null;
			right = null;
			next = null;
		}
	}
	public static void main(String[] args) {
		// create root
		root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		connect(root);
		printll(root);
	}
	public static void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.add(root);
		q.add(null);
		while(q.size() > 1){
			TreeLinkNode curr = q.remove();
			if(curr == null)
				q.add(null);
			else{
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
				curr.next = q.peek();
			}
		}
		return;
	}
	public static void printll(TreeLinkNode root) {
		Stack<TreeLinkNode> s = new Stack<>();
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				TreeLinkNode curNode = s.pop();
				System.out.print(curNode.data + " ");
				if(curNode.next == null) {
					System.out.println("null");
				}
				else{
					System.out.println(curNode.next.data);
				}
				root = curNode.right;
			}
		}
	}
}

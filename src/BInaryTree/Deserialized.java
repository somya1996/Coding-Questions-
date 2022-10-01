package BInaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Deserialized {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n =  sc.nextInt();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			list.add(x);
		}
		TreeNode root = solve(list);
		printll(root);
	}
	public static void printll(TreeNode root){
		if(root == null)
			return;
		System.out.println(root.data);
		printll(root.left);
		printll(root.right);
	}
	public static TreeNode solve(ArrayList<Integer> A) {
		TreeNode root = new TreeNode(A.get(0));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int i=1;
		while(!q.isEmpty()){
			TreeNode temp = q.remove();
			if(A.get(i)!=-1){
				temp.left = new TreeNode(A.get(i));
				q.add(temp.left);
			}
			i++;
			if(A.get(i)!=-1){
				temp.right = new TreeNode(A.get(i));
				q.add(temp.right);
			}
			i++;
		}
		return root;
	}
}
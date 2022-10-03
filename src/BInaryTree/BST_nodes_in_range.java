package BInaryTree;

public class BST_nodes_in_range {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
		public static void main(String[] args) {
			/*Node root = new Node(15);
			root.left = new Node(12);
			root.right = new Node(20);
			root.left.left = new Node(10);
			root.left.right = new Node(14);
			root.right.left = new Node(16);
			root.right.right = new Node(27);
			root.left.left.left = new Node(8);*/
			Node root = new Node(8);
			root.left = new Node(6);
			root.right = new Node(21);
			root.left.left = new Node(1);
			root.left.right = new Node(7);

			//int B = 12;
			//int C = 20;
			int B = 2;
			int C = 20;
			int count_nodes = solve(root , B , C);
			System.out.println(count_nodes);
		}
		public static int solve(Node A, int B, int C) {
			if(A == null)
				return 0;
			if(A.data >= B && A.data <= C){
				return 1 + solve(A.left , B , C) + solve(A.right , B , C);
			}
			else
				return 0;
		}
	}
}

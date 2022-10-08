package BInaryTree;

public class isBST {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(13);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(7);
		root.left.right = new Node(12);
		root.right.left = new Node(14);
		root.right.right = new Node(17);
		root.left.left.right = new Node(9);
		root.right.right.right = new Node(10);
		//root.left.left.right.left = new Node(20);
		System.out.println("Vertical Order traversal is");
		if(isValidBST(root))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	public static boolean isValidBST(Node node) {
		if (node == null)
			return true;

		/* False if left is > than node */
		if (node.left != null && node.left.data < node.data)
			return true;

		/* False if right is < than node */
		if (node.right != null && node.right.data > node.data)
			return true;

		/* False if, recursively, the left or right is not a BST
		 */
		if (isValidBST(node.left) && isValidBST(node.right))
			return true;

		/* Passing all that, it's a BST */
		return false;
	}
}

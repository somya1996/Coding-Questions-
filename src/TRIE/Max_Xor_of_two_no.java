package TRIE;

public class Max_Xor_of_two_no {
	class TriNode{
		TriNode left;
		TriNode right;
		TriNode(){
			left = null;
			right = null;
		}
	}
	TriNode root = new TriNode();
	public static void main(String[] args){
		int A[] = {5 , 17 , 100 , 11};
		Max_Xor_of_two_no mx = new Max_Xor_of_two_no();
		int max_xor = mx.solve(A);
		System.out.println(max_xor);
	}
	public int solve(int[] A){
		for(int i=0; i<A.length; i++){
			insert(root  , A[i]);
		}
		int max_xor = 0;
		for(int i=0; i<A.length; i++){
			int current_xor = find_max_xor(root , A[i]);
			max_xor = Math.max(max_xor , current_xor);
		}
		return max_xor;
	}
	public void insert(TriNode root , int num){
		TriNode temp = root;
		for(int j = 31; j>=0; j--){
			int bit = (num>>j)&1;
			if(bit == 0){
				if(temp.left == null)
					temp.left = new TriNode();
				temp = temp.left;
			}
			else{
				if(temp.right == null)
					temp.right = new TriNode();
				temp = temp.right;
			}
		}
	}
	public int find_max_xor(TriNode root , int num){
		int current_ans = 0;
		TriNode temp = root;

		for(int j=31; j>=0; j--){
			int bit = (num>>j)&1;
			if(bit == 0){
				if(temp.right != null){
					temp = temp.right;
					current_ans = current_ans + (1<<j);
				}
				else{
					temp = temp.left;
				}
			}
			else{
				if(temp.left != null){
					temp = temp.left;
					current_ans = current_ans + (1<<j);
				}
				else
					temp = temp.right;
			}
		}
		return current_ans;
	}
}

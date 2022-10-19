package TRIE;

import java.util.Scanner;

public class Max_Xor_Subarray {
	class TrieNode{
		int val;
		int idx;
		TrieNode arr[] = new TrieNode[2];
		TrieNode(){
			val = 0;
			idx = -1;
			arr[0] = null;
			arr[1]  = null;
		}
	}
	class Pair{
		int result ;
		int idx ;
		Pair(int a , int b){
			result = a;
			idx = b;
		}
	}
	TrieNode root = new TrieNode();

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<A.length; i++){
			A[i] = sc.nextInt();
		}
		Max_Xor_Subarray mxs = new Max_Xor_Subarray();
		int ans[] = mxs.solve(A);

		System.out.println();
		System.out.println(">>>>>>>>FINAL ANSWER>>>>>>>>>");
		System.out.println("start "+ans[0]);
		System.out.println("end "+ans[1]);
	}
	public int[] solve(int[] arr) {
		int[] prefix_xor = new int[arr.length];

		prefix_xor[0] = arr[0];
		for(int i=1; i<arr.length; i++){
			prefix_xor[i] = prefix_xor[i-1] ^ arr[i];
		}

		System.out.println();
		//Printing prefix xor
		for(int i=0; i<prefix_xor.length; i++){
			System.out.print(prefix_xor[i]+" ");
		}

		insert(0 , -1);
		int start_idx = -1;
		int end_idx = -1;
		int max_xor = Integer.MIN_VALUE;

		for(int i=0; i<prefix_xor.length; i++){
			insert(prefix_xor[i] , i);
			Pair ans = find_max_xor(prefix_xor[i]);
			System.out.println();
			System.out.println("prefix["+i+"] "+prefix_xor[i]);
			System.out.println("Xor pair  "+ans.result);

			if(ans.result > max_xor){
				start_idx = ans.idx+1;
				System.out.println("start index "+start_idx);
				end_idx = i;
				System.out.println("end index "+end_idx);
				max_xor = ans.result;
				System.out.println("max xor "+max_xor);
			}
			else if(ans.result == max_xor){
				int max_length = end_idx - start_idx + 1;
				System.out.println("max Length "+max_length);
				int curr_length = i - ans.idx;
				System.out.println("current length "+curr_length);
				if(curr_length < max_length){
					start_idx = ans.idx+1;
					System.out.println("start index "+start_idx);
					end_idx = i;
					System.out.println("end index "+end_idx);
				}
				else if(curr_length == max_length && ans.idx < start_idx){
					start_idx = ans.idx+1;
					System.out.println("start index "+start_idx);
					end_idx = i;
					System.out.println("end index "+end_idx);
				}
			}
		}
		int res[] = new int[2];
		res[0] = start_idx+1;
		res[1] = end_idx+1;
		return res;
	}
	public Pair find_max_xor(int value){
		TrieNode temp = root;
		for (int i = 31 - 1; i >= 0; i--) {
			int val = ((value >> i )& 1) >= 1 ? 1 : 0;
			if (temp.arr[1 - val] != null)
				temp = temp.arr[1 - val];
			else if (temp.arr[val] != null)
				temp = temp.arr[val];
		}
		return (new Pair( temp.val^value, temp.idx));
	}
	public void insert(int value , int index){
		TrieNode temp = root;
		for (int i = 31 - 1; i >= 0; i--) {
			int bit = ((value >> i) & 1);
			if (temp.arr[bit] == null)
				temp.arr[bit] = new TrieNode();

			temp = temp.arr[bit];
		}
		temp.val = value;
		temp.idx = index;
	}
}

package TRIE;

import java.util.HashMap;
import java.util.Scanner;

public class Dictionary_search {
	class TriNode{
		char data;
		boolean isTerminal;
		HashMap<Character , TriNode>hm;
		TriNode(char d){
			data = d;
			isTerminal = false;
			hm = new HashMap<>();
		}
	}

	TriNode root = new TriNode('\0');

	public static  void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("size");
		int n = sc.nextInt();
		sc.nextLine();
		String A[] = new String[n];
		System.out.println("Print words in array of string a");
		for(int i=0; i<n; i++){
			A[i] = sc.nextLine();
		}
		System.out.println("Print words in array of string B");
		String B[] = new String[n];
		for(int i=0; i<n; i++){
			B[i] = sc.nextLine();
		}
		Dictionary_search ds = new Dictionary_search();
		int[] ans = ds.solve(A,B);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}

	public int[] solve(String[] A, String[] B) {
		int ans[] = new int[B.length];
		for(int i=0; i<A.length; i++){
			insert(root , A[i]);// inserting string word by word in TRIE
		}

		for(int i=0; i<B.length; i++){
			boolean a = search(root ,B[i]);
			if(a == true)
				ans[i] = 1;
			else
				ans[i] = 0;
		}
		return ans;
	}
	public void insert(TriNode root , String A){
		TriNode temp = root;
		for(int i=0; i<A.length(); i++){
			char s = A.charAt(i);
			if(!temp.hm.containsKey(s)){
				TriNode n = new TriNode(s);
				temp.hm.put(s , n);
			}
			temp = temp.hm.get(s);
		}
		temp.isTerminal = true;
	}

	public boolean search(TriNode root , String A){
		TriNode temp = root;
		for(int i=0; i<A.length(); i++){
			char ch = A.charAt(i);
			if(!temp.hm.containsKey(ch))
				return false;
			temp = temp.hm.get(ch);
		}
		return temp.isTerminal; // this return terminal is ending or not
	}
}

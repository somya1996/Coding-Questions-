package TRIE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Max_Sum_Pair {
	class TrieNode{
		char value;
		int digit;
		HashMap<Character,TrieNode>hm;
		boolean isTerminal;
		TrieNode(char val){
			value = val;
			digit = -1;
			hm = new HashMap<>();
			isTerminal = false;
		}
	}
	TrieNode root = new TrieNode('\0');
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println(" size ");
		int n  = sc.nextInt();
		sc.nextLine();
		String[] str = new String[n];
		System.out.println("String values");
		for(int i=0; i<n; i++){
			str[i] = sc.nextLine();
		}

		int[] B = new int[n];
		System.out.println(" B values ");
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}
		Max_Sum_Pair msp = new Max_Sum_Pair();
		int[] ans = msp.solve(str,B);

		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i]+" ");
	}
	public int[] solve(String[] A, int[] B) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0; i<A.length; i++){
			if(B[i]==-1){
				int sum = find_sum_of_element(A[i]);
				al.add(sum);
			}
			else{
				buildTree(A[i],B[i]);
			}
		}
		int ans[] = new int[al.size()];
		for(int i=0; i<al.size(); i++){
			ans[i] = al.get(i);
		}
		return ans;
	}
	public void buildTree(String word , int weight){
		TrieNode temp = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(!temp.hm.containsKey(ch)){
				TrieNode n = new TrieNode(ch);
				temp.hm.put(ch , n);
			}
			temp.hm.get(ch).digit += weight;
		}
		temp.isTerminal = true;
	}
	public int find_sum_of_element(String word){
		TrieNode temp = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(temp.hm.containsKey(ch))
				temp = temp.hm.get(ch);
			else
				return 0;
		}
		return temp.digit;
	}
}

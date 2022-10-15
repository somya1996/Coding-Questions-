package TRIE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shortest_Unique_Prefix {
	class TriNode{
		char data;
		boolean isTerminal;
		int weight ;
		HashMap<Character , TriNode>hm;
		TriNode(char d){
			data = d;
			isTerminal = false;
			hm = new HashMap<>();
			weight = 0;
		}
	}

	TriNode root = new TriNode('\0');

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("size");
		int n = sc.nextInt();
		sc.nextLine();
		String A[] = new String[n];
		System.out.println("Print words in array of string a");
		for(int i=0; i<n; i++){
			A[i] = sc.nextLine();
		}

		Shortest_Unique_Prefix sup = new Shortest_Unique_Prefix();
		String[] ans = sup.prefix(A);

		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}

	public String[] prefix(String[] A) {
		ArrayList<String> al = new ArrayList<>();
		for(int i=0; i<A.length; i++){
			insertTrie(root , A[i]);
		}
		for(int i=0; i<A.length; i++){
			al.add(findPrefix(root , A[i]));
		}

		String ans[] = new String[al.size()];
		for(int i=0; i<al.size(); i++){
			ans[i] = al.get(i);
		}
		return ans;
	}
	public void insertTrie(TriNode root , String word){
		TriNode temp = root;
		for(int i=0; i<word.length(); i++){
			char s = word.charAt(i);
			if(!temp.hm.containsKey(s)){
				TriNode n = new TriNode(s);
				temp.hm.put(s , n);
				temp.weight++;
			}
			else{
				temp.weight++;
			}
			temp = temp.hm.get(s);
		}
		temp.isTerminal = true;
	}

	public String findPrefix (TriNode root , String word){
		StringBuilder sb = new StringBuilder();
		TriNode temp = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(temp.weight == 1){
				//sb.append(ch);
				return sb.toString();
			}
			else{
				sb.append(ch);
				temp = temp.hm.get(ch);
			}
		}
		return sb.toString();
	}
}

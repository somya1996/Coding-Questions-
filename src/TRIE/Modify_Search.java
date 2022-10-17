package TRIE;

import java.util.HashMap;
import java.util.Scanner;

public class Modify_Search {
	class TriNode{
		HashMap<Character,TriNode> hm;
		boolean isTerminal;
		TriNode(){
			hm = new HashMap<>();
			isTerminal = false;
		}
	}
	TriNode root = new TriNode();

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("size of n");
		int n = sc.nextInt();

		String[] a = new String[n];
		System.out.println("insert in string a");
		sc.nextLine();
		for(int i=0; i<n; i++){
			a[i] = sc.nextLine();
		}

		System.out.println("size of m");
		int m = sc.nextInt();

		String[] b = new String[m];
		System.out.println("insert in string b");
		sc.nextLine();
		for(int i=0; i<m; i++){
			b[i] = sc.nextLine();
		}

		Modify_Search ms = new Modify_Search();
		String ans = ms.solve(a , b);
		System.out.println(ans);
	}
	public String solve(String[] A, String[] B) {
		for(int i=0; i<A.length; i++){
			insert(root , A[i]);
		}
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<B.length; i++){
			if(search_Trie(B[i], root, 0 , 0) == true)
				answer.append('1');
			else
				answer.append('0');
		}
		return answer.toString();
	}
	public void insert(TriNode root , String word){
		TriNode temp = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(!temp.hm.containsKey(ch)){
				//TriNode n = new TriNode(ch);
				temp.hm.put(ch,new TriNode());
			}
			temp = temp.hm.get(ch);
		}
		temp.isTerminal = true;
	}
	public boolean search_Trie(String str , TriNode root , int index , int isModified){
		boolean ans = false;
		int size = str.length();
		if(size == index){
			if(isModified == 1 && root.isTerminal == true)
				return true;
			else
				return false;
		}
		char ch = str.charAt(index);

		if(isModified == 0){
			for(char c : root.hm.keySet()){
				// if found then no modification is needed
				if(ch == c)
					ans = ans || search_Trie(str , root.hm.get(c) , index+1 , isModified);
				else
					ans = ans || search_Trie(str , root.hm.get(c) , index+1 , 1);
			}
		}
		else{ // if ismodified is true
			if(root.hm.containsKey(ch) == true)
				ans = ans || search_Trie(str , root.hm.get(ch) , index+1 , isModified);
		}
		return ans;
	}
}

package QUEUE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Phone_directory {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String digit = sc.nextLine();
		ArrayList<String> ans = letterCombinations(digit);
		System.out.println(ans);
	}
	public static ArrayList<String> letterCombinations(String A) {
		LinkedList<String> ll = new LinkedList<>();
		String[] mapping = {"0" , "1" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
		for(int i=0; i<A.length(); i++){
			int x = A.charAt(i)-'0';
			ll.add("");
			int size = ll.size();
			while(size>0){
				String t = ll.poll();
				for(char s : mapping[x].toCharArray())
					ll.add(t+s);
				size--;
			}
		}
		ArrayList<String> ans = new ArrayList<>();
		for(int i=0; i<ll.size(); i++){
			ans.add(ll.poll());
		}
		return ans;
	}
}

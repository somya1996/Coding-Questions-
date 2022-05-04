package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		HashMap<Character , Integer> hm = new HashMap<>();
		int mid = 0;
		if(str.length()%2==0)
			mid = str.length()/2;
		else
			mid = (str.length()/2)+1;
		for(int i=0; i<mid; i++){
			hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
		}
		for(int i=mid; i<str.length(); i++){
			if(hm.containsKey(str.charAt(i)))
				hm.put(str.charAt(i),hm.get(str.charAt(i))-1);
			else
				hm.put(str.charAt(i),1);
		}

		System.out.println(hm);
		int count = 0;
		for(int i: hm.values()){
			if(i>=1)
				count++;
		}
		//System.out.println(count);
		if(count==0||count==1)
			System.out.println("Is pallindrome ");
		else
			System.out.println(" Not pallindrome ");
	}
}

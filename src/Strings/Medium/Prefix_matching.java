package Strings.Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class Prefix_matching {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//ArrayList<String> al = new ArrayList<>();
		int n = sc.nextInt();

		sc.nextLine();
		ArrayList<String> al = new ArrayList<String>();
		while (n>0)
		{
			String i = sc.nextLine();
			al.add(i);
			n--;
		}
		System.out.println(al);
		String B = sc.nextLine();
		ArrayList<Integer> ans = new ArrayList<>() ;
		ans = solve(al , B);
		//solve(al , B);
		System.out.println(ans);

	}
	public static ArrayList<Integer> solve(ArrayList<String> A, String B) {
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> pairs = new ArrayList<>();
		for(int i=0; i<A.size(); i++) {
			String c = A.get(i);
			if (c.startsWith(B)) {  // startsWith - O(n)
				ans.add(i);
			}
		}

		if(ans.size()>0){
			pairs.add(ans.get(0));
			pairs.add(ans.get(ans.size()-1));
		}
		else
		{
			pairs.add(-1);
			pairs.add(-1);
		}
		return pairs;
		//System.out.println(pairs);
	}
}

package Strings.Hard;

import java.util.ArrayList;
import java.util.Scanner;

public class KMP_ALGORITHM {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine();
		String pat = sc.nextLine();
		int[] idx = search(txt , pat);
		for(int i=0; i<idx.length; i++)
			System.out.println(idx[i]);
	}
	public static int[] search(String txt , String pat){
		String s = pat+"$"+txt;
		int[] LPS = generate(s);
		System.out.println();
		ArrayList<Integer> al = new ArrayList<>();
		for(int k=0; k<s.length(); k++){
			if(LPS[k] == pat.length()){
				int startidx = k-pat.length();
				al.add(startidx-(pat.length()));
			}
		}
		System.out.println(al);
		int ans[] = new int[al.size()];
		for(int k=0; k<al.size(); k++){
			ans[k] = al.get(k);
		}
		//if(ans.length == 0)
		//	return new int[]{};
		return ans;
	}
	public static int[] generate(String s){
		int[] LPS = new int[s.length()];
		int i=1 , j = 0;
		LPS[0] = 0;
		while(i<s.length()){
			if(s.charAt(i) == s.charAt(j)){
				LPS[i++] = j+1;
				j++;
			}
			else{
				if(j==0)
					LPS[i++] = 0;
				else
					j = LPS[j-1];
			}
		}
		for(int k=0; k<LPS.length; k++){
			System.out.print(LPS[k]+" ");
		}
		return LPS;
	}
}

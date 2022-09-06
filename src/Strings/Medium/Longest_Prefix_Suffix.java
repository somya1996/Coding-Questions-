package Strings.Medium;

import java.util.Scanner;

public class Longest_Prefix_Suffix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = lps(s);
		System.out.println(count);
	}
	static int lps(String s) {
		int[] LPS = new int[s.length()];
		LPS[0] = 0;
		int j = 0 , i = 1;
		while(i<s.length()){
			if(s.charAt(i) == s.charAt(j)){
				LPS[i] = j+1;
				i++;
				j++;
			}
			else{
				if(j == 0)
					LPS[i++] = 0;
				else
					j = LPS[j-1];
			}
		}
		for(int k=0; k<s.length(); k++)
			System.out.print(LPS[k]+" ");


		return LPS[i-1];
	}
}

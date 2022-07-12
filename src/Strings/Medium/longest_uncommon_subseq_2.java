package Strings.Medium;

import java.util.Scanner;

public class longest_uncommon_subseq_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] s = new String[n];
		for(int i=0; i<n; i++) {
			 s[i] = sc.nextLine();
		}
		int len = l_uc_s_2(s);
		System.out.println(len);
	}
	public static int l_uc_s_2(String[] str){
		int maxlen = -1;
		int n = str.length;
		for(int i=0; i<n; i++){
			String curr = str[i];
			int j = -1;
			while(++j < n){
				if(i != j && issubseq(str[i] , str[j]))
					break;
			}
			if(j == n)
				maxlen = Math.max(maxlen , curr.length());
		}
		return maxlen;
	}
	public static boolean issubseq(String a , String b){
		int i=0 , j = 0;
		while(i<a.length() && j<b.length()){
			if(a.charAt(i) == b.charAt(j)){
				i++;
			}
			j++;
		}
		return i == a.length();
	}
}

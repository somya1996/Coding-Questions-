package Strings.Medium;

import java.util.Scanner;

public class Minimum_operation_needed_convert_to__string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int ans = minCostToGivenString(str1 , str2);
		System.out.println(ans);
	}
	public static int minCostToGivenString(String str1, String str2) {
		if(str1.length() != str2.length())
			return -1;
		int[]freq = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
				freq[str1.charAt(i) - 'a']++;
			} else {
				freq[str1.charAt(i) - 'A']++;
			}
		}

		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
				freq[str2.charAt(i) - 'a']--;
			} else {
				freq[str2.charAt(i) - 'A']--;
			}
		}

		for (int i = 0; i < 52; i++) {
			if (freq[i] != 0) {
				return -1;
			}
		}
		char s1[] = str1.toCharArray();
		char s2[] = str2.toCharArray();
		int i = 0 , count = 0;
		while(i < s1.length){
			int j = i;
			if(s1[i] == s2[j]){
				i++;
				j++;
			}
			else{
				while(j<s2.length && s2[j]!=s1[i])
					j++;
				if(j == s2.length)
					return -1;
				if(s2[j] == s1[i]) {
					char temp = s2[i];
					s2[i] = s2[j];
					s2[j] = temp;
					count++;
				}
				j = i;
			}
		}

		return count;


		/*if(str1.length()<str2.length())
			return -1;
		int count = 0;
		int i=0;
		int j=0;
		while(i<str1.length() && j<str2.length()){
			if(str1.charAt(i)==str2.charAt(j)){
				i++;
				j++;
			}
			else{
				count++;
				i++;
			}
		}
		return count;*/
	}
}

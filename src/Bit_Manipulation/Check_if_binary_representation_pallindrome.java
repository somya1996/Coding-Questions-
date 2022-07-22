package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class Check_if_binary_representation_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		boolean ans = checkPalindrome(n);
		System.out.println(ans);
	}
	public static boolean checkPalindrome(long N) {
		ArrayList<Long> al = new ArrayList<Long>();
		while(N !=0){
			al.add(0 , N%2);
			N = N/2;
		}
		System.out.println(al);
		int start = 0 , end = al.size()-1;

		while(start <= end){
			if(al.get(start) != al.get(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}

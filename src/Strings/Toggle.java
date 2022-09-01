package Strings;

import java.util.Scanner;

public class Toggle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String res = toggleCase(s);
		System.out.println(res);
	}
	public static String toggleCase(String s){
		/*// TC - O(n)    SC - O(n)
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length; i++){
			int val = arr[i];
			if(arr[i]>='a' && arr[i]<='z')
				arr[i] = (char)(val-32);
			else
				arr[i] = (char)(val+32);
		}
		String ans = "";
		for(int i=0; i<arr.length; i++){
			ans += arr[i];
		}
		return ans;*/

		// little faster than previous solution
		char[] A = s.toCharArray();
		for(int i=0; i<A.length;i++) {
			A[i] ^= 32;
		}

		return new String(A);
	}
}

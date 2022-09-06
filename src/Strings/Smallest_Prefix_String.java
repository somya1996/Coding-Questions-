package Strings;

import java.util.Scanner;

public class Smallest_Prefix_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		String ans = smallestPrefix(A , B);
		System.out.println(ans);
	}
	public static String smallestPrefix(String A, String B) {
		String ans = "";
		ans = ans + A.charAt(0);
		int i=1 , j = 0;
		while(i<A.length() && j<B.length()){
			if(A.charAt(i)<B.charAt(j)){
				ans = ans + A.charAt(i);
				i++;
			}
			else{// if(A.charAt(i) >= B.charAt(j)){
				ans = ans + B.charAt(j);
				j++;
				break;
			}
		}
		if(j < 1){
			ans = ans + B.charAt(j);
			j++;
		}
		return ans;
	}
}

package Strings.Medium;

import java.util.Scanner;

public class Make_String_Pallindrome_at_begining {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int ans = solve(A);
		System.out.println(ans);
	}
	// TIME COMPLEXITY  -> O(n^2)
	// USING prefix substring of reverse of a string and checking is it pallindrome

	/*public static int solve(String A){
		A = rev(A);
		String ans = "";
		int len = 0;
		for(int i=0; i<A.length(); i++){
			ans = ans + A.charAt(i);
			if(isPallindrome(ans))
				len = ans.length();
		}
		int diff = A.length()-len;
		return diff;
	}
	public static boolean isPallindrome(String a){
		int i=0 , j = a.length()-1;
		while(i<j){
			if(a.charAt(i) != a.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}*/
	public static int solve(String A) {
		int n = A.length();
		A = A + '$' + rev(A) ;
		int LPS[] = generate(A);
		int len = n - LPS[A.length()-1];
		return len;
	}
	public static String rev(String A){
		StringBuilder str = new StringBuilder(A);
		str.reverse();
		return str.toString();
	}
	public static int[] generate(String A){
		int []LPS = new int[A.length()];
		LPS[0] = 0;
		int j = 0 , i =  1;
		while(i<A.length()){
			if(A.charAt(i)==A.charAt(j)){
				LPS[i++] = j+1;
				j++;
			}
			else{
				if(j==0)
					LPS[i++] = 0;
				else{
					j = LPS[j-1];
				}
			}
		}
		for(int k=0; k<A.length(); k++){
			System.out.print(LPS[k]+" ");
		}
		System.out.println();
		return LPS;
	}
}

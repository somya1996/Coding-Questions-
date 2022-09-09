package Strings.Medium;

import java.util.Scanner;

public class Repeated_String_Match {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int ans = repeatedStringMatch(a , b);
		System.out.println(ans);
	}
	public static int repeatedStringMatch(String A, String B) {
		/*// Time complexity O(N*M)
		String t="";
		int count=0;
		int k = A.length() + B.length(); // O(N+M)
		while(k >= t.length()){
			t = t+A;  //O(n)
			count++;
			if(t.contains(B)) // O(n)
				return count;
		}
		return -1;*/

		String t = A;
		int count = 1;
		while(t.length()<B.length()){
			t += A;
			count++;
		}
		//System.out.println(t);
		//System.out.println(count);
		if(check(A,B) == true){
			return count;
		}
		else if(check(A+t , B) == true) {
			return count + 1;
		}
		return -1;
	}
	public static boolean check(String a , String b){
		String s = b+'$'+a;
		int LPS[] = new int[s.length()];
		LPS[0] = 0;
		int i = 1 , j = 0;
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
		for(int k=0; k<LPS.length; k++){
			if(LPS[k] == b.length())
				return true;
		}
		return false;
	}
}

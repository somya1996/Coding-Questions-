package Strings.Medium;

import java.util.Scanner;

public class Minimum_distance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Minimum_distance m = new Minimum_distance();
		System.out.println(m.solve(s));
	}
	public int solve(String A) {
		int ans = Integer.MAX_VALUE;
		int start = -1 , end = -1;
		for(int i=0; i<A.length(); i++){
			if(A.charAt(i) == 'x'){
				start = i;
				if(end != -1){
					ans = Math.min(ans , (int)Math.abs(end - start));
				}
			}
			if(A.charAt(i) == 'o'){
				end = i;
				if(start != -1){
					ans = Math.min(ans , (int)Math.abs(start-end));
				}
			}
		}
		return ans;
	}
}

package Array;

import java.util.Scanner;

public class Complete_the_Staircase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = completeRows(n);
		System.out.println(ans);
	}
	public static int completeRows(int n) {
		int start = 1 , i = 0;
		while(n >= 0){
			i++;
			n = n - start;
			start++;
		}
		return i;
	}
}

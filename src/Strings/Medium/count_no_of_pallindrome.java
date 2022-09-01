package Strings.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class count_no_of_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = CountPS(s , s.length());
		System.out.println(ans);
	}
	public static int CountPS(String S, int N)
	{
		int count = 0 ;
		int dp[][] = new int[N][N];

		for(int[] rows: dp)
			Arrays.fill(rows , 0);

		for(int i=0; i<N; i++){
			dp[i][i] = 1;
		}

		for(int i=0; i<N-1; i++){
			if(S.charAt(i)==S.charAt(i+1)){
				dp[i][i+1] = 1;
				count++;
			}
		}

		for(int len = 3; len <= N ; len++){
			for(int i=0; i < N-len+1 ; i++){
				int j = i+len-1;
				if(S.charAt(i) == S.charAt(j) && dp[i+1][j-1]==1){
					dp[i][j] = 1;
					count++;
				}
			}
		}
		return count;
	}
}

package Greedy_Algorithm;

import java.util.Scanner;

public class Another_coin_problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Another_coin_problem acp = new Another_coin_problem();
		int ans = acp.solve(n);
		System.out.println(ans);
	}
	public int solve(int A) {
		int ans=0;
		while(A>0){
			ans+=A%5;
			A=A/5;
		}
		return ans;
	}
}

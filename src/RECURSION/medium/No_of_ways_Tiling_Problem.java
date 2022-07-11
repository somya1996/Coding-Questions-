package RECURSION.medium;

import java.util.Scanner;
// NX4 ways of tiles
public class No_of_ways_Tiling_Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = ways(n);
		System.out.println(ans);
	}
	public static long ways(int n){
		if(n == 1)
			return 1L;
		if(n == 2)
			return 1L;
		if(n == 3)
			return 1L;
		if(n == 4)
			return 2L;
		return ways(n-1) + ways(n-4);
	}
}

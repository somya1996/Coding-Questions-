package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Square_root_using_binary_without_precision {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = sq_root(n);
		System.out.println(ans);
	}
	public static int sq_root(int n){
		int start = 0 , end = n;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid * mid == n) {
				ans = mid;
				break;
			}
			if (mid * mid < n) {
				start = mid + 1;
				ans = mid;
			}
			else {
				end = mid - 1;
			}
		}
		return ans;
	}
}

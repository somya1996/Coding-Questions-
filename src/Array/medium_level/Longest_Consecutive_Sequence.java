package Array.medium_level;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Longest_Consecutive_Sequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int length = longestConsecutive(arr);
		System.out.println(length);
	}
	public static int longestConsecutive(final int[] A) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int num : A) {
			hs.add(num);
		}

		int ans = 0;

		for (int num : hs) {
			if (!hs.contains(num-1)) {
				int curr_val = num;
				int count = 1;

				while (hs.contains(curr_val+1)) {
					curr_val += 1;
					count += 1;
				}

				ans = Math.max(ans, count);
			}
		}

		return ans;
	}
}

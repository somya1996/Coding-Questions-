package Array.medium_level.JUMP_GAME_PATTERN;

import java.util.Scanner;

public class reachable_last_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(jumps(arr));
	}

	public static boolean jumps(int[] arr) {
		int n = arr.length;
		int maxlen = 0;
		for(int i = 0; i<n; i++){
			if(i > maxlen)
				return false;
			maxlen = Math.max(maxlen , i+arr[i]);
		}
		return true;
	}
}

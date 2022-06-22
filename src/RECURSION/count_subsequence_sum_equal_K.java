package RECURSION;

import java.util.ArrayList;
import java.util.Scanner;

public class count_subsequence_sum_equal_K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer>al = new ArrayList<>();
		int k = sc.nextInt();
		System.out.println(count_subsequence(0 , arr , n , k , 0 ));
	}
	public static int count_subsequence(int index , int[] arr , int n , int k , int sum ){
		if (index == n) {
			if (sum == k){
				//for (int x : al) {
				//	System.out.print(x + " ");
				//}
				//System.out.println();
				return 1;
			}
			return 0;
		}

		//al.add(arr[index]);
		sum += arr[index];
		int l = count_subsequence(index + 1, arr, n, k, sum);
		//al.remove(al.size() - 1);
		sum -= arr[index];
		int r = count_subsequence(index + 1, arr, n, k, sum);
		return l+r;
	}
}

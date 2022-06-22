package RECURSION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Printing_subsequence_whose_sum_is_K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		ArrayList<Integer>al = new ArrayList<>();
		subsequence_sum(0 , arr , al , n , k , 0);
	}
	// printing all subssequence whose sum is sum
	/*public static void subsequence_sum(int idx , int[]arr , ArrayList<Integer> al , int n , int k , int sum){
		if(idx == n){
			if (sum == k) {
				//if (al.size() > 0)
				for (int x : al) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
			return;
		}

		sum += arr[idx];
		al.add(arr[idx]);
		subsequence_sum(idx+1,arr,al,n,k,sum);

		al.remove(al.size()-1);
		sum -= arr[idx];
		subsequence_sum(idx+1,arr,al,n,k,sum);
	}*/

	// print only one subsequence as ans whose sum is equal to given sum
	public static boolean subsequence_sum(int idx , int[]arr , ArrayList<Integer> al , int n , int k , int sum) {
		if (idx == n) {
			if (sum == k){
				for (int x : al) {
					System.out.print(x + " ");
				}
				System.out.println();
				return true;
			}
			return false;
		}

		al.add(arr[idx]);
		sum += arr[idx];
		if(subsequence_sum(idx + 1, arr, al, n, k, sum) == true)
			return true;
		al.remove(al.size() - 1);
		sum -= arr[idx];
		if(subsequence_sum(idx + 1, arr, al, n, k, sum) == true)
			return true;
		return false;
	}
}

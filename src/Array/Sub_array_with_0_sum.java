package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Sub_array_with_0_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = solve(arr);
		System.out.println(ans);
	}
	public static int solve(int[] A) {
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		hm.put(0,-1);
		int sum = 0;
		for(int i=0; i<A.length; i++){
			sum += A[i];
			if(hm.containsKey(sum)){
				return 1;
			}

			else{
				hm.put(A[i],i);
			}
		}
		return 0;
	}
}

package Array.medium_level.prefix_sum;

import java.util.HashMap;
import java.util.Scanner;

public class Longest_Sub_Array_with_Sum_K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int k = sc.nextInt();

		int ans = lenOfLongSubarr(arr , n , k);
		System.out.println(ans);
	}
	public static int lenOfLongSubarr (int A[], int N, int K) {
		/*int len = 0;
		int l = 0 , r = 0;
		int sum = 0;
		while(r < N){
			sum += A[r];
			if(sum < 0)
				r++;
			else if(sum == K){
				len = Math.max(len , r-l+1);
				r++;
			}
			else if(sum > K) {
				while (sum > K) {
					sum -= A[l];
					l++;
				}
				if (sum == K)
					len = Math.max(len, r - l + 1);
			}
			r++;
		}*/
		int maxlen = 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		hm.put(0,-1);
		int sum = 0;
		for(int i=0; i<N; i++){
			sum += A[i];
			if(hm.containsKey(sum-K)){
				maxlen = Math.max(i - hm.get(sum-K) , maxlen);
			}
			else{
				hm.put(sum , i);
			}
		}
		return maxlen;
	}

}

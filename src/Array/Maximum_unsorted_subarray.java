package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_unsorted_subarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans[] = subUnsort(arr);

		for(int i = 0; i<ans.length; i++){
			System.out.println(ans[i]);
		}
	}
	public static int[] subUnsort(int[] A) {
		int n = A.length;
		int i = 0 , j = n -1;

		while(i<n-1 && A[i]<=A[i+1]) {
			i++;
		}

		while(j > 0 && A[j]>=A[j-1]){
			j--;
		}

		if(i == n-1) {
			int ans[] = new int[1];
			ans[0] = -1;
			return ans;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int x=i; x<=j; x++){
			max = Math.max(max , A[x]);
			min = Math.min(min , A[x]);
		}
		System.out.println("Max "+max);
		System.out.println("Min "+min);

		int low = -1 , high = -1;
		for(int x=0; x<n; x++){
			if(A[x] > min) {
				low = x;
				System.out.println("low "+low);
				break;
			}
		}

		for(int x = n-1; x>=0; x-- ){
			if(A[x] < max){
				high = x;
				System.out.println("high "+high);
				break;
			}
		}
		int ans[] = new int[2];
		ans[0] = low;
		ans[1] = high;
		return ans;

		/*
		public int[] subUnsort(int[] A) {
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < n - 1 && A[i] <= A[i + 1]) {
            i++;
        }
        while (j > 0 && A[j] >= A[j - 1]) {
            j--;
        }
        if (i == n - 1) { // if array is already sorted, output -1
            int ans[] = new int[1];
            ans[0] = -1;
            return ans;
        }
        int mn = A[i + 1], mx = A[i + 1];
        for (int k = i; k <= j; k++) {
            mx = Math.max(mx, A[k]);
            mn = Math.min(mn, A[k]);
        }
        int l = 0, r = n - 1;
        while (A[l] <= mn && l <= i) {
            l++;
        }
        while (A[r] >= mx && r >= j) {
            r--;
        }
        int ans[] = new int[2];
        ans[0] = l;
        ans[1] = r;
        return ans;
		 */
	}
}

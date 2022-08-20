package Sorting_Techniques.Medium;

import java.util.Scanner;
// TC - O(min(log m, log n))
// SC - O(1)
public class Median_of_sorted_array_optimal_approach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for(int i=0; i< arr.length; i++)
			arr[i] = sc.nextInt();

		int m = sc.nextInt();
		int brr[] = new int[m];
		for(int i=0; i<m; i++){
			brr[i] = sc.nextInt();
		}

		double median = findMedianSortedArrays(arr , brr);
		System.out.println(median);
	}
	public static double findMedianSortedArrays(int[] A , int[] B) {
		int n = A.length;
		int m = B.length;

		if(n > m){
			return findMedianSortedArrays(B , A); // Swapping to make A smaller
		}

		int low = 0 ;
		int high = n;
		int real_median = (n+m+1)/2;

		while(low <= high){
			int mid = (low+high)/2;
			int cut1 = mid;
			System.out.println(cut1);
			int cut2 = real_median - cut1;
			System.out.println(cut2);

			int left1 = (cut1>0) ? A[cut1-1] : Integer.MIN_VALUE;
			int left2 = (cut2>0) ? B[cut2-1] : Integer.MIN_VALUE;

			int right1 = (cut1<n) ? A[cut1] : Integer.MAX_VALUE;
			int right2 = (cut2<m) ? B[cut2] : Integer.MAX_VALUE;

			if (left1 <= right2 && left2 <= right1){
				if((n + m) % 2 == 0){
					return (Math.max(left1, left2)+Math.min(right1,right2))/2.0;
				}
				else{
					return Math.max(left1 , left2);
				}
			}
			else if(left1 > right2)
				high = cut1-1;
			else
				low = cut1+1;
		}
		return 0.0;
	}
}

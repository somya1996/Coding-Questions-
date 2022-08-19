package Sorting_Techniques.Medium;

import java.util.Scanner;

public class search_in_biotonic_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int B = sc.nextInt();
		int ans = solve(arr , B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int B) {
		if(A.length == 1)
			return 0;
		int max = get_max(A , 0 , A.length-1);
		System.out.println(max);
		int ans = -1;
		if(A[max] == B)
			return max;
		if(A[max] > B && B >= A[0])
			return binary_search(A , 0 , max , B);
		if(B < A[max] && B >= A[A.length-1] && ans == -1)
			ans = binary_search_Rev(A,max+1,A.length-1,B);
		return ans;
	}
	public static int get_max(int[]A , int start , int end){
		int m=0;
		while(start<=end){
			m=(start+end)/2;
			if(A[m]>A[m-1] && A[m]>A[m+1]){
				return m;
			}
			else if(A[m]>A[m-1] && A[m]<A[m+1])
				start = m+1;
			else
				end = m-1;
		}
		return start;
	}
	public static int binary_search(int[] A , int start , int end , int B){
		int  m=0;
		while(start <= end){
			m=(start+end)/2;
			if(A[m]==B)
				return m;
			else if(B<A[m])
				end = m-1;
			else
				start = m+1;
		}
		return -1;
	}
	public static int binary_search_Rev(int[] A , int start , int end , int B){
		int  m=0;
		while(start <= end){
			m=(start+end)/2;
			if(A[m]==B)
				return m;
			else if(B<A[m])
				start = m+1;
			else
				end = m-1;
		}
		return -1;
	}
}

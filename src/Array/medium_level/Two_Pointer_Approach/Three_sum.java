package Array.medium_level.Two_Pointer_Approach;

import java.util.Arrays;
import java.util.Scanner;

public class Three_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		 int Target = sc.nextInt();
		 int count = threeSumClosest(arr , Target);
		 System.out.println(count);
	}
	public static int threeSumClosest(int[] A, int B) {
		int val = Integer.MAX_VALUE;
		Arrays.sort(A);
		int n = A.length;
		for(int i=0; i<n-2; i++){
			int j = i+1 , k = n-1;
			//int t = B - A[i];
			while(j<k){
				int sum = A[j]+A[k]+A[i];
				if(Math.abs(B-sum) < Math.abs(B-val))
					val = sum;
				if(sum > B){
					k--;
				}
				else{
					j++;
				}
			}
		}
		return val;
	}
}

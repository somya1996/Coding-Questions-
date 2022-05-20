package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Maximum_positivity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans[] = solve(arr);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] solve(int[] A){
		int A1[]= new int[A.length];
		// created new array if element is positive then +1 and if it is negative then -1
		for(int i=0; i<A.length; i++){
			if(A[i]>0)
				A1[i] = 1;
			else
				A1[i] = -1;
		}

		for(int i=0; i<A1.length; i++){
			System.out.print(A1[i]+" ");
		}
		int L = 0 , R = 0 , best_L = 0 , best_R = 0 ;
		int sum = 0 , maxsofar = 0;
		for(int i=0; i<A1.length; i++){
			if(A1[i] == 1){
				sum += A1[i];
				R = i;
				if(sum > maxsofar){
					maxsofar = sum;
					best_L = L;
					best_R = R;
				}
			}
			if(A1[i] == -1 && i!=A1.length-1){
				if(sum > maxsofar){
					maxsofar = sum;
					best_L = L;
					best_R = R;
				}
				sum = 0;
				L = i+1;
			}
			System.out.println("" +
								" max_so_far "+maxsofar+
								" best_L "+best_L+
								" best_R "+best_R);
		}
		int ans[] = new int[maxsofar];
		int k = 0;
		for(int i=best_L; i<best_R+1; i++){
			ans[k++] = A[i];
		}
		return ans;

	}
}

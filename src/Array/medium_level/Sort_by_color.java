package Array.medium_level;

import java.util.Scanner;

public class Sort_by_color {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int ans[] = sortColors(arr);
		for(int i=0; i<n; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] sortColors(int[] A) {
		int i = 0 , j = 0 , k = A.length-1;
		while(j<=k){
			if( A[j] == 0){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
				j++;
			}
			else if(A[j] == 2){
				int temp = A[j];
				A[j] = A[k];
				A[k] = temp;
				k--;
			}
			else{
				j++;
			}
		}
		return A;
	}
}

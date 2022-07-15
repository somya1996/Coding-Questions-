package Array.medium_level;

import java.util.Scanner;

public class find_missing_positive_integer {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		find_missing_positive_integer fmpi = new find_missing_positive_integer();
		int ans = fmpi.firstMissingPositive(arr);
		System.out.println(ans);
	}
	public int firstMissingPositive(int[] A) {
		for(int i=0; i<A.length; i++){
			int element = A[i];
			//System.out.println(element);
			int pos = element-1;
			//System.out.println(pos);
			if(A[i] > 0 && pos < A.length){
				if(A[pos] != element) {
					swap(A, i, pos);
					i--;
				}
			}
		}
		for(int i=0; i<A.length; i++){
			if(i+1 != A[i])
				return i+1;
		}
		return A.length+1;
	}
	public static void swap(int[] A , int i , int chair){
			int temp = A[chair];
			A[chair] =  A[i];
			A[i] = temp;
	}

}

package Array;

import java.util.Arrays;
import java.util.Scanner;

public class if_two_array_equal {
	public static void main(String[] args){
			//initialization
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n ;i++)
			arr[i] = sc.nextInt();
		int brr[] = new int[n];
		for(int i=0;i<n ;i++)
			brr[i] = sc.nextInt();

		System.out.println(to_check_equal_array(arr,brr,n));
	}

	public static boolean to_check_equal_array(int[] arr, int[] brr, int n) {
		boolean flag = false;
		Arrays.sort(arr);
		Arrays.sort(brr);
		for(int i=0;i<n;i++) {
			if (arr[i] != brr[i]) // this will compare the element if it is equal or not
				return false;
		}
		return true;
	}
}

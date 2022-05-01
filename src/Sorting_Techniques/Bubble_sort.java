package Sorting_Techniques;

import java.util.Scanner;

public class Bubble_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		bubble_sort(arr , n);
		System.out.println("After sorting ");
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static int[] bubble_sort(int arr[] , int n){
		//int new_arr[] = new int[n];
		int len = arr.length-1;
		for(int pass = 0; pass<len; pass++){    //    pass         j
			for(int j=0; j<len-pass; j++){      //    1            n   times
				if(arr[j]>arr[j+1]){            //    2            n-2 times
					int temp = arr[j];          //    3            n-3 times
					arr[j] = arr[j+1];          //    n             1  times
					arr[j+1] = temp;           // (DEPENDENT) j = n + n-1 + n-2 + n-3 + .... + 1 = n - n(n+1)/2
				}                              //  Time Complexity is O(n^2)
			}
		}
		return arr;
	}
}

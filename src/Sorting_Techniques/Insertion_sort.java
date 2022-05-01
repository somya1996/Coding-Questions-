package Sorting_Techniques;

import java.util.Scanner;

public class Insertion_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		insertion_sort(arr , n);
		System.out.println("After sorting ");
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static int[] insertion_sort(int arr[],int n){
		for(int i=1; i<=n-1; i++){
			int val = arr[i] , j = i-1;                           //  counter     j(index value)
			while(j>=0 && arr[j]>val){                            //     1        compare with(0)    -  1 times
					arr[j+1] = arr[j];                            //     2        compare with(0,1)  -  2 times
					j = j-1;                                      //     3        compare with(0,1,2)-  3 times
				}                                                 //     n        compare with(0 to n)- n-1 times
				arr[j+1] = val;                              //Time complexity : O(n^2)
		}
		/*for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}*/
		return arr;
	}
}

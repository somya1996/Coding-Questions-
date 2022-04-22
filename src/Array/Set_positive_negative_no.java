package Array;

import java.util.Scanner;
/*
Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate
positive and negative numbers without changing the relative order of positive and negative numbers.

Note: Array should start with positive number.

Example 1:
Input:
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
*/
public class Set_positive_negative_no {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}

		rearrange(a , n);
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}

	}
	public static void rearrange(int a[] , int n ){
		for(int i=0; i<n; i++){
			if(i%2==1 && a[i]>=0){
				int j = i+1;
				while(j<n && a[j]>=0)
					j++;
				if(j == n) break;
				rotate_to_right(a , i, j);
			}
			else if(i%2==0 && a[i]<0){
				int j = i+1;
				while(j<n && a[j]<0)
					j++;
				if(j==n)
					break;
				rotate_to_right(a, i, j);
			}
		}
	}
	public static void rotate_to_right(int a[], int i , int j){
			int temp = a[j];
			for(int k = j; k>i; k--){
				a[j] = a[j-1];
			}
			a[i] = temp;
	}
}

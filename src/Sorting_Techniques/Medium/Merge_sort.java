package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Merge_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		mergeSort(arr , 0 , n-1);
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
	}
	public static void merge(int arr[], int l, int m, int r){
		int i = l;
		int j = m+1;
		int k = 0;
		int temp[] = new int[r-l+1];

        while(i<=m && j<=r){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=m){
            temp[k++] = arr[i++];
        }
        while(j<=r){
            temp[k++] = arr[j++];
        }
        for(int a=0; a<temp.length; a++){
            arr[l+a] = temp[a];
		}
	}
	public static void mergeSort(int arr[], int l, int r)
	{
		if(l<r){
			int mid = (l+(r-1))/2;
			mergeSort(arr , l , mid);
			mergeSort(arr , mid+1 , r);
			merge(arr , l , mid , r);
		}

	}
}

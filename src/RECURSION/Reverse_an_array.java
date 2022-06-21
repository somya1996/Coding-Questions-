package RECURSION;

import java.util.Scanner;
// using parameterized and functional recursion
public class Reverse_an_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		// parameterized
		//reverse(0 , arr , n-1);

		// functional
		/*reverse(0 , arr);
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}*/

		// one more
		reverse(0 , arr);
	}

	// using parameterized recursion
	/*public static void reverse(int l , int[] arr ,  int r){
		if(l>=r)
			return ;
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		reverse(l+1 , arr , r-1);
	}*/

	// using functional recursion
	/*public static void reverse(int i , int[] arr){
		int n = arr.length;
		if(i >= n/2)
			return;
		swap(i , n-i-1 , arr);
		reverse(i+1 , arr);
	}*/

	// but using this method we are not changing array only printing in reverse order
	public static void reverse(int i , int [] arr){
		if(i>arr.length-1)
			return;
		reverse(i+1 , arr);
		System.out.print(arr[i]+" ");
	}
	public static void swap(int i , int j , int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

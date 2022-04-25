package Array;

import java.util.Scanner;

public class Prefix_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int new_arr[] = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++){
			sum += arr[i];
			new_arr[i] = sum;
		}
		for (int x:new_arr) {
			System.out.print(x+" ");
		}
	}
}

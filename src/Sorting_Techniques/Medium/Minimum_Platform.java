package Sorting_Techniques.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Platform {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arrival[] = new int[n];
		for(int i=0; i<n; i++){
			arrival[i] = sc.nextInt();
		}

		int departure[] = new int[n];
		for(int i=0; i<n; i++){
			departure[i] = sc.nextInt();
		}

		int platform = findPlatform(arrival , departure , n);
		System.out.println(platform);

	}
	static int findPlatform(int arr[], int dep[], int n){
		Arrays.sort(arr);
		Arrays.sort(dep);

		//int platform = 1;
		int required_platform = 1;
		int i= 1 , j = 0;
		while( i < n && j < n){
			if(arr[i] <= dep[j]){
				required_platform ++;
			}
			else{
				j++;
			}
			i++;
		}
		return required_platform;
	}
}

package Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Leaders_in_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		ArrayList<Integer> al = new ArrayList<Integer>();
		int max = 0;
		for(int i = n-1; i >= 0; i--){
			if(arr[i]>max) {
				al.add(arr[i]);
				max = arr[i];
			}
		}
		Collections.reverse(al);
		System.out.println(al);
	}
}

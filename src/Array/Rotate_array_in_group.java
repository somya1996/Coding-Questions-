package Array;

import  java.util.Scanner;
import java.util.ArrayList;

public class Rotate_array_in_group {
	public static void main(String[] args) {
		//initialization
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			arr.add(sc.nextInt());
		//grouping of
		int k = sc.nextInt();
		//working
		for(int i=0; i<n; i+=k){
			if(i+k<n)
				reverse(arr,n,i,i+k-1);
			else
				reverse(arr, n, i , n-1);
		}
		for(int i=0;i<n;i++)
			System.out.print(arr.get(i)+" ");
	}
	public static void reverse(ArrayList<Integer>arr,int n , int start , int end){
		while(start<end){
			int temp = arr.get(start);
			arr.set(start,arr.get(end));
			arr.set(end,temp);
			start++;
			end--;
		}
	}
}

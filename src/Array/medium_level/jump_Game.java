package Array.medium_level;

import java.util.Scanner;

public class jump_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int jump = minJumps(arr);
		System.out.println(jump);

	}
	public static int minJumps(int[] arr){
		int rechable = 0;
		for(int i=0 ; i<arr.length; i++){
			if(rechable < i)
				return -1;
			rechable = Math.max(rechable , i+arr[i]);
		}
		return rechable;
	}
}

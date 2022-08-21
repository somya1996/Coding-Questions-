package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Painter_Partition_Problem {
	static long p = 10000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int no_of_painters = sc.nextInt();

		int time = sc.nextInt();

		int n = sc.nextInt();
		int board[] = new int[n];
		for(int i=0; i<n; i++){
			board[i] = sc.nextInt();
		}

		int ans = paint(no_of_painters , time , board);
		System.out.println(ans);
	}
	public static int paint(int A, int B, int[] C) {
		long start = Long.MIN_VALUE , end = 0; // end will be total sum
		for(int i=0; i<C.length; i++){
			start = Math.max(start , C[i]*B);
			end += C[i]*B;
		}
		// can start start from 0 also but our ans lies in more than max value
		long ans = -1;
		while(start <= end){
			long mid = (start+end)/2;
			if(checkCanPaint(mid , C , B , A)){
				ans = mid;
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		return (int)(ans%p);
	}
	public static boolean checkCanPaint(long mid , int[] C , int B , int A){
		long total_time = 0L ;
		int painter = 0;
		for(int i=0; i< C.length; i++){
			total_time += C[i]*B;
			if(total_time > mid){
				painter++;
				total_time = C[i];
			}
		}
		if(total_time != 0)
			painter++;

		if(painter <= A)
			return true;
		return false;
	}
}

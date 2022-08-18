package Sorting_Techniques.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class Aggressive_cow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int []stalls = new int[n];
		for(int i=0; i<n; i++){
			stalls[i] = sc.nextInt();
		}

		int cow = sc.nextInt();

		int minimum_separation = aggr_cow(stalls , cow);
		System.out.println(minimum_separation);
	}
	public static int aggr_cow(int[] stalls , int cow){
		int n = stalls.length;
		Arrays.sort(stalls);
		//for(int i=0; i<stalls.length; i++)
		//	System.out.print(stalls[i]+" ");
		// search space = end - start
		int start = 0 , end = stalls[n-1]-stalls[0];
		//System.out.println("search space start "+start+" end "+end);
		int ans = 0;
		// do binary search
		while(start <= end){
			int mid = (start+end)/2;
			//System.out.println(" mid "+mid);
			if(check_minSep(stalls ,mid ,  cow)){ // if this is true
				ans = mid;
				//System.out.println("ans "+ans);
				start = mid+1;
				//System.out.println("start "+start);
			}
			else {
				end = mid - 1;
				//System.out.println("end "+end);
			}

		}
		return ans;
	}
	public static boolean check_minSep(int[] stalls , int mid , int cow){
		int cnt = 1;
		int prev_cow_pos = stalls[0];
		for(int i = 1; i<stalls.length; i++){
			if((stalls[i] - prev_cow_pos)>= mid){
				cnt++;
				prev_cow_pos = stalls[i];
				if(cnt == cow)
					return true;
			}
		}
		return false;
	}
}

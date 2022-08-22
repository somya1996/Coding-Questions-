package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Food_Packet_Distribution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_distribution_box = sc.nextInt();

		int n = sc.nextInt();
		int people_in_each_city[] = new int[n];
		for(int i=0; i<n; i++){
			people_in_each_city[i] = sc.nextInt();
		}

		int ans = packets(people_in_each_city , no_of_distribution_box);
		System.out.println(ans);
	}
	public static int packets(int[] people , int distribution_box){
		int min = Integer.MAX_VALUE;
		for(int i =0; i<people.length; i++){
			Math.min(min , people[i]);
		}
		int start = 0 , end = min;
		int ans = 0;
		while(start <= end){
			int mid = (start+end)/2;
			if(check_is_distribution_valid(mid , people , distribution_box)){
				ans = mid;
				start = mid+1;
			}
			else{
				end = mid -1;
			}
		}
		return ans;
	}
	public static boolean check_is_distribution_valid(int mid , int[]people , int distribution){
		int sum = 0 ;
		for(int i=0; i<people.length; i++){
			if(mid==0) {
				sum+=people[i];
			}
			else {
				sum += (people[i] / mid);
			}
		}
		return sum >= distribution;
	}
}

package Array.medium_level;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_platforms {
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
	public static int findPlatform(int arr[], int dep[], int n){
		Arrays.sort(arr);
		Arrays.sort(dep);
		int req_platform = 1 , max_platform_needed = 1;
		int i=1 , j =0;
		while(i<n && j<n){
			//System.out.println("arr[i] "+arr[i]+" dep[j] "+dep[j]);
			if(dep[j] >= arr[i]){
				req_platform++;
				//System.out.println(req_platform);
				i++;
			}
			//dep[j] < arr[i]
			else{
				req_platform --;
				j++;
			}
			if(max_platform_needed < req_platform){
				max_platform_needed = req_platform;
			}
			//max_platform_needed = Math.max(max_platform_needed , req_platform);
		}
		return max_platform_needed;
	}
}

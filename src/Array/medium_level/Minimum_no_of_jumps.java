package Array.medium_level;
import java.util.Scanner;
public class Minimum_no_of_jumps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = min_jump(arr);
		System.out.println(ans);
	}
	public static int min_jump(int[] nums){
		// one way(optimised way)
		/*int destination = 0;
		int position = 0; // it use for iterating each value in array
		int jump = 0;
		for(int i=0; i<nums.length-1; i++) {
			destination = Math.max(destination, i + nums[i]);
			if (position == i){
				position = destination;
				jump++;
			}
		}
		return jump;*/
		// This way is incorrect if given 0 value in an array because from 0 we can't
		// increment value and not able to reach the end index value so we have another way
		// more optimised way

		// other way (optimised way)
		int jump = 1;
		int max_reach = nums[0];
		int step = nums[0];
		for(int i=1; i<nums.length; i++){
			if(i == nums.length-1){
				return jump;
			}
			max_reach = Math.max(max_reach , i+nums[i]);
			step--;
			if(step == 0){
				jump++;
				if(i >= max_reach){
					return -1;
				}
				step = max_reach-i;
			}

		}
		return -1;
	}
}

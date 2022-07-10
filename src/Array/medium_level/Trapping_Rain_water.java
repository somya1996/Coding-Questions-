package Array.medium_level;

import java.util.Scanner;

public class Trapping_Rain_water {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int height[] = new int[n];
		for(int i=0; i<n ;i++){
			height[i] = sc.nextInt();
		}
		int trapwater = total_rain_water_trap(height);
		System.out.println(trapwater);
	}

	public static int total_rain_water_trap(int[] height) {
		// Time Complexity => O(n) and Space Complexity : O(n)
        /*
        int [] left = new int[height.length];
        int [] right = new int[height.length];

        int n = height.length - 1;

        left[0] = height[0];
        for(int i=1; i<height.length; i++){
            left[i] = Math.max(left[i - 1], height[i]);

        }
        right[n] = height[n];
        for(int i=height.length-2; i>=0; i--){
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int sum = 0;
        for(int i=0; i<n ; i++){
            sum  += Math.min(left[i] , right[i]) - height[i];
        }

        return sum;
        */

		//Time complexity : O(n)  ans O(1) Space complexity
		int n = height.length;
		int left = 0;
		int right = n - 1;
		int leftbar = height[0];
		int rightbar = height[n - 1];
		int sum = 0;

		while (left <= right) {
			if (leftbar < rightbar) { // increment leftbar
				if (height[left] > leftbar)
					leftbar = height[left];
				else {
					sum += leftbar - height[left];
					left++;
				}
			} else {
				if (height[right] > rightbar)
					rightbar = height[right];
				else {
					sum += rightbar - height[right];
					right--;
				}

			}
		}
		return sum;
	}
}

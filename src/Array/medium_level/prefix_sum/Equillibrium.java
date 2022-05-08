package Array.medium_level.prefix_sum;

import java.util.Scanner;

public class Equillibrium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		// one way using prefix sum
		//TIME COMPLEXITY : O(n)
		//SPACE COMPLEXITY : O(n)
		/*int ps[] = new int[n];
		int k = 0;
		ps[0] = arr[0];
		for(int i=1;i<arr.length; i++){
			ps[i] = ps[i-1] + arr[i];
			if(ps[i] == 0) {
				k = i;
				break;
			}
		}

		System.out.println(" prefix sum ");
		for(int i=0;i<arr.length;i++){
			System.out.print(ps[i]+" ");
		}
		System.out.println();
		System.out.println(arr[k]);
		*/
		// other way using (left_sum of an element == right_sum of an element)
		//Time complexity : O(n)
		//Space complexity: O(1)
		int total_sum = 0;
		int ans = 0;
		for(int i=0; i<n; i++){
			total_sum += arr[i];
		}
		int leftsum = 0;
		for(int i=0; i<arr.length; i++){
			if(leftsum == total_sum-arr[i]){
				ans = i;
				System.out.println(ans);
				break;
			}
			leftsum += arr[i];

		}
		System.out.println(arr[ans]);
	}
}

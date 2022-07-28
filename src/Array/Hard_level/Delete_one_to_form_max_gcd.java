package Array.Hard_level;

import java.util.Scanner;

public class Delete_one_to_form_max_gcd{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int max_gcd_by_deleting_one_no = solve(arr) ;
		System.out.println(max_gcd_by_deleting_one_no);
	}
	public static int solve(int[] A) {
		int [] prefix_gcd = new int[A.length];
		prefix_gcd[0] = A[0];
		for(int i=1; i<A.length; i++){
			prefix_gcd[i] = gcd(prefix_gcd[i-1] , A[i]);
		}

		int n = A.length;

		int[] suffix_gcd = new int[A.length];
		suffix_gcd[A.length-1] = A[A.length-1];
		for(int i=n-2; i>=0; i--){
			suffix_gcd[i] = gcd(suffix_gcd[i+1] , A[i]);
		}
		int max_gcd = Integer.MIN_VALUE;
		int left_gcd = 0;
		int right_gcd = 0;
		for(int i = 0 ; i < n ; i++){
			// special ans
			if(i == 0)
				left_gcd = 0;
			else
				left_gcd = prefix_gcd[i-1];
			//special case
			if(i == n-1)
				right_gcd = 0;
			else
				right_gcd = suffix_gcd[i+1];

			int current_gcd = gcd(left_gcd , right_gcd);
			max_gcd = Math.max(max_gcd , current_gcd);
		}
		return max_gcd;
	}
	public static int gcd(int a ,  int b){
		while(a!=0){
			int temp = b%a;
			b = a;
			a = temp;
		}
		return b;
	}
}

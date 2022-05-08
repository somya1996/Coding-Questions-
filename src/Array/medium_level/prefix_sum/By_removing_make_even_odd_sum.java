package Array.medium_level.prefix_sum;

import java.util.Scanner;

public class By_removing_make_even_odd_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int evensum[] = new int[A.length];
		int oddsum[] = new int[A.length];

		evensum[0] = A[0];
		oddsum[0] = 0;

		for(int i=1; i<=A.length-1; i++){
			if(i%2 == 0){
				evensum[i] = evensum[i-1]+A[i];
				oddsum[i] = oddsum[i-1];
			}
			else{
				evensum[i] = evensum[i-1];
				oddsum[i] = oddsum[i-1] + A[i];
			}
		}

		//for(int i=0; i<n; i++){
		//	System.out.println("evensum "+ evensum[i]);
		//	System.out.println("oddsum "+ oddsum[i]);
		//}
		int result = 0;
		for(int i=0; i<n; i++){
			if(i==0) {
				if (oddsum[A.length - 1] - oddsum[i] == evensum[A.length - 1] - evensum[i])
					result++;
			}

			else if(i == n-1){
				if(oddsum[A.length-2] == evensum[A.length-2])
					result++;
			}
			else{
				int odd = oddsum[i-1] + evensum[A.length-1] - evensum[i] ;
				int even = evensum[i-1] + oddsum[A.length-1] - oddsum[i];
				if(even == odd)
					result++;
			}
			/*
			System.out.println(" i "+i);
				int even = evensum[i-1] + oddsum[A.length-1] - oddsum[i] ;
				System.out.println("even "+even+ " evensum[i-1] "+ evensum[i-1]+" oddsum[A.length-1] "+oddsum[A.length-1] +" oddsum[i] "+oddsum[i]);
				int odd = oddsum[i-1] + evensum[A.length-1] - evensum[i];
				System.out.println("odd "+odd+ " oddsum[i-1] "+ oddsum[i-1]+" evensum[A.length-1] "+evensum[A.length-1] +" evensum[i] "+evensum[i]);
				if(even == odd)
					result++;
			 */

		}
		System.out.println(result);
	}
}

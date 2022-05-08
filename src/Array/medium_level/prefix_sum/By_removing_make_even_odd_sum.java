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

		for(int i=1; i<n; i++){
			if(i%2==0)
				evensum[i] = evensum[i-1]+A[i];
			else
				evensum[i] = evensum[i-1];
		}

		for(int i=1; i<n; i++){
			if(i%2!=0)
				oddsum[i] = oddsum[i-1]+A[i];
			else
				oddsum[i] = oddsum[i-1];
		}

		for(int i=0; i<n; i++){
			System.out.println("evensum "+ evensum[i]);
			System.out.println("oddsum "+ oddsum[i]);
		}

		for(int i=0; i<n; i++){


		}
	}
}

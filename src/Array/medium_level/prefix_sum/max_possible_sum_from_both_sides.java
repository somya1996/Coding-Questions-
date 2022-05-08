package Array.medium_level.prefix_sum;

import java.util.Scanner;

public class max_possible_sum_from_both_sides {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();

		int leftpointer  = A.length-B;
		int rightpointer = A.length-1;
		for(int i=leftpointer; i<=rightpointer; i++){
			sum += A[i];
		}

		rightpointer = 0;
		int maxsum = sum;
		System.out.println(" left "+leftpointer+" right "+rightpointer);
		while(leftpointer<A.length){
			sum = sum - A[leftpointer] + A[rightpointer];
			maxsum = Math.max(maxsum , sum);
			leftpointer++;
			rightpointer++;
		}
		System.out.println("Maxsum "+maxsum);
	}
}

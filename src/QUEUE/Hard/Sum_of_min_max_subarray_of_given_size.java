package QUEUE.Hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Sum_of_min_max_subarray_of_given_size {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i< n; i++){
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int sum = solve(arr , B);
		System.out.println(sum);
	}
	public static int solve(int[] A, int B) {
		Deque<Integer> max = new LinkedList<>();
		Deque<Integer> min = new LinkedList<>();
		for(int i=0; i<B; i++){
			while(!max.isEmpty() && A[i] >= A[max.peekLast()])
				max.removeLast();
			max.addLast(i);

			while(!min.isEmpty() && A[i] < A[min.peekLast()])
				min.removeLast();
			min.addLast(i);
		}
		int sum = 0;
		for(int i = B; i<A.length; i++){
			sum += A[min.peekFirst()]+A[max.peekFirst()];
			System.out.println(" min.peekFirst() "+ A[min.peekFirst()]);
			System.out.println(" max.peekFirst() "+ A[max.peekFirst()]);
			System.out.println(" sum "+sum);
			while(!max.isEmpty() && max.peekFirst()<= i - B){
				max.removeFirst();
			}
			while(!max.isEmpty() && A[i]>= A[max.peekLast()])
				max.removeLast();
			max.addLast(i);

			while(!min.isEmpty() && min.peekFirst()<= i - B){
				min.removeFirst();
			}
			while(!min.isEmpty() && A[i] <= A[min.peekLast()])
				min.removeLast();
			min.addLast(i);
		}
		sum += A[min.peekFirst()]+A[max.peekFirst()];
		return sum;
	}
}

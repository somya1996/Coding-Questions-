package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Sum_of_maximum_elements_of_all_subarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int sum = solve(arr);
		System.out.println(sum);
	}
	public static int solve(int[] arr){
		int n = arr.length;

		//next greatest to left
		Stack<Integer>s = new Stack<>();
		int right[] = new int[arr.length];
		for(int i=0; i<n; i++){
			while(!s.isEmpty() && arr[s.peek()]<=arr[i])
				s.pop();
			if(s.isEmpty())
				right[i] = -1;
			else
				right[i] = s.peek();
			s.push(i);
		}

		//next greatest to right
		Stack<Integer>s1 = new Stack<>();
		int left[] = new int[arr.length];
		for(int i=n-1; i>=0; i--){
			while(!s1.isEmpty() && arr[s1.peek()]<=arr[i])
				s1.pop();
			if(s1.isEmpty())
				left[i] = n;
			else
				left[i] = s1.peek();
			s1.push(i);
		}


		int sum = 0;
		for(int i=0; i<n; i++){
			int start = i - left[i];
			int end = right[i] - i;
			sum += (start*end*arr[i]);
		}
		return sum;
	}
}

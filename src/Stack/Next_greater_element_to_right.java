package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Next_greater_element_to_right {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextLong();
		}
		Next_greater_element_to_right ng = new Next_greater_element_to_right();
		long[] ans = ng.nextLargerElement(arr , n);
		for(int i=0; i< ans.length; i++)
			System.out.print(ans[i] + " ");
	}
	public static long[] nextLargerElement(long[] arr, int n){
		Stack<Long> s = new Stack<Long>();
		long[] ans = new long[arr.length];

		ans[n-1] = -1;
		s.push(arr[n-1]);
		for(int i= n-2; i>=0 ; i--){
			if(arr[i] < s.peek())
				ans[i] = s.peek();
			else{
				while(!s.empty() && arr[i] > s.peek())
					s.pop();
				ans[i] = (s.empty())?-1:s.peek();
			}
			s.push(arr[i]);
		}
		return ans;
	}
}

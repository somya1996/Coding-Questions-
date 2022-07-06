package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Nest_greater_element_circular {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextLong();
		}
		Nest_greater_element_circular ng = new Nest_greater_element_circular();
		long[] ans = ng.nextLargerElementCircular(arr , n);
		for(int i=0; i< n; i++)
			System.out.print(ans[i] + " ");
	}
	public long[] nextLargerElementCircular(long[] arr , int n){
		Stack<Long> s = new Stack<>();
		long[] ans = new long[2*n];
		ans[2*n-1] = -1;
		s.push(arr[(2*n-1)%n]);

		for(int i = 2*n-2 ; i >= 0; i--){
			if(arr[i%n] < s.peek())
				ans[i] = s.peek();
			while(s.isEmpty() == false && s.peek() <= arr[i % n])
				s.pop();
			ans[i] = s.isEmpty()?-1:s.peek();
			s.push(arr[i%n]);
		}
		return ans;
	}
}

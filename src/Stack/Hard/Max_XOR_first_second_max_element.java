package Stack.Hard;

import java.util.Scanner;
import java.util.Stack;

public class Max_XOR_first_second_max_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int max_xor = solve(arr);
		System.out.println(max_xor);
	}
	public static int solve(int[] A) {
		Stack<Integer> ngr = new Stack<>();
		Stack<Integer> ngl = new Stack<>();
		int left_greater[] = new int[A.length];
		for(int i=0; i<A.length; i++){
			while(!ngl.isEmpty() && A[i] >= ngl.peek())
				ngl.pop();
			if(ngl.isEmpty())
				left_greater[i] = -1;
			else
				left_greater[i] = ngl.peek();
			ngl.push(A[i]);
		}
		int right_greater[] = new int[A.length];
		for(int i= A.length-1; i>=0; i--){
			while(!ngr.isEmpty() && A[i] >= ngr.peek())
				ngr.pop();
			if(ngr.isEmpty())
				right_greater[i] = -1;
			else
				right_greater[i] = ngr.peek();
			ngr.push(A[i]);
		}
		int ans = -1;
		for(int i=0; i<A.length; i++){
			if(right_greater[i] > A[i])
				ans = Math.max(ans , right_greater[i]^A[i]);

			if(left_greater[i] > A[i])
				ans = Math.max(ans , left_greater[i]^A[i]);
		}
		if(ans == -1)
			return 0;
		return ans;
	}
}

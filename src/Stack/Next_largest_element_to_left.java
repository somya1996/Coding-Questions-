package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Next_largest_element_to_left {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Next_largest_element_to_left ngl = new Next_largest_element_to_left();
		int[] ans = ngl.Next_largest_element_to_left(arr , n);
		for(int i=0; i< ans.length; i++)
			System.out.print(ans[i] + " ");
	}
	public int[] Next_largest_element_to_left(int arr[] , int n){
		int [] ans = new int[n];
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<n; i++){
			while(!s.isEmpty() && arr[i]>s.peek())
				s.pop();
			ans[i] = s.isEmpty()?-1:s.peek();
			s.push(arr[i]);
		}
		return ans;
 	}
}

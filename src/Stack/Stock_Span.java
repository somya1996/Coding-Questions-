package Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Stock_Span {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Stock_Span sp = new Stock_Span();
		int[] ans = sp.calculateSpan(arr , n);
		for(int i=0; i< ans.length; i++)
			System.out.print(ans[i] + " ");
	}
	public static int[] calculateSpan(int price[], int n){
		int [] temp = new int[n];
		Stack<Integer> s = new Stack<>();
		HashMap<Integer, Integer> hm = new HashMap<Integer , Integer>();
		int [] ans = new int[n];
		for(int i=0; i<n; i++){
			while(!s.isEmpty() && price[i]>s.peek())
				s.pop();
			if(s.isEmpty())
				temp[i] = -1;
			else
				temp[i] = s.peek();
			s.push(price[i]);
		}
		for(int i =0 ; i < temp . length ; i++){
			if(hm.containsKey(temp[i])){
				ans[i] = i - hm.get(temp[i])+1;
			}
			else{
				hm.put(temp[i] , i);
				ans[i] = 1;
			}
		}
		return ans;
	}
}

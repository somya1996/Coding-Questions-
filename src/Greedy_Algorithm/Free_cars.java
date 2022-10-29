package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Free_cars {
	static class Deal{
		int deadline;
		int profit;
		Deal(int deadline , int profit){
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("Time");
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		System.out.println("Profit");
		int[] B = new int[n];
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}

		int ans = solve(A , B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int[] B) {
		ArrayList<Deal> list = new ArrayList<Deal>();
		int mod = 1000000007;
		for(int i=0; i<A.length; i++){
			list.add(new Deal(A[i] , B[i]));
		}
		Collections.sort(list , (deal1 , deal2)-> deal1.deadline - deal2.deadline);
		System.out.println(list);

		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		long ans = 0;
		int t = 0;
		for(int i=0; i<list.size(); i++){
			if(t < list.get(i).deadline){
				t++;
				minheap.add(list.get(i).profit);
				ans += list.get(i).profit;
				ans %= mod;
			}
			else{
				if(list.get(i).profit > minheap.peek()){
					int min = minheap.peek();
					ans -= min;
					ans %= mod;
					minheap.add(list.get(i).profit);
					ans += minheap.peek();
					ans %= mod;
				}
			}
		}
		return (int)ans%mod;
	}
}

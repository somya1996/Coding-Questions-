package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class subarray_size_window {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for( int i=0; i< n; i++){
			A[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		//for(int i=0; i<A.length; i++)
		//	System.out.print(A[i]+" ");
		//System.out.println(k);
		ArrayList<Integer> count = size_of_window(A , k);
		System.out.println(count);
	}
	public static ArrayList<Integer> size_of_window(int[] A, int k){
		//System.out.println(" size of window ");
		int n = A.length;
		ArrayList<Integer> res = new ArrayList<>();
		int left = 0 , right = k;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<k; i++){
			if(hm.containsKey(A[i])){
				hm.put(A[i] , hm.get(A[i])+1);
			}
			else{
				hm.put(A[i] , 1);
			}
		}
		//System.out.println(hm);
		int count = hm.size();
		res.add(count);
		//System.out.println(" updated res "+res);
		while(right<n){
			if(hm.containsKey(A[left])) {
				hm.put(A[left], hm.get(A[left]) - 1);
				if(hm.get(A[left]) == 0)
					hm.remove(A[left]);
			}
			//System.out.println(" l "+hm);
			if(hm.containsKey(A[right])){
				hm.put(A[right] , hm.get(A[right])+1);
			}
			else{
				hm.put(A[right] , 1);
			}
			res.add(hm.size());
			left++;
			right++;
			//System.out.println(" r "+hm);
			//System.out.println(" res "+res);
		}
		//res.add(count);
		return res;
	}

	public static class bit_reverse_32bit {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			long A = sc.nextLong();
			long ans = reverse(A);
			System.out.println(ans);
		}
		public static long reverse(final long A) {
			long B = A;
			long sum = 0;
			int idx = 31;
			while(B!=0){
				long rem = B%2;
				sum += rem<<idx--; //curr -- becoz 1st - 32nd value then 2nd - 31st value
				B /= 2;
			}
			return sum;
		}
	}
}

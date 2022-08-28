package Array.medium_level;

import java.util.*;

public class Relative_sort_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A1[] = new int[n];
		for(int i=0; i<n; i++){
			A1[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int A2[] = new int[m];
		for(int i=0; i<m; i++){
			A2[i] =sc.nextInt();
		}

		ArrayList<Integer> ans = solve(A1 , A2);
		for(int i=0; i<ans.size(); i++){
			System.out.print(ans.get(i)+" ");
		}
	}
	//TC : O(nlogn)   SC : O(n)
	public static ArrayList<Integer> solve(int[] A, int[] B) {
		ArrayList<Integer> al = new ArrayList<>();
		TreeMap<Integer , Integer> hm = new TreeMap<Integer , Integer>();

		//Arrays.sort(A);
		for(int i=0; i<A.length; i++){
			if(hm.containsKey(A[i]))
				hm.put(A[i] , hm.get(A[i])+1);
			else{
				hm.put(A[i] , 1);
			}
		}
		System.out.println(hm);

		for(int i=0; i<B.length; i++){
			int x = B[i];
			if(hm.containsKey(x)){
				int count = hm.get(x);
				if(count >= 1){
					while(count != 0) {
						al.add(B[i]);
						count--;
					}
				}
				hm.remove(x);
			}
		}

		for(int x: hm.keySet()){
			if(hm.get(x) > 0){
				int count = hm.get(x);
				while(count != 0){
					al.add(x);
					count--;
				}
			}
		}

		return al;
	}
}

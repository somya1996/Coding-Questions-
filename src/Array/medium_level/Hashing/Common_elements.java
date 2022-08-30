package Array.medium_level.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Common_elements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int B[] = new int[m];
		for(int i=0; i<m; i++){
			B[i] = sc.nextInt();
		}
		int[] ans = solve(A, B);
		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i]+" ");
	}
	public static int[] solve(int[] A, int[] B) {

		HashMap<Integer, Integer> hm = new HashMap<Integer , Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) {
			if (hm.containsKey(A[i])) {
				hm.put(A[i], hm.get(A[i]) + 1);
			} else {
				hm.put(A[i], 1);
			}
		}
		for(int i=0;i<B.length;i++){
			if(hm.containsKey(B[i])){
				if(hm.get(B[i])>0)
				{
					al.add(B[i]);
					hm.put(B[i],hm.get(B[i])-1);
				}
			}
		}

		Collections.sort(al);
		int[] arr = new int[al.size()];
		for(int i=0; i<arr.length; i++){
			arr[i] = al.get(i);
		}
		return arr;

		//Using nested HashMap
		/*public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
			HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
			for(int x: A){
				a.put(x, a.getOrDefault(x, 0)+1);
			}
			for(int x: B){
				b.put(x, b.getOrDefault(x, 0)+1);
			}
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(int k: a.keySet()){
				if(b.containsKey(k)){
					for(int i = 0; i < Math.min(a.get(k), b.get(k)); ++i){
						ans.add(k);
					}
				}
			}
			return ans;
		 */
	}
}
/*
What is difference in hm.put(B[i] ,hm.get(B[i])-1) and hm.replace(B[i],hm.get(B[i])-1);
for(int i=0;i<B.length;i++){
            if(hm.containsKey(B[i])){
                if(hm.get(B[i])>0)
                {
                    al.add(B[i]);
                    hm.replace(B[i],hm.get(B[i])-1);
                }
            }
        }

while using put its giving trivial case erroe and we are using replace then correct output
 */
package Array.medium_level.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Count_Rectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		int B[] = new int[n];
		for(int i=0; i<n; i++)
			B[i] = sc.nextInt();
		int ans = solve(A , B);
		System.out.println(ans);
	}
	public static int solve(int[] a, int[] b) {
		int n = a.length;
		HashMap<Integer, HashSet> hm = new HashMap<>();
		HashSet<Integer> h;
		for(int i=0; i<n; i++){
			if(hm.containsKey(a[i]))
				h = hm.get(a[i]);
			else
				h = new HashSet<>();
			h.add(b[i]);
			hm.put(a[i] , h);
		}
		int count = 0;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				if(a[i] == a[j] || b[i] == b[j])
					continue;
				if(hm.get(a[i]).contains(b[j]) && hm.get(a[j]).contains(b[i]))
					count++;
			}
		}
		return count/2;
	}
}

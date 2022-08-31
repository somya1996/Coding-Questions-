package Array.medium_level.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Count_right_triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int[] B = new int[n];
		for(int i=0; i<n; i++)
			B[i] = sc.nextInt();

		int ans = solve(A,B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int[] B) {
		// Brute force - O(n^3)
		/*int n = A.length;
		int count = 0;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int k=j+1; k<n; k++){
					if(A[i]==A[j] || A[j]==A[k]){
						if(B[i]==B[k] || B[j]==B[k] || B[i]==B[j])
							count++;
					}
				}
			}
		}
		return count;*/
		HashMap<Integer, Integer> mapX = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mapY = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++)
		{
			mapX.put(A[i], mapX.getOrDefault(A[i], 0)+1);
			mapY.put(B[i], mapY.getOrDefault(B[i], 0)+1);
		}


		int res = 0;
		for(int i=0; i<B.length; i++)
		{
			System.out.println("X "+mapX);
			System.out.println("Y "+mapY);

			int l = (mapX.get(A[i])-1);
			System.out.println("A[i] "+A[i]+"l "+l);

			int r = (mapY.get(B[i])-1);
			System.out.println("B[i] "+B[i]+"r "+r);

			res += l*r;
		}
		return res;
	}
}

package Array.medium_level.Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class Compare_sorted_subarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		int[][] B = new int[m][4];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				B[i][j] = sc.nextInt();
			}
		}

		int[] ans = solve(A, B);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}
	public static int[] solve(int[] A, int[][] B) {
		int[] result = new int[B.length];
		HashSet<Integer> hs = new HashSet<Integer>();

		int l1 , l2 , r1 , r2 ;
		for(int i=0; i<B.length; i++){
			l1 = B[i][0];
			r1 = B[i][1];
			l2 = B[i][2];
			r2 = B[i][3];

			int length = r2 - l2 + 1;
			int count = 0;
			for(int idx=l1; idx<=r1; idx++){
				hs.add(A[idx]);
				if(hs.contains(A[idx]) && A[idx] == A[l2]){
					l2++;
					hs.remove(A[idx]);
					count++;
				}
				else if(hs.contains(A[idx]) && A[idx] == A[r2]){
					hs.remove(A[idx]);
					r2--;
					count++;
				}
				else{
					break;
				}
			}

			if(count == length)
				result[i] = 1;
			else
				result[i] = 0;
		}
		return result;
	}
}
/*
For every B[i] row, inside inner for loop, while inserting A[l1] to A[r1] into HashSet
           check for every A[idx] if equal to A[l2] or A[r2], increase l2 or decrease r2 index which
           ever is equal to A[idx], and increment a or b counter respectively. Remove the matched value A[idx]
           from HashSet. This should be done because we don't know if the range l2 to r2 is
           increasingly sorted or decreasingly.

        => Incase, while inserting value (A[idx]) into HashSet, A[idx] is not equal to either A[l2] or A[r2], else
           is executed and it breaks, for that i index in result array, 0 will be stored.

        => 1 is stored when a + b is equal to number of elements from l2 to r2 (diff).
        => Using a Third for loop inside, for checking A[l2] to A[r2] will give TLE. TC increases.
        => Clear the HashSet after every i of B array.
 */
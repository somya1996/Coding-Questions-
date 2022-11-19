package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Interleaving_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = "aabcc";
		String B = "dbbca";
		String C = "aadbbcbcac";
		int ans = isInterleave_recursive(A, B, C);
		System.out.println(ans);

		int ans1 = isInterleave_Top_Down(A, B, C);
		System.out.println(ans1);

		boolean ans2 = isInterleave_Bottom_Up(A, B, C);
		System.out.println(ans2);
	}

	public static int isInterleave_Top_Down(String A, String B, String C) {

		int N = A.length();
		int M = B.length();
		int L = C.length();

		byte[][][] dp = new byte[N + 1][M + 1][L + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				for (int k = 0; k <= L; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		return interLeaveCheck(A, B, C, N, M, L, dp);

	}

	public static int interLeaveCheck(String A, String B, String C, int i, int j, int k, byte[][][] dp) {

		if (i == 0 && j == 0 && k == 0) {
			return 1;
		}
		if ((i == 0 && j != k) || (j == 0 && i != k)) {
			return 0;
		}

		if (dp[i][j][k] != -1) {
			return (int) dp[i][j][k];
		}

		int ans = 0;


		if ((i > 0 && C.charAt(k - 1) == A.charAt(i - 1)) && (j > 0 && C.charAt(k - 1) == B.charAt(j - 1))) {

			ans = Math.max(interLeaveCheck(A, B, C, i - 1, j, k - 1, dp), interLeaveCheck(A, B, C, i, j - 1, k - 1, dp));
		} else if (i > 0 && C.charAt(k - 1) == A.charAt(i - 1)) {

			ans = interLeaveCheck(A, B, C, i - 1, j, k - 1, dp);
		} else if (j > 0 && C.charAt(k - 1) == B.charAt(j - 1)) {

			ans = interLeaveCheck(A, B, C, i, j - 1, k - 1, dp);
		} else {

			ans = 0;
		}

		dp[i][j][k] = (byte) ans;

		return ans;

	}

	// using recursion throws TLE
	public static int isInterleave_recursive(String A, String B, String C) {
		int N = A.length();
		int M = B.length();
		int L = C.length();
		if (C.length() != A.length() + B.length())
			return 0;
		return recursive(A, B, C, N, M, L);
	}

	public static int recursive(String A, String B, String C, int i, int j, int k) {
		if (i == 0 && j == 0 && k == 0)
			return 1;

		if ((i > 0 && C.charAt(k - 1) == A.charAt(i - 1)) && (j > 0 && C.charAt(k - 1) == B.charAt(j - 1)))
			return Math.max(recursive(A, B, C, i - 1, j, k - 1), recursive(A, B, C, i, j - 1, k - 1));

		else if (i > 0 && C.charAt(k - 1) == A.charAt(i - 1))
			return recursive(A, B, C, i - 1, j, k - 1);

		else if (j > 0 && C.charAt(k - 1) == B.charAt(j - 1))
			return recursive(A, B, C, i, j - 1, k - 1);

		else
			return 0;

		/*HINT
		Case 1: A[i] = C[k] && B[j] = C[k] —> result depends on Max(interleaveCheck(A, B, C, i-1, j, k-1), interleaveCheck(A, B, C, i, j-1, k-1))
		Case 2: A[i] = C[k] —> result depends on interleaveCheck(A, B, C, i-1, j, k-1)
		Case 3: B[j] = C[k] —> result depends on interleaveCheck(A, B, C, i, j-1, k-1)
		Case 4: A[i] != C[k] && B[j] != C[k] —> Return 0;
		*/
	}
	public static boolean isInterleave_Bottom_Up(String A , String B , String C){
		int n = A.length();
		int m = B.length();
		if(A.length()+B.length() != C.length())
			return false;
		boolean[][] dp = new boolean[n+1][m+1];

		dp[0][0] = true;

		for (int i = 0; i <= n; i++){
			for (int j = 0; j <= m; j++){
				if (i == j && i == 0)
					continue;

				int k = i+j;
				dp[i][j] = (i >= 1 && dp[i-1][j] == true && A.charAt(i-1) == C.charAt(k-1))
						|| (j >= 1 && dp[i][j-1] == true && B.charAt(j-1) == C.charAt(k-1));
			}
		}

		return dp[n][m];
	}
}



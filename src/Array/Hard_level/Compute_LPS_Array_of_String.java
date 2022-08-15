package Array.Hard_level;

import java.util.Scanner;

public class Compute_LPS_Array_of_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String text = sc.nextLine();
		String pattern = sc.nextLine();
		int lps[] = new int[pattern.length()];

		computeLPSArray(pattern, pattern.length(), lps);

		for(int i=0; i<lps.length; i++)
			System.out.print(lps[i]+" ");
	}

	public static void computeLPSArray(String pat , int M , int[] lps) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				}
				else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
}

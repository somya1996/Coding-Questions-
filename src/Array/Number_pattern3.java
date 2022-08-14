package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Number_pattern3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> ans = numberPattern(n);
		System.out.println(ans);
		//numberPattern(n);
	}
	public static ArrayList<ArrayList<Integer>> numberPattern(int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int row = 1;
		while (row <= n) {
			//ans.add(new ArrayList<>());
			ArrayList<Integer> temp = new ArrayList<>();
			for (int cst = 1; cst <= row; cst++) {
				if (cst == 1 || cst == row) {
					temp.add(1);
				}
				else
					temp.add(2);
				//ans.get(row).add(currentans);
			}
			ans.add(temp);
			//nst = nst+1;

			row = row + 1;
		}
		// Write your code here.
		return ans;
		/*ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(n);

		for (int i = 0; i < n; i++) {

			result.add(new ArrayList<Integer>(i + 1));

			for (int j = 0; j <= i; j++) {

				int currentAns;

				// If end positions, then insert 1.
				if (j == 0 || j == i) {
					currentAns = 1;
				}
				// All other tables will have 2 guests.
				else {
					currentAns = 2;
				}
				result.get(i).add(currentAns);
			}
		}

		return result;*/
	}

	/*
	public static void numberPattern(int n){
		int nst = 1;
		int row = 1;
		while (row <= n) {
			for (int cst = 1; cst <= row; cst++) {
				if (cst == 1 || cst == row)
					System.out.print(1);
				else
					System.out.print(2);
			}
			//nst = nst+1;
			System.out.println();
			row = row + 1;
		}
	}*/
}

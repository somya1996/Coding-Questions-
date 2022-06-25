package RECURSION;

import java.util.ArrayList;
import java.util.Scanner;

public class Gray_Code {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(grayCode(n));

	}
	int num = 0;
	public static ArrayList<Integer> grayCode(int a) {
		/*
		//One way
		ArrayList<Integer> start = new ArrayList<>();
		if(a == 1){
			start.add(0);
			start.add(1);
			return start;
		}
		ArrayList<Integer> ans = grayCode(a-1);
		// Now loop to iterate each elements in an arraylist to get new output
		int x = ans.size();
		for( int i = 0; i<x; i++){
			start.add(ans.get(i));
		}
		for(int j=x-1; j>=0; j--) {
			start.add(ans.get(j) + (1 << (a - 1)));
		}
		return start;
		*/
		ArrayList<Integer> ans = new ArrayList<>();
		solve(ans , a , 0);
		return ans;

	}
	public static ArrayList<Integer> solve(ArrayList<Integer> res , int A , int element){
		if(res.size()==(1<<A))
			return res;
		System.out.println(res);
		res.add((element ^ (element>>1)));

		return solve(res,A,element+1);
	}
}

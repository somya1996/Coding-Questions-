package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ans = prime_Factors(n);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
	}
	public static int[] prime_Factors(int n){
		ArrayList<Integer> al = new ArrayList<>();
		while(n%2 == 0){
			al.add(2);
			n /= 2;
		}
		for(int i=3; i<=Math.sqrt(n); i+=2){
			while(n%i == 0){
				al.add(i);
				n /= i;
			}
		}
		if(n > 2)
			al.add(n);

		int[] res = new int[al.size()];
		int k = 0;
		for(int i=0; i< res.length; i++)
			res[i] = al.get(i);
		return res;
	}
}

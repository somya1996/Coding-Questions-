package RECURSION;
//Number of non-negative integral solutions of a + b + c = n
// Given a number n, find the number of ways in which  we can add 3 non-negative integers so that their sum is n.
import java.util.Scanner;

public class ways_of_non_negative_integral {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = ways_to_form_n(n);
		System.out.println(ans);
	}
	// Brute force
	/*
	public static int ways_to_form_n(int n){
		int result = 0;
		for(int i=0; i<=n; i++){
			for(int j=0; j<= n-i; j++){
				for(int k=0; k<=n-i-j; k++){
					if(i+j+k == n)
						result++;
				}
			}
		}
		return result;
	}
	*/
	//Optimal way
	public static int ways_to_form_n(int n){
		return ((n+1) * (n+2))/2;
	}

}

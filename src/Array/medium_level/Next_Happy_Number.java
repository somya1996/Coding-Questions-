package Array.medium_level;

import java.util.HashSet;
import java.util.Scanner;

public class Next_Happy_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(nextHappy(n));
	}
	static int nextHappy(int n){
		if(isHappy(n) == true)
			n = n+1;
		else{
			n = n++;
			while (!isHappy(n)){
				n = n+1;
				System.out.println("x in loop " + n);
			}
		}
		return n;
	}
	public static boolean isHappy(int n){
		HashSet<Integer> hs = new HashSet<>();
		int sum = 0 ;
		while(n > 0){
			int x = n%10;
			sum += x*x;
			n = n/10;
			if(n == 0 && sum != 1){
				if(hs.contains(sum)){
					return false;
				}
				else{
					hs.add(sum);
					n = sum;
					sum = 0;
				}
			}
		}
		return true;
	}
}

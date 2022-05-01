package Array.medium_level;

import java.util.Scanner;
import java.util.ArrayList;

public class Super_Primes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(no_of_super_primes(n));
	}
	public static int no_of_super_primes(int n){
		int ans = 0 ,count = 0;
		if (n<=4)
			return 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(2);
		al.add(3);
		for(int i=5; i<=n; i++ ){
			if(isPrime(i)){
				if(al.contains(i-al.get(al.size()-1))){
					ans = i;
					count++;
					System.out.println("super primes are: "+ans);
				}
				al.add(i);
			}
		}
		return count;
	}
	public static boolean isPrime(int n){
		for(int i=2;i*i<=n; i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
}

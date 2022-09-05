package Maths;

import java.util.Scanner;

public class Mathematical_manipulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = CommonFactor(n);
		System.out.println(count);
	}
	public static int CommonFactor(int n){
		int count = 0;
		for(int i=2; i<=n; i++){
			if(gcd(i , n)>1){
				count++;
			}
		}
		return count;
	}
	public static int gcd(int x , int y){
		if(x==0)
			return y;
		return gcd(y%x , x);
	}
}

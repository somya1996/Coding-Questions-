package Array.medium_level;

import java.util.Scanner;

public class Reverse32bit_integer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = reverse(n);
		System.out.println(ans);
	}
	public static int reverse(int x){
		/*
		long r = 0;
		while(x != 0){
			r = r*10 + x%10;
			x /= 10;
		}
		if(r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
			return (int)r;
		else
			return 0;

		 */
		int result = 0;

		while (x != 0){
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if((newResult - tail)/10 != result)
				return 0;

			result = newResult;
			x = x / 10;
		}

		return result;
	}
}

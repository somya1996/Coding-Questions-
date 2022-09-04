package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Square_root_with_given_precision {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		float f = squareRoot(n , p);
		System.out.println(f);
	}
	static float squareRoot(int number, int precision)
	{
		int start = 0, end = number;
		int mid;
		// variable to store the answer
		double ans = 0.0;

		// for computing integral part
		// of square root of number
		while (start <= end) {
			mid = (start + end) / 2;
			if (mid * mid == number) {
				ans = mid;
				break;
			}

			// incrementing start if integral
			// part lies on right side of the mid
			if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			}

			// decrementing end if integral part
			// lies on the left side of the mid
			else {
				end = mid - 1;
			}
		}

		// For computing the fractional part
		// of square root upto given precision
		double increment = 0.1;
		for (int i = 0; i < precision; i++) {
			while (ans * ans <= number) {
				ans += increment;
			}
			// loop terminates when ans * ans > number
			ans = ans - increment;
			increment = increment / 10;
		}
		return (float)ans;
	}
}

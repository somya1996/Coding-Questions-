package Array.medium_level;

import java.math.BigInteger;
import java.util.Scanner;

public class Power_of_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int ans = power(A);
		System.out.println(ans);
	}
	public static int power(String A) {
		// this code is only for small values but if no. is greater than long data type then this code will not work
		/*
		if(A == null || A.length()== 0)
			return 0;
		if(A.charAt(0)=='0')
			return 0;
		else {
			long count = 0;
			//int rem = 0;
			int no_of_1 = 0;
			int i = 0;
			while (i < A.length()) {
				long val = A.charAt(i) - '0';
				count = val + count * 10;
				i++;
			}
			System.out.println(count);

			while(count != 0){
				if((count & 1) == 1)
					no_of_1++;
				count = count>>1;
			}
			if(no_of_1 > 1)
				return 0;
		}
		return 1;*/

		//Other way
		/*
		BigInteger b1 = new BigInteger(A);
		if(b1.equals(BigInteger.valueOf(1)))
			return 0;
		else if(b1.and(b1.subtract(BigInteger.valueOf(1))).equals(BigInteger.valueOf(0)))
			return 1;
		return 0;
		*/

		String dividend = A;
		StringBuilder quotient;

		if (A == null || A.length() == 0)
			return 0;

		if (A.length() == 1 && A.charAt(0) == '0')
			return 0;

		while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
			quotient = new StringBuilder();
			int carry = 0;
			int n = dividend.length();
			// to check the last digit is odd or even if even then only valid for power of 2
			if (n > 0) {
				int num = dividend.charAt(n - 1) - '0';
				if (num % 2 == 1) {
					return 0;
				}
			}

			for (int i = 0; i < n; i++) {
				char c = dividend.charAt(i);
				int res = ((c - '0') + (10 * carry))/2;
				carry = ((c - '0') + (10 * carry)) % 2;

				quotient.append(res);
			}
			/*
			for (int i = 0; i < n; i++) {

	            char c = (char) (dividend.charAt(i) - '0');
	            int res = c + 10 * carry;

	            c = (char) (res / 2 + '0');
	            carry = res % 2;

	            str.append(c);
	        }
			 */
			if(carry == 1)
				return 0;

			if(quotient.charAt(0)=='0')
				quotient.deleteCharAt(0);

			dividend = quotient.toString();
		}

		return 1;

	}
}

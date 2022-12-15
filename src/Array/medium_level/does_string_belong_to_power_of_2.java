package Array.medium_level;
import java.util.Scanner;

public class does_string_belong_to_power_of_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = power(s);
		System.out.println(ans);
	}
	public static int power(String A){
		String dividend = A;
		StringBuilder str;

		if (A == null || A.length() == 0)
			return 0;

		if (A.length() == 1 && A.charAt(0) == '0')
			return 0;

		while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
			str = new StringBuilder();
			int carry = 0;
			int n = dividend.length();

			if (n > 0) {
				int num = dividend.charAt(n - 1) - '0';

				if (num % 2 == 1)
					return 0;
			}

			for (int i = 0; i < n; i++) {

				char c = (char) (dividend.charAt(i) - '0');
				int res = c + 10 * carry;

				c = (char) (res / 2 + '0');
				carry = res % 2;

				str.append(c);
			}

			if (str.charAt(0) == '0')
				str.deleteCharAt(0);

			dividend = str.toString();
		}

		return 1;
	}
}

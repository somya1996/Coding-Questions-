package Array.medium_level;

import java.util.Scanner;

public class Largest_coprime_divisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(cpFact(A , B));
	}
	public static int cpFact(int A, int B) {
		while (gcd(A, B) != 1) {
			A = A/gcd(A, B);
		}

		return A;
	}

	public static int gcd(int A, int B) {
		//if (b == 0) {
		//	return a;
		//}

		//return gcd(b, a % b);
		while(A!=0){
			int temp = B%A;
			B = A;
			A = temp;
		}
		return B;
	}
}

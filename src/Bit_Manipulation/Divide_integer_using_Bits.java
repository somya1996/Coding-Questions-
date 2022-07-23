package Bit_Manipulation;

import java.util.Scanner;

public class Divide_integer_using_Bits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(division(a , b));
	}
	public static int division(int dividend , int divisor){
		/*boolean isDividendNegative = false;
		if(dividend < 0)
		{
			dividend *= -1;
			isDividendNegative = true;
		}

		boolean isDivisorNegative = false;
		if(divisor < 0)
		{
			divisor *= -1;
			isDivisorNegative = true;
		}

		long a = Math.abs(dividend);
		long b =  Math.abs(divisor);

		int quotient = 0;

		for(int i = 30; i >= 0; i--){
			if((b << i ) <= a){
				quotient = quotient|(1<<i);
				a = a - (b << i);
			}
		}

		// Both are negative.
		if(isDividendNegative && isDivisorNegative)
		{
			return (int)quotient;
		}

		// Both are positive.
		if(!isDividendNegative && !isDivisorNegative)
		{
			return (int)quotient;
		}

		// One is negative and one is positive.
		return -1*(int)quotient;
		*/


		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
		// remove sign of operands
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int quotient = 0;
		while(dividend - divisor >= 0){
			int x = 0;
			while(dividend - (divisor<<1<<x)>=0)
				x++;
			quotient += (1<<x);
			dividend -= divisor<<x;
		}
		//if the sign value computed earlier is -1 then
		//negate the value of quotient
		if(sign==-1)
			quotient=-quotient;
		return quotient;
	}
}

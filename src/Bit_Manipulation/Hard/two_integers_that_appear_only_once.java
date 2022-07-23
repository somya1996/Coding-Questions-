package Bit_Manipulation.Hard;

import java.util.Scanner;

public class two_integers_that_appear_only_once {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int[] ans = solve(arr);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] solve(int[] A) {
		int xor = 0;
		for(int x: A){
			xor ^= x;
		}
		//System.out.println(xor);
		// to get last set bit
		xor = (xor & -(xor));
		//System.out.println(xor);
		int count1 = 0 ;
		int count0 = 0;

		for(int num : A){
			if((num & xor) > 0)
				count1 ^= num;
			else
				count0 ^= num;
		}
		//System.out.print(count1+" "+count0);

		int arr[] = new int[2];
		if(count0 > count1){
			arr[0] = count1;
			arr[1] = count0;
		}
		else{
			arr[0] = count0;
			arr[1] = count1;
		}


		return arr;

		/*int result[] = new int[2];
		int xor = A[0];
		for (int i=1; i<A.length; i++)
		{
			xor ^= A[i];
		}

		int bit = xor & ~(xor-1);

		int num1 = 0;
		int num2 = 0;

		for (int num : A)
		{
			if ((num & bit) > 0)
			{
				num1 ^= num;
			}
			else
			{
				num2 ^= num;
			}
		}

		result[0] = num1;
		result[1] = num2;
		return result;*/
	}
}

package Array;

import java.util.Scanner;

//formulae :  nCr=n!/(r!*(n-r)!) but this can only use for small no for large values it will give negative no
public class PascalTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int row =1;row<=n;row++) {
			int sum = 1;
			for (int cst =1 ; cst <= n; cst++) {
				if(cst == 1)
					System.out.print(1+" ");
				if(cst<=row) {
						sum = sum*(row-cst)/cst;
						System.out.print(sum+" ");
				}
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}
}

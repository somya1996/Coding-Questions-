package Array;
import java.util.Scanner;


public class Sum_of_two_no_without_arithmetic {
	public static void main(String[] args) {
		int start = (int)System.currentTimeMillis();
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i=0;i<b;i++){
			a++;
		}
		System.out.println(a);
		int end = (int)System.currentTimeMillis();
		System.out.println("Time taken :"+(end - start));

	}
}

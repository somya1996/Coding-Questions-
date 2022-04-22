package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Missing_element_array {
	public static void main(String[] args) {
		int n = 6;
		int[] a = {1, 2, 4, 5, 6};
		System.out.println(findDisappearedNumbers(a , n));
	}

	private static int findDisappearedNumbers(int[] a , int n) {
		/*Arrays.sort(a);
		int count = 1, i = 0;
		int missing = 0;
		while (i <= a.length) {
			//System.out.println(" In loop a[i] "+a[i]+" count "+count);
			if (a[i] != count) {
				//System.out.println(" If not equal ");
				missing = count;
				break;
			}
			i++; count++;

		}
		return missing;*/
		int sum = 0 , sum1 = 0 , count = 1;
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(" Array sum : "+a[i] );
			sum+= a[i];
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(" Count sum : "+count );
			sum1 += count;
			count++;
		}
		System.out.println();
		return sum1-sum;
	}
}

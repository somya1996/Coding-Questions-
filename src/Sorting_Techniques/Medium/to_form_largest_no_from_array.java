package Sorting_Techniques.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class to_form_largest_no_from_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		String ans = largestNumber(arr);
		System.out.println(ans);
	}

	public static String largestNumber(final int[] A) {
		String[] str = new String[A.length];
		int i = 0;
		for(int x: A){
			str[i++] = Integer.toString(x);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String o1 = a+b;
				String o2 = b+a;
				return o2.compareTo(o1);
			}
		});

		if(str[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();

		for(int j =0; j<str.length; j++){
			sb.append(str[j]);
		}

		return sb.toString();
	}
}

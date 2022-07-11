package RECURSION;

import java.util.Scanner;

public class Print_all_permutation_of_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = str.length();
		permute1(str,0 ,n-1);
	}

	static void permute1(String str, int start , int end )
	{
		if(start == end){
			System.out.println(str);
			return;
		}
		else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				// storing this in str so that we can work on  swapped function
				permute1(str, start + 1, end);
				str = swap(str, start, i);
			}
		}
	}
	public static String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}

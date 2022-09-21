package Strings.Hard;

import java.util.Scanner;

public class Licence_formatting_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.nextLine();
		int K = sc.nextInt();
		String ans = ReFormatString(s , K);
		System.out.println(ans);
	}
	public static String ReFormatString(String S, int K){
		StringBuilder sb = new StringBuilder();

		S = S.toUpperCase();
		S = S.replaceAll("-","");

		int count = 0;
		for(int i=S.length()-1; i>=0; i--)
		{
			if(count == K)
			{
				sb.append('-');
				count = 0;
			}
			sb.append(S.charAt(i));
			count++;
		}

		return sb.reverse().toString();
	}
}

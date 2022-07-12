package Strings;
import java.util.Scanner;

public class longest_uncommon_subseq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		int len = l_uc_s(s , t);
		System.out.println(len);
	}
	public static int l_uc_s(String s , String t){
		if(s.equals(t) == true)
			return 0;
		return Math.max(s.length() , t.length());
	}

}

package Strings;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Validate_an_IP_Address {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		if (isValid(x) == true)
			System.out.println(" Valid ");
		else
			System.out.println(" Not Valid ");
	}

	public static boolean isValid(String s) {
		int dot = 0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='.')
				dot++;
		if(dot>3 || dot<3)
			return false;

		String x[] = s.split("\\.");
		if (x.length != 4) {
			return false;
		}
		for(int i=0;i<x.length;i++){
				if(!isNumbers(x[i]))
					return false;
				if(x[i].length()>3)
					return false;
				else if(x[i].equals("") || !(x[i].length()<=3 && Integer.parseInt(x[i])<=255))
					return false;

				if((x[i].charAt(0)=='0' && x[i].length()>1) || (Integer.parseInt(x[i])==0 && x[i].length()>1))
					return false;
		}
		return true;
	}

	public static boolean isNumbers(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
}

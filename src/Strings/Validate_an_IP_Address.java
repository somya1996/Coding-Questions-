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
		String words[] = s.split("\\.");

		if (words.length != 4) {
			return false;
		}

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > 3)
				return false;
			if (Integer.parseInt(words[i]) <= 0 && Integer.parseInt(words[i]) >= 255)
				return false;

			if ((Integer.parseInt(words[i]) == 0 && words[i].length() > 1) || (words[i].charAt(0) == '0' && words[i].length() > 1))
				return false;
			else if(words[i].equals("") || !(words[i].length()<=3 && Integer.parseInt(words[i])<=255))
				return false;
		}
		return true;
	}
}

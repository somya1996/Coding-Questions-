package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class All_possible_string {
	private static ArrayList<String> spaceString(String str){
		ArrayList<String> strs = new ArrayList<>();
		if(str.length()==1) {
			strs.add(str);
			return strs;
		}
		int len = str.length();
		ArrayList<String> strsTemp = spaceString(str.substring(1,len));
		System.out.println(strsTemp);
		for (int i = 0; i < strsTemp.size(); i++)
		{

			strs.add(str.charAt(0) +
					strsTemp.get(i));
			strs.add(str.charAt(0) + " " +
					strsTemp.get(i));
		}

		return strs;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> patterns = new ArrayList<String>();

		// Function Call
		patterns = spaceString(sc.nextLine());

		// Print patterns
		for (String s : patterns)
		{
			System.out.println(s);
		}
	}
}

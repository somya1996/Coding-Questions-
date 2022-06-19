package Bit_Manipulation;

import Strings.All_possible_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class power_set {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		ArrayList<String> as = new ArrayList<>();
		as = AllPossibleString(s);
		System.out.println(as);
	}

	private static ArrayList<String> AllPossibleString(String s) {
		ArrayList<String> res = new ArrayList<String>();
		int length = s.length();
		int pow = (int)Math.pow(2,length);
		for(int i=1; i<pow; i++){
			String str = "";
			for(int j=0; j<length; j++){
				if((i&(1<<j))!=0){
					str += s.charAt(j);
				}
			}
			res.add(str);
		}
		Collections.sort(res);
		return res;
	}
}

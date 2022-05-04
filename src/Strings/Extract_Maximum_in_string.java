package Strings;

import java.util.Scanner;
/*
INPUT:  100klh564abc365bg
OUTPUT: 564
*/
public class Extract_Maximum_in_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int num = 0 , max = 0 , sum = 0;
		String s = "";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='0'&& str.charAt(i)<='9'){
				num = num*10 + (str.charAt(i)-'0');
			}
			else{
				max = Math.max(max , num);
				num = 0;
			}
		}
		max = Math.max(max , num);  // if in string all the characters are no so it will not go in else part
		System.out.println(max);
	}
}

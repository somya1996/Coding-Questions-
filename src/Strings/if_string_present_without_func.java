package Strings;

import java.util.Scanner;

public class if_string_present_without_func {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String x = sc.nextLine();
		int idx = strstr(s,x);
		System.out.println(idx);

	}
	public static int strstr(String s, String x){
		boolean flag = false;
		int index = -1;
		for(int i=0; i < s.length()-x.length(); i++){
			if(s.substring(i,i+x.length()).equals(x)){
				flag = true;
				index = i;
			}
		}
		if(flag == false)
			return -1;
		return index;

		/*boolean flag = false;
		for (int i = 0; i < s.length() - x.length() + 1; i++) {
			if (s.substring(i, i + x.length()).equals(s)) {
				System.out.print(i + " ");
				flag = true;
			}
		}

		if (flag == false) {
			System.out.println("NONE");*/
		//}
	}
}

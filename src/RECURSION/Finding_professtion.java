package RECURSION;

import java.util.Scanner;

public class Finding_professtion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int level = sc.nextInt();
		int pos = sc.nextInt();
		char c =  profession(level , pos);
		if(c == 'd')
			System.out.println("Doctor");
		else
			System.out.println("Engineers");
	}
	static char profession(int level, int pos){
		if(level == 1)
			return 'e';
		if(profession(level -1 , (pos+1)/2) == 'd')
			return (pos%2 > 0 ? 'd':'e');
		return(pos%2 >0 ? 'e':'d');
	}
}

package RECURSION.medium;

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
		// Main working : Going in reverse direction to check what will be its parent profession
		/*
			if E then at [odd - E  , even - D]
			if D then at [odd - D  , even - E]
			to get its parent node we'll do (pos+1)/2
		*/
		//Base case
		if(level == 1)
			return 'e';
		if(profession(level -1 , (pos+1)/2)=='d') {
			System.out.println("if "+" level "+level + " pos "+ pos);
			return (pos % 2 > 0 ? 'd' : 'e');
		}
		else {
			System.out.println("else "+ "level "+ level +" pos "+ pos);
			return (pos % 2 > 0 ? 'e' : 'd');
		}
	}
}

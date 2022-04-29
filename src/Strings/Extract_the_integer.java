package Strings;
import java.util.Scanner;

//1. Prakhar Aggrawal, 2. Manish Kumar Rai, 3. Rishabh Gupta56    // Output: 1 2 3 56
//2. 1.hello34 2.67world34   //Output: 1 34 2 67 34
public class Extract_the_integer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String s = "";
		System.out.println(str);
		for(int i = 0; i<str.length()-1; i++){
			if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				s += str.charAt(i);
				if(str.charAt(i+1)>='0' && str.charAt(i+1)<='9') {
					continue;
				}
				else{
					s += " ";
				}
			}

		}
		if(str.charAt(str.length()-1)>='0' && str.charAt(str.length()-1)<='9')
			s += str.charAt(str.length()-1);

		System.out.println(s);
	}
}

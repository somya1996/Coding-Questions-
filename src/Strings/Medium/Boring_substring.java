package Strings.Medium;

import java.util.Scanner;

public class Boring_substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int can_change = solve(A);
		if(can_change == 1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	public static int solve(String A) {
        /*String odd = "", even = "";
        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);
            if (c % 2 == 0)
                odd += c;
            else
                even += c;
        }
        char[] ar = odd.toCharArray();
        Arrays.sort(ar);
        odd = String.valueOf(ar);
        ar = even.toCharArray();
        Arrays.sort(ar);
        even = String.valueOf(ar);
        if (check(odd + even))
            return 1;
        else if (check(even + odd))
            return 1;
        return 0;
    }
    public static boolean check(String s){
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i)
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        return ok;
    }*/

// if we take even and odd parity ascii vale the consective characters will neve occur simultaneously
// eg abcdefghij
// odd = acegi    even = bdfhj
// now both string separately not making not a boring substring but we have to check when we concat is it making
//boring substring or not
// to check that O+E  => max character value of odd string - min character value of even string if -> 1 then boring
// to check that E+O  => max character value of even string - min character value of odd string if -> 1 then boring

		int maxOdd = Integer.MIN_VALUE;
		int minOdd = Integer.MAX_VALUE;
		int maxEven = Integer.MIN_VALUE;
		int minEven = Integer.MAX_VALUE;
		for(int i=0; i<A.length(); i++){
			if(A.charAt(i)%2 == 0){
				maxEven = Math.max(maxEven , A.charAt(i));
				minEven = Math.min(minEven , A.charAt(i));
			}
			else{
				maxOdd = Math.max(maxOdd , A.charAt(i));
				minOdd = Math.min(minOdd , A.charAt(i));
			}
		}
		if(Math.abs(maxOdd - minEven) != 1)
			return 1;
		else if(Math.abs(maxEven - minOdd) != 1)
			return 1;
		return 0;
	}
}

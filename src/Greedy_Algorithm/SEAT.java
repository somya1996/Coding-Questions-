package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class SEAT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int ans = seats(A);
		System.out.println(ans);
	}
	public static int seats(String A) {
		int start = -1 , end = -1;
		int person = 0;
		int mod = 10000007;
		for(int i=0;i<A.length(); i++){
			if(A.charAt(i) == 'x'){
				if(start == -1)
					start = i;
				end = i;
				person++;
			}
		}
		if(person == 0 || person<2)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=start; i<=end; i++){
			if(A.charAt(i)=='x')
				list.add(i);
		}
		//System.out.println(list);
		int mid = person/2;
		//System.out.println(mid);
		int range = list.get(mid);
		//System.out.println(range);
		long jump = 0L;

		for(int i=0; i<list.size(); i++){
			int start_index = list.get(i);
			int end_index = range-mid+i;
			jump = jump%mod + Math.abs(end_index - start_index);
		}

		return (int)jump%mod;
	}
}
/**
 * Initialize an arraylist to store all the indexes of person present.
 * Find the median of arrayList of positions.
 * Now all the other persons will now be made to sit in a group so:
        > all person sit in starting
        > all person sit in end
        > all person sit in middle
 * All the other persons will now be made to sit around this person as this will give the minimum number
   of jumps that are required to be made.
 * Initialize a variable ans that stores the minimum jumps required.
 * Now, traverse the vector position[] and for every index i find the median element and update ans as:
 * ans = ans + abs(position[i] – medianElement)
 */
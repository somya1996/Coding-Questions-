package Array.medium_level;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Subarray_with_least_average {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0; i<n; i++){
			al.add(sc.nextInt());
		}
		int B = sc.nextInt();
		//int ans = solve(al,B);
		Subarray_with_least_average a = new Subarray_with_least_average();
		int ans = a.solve(al,B);
		System.out.println(ans);

	}
	public int solve(ArrayList<Integer> A, int k) {
		// sliding window equation
		int cursum = 0;
		for(int i=0; i<A.size(); i++){
			cursum += A.get(i);
		}
		// initialize cursum with starting k elements then:
		// start deleting from index value zero A.get(i-1)
		// start adding new elements after the kth element using A.get(i+k-1)
		int min = cursum , index = 0;
		for(int i=1; i<= A.size()-k; i++){
			cursum = cursum - A.get(i-1)+ A.get(i+k-1);
			if(min > cursum){
				min = cursum;
				index = i;
			}
		}
		return index;
	}
}

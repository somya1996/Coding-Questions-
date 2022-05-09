package Array.medium_level.prefix_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class consecutive_sum_prime_n0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}


		for(int i=0; i<arr.length; i++){
			//System.out.println("Start i "+ i +" "+arr[i]);
			all_primes(arr[i]);
		}
	}
	public static void all_primes(int limit){
		ArrayList<Integer> al = new ArrayList<>();
		boolean P[] = SOE(limit);
		for(int i=0; i<P.length; i++){
			if(P[i] == true) {
				al.add(i);
			}
		}
		//System.out.println(al);
		consecutive_sum(al , limit);
	}
	public static boolean[] SOE(int number){
		boolean isP[] = new boolean[number+1];
		Arrays.fill(isP , true);
		isP[0] = false;
		isP[1] = false;
		for(int i=2; i<=Math.sqrt(number); i++){
			for(int j=2*i; j<=number; j+=i){
				isP[j] = false;
			}
		}
		return isP;
	}
	public static void consecutive_sum(ArrayList<Integer>al , int x){
		int ps[] = new int[al.size()];
		ps[0] = al.get(0);
		for(int i=1; i<al.size(); i++){
			ps[i] = ps[i-1] + al.get(i);
		}
		//for(int i=0;i<ps.length; i++)
		//	System.out.print(ps[i]+" ");
		for(int i=1; i<ps.length; i++){
			if(ps[i]!=2 || ps[i]<x)
				if(al.contains(ps[i]))
					System.out.print(ps[i]+" ");
		}
		System.out.println();
	}
}

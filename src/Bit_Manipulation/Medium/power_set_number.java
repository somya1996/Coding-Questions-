package Bit_Manipulation.Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class power_set_number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		ArrayList<ArrayList<Integer>> as = new ArrayList<>();
		AllPossibleSubset(arr , as , new ArrayList<Integer>());
		System.out.println(as);
	}
	public static void AllPossibleSubset(int[] arr , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer>ds){
		int len = arr.length;
		int powerset = (int)Math.pow(2 , len);
		for(int power = 0; power< powerset; power++){
			for(int j = 0; j<arr.length; j++){
				System.out.println(" power "+power+" j "+j+" "+(power & (1<<j)));
				if((power & (1<<j)) != 0){
					ds.add(arr[j]);
				}
			}
			ans.add(new ArrayList<>(ds));
			ds.clear();
		}
	}

}

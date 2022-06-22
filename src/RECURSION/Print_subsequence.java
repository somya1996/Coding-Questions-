package RECURSION;

import java.util.ArrayList;
import java.util.Scanner;

public class Print_subsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer>al = new ArrayList<>();
		subsequence(0 , arr , al , n);
	}
	public static void subsequence(int index , int[] arr , ArrayList<Integer>al, int n){
		//Base case
		if(index == n){
			if(al.size()>0) {
				for (int x : al) {
					System.out.print(x + " ");
				}
				System.out.println();
			}
			return;
		}
		al.add(arr[index]);//including current index
		subsequence(index+1 , arr , al , n);
		al.remove(al.get(al.size()-1));// exclusing current index
		subsequence(index+1,arr , al , n);
	}
}

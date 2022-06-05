package Array.Hard_level;

import java.util.Scanner;

public class Boyer_Moore_Algo_for_Nby3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ele = majorityElemenet_Nby3(arr);
		System.out.println(ele);
	}
	public  static  int majorityElemenet_Nby3(int A[]){
		int num1 = -1;
		int num2 = -1;
		int count1 = 0;
		int count2 = 0;
		int n = A.length;
		for(int i=0; i<n; i++){
			if(A[i] == num1){
				count1++;
			}
			else if(A[i] == num2){
				count2++;
			}
			else if(count1 == 0){
				num1 = A[i];
				count1 = 1;
			}
			else if(count2 == 0){
				num2 = A[i];
				count2 = 1;
			}
			else {
				count1--;
				count2--;
			}
		}
		count1 = 0 ;
		count2 = 0 ;
		for(int i = 0; i<n; i++){
			if(A[i] == num1)
				count1++;
			if(A[i] == num2)
				count2++;
		}
		if(count1 > n/3)
			return num1;
		if(count2 > n/3)
			return num2;
		return -1;
	}
}

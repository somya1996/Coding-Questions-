package Array.Hard_level;

import java.util.Scanner;

public class Find_Next_Pallindrome {
/*
Given a numeric string A representing a large number you need to find the next
smallest palindrome greater than this number.
Input 1:                      Output 1:
 A = "23545"                       A = "23632"

Input 2:                      Output 2:
 A = "999"                         A = "1001"
*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = s.length();
		int arr[];

		arr = new int[len];

		int a = Integer.parseInt(String.valueOf(s));
		int i = len-1;
		//to fill in array
		while(a!=0){
			int rem = a%10;
			arr[i--] = rem;
			a = a/10;
		}

		for(int j=0;j<arr.length;j++)
			System.out.print(arr[j]+" ");

		int start = 0 , end = arr.length-1;
		int mid = start+end/2;

		if(len%2==0 && arr[mid]<9){
			if(arr[mid]<arr[mid+1])
				arr[mid] = arr[mid+1];
			else if(arr[mid]>arr[mid+1])
				arr[mid+1] = arr[mid];
			else{
				arr[mid] += 1;
				arr[mid+1] = arr[mid];
			}
		}
		else if(len%2==0 && arr[mid]==9){
			arr[mid-1] += 1;
			arr[mid] = arr[mid+1] = 0;
		}
		else if(len%2!=0 && arr[mid]==9){
			arr[mid-1] += 1;
			arr[mid] = 0;
		}
		else{
			arr[mid] = arr[mid]+1;
		}



		while(start<end){
			if(arr[start] != arr[end]){
				arr[end] = arr[start];
			}
			start++;
			end--;
		}

		System.out.println();
		for(int j=0;j<arr.length;j++)
			System.out.print(arr[j]+" ");
	}


}

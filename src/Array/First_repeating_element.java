package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Given an array arr[] of size n, find the first repeating element. The element should occurs more than once and
the index of its first occurrence should be the smallest.
Example 1:
Input:
n = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation: 5 is appearing twice and its first appearence is at index 2 which is less than 3 whose first
			occuring index is 3.

	Note : We can use XOR for getting unique element but what if we have 3 occurance of same no and we need to
	       find only those elements wich do not occur more than one time so we use hashmap for less time and other
	       way is introducing an arr[100] with size 100 and if and element occur more thant one time the just
	       increse its index value.
 */
public class First_repeating_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(repetiting_element(arr , n));

	}
	public static int repetiting_element(int arr[] , int n){
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < n ; i++)
		{
			if(hm.containsKey(arr[i])){
				hm.put(arr[i] , hm.get(arr[i])+1);
			}
			else
				hm.put(arr[i] , 1);
		}
		for(int i=0;i<n;i++){
			if(hm.get(arr[i])>1)
				return i;
		}
		return -1;
	}
}

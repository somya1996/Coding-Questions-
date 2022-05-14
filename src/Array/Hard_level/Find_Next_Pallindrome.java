package Array.Hard_level;

import java.util.Arrays;
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


	/*
		Maximum subarray size, such that all subarrays of that size have sum less than k

		Examples :

		Input :  arr[] = {1, 2, 3, 4} and k = 8.
		Output : 2
		Sum of subarrays of size 1: 1, 2, 3, 4.
		Sum of subarrays of size 2: 3, 5, 7.
		Sum of subarrays of size 3: 6, 9.
		Sum of subarrays of size 4: 10.
		So, maximum subarray size such that all subarrays of that size have the sum of elements less than 8 is 2.

		Input :  arr[] = {1, 2, 10, 4} and k = 8.
		Output : -1
		There is an array element with value greater than k, so subarray sum cannot be less than k.

		Input :  arr[] = {1, 2, 10, 4} and K = 14
		Output : 2
		*/
	public static class Max_subarray_size_have_sum_less_than_k {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int A[] = new int[n];
			for(int i=0; i<A.length; i++){
				A[i] = sc.nextInt();
			}
			int x = sc.nextInt();

			//prefix sum
			int ps[] = new int[A.length+1];
			Arrays.fill(ps,0);

			//ps[0] = A[0];

			for(int i=0 ; i<n ; i++){
				ps[i+1] = ps[i]+A[i];
			}

			for(int i=0; i<ps.length; i++) {
				System.out.print(ps[i] + " ");
			}

			System.out.println();

			int ans = maximum_size_subarray_less_then_x(ps , n , x);
			System.out.println(ans);
		}
		public static int maximum_size_subarray_less_then_x( int ps[] , int n, int x){
			int ans = -1;
			int start = 0 , end = n ;
			while(start<end){
				int mid = (start+end)/2;
				int i;
				for(i=mid; i<=n; i++){
					if(ps[i]-ps[i-mid]>x)
						break;
				}
				if(i==n+1){
					start = mid+1;
					ans = mid;
				}
				else
					end = mid-1;

			}
			return ans;
		}
	}
}

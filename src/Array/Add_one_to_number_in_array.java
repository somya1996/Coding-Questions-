package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_one_to_number_in_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++)
			A[i] = sc.nextInt();
		int[] ans = plusOne(A);
		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i] + " ");
	}
	public static int[] plusOne(int[] A) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int n = A.length;
		int carry = 1 , sum = 0;
		for(int i = n-1; i >= 0 ; i--){
			//if( i == 0 && A[i] == 0)
			//	continue;
			sum = carry + A[i];
			if( sum > 9){
				al.add(0 , sum%10);
				carry = sum/10;
			}
			else{
				al.add(0 , sum);
				carry = 0;
			}
		}
		if(carry > 0){
			al.add(0 , carry);
		}

		while(true){
			if(al.get(0) == 0){
				al.remove(0);
			}
			else
				break;
		}
		int arr[] = new int[al.size()];
		for(int i= al.size()-1 ; i>=0; i--){
			arr[i] = al.get(i);
		}
		return arr;
		// this is not a good way to add a no
		/*ArrayList<Integer> al = new ArrayList<Integer>();
		int num = 0 ;
		for(int i = 0; i<A.length ; i++){
			num = num*10 + A[i];
		}

		num = num+1;
		while(num != 0){
			al.add(0 ,num%10);
			num = num/10;
		}
		int arr[] = new int[al.size()];
		for(int i=0; i<al.size(); i++){
			arr[i] = al.get(i);
		}
		return arr;*/
	}
}

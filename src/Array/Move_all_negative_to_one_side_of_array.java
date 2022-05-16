package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Move_all_negative_to_one_side_of_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		// using simple method and if order is not important then only this method can be used
		/*int j = 0;
		for(int i=0; i<n; i++){
			if(arr[i]<0) {
				if (i != j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}*/
		// using 2 Pointer method and if order is not important then only this method can be used
		int start = 0 , end = n-1;
		while(start <= end){
			if(arr[start]<0 && arr[end]<0)
				start++;
			else if(arr[start]>0 && arr[end]<0){
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			else if(arr[start]>0 && arr[end]>0){
				end--;
			}
			else{
				start++;
				end--;
			}
		}

		// using this takes too much space and there is no logic used
		// not a good code
		/*ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negative = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			if(arr[i]<0)
				negative.add(arr[i]);
			else
				positive.add(arr[i]);
		}
		int k=0;
		for(int i=0; i<negative.size(); i++){
			arr[k++] = negative.get(i);
		}
		for(int i=0; i<positive.size(); i++){
			arr[k++] = positive.get(i);
		}*/

		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}

	}
}

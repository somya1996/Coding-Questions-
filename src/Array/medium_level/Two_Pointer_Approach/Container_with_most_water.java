package Array.medium_level.Two_Pointer_Approach;

import java.util.Scanner;

public class Container_with_most_water {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int storage = maxArea(arr);
		System.out.println(storage);
	}
	public static int maxArea(int[] A) {
		int n = A.length;
		int i = 0 , j = n-1;
		int container = Integer.MIN_VALUE;
		int height = 0 , width = 0;
		while(i<=j){
			if(A[i] < A[j]){
				height = Math.min(A[i] , A[j]);
				width = j-i;
				//container = Math.max(container , height*width);
				i++;
			}
			else if(A[i] == A[j]){
				height = A[i]; width = j-i;
				//container = Math.max(container , height*width);
				i++;
				j--;
			}
			else{
				height = A[j];
				width = j-i;
				//container = Math.max(container , height*width);
				j--;
			}
			container = Math.max(container , height*width);
		}
		return container;
	}
}

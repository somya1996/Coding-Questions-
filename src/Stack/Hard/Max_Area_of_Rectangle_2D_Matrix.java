package Stack.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Max_Area_of_Rectangle_2D_Matrix {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int ans = solve(matrix);
		System.out.println(ans);
	}
	public static int solve(int[][] matrix) {
		if(matrix.length == 0)
			return 0;
		if(matrix.length == 1 && matrix[0].length == 1)
			return matrix[0][0];
		int arr[]  = new int[matrix[0].length];
		Arrays.fill(arr,0);
		int max_rec = 0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == 1)
					arr[j] = arr[j] + 1;
				else
					arr[j] = 0;
			}
			int area = MAH(arr);
			max_rec = Math.max(max_rec , area);
		}
		return max_rec;
	}

	public static int MAH(int[] arr){
		int n = arr.length;
		int max = 0;
		int[] left = new int[n];
		Stack<Integer>st = new Stack<Integer>();
		for(int i=0; i<n; i++){
			while(!st.isEmpty() && arr[st.peek()] >= arr[i])
				st.pop();
			if(st.isEmpty())
				left[i] = -1;
			else
				left[i] = st.peek();
			st.push(i);
		}

		int[] right = new int[n];
		Stack<Integer>st1 = new Stack<Integer>();
		for(int i=n-1; i>=0; i--){
			while(!st1.isEmpty() && arr[st1.peek()] >= arr[i])
				st1.pop();
			if(st1.isEmpty())
				right[i] = n;
			else
				right[i] = st1.peek();
			st1.push(i);
		}

		for(int i=0; i<n; i++){
			int width = right[i]-left[i]-1;
			if(max < arr[i]*width)
				max = arr[i]*width;
		}
		return max;
	}

	public static int largestInLine(int[] height) {
		if(height == null || height.length == 0) return 0;
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for(int i = 0; i <= len; i++){
			int h = (i == len ? 0 : height[i]);
			if(s.isEmpty() || h >= height[s.peek()]){
				s.push(i);
			}else{
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}
}

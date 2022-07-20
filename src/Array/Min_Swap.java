package Array;

import java.util.Scanner;

public class Min_Swap {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		//int arr[] = new int[n];
		int[] arr ={ 52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37,
				59, 3, 56, 79, 26, 55,60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36,
				21,94, 46, 52, 47, 87, 33, 87, 70 };
		//for(int i=0; i<n; i++)
		//	arr[i] = sc.nextInt();

		//int B = sc.nextInt();
		int B = 19;
		System.out.println(solve(arr , B));
	}
	public static int solve(int[] A, int B) {
		/*int count = 0;
		for(int i=0; i<A.length; i++){
			if(A[i] <= B)
				count++;
		}
		int l = 0 , r = 0 , cnt = 0;
		while(r < count){
			if(A[r] > B)
				cnt++;
			r++;
		}
		int ans = cnt;
		while(r < A.length){
			if(A[r]>B)
				cnt++;
			if(A[r] > B)
				cnt--;
			ans = Math.min(ans , cnt);
			l++;
			r++;
		}
		return ans;*/
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= B)
				count++;
		}
		if (count <= 1)
			return 0;
		int l = 0, r = 0, cnt = 0;
		while (r < count) {
			if (A[r] > B)
				cnt++;
			r++;
		}
		int ans = cnt;
		while (r < A.length) {
			if (A[r] > B)
				cnt++;
			if (A[l] > B)
				cnt--;
			ans = Math.min(ans, cnt);
			l++;
			r++;
		}
		return ans;

	}
}

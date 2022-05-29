package Matrix;

import java.util.Scanner;
/*
n = 2
1 2 3 4 5 6 7 8
9 10 11 12 13 14 15 16
17 18 19 20 21 22 23 24
25 26 27 28 29 30 31 32
33 34 35 36 37 38 39 40
41 42 43 44 45 46 47 48
49 50 51 52 53 54 55 56
57 58 59 60 61 62 63 64


36 28 20 21 22 30 38 46 54 53 52 51 50 42 34 26 18 10 2 3 4 5 6 7 8 16 24 32 40 48 56 64
29 37 45 44 43 35 27 19 11 12 13 14 15 23 31 39 47 55 63 62 61 60 59 58 57 49 41 33 25 17 9 1

*/
public class Matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res[][] = formCoils(n);
		for(int i=0; i< res.length; i++){
			for(int j = res[0].length-1; j>=0; j--){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int[][] formCoils(int n) {
		// code here
		int ans[][] = new int[4*n][4*n];
		int count = 1;
		for(int i=0; i<4*n; i++){
			for(int j = 0; j<4*n; j++){
				ans[i][j] = count++;
			}
		}
		/*for(int i=0; i<4*n; i++) {
			for (int j = 0; j < 4 * n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/

		int total_size = 4*n*4*n;
		int res[][] = new int[2][total_size/2];
		int top = 0 , bottom = 4*n-1;
		int left = 1 , right = 4*n-1;
		int dir = 1;
		int idx = 0;

		while(top <= bottom && left <= right ){
			if(dir == 1){
				for(int i=bottom ; i >= top; i--){
					res[0][idx++] = ans[i][right];
				}
				right--;
				bottom --;
				dir++;
			}
			if(dir==2 ){
				for(int i=right; i>= left; i--){
					res[0][idx++] = ans[top][i];
				}
				top++;
				right--;
				dir++;
			}
			if(dir == 3 ){
				for(int i = top; i<=bottom; i++){
					res[0][idx++] = ans[i][left];
				}
				left++;
				top++;
				dir++;
			}
			if(dir == 4 ){
				for(int i = left; i<=right; i++){
					res[0][idx++] = ans[bottom][i];
				}
				bottom--;
				left++;
				dir = 1;
			}
		}


		top = 0 ; bottom = 4*n-1; left = 0; right = 4*n-2; dir = 1 ; idx = 0;
		//int res1[] = new int[total_size/2];
		while(top <= bottom && left <= right){
			if(dir == 1){
				for(int i= top; i<=bottom; i++){
					res[1][idx++] = ans[i][left];
				}
				left++;
				top++;
				dir++;
			}
			if(dir == 2){
				for(int i = left; i<= right; i++){
					res[1][idx++] = ans[bottom][i];
				}
				bottom--;
				left++;
				dir++;
			}
			if(dir == 3){
				for(int i= bottom; i>= top; i--){
					res[1][idx++] = ans[i][right];
				}
				right--;
				bottom--;
				dir++;
			}
			if(dir == 4){
				for(int i= right; i>= left; i--){
					res[1][idx++] = ans[top][i];
				}
				right--;
				top++;
				dir = 1;
			}

		}
		//System.out.println();
		/*for(int i=0; i< res.length; i++){
			for(int j = res[0].length-1; j>=0; j--){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}*/
		return res;

	}
}

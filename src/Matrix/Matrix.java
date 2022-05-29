package Matrix;

import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		formCoils(n);
		//int ans[][] = formCoils(n);
		//int count = 0;
		//for(int i=0; i<4*n; i++){
		//	for(int j = 0; j<4*n; j++){
		//		System.out.println(ans[i][j]);
		//	}
		//}
	}
	static void formCoils(int n) {
		// code here
		int ans[][] = new int[4*n][4*n];
		int count = 1;
		for(int i=0; i<4*n; i++){
			for(int j = 0; j<4*n; j++){
				ans[i][j] = count++;
			}
		}
		for(int i=0; i<4*n; i++) {
			for (int j = 0; j < 4 * n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

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
		System.out.println();
		for(int i=0; i< res.length; i++){
			for(int j = res[0].length-1; j>=0; j--){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		//return ans;

	}
}

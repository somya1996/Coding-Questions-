package Matrix;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Max_rows_with_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int val = rowWithMax1s(arr,n,m);
		System.out.println(val);
	}
	public static int rowWithMax1s(int arr[][], int n, int m) {
		int max = 0;
		int  res = 0;
		int val = -1;
		for(int i=0; i<n; i++){
			int count = 0;

			for(int j=0; j<m; j++){
				if(arr[i][j] == 1){
					count++;
				}
			}
			max = Math.max(count , max);
			if(res < count){
				res = count;
				val = i;
			}
		}
		return val;
	}
}

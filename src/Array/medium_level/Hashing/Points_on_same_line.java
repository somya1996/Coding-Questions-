package Array.medium_level.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Points_on_same_line {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int X[] = new int[n];
		for(int i=0; i<n; i++){
			X[i] = sc.nextInt();
		}

		int Y[] = new int[n];
		for(int i=0; i<n; i++){
			Y[i] = sc.nextInt();
		}
		int count = solve(X,Y);
		System.out.println(count);

	}
	public static int solve(int[] A, int[] B) {
		HashMap<String , Integer> hm = new HashMap<String , Integer>();
		int total = 0;
		int maxi = 0 , count = 0;
		int n = A.length;
		for(int i=0; i<n; i++){
			maxi = 0 ; count = 0;
			for(int j=i+1; j<n; j++){
				if(A[i] == A[j] &&  B[i] == B[j]){
					count++;
				}
				else{
					int x = A[j] - A[i];
					int y = B[j] - B[i];
					int gcd = GCD(y , x);
					x /= gcd;
					y /= gcd;
					hm.put(x+","+y , hm.getOrDefault(x+","+y , 0)+1);
					maxi = Math.max(maxi , hm.get(x+","+y));
				}
			}
			total = Math.max(total , maxi+count+1);
			hm.clear();
		}
		return total;
	}
	public static int GCD(int x , int y){
		if(x==0)
			return y;
		return GCD(y%x , x);
	}
}
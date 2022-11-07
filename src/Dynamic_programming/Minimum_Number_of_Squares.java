package Dynamic_programming;

import java.util.ArrayList;
import java.util.Scanner;

public class Minimum_Number_of_Squares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = countMinSquares_recursive(n);
		System.out.println(ans);
		int ans1 = bottom_up(n);
		System.out.println(ans1);
	}
	/*public static int countMinSquares_recursive(int A) {
		ArrayList<Integer> ds = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		recursive(A , ds , min);
		return min;
	}
	public static void recursive(int target , ArrayList<Integer>ds , int min){
		if(target == 0){
			min = Math.min(min , ds.size());
			return;
		}
		for(int i=1; i<=target; i++){
			if(target >= i*i){
				ds.add(target);
				recursive(target-(i*i) , ds , min);
				ds.remove(ds.size()-1);
			}
		}
	}*/
	public static int countMinSquares_recursive(int A){
		if (A <= 3)
			return A;
		int res = A;
		for (int x = 1; x <= A; x++){
			int temp = x * x;
			if (temp > A)
				break;
			else
				res = Math.min(res, 1 + countMinSquares_recursive(A - temp));
		}
		return res;
	}
	public static int bottom_up(int n){
		if(n<=3)
			return n;
		int dp[] = new int[n];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for(int x=4; x<=n; x++){
			dp[x] = x;
			for(int i=1; i<=(int)Math.sqrt(x); i++){
				int temp = i*i;
				if(temp>x) break;
				dp[x] = Math.min(x , 1+dp[i]);
			}
		}
		return dp[n];
	}
}

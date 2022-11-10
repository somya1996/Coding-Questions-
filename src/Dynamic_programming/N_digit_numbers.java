package Dynamic_programming;

import java.util.HashMap;
import java.util.Scanner;

public class N_digit_numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		N_digit_numbers ndn = new N_digit_numbers();
		int ans = ndn.recusive_solve(A , B);
		System.out.println(ans);

		int ans1 = top_down_solve(A , B);
		System.out.println(ans1);
	}
	public int recusive_solve(int A, int B) {
		int ans = 0;
		for(int i=1; i<=9; i++){
			ans += recusive(A-1 , B-i);
		}
		return ans;
	}
	public int recusive(int index , int target){
		if(index == 0)
			return target==0?1:0;
		if(target == 0)
			return 1;
		int ans = 0;
		for(int i=0; i<=9; i++){
			ans += recusive(index-1 , target-i);
		}
		return ans;
	}
	static int mod = 1000000009;
	static HashMap<String , Integer>hm = new HashMap<>();
	public static int top_down_solve(int A , int B){
		return td_solve(A , A , B);
	}
	public static int td_solve(int remaining_changes , int changes_needed, int sum ){
		String key = remaining_changes+"_"+sum;
		if(hm.containsKey(key))
			return hm.get(key);

		if(remaining_changes == 1){
			hm.put(key,sum <= 9 ? 1 : 0);
			return sum <= 9 ? 1 : 0;
		}

		int total = 0;
		int start = remaining_changes == changes_needed ? 1:0;
		for(int i=start; i<=9; i++){
			if(sum - i >= 0){
				total = (total%mod + td_solve(remaining_changes-1 , changes_needed , sum-i)%mod)%mod;
			}
		}
		hm.put(key , total);
		return total;
	}
}


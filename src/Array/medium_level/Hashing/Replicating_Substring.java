package Array.medium_level.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Replicating_Substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		String B = sc.nextLine();
		sc.nextLine();
		int ans = solve(A , B);
		System.out.println(ans);
	}
	public static int solve(int A, String B) {
		HashMap<Character , Integer> hm = new HashMap<Character , Integer>();
		for(int i=0; i<B.length(); i++){
			if(hm.containsKey(B.charAt(i))){
				hm.put(B.charAt(i) , hm.get(B.charAt(i))+1);
			}
			else{
				hm.put(B.charAt(i) , 1);
			}
		}
		for(Character x: hm.keySet()){
			if(hm.get(x)%A != 0)
				return -1;
		}
		return 1;
	}
}

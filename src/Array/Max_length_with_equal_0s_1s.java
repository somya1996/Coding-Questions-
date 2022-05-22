package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Max_length_with_equal_0s_1s {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int count = 0;
		HashMap<Integer , Integer> hm = new HashMap<Integer,Integer>();
		hm.put(0,-1);
		int maxlen = 0;
		for(int i=0; i<n;i++){
			if(arr[i] == 1){
				count = count+1;
			}
			if(arr[i] == 0){
				count -= 1;
			}
			if(hm.containsKey(count)){
				maxlen = i - hm.get(count);
			}
			else{
				hm.put(count , i);
			}
		}
		System.out.println(maxlen);
	}
}

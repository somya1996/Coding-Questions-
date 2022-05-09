package Array.medium_level.prefix_sum;

import java.util.HashMap;
import java.util.Scanner;

public class Max_subarray_with_zero_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];

		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		int sum = 0 , maxlength = 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0; i<n; i++){
			sum += A[i];
			if(A[i]==0 && maxlength == 0)
				maxlength = i;
			if(sum == 0)
				maxlength = i+1;
			if(hm.containsKey(sum)){
				int len = i - hm.get(sum);
				maxlength = Math.max(maxlength , len);
				System.out.println(" Present "+sum +" i "+i+" hm.get(sum) "+hm.get(sum)+ "maxlength "+maxlength);
			}
			else
				hm.put(sum,i);
		}
		for(Integer i: hm.keySet()){
			System.out.println(i);
		}
		System.out.println(hm);
		System.out.println(maxlength);
	}
}

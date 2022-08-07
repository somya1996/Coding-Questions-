package Array;

import java.util.HashMap;
import java.util.Scanner;


// Main problem in this is HashMap dosent take duplicate value and if my array contain duplicate
// in hashmap : If you try to insert the duplicate key, it will replace the element of the corresponding key
public class pair_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(paircount(arr, n, target));
	}

	public static int paircount(int a[], int n, int k) {
		int count = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(k - a[i]))
				count++;
			if (!hm.containsKey(a[i]))
				hm.put(a[i], 1);
			else//(if hm.key is already present in the hashmap table then we need to increment given key value)
				hm.put(a[i], hm.get(a[i]) + 1);   // hm.get(a[i])+1 --> this is used to get the value at given key
		}                                      //  Here a[i] is key
		return count;
	}
}

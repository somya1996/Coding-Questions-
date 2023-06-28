package Array;

import java.util.Arrays;
class Pair<K, V> {
	private final K key;
	private final V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

public class test {
		public int maxCoins(int A, int[] B, int C) {
			// create a list of (cost, index) pairs
			Pair<Integer, Integer>[] costs = new Pair[A];
			for (int i = 0; i < A; i++) {
				costs[i] = new Pair<>(2 * B[i], i);
			}
			// sort the list in descending order of cost
			Arrays.sort(costs, (a, b) -> b.getKey().compareTo(a.getKey()));
			// initialize the total earnings to 0
			int earnings = 0;
			// iterate over the customers
			for (int i = 0; i < C; i++) {
				// find the first berry with remaining stock
				int j = 0;
				while (j < A && B[costs[j].getValue()] == 0) {
					j++;
				}
				// if all berries are sold out, break the loop
				if (j == A) {
					break;
				}
				// sell one berry of the selected type
				B[costs[j].getValue()]--;
				// update the total earnings
				earnings += costs[j].getKey();
			}
			// return the total earnings
			return earnings;
		}

		public static void main(String[] args) {
			int A = 4;
			int[] B = {3, 1, 4,1};
			int C = 3;
			test t = new test();

			int maxCoins = t.maxCoins(A, B, C);
			System.out.println("Maximum coins earned: " + maxCoins);
		}
}

package QUEUE.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Max_frequency_stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		for(int i=0; i<n; i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int ans[] = solve(arr);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
	}
	public static int[] solve(int[][] A) {
		HashMap<Integer, Integer> freqmap = new HashMap<>();
		HashMap<Integer , Stack<Integer>> freqStack = new HashMap<>() ;
		ArrayList<Integer> al = new ArrayList<>();

		int maxfreq = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i][0] == 1) {
				int x = A[i][1];
				al.add(-1);
				int freq = freqmap.getOrDefault(x , 0)+1;
				if(freq > maxfreq)
					maxfreq = freq;
				freqmap.put( x , freq);
				freqStack.computeIfAbsent(freq , f->new Stack<>()).push(x);
			}
			else {
				Stack<Integer> s = freqStack.get(maxfreq);
				int top = s.pop();
				al.add(top);
				if(s.isEmpty())
					maxfreq--;
				freqmap.put(top , freqmap.get(top)-1);
			}
		}
		System.out.println("freqMAp" + freqmap);
		System.out.println("freqStack" + freqStack);
		int[] ans = new int[al.size()];
		for(int i=0; i<al.size(); i++){
			ans[i] = al.get(i);
		}
		return ans;
	}
}

package Array;

import java.util.*;

public class Jump_IV {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Jump_IV j4 = new Jump_IV();
		int ans = j4.minJumps(arr);
		System.out.println(ans);
	}

	public int minJumps(int[] arr) {
		HashMap<Integer,ArrayList<Integer>> map = new HashMap();
		int len = arr.length;

		for(int idx = 0;idx<len;idx++){
			int val = arr[idx];
			ArrayList<Integer> list = map.getOrDefault(val,new ArrayList());
			list.add(idx);
			map.put(val,list);
		}

		Queue<Integer> queue = new ArrayDeque();
		boolean visited[] = new boolean[len];
		queue.add(0);
		int minJumps = 0;

		while(queue.size()>0){
			int size = queue.size();

			while(size>0){
				int idx = queue.remove();
				if(idx==len-1) return minJumps;
				size--;
				if(visited[idx]) continue;
				visited[idx] = true;

				if(idx-1>=0&&!visited[idx-1]) queue.add(idx-1);
				if(idx+1<len&&!visited[idx+1]) queue.add(idx+1);

				if(map.get(arr[idx])!=null){
					ArrayList<Integer> list = map.get(arr[idx]);

					for(int nextIdx : list){
						if(!visited[nextIdx]) queue.add(nextIdx);
					}

					map.remove(arr[idx]);
				}
			}

			minJumps++;
		}

		return -1;
	}
}
// here we need to build a graph and see whether we can easily get on to the last element with the minimum steps possible.
// here we have 3 options
// 1. we move i+1 if i+1 < length
// 2. we move i-1 if i-1 >= 0
// 3. we move to j if arr[i] == arr[j] and i != j
// now after building graph we need to do the bFS.
// we can also make use of a visited boolean array to check we already visited a node or not
// one of the key things is we need to clear the dictionary inorder to prevent the stepping back
package QUEUE;

import java.util.*;

class Pair{
	int idx;
	int len;
	Pair(int i , int l){
		idx = i;
		len = l;
	}
}
public class jump_GameIV {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		jump_GameIV jg = new jump_GameIV();
		int ans = jg.minJumps(arr);
		System.out.println(ans);
	}
	public int minJumps(int[] arr) {
		HashMap<Integer , ArrayList<Integer>> hm = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			int val = arr[i];
			ArrayList<Integer> list = new ArrayList<>();
			if(hm.containsKey(val)){
				list = hm.get(val);
				//list.add(i);
				//hm.put(val , list);
			}
			list.add(i);
			hm.put(val , list);
		}
		System.out.println(hm);

		Queue<Pair> q = new LinkedList<>();
		int[] vis = new int[arr.length];
		Arrays.fill(vis , 0);
		int minjump = Integer.MAX_VALUE;
		q.add(new Pair(0 , 0));
		while(!q.isEmpty()){
			Pair p = q.poll();
			vis[p.idx] = 1;

			if(p.idx == arr.length-1)
				minjump = Math.min(minjump , p.len);

			if(p.idx-1 >= 0 && vis[p.idx-1] != 1){
				q.add(new Pair(p.idx-1 , p.len+1));
			}

			if(p.idx+1 < arr.length && vis[p.idx+1] != 1){
				q.add(new Pair(p.idx+1 , p.len+1));
			}

			if(hm.containsKey(arr[p.idx])){
				for(Integer x : hm.get(arr[p.idx])){
					if(vis[x] != 1)
						q.add(new Pair(x , p.len+1));
				}
			}
			hm.remove(arr[p.idx]);
		}
		return minjump;
	}
}

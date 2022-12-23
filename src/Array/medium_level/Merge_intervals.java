package Array.medium_level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}


public class Merge_intervals {

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			Interval ele = new Interval();
			ele.start = sc.nextInt();
			ele.end = sc.nextInt();
			intervals.add(ele);
		}
		Merge_intervals mi = new Merge_intervals();
		ArrayList<Interval> ans = mi.merge(intervals);
		for(int i=0; i<ans.size(); i++){
			System.out.println(ans.get(i).start+" "+ans.get(i).end);
		}
	}
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals , (a,b)->a.start - b.start);
		int n = intervals.size();
		ArrayList<Interval>result = new ArrayList<Interval>();
		result.add(intervals.get(0));
		for(int i=0; i<n; i++){
			Interval preInterval = result.get(result.size()-1);

			if(preInterval.end > intervals.get(i).start){
				preInterval.start = Math.min(preInterval.start , intervals.get(i).start);
				preInterval.end = Math.max(preInterval.end , intervals.get(i).end);
				//result.remove(result.size()-1);
				//result.add(preInterval);
				result.set(result.size()-1 , preInterval);
			}
			else
				result.add(intervals.get(i));
		}
		return result;
	}
}

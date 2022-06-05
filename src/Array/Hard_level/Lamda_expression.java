package Array.Hard_level;

import java.util.ArrayList;
import java.util.Collections;

public class Lamda_expression {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(205);
		al.add(102);
		al.add(98);
		al.add(275);
		al.add(203);
		System.out.println("Elements of the ArrayList " + "before sorting : " + al);
		//Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
		Collections.sort(al , (o1 , o2) -> {
			//return o1.compareTo(o2);
			if(o1 < o2)
				return -1;
			else if(o1 > o2)
				return 1;
			else
				return 0;
		});
		System.out.println("Elements of the ArrayList after" + " sorting : " + al);
	}
}

package Array;
/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting
its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.

Example 1:

Input:
N = 4
Petrol = 4 6 7 4
Distance = 6 5 3 5
Output: 1
Explanation: There are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs
as {4, 6}, {6, 5},{7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd
petrol pump. Output in this case is 1 (index of 2nd petrol pump).
*/
import java.util.Scanner;

public class Circular_tour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int petrol[] = new int[n];
		int distance[] = new int[n];
		for (int i=0; i<n; i++)
			petrol[i] = sc.nextInt();
		for(int i=0; i<n; i++)
			distance[i] = sc.nextInt();
		// Give the starting index value from where truck can go to all the petrol pumps
		int start = tour(petrol , distance);
		System.out.println(start);
	}
	public static int tour(int petrol[], int distance[]){
		/* here we have to reach every petrol pump in circular form
		 eg 4 8 7 4
		    6 5 3 5
		    i=0 {4 , 6}  balance = 4-6 = -2  kami/defecit = -2  (it is -ve so STARTING POINT will be next)
		s=> i=1 {8 , 5}  balance = 8-5 = 3  +ve (means this can move to next petrol pump)
		    i=2 {7 , 3}  balance = 7-3 = 4+prev_balance = 7 +ve (means this can move to next petrol pump)
		    i=3 {4 , 5}  balance = 4-5 = -1+prev_balance = 6 +ve (all the petrol pump is reached)

		    if(total_balance_petrol + defecit >= 0)
		       if yes then truck has completed all the points
		 */
		int balance = 0;
		int start = 0;
		int defecit = 0;
		for(int i=0 ; i < petrol.length; i++){
			balance += petrol[i] - distance[i];
			if(balance < 0) {
				start = i + 1;
				defecit += balance;
				balance = 0;
			}
		}
		if(balance + defecit >= 0)
			return start;

		return -1;
		/*
		This will give W.A for {4 6 7 4} & {6 5 3 5}
		int balance = 0;
		int start = 0;
		int i = 0;
		for(i=0 ; i < petrol.length; i++){
			balance += petrol[i] - distance[i];
			if(balance < 0)
				start = i+1;
		}
		if(i == petrol.length) {
			if(balance >= 0)
				return start;
		}
		return -1;
		 */
	}
}

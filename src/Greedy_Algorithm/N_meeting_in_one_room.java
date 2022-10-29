package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N_meeting_in_one_room {
	static class room{
		int start;
		int end;
		room(int start , int end){
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("All element of A ");
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		System.out.println("All elements of B ");
		int B[] = new int[n];
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}

		int count = maxMeetings(A , B , n);
		System.out.println(count);
	}
	public static int maxMeetings(int start[], int end[], int n){
		ArrayList<room> list = new ArrayList<>();
		for(int i=0; i<n; i++){
			list.add(new room(start[i] , end[i]));
		}
		Collections.sort(list , (room1 , room2)->(room1.end - room2.end));
		int meeting = 1;
		int cur_end = list.get(0).end;
		for(int i=1; i<n; i++){
			int next_start = list.get(i).start;
			if(next_start > cur_end){
				meeting++;
				cur_end = list.get(i).end;
			}
		}
		return meeting;
	}
}

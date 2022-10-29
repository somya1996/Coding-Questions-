package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Finish_Maximum_job{
	class Job{
		int start;
		int end;
		Job(int start , int end){
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

		Finish_Maximum_job fmj = new Finish_Maximum_job();
		int count = fmj.solve(A , B);
		System.out.println(count);
	}
	public int solve(int[] A, int[] B) {
		ArrayList<Job> list = new ArrayList<>();
		for(int i=0; i<A.length; i++){
			list.add(new Job(A[i] , B[i]));
		}
		Collections.sort(list ,(job1 , job2)-> job1.end - job2.end);
		int cur_end = list.get(0).end;
		int count = 1;
		for(int i=1; i< list.size(); i++){
			int next_start = list.get(i).start;
			if(cur_end <= next_start){
				count++;
				cur_end = list.get(i).end;
			}
		}
		return count;
	}
}

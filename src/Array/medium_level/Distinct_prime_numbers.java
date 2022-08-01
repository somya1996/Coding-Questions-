package Array.medium_level;

import java.util.HashSet;
import java.util.Scanner;

public class Distinct_prime_numbers {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = solve(arr);
		System.out.println(ans);
	}
	public static int solve(int[] A) {
		HashSet<Integer> set = new HashSet<>();
		int count=0;
		int max=Integer.MIN_VALUE;
		for(int i:A)
		{
			if(i>max)
				max=i;
		}
		// create sieve array
		//Create Sieve array
		int arr[]=new int[max+1];
		int n=arr.length;
		arr[0]=1;
		arr[1]=1;
		for(int i=2;i<=n/i;i++)
		{
			if(arr[i]==0)
			{
				for(int j=i*i;j<n;j=j+i)
				{
					arr[j]=1;
				}
			}
		}
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");

		for(int num:A)
		{
			for(int i=1;i<=n/i;i++)
			{
				if(num%i==0)
				{
					if(arr[i]==0)
						set.add(i);
					if(arr[num/i]==0)
						set.add(num/i);

				}
			}
		}
		System.out.println(set);
		return set.size();
	}
}

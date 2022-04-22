package Array;

import java.util.Scanner;

public class Equillibrium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		if(n==1)
			ans = 1;
		for(int i=1;i<n-1;i++){
			//for presum
			int count = 0 , prevsum = 0 , postsum = 0;
			//System.out.println("i "+ i);
			while(count < i){
				//System.out.println(" count "+count);
				prevsum += arr[count];
				//System.out.println("prevsum "+prevsum);
				count++;
			}
			int count1 = i+1;
			while(count1 < n){
				//System.out.println(" count1 "+count1);
				postsum += arr[count1];
				//System.out.println("postsum "+postsum);
				count1++;
			}
			if(prevsum == postsum) {
				ans = i+1;
				break;
			}
			else
				ans = -1;
		}
		System.out.println(ans);

	}
}

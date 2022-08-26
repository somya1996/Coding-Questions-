package Array.medium_level.Two_Pointer_Approach;

import java.util.Scanner;

public class Count_rectangles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int ans = solve(arr , B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int B) {
		int mod = 1000*000*000+7;
		int i = 0 , j = A.length-1;
		System.out.println(" i "+i+" j "+j);
		long count = 0;
		while(i<=j){
			long area = (long)A[i]*A[j];
			if(area < B){
				int len = (j-i+1);
				System.out.println(" len "+len);
				count = count%mod + ((long)(2*len)-1)%mod;
				i++;
			}
			else{
				j--;
			}
		}
		return (int)count%mod;
	}
	/*

        int mod=(1000*1000*1000)+7;
        int l=0,r=A.length-1;
        long ans=0;
        while(l<=r){
            long area=(long)A[l]*A[r];
            if(area<B){
                int size=(r-l+1);
                ans=ans%mod+(((long)2*size)-1)%mod;
                l++;
            }else {
                r--;
            }
        }
        return (int)ans%mod;*/
}

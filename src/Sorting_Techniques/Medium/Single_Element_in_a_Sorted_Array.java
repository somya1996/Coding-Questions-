package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Single_Element_in_a_Sorted_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = singleNonDuplicate(arr);
		System.out.println(ans);
	}
	public static int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		int start = 0 , end = nums.length-1 , mid = 0;
		if(n==1) return nums[0];
		if(nums[0]!=nums[1]) return nums[0];
		if(nums[n-1]!=nums[n-2]) return nums[n-1];
		while(start <= end){
			mid = (start + end) / 2;
			//System.out.println("mid "+mid);
			if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
				return nums[mid];
			if(mid % 2 == 0) {
				if(nums[mid] == nums[mid+1])
					start = mid+1;
				else
					end = mid - 1;
			}
			else {
				if(nums[mid] == nums[mid-1])
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return nums[start];
	}
}
/*
public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1,mid=0,n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        while(l<=r){
            mid = (r+l)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]) r=mid-1;
                else l=mid+1;
            }
            else{
                if(nums[mid]!=nums[mid-1]) r=mid-1;
                else l=mid+1;
            }
        }
        return nums[l];
    }
 */
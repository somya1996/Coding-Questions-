package Sorting_Techniques;

import java.util.Scanner;

public class count_next_smaller_to_self {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		count_next_smaller_to_self cns = new count_next_smaller_to_self();
		int[] ans = cns.constructLowerArray(arr , n);
		for(int i=0; i<n;i++){
			System.out.print(ans[i]+" ");
		}
	}
	class Info
	{
		int val;
		int index;

		public Info(int val, int index)
		{
			this.val = val;
			this.index = index;
		}
	}
	private int[] tempResult;
	private void merge(Info[] arr, int startLeft, int endLeft, int startRight, int endRight)
	{
		int m = endLeft - startLeft + 1;
		int n = endRight - startRight + 1;
		Info[] temp = new Info[m+n];
		int i = 0;
		int j = 0;
		int k = 0;

		int toAdd = 0;
		while(i<m && j<n)
		{
			if(arr[startLeft+i].val <= arr[startRight+j].val)
			{
				System.out.println("if startleft+i "+arr[startLeft+i].val + " less that " + "startRight+j" + arr[startRight+j].val);
				tempResult[arr[startLeft + i].index] += toAdd;
				temp[k++] = arr[startLeft+(i++)];
			}
			else
			{
				temp[k++] = arr[startRight+(j++)];
				toAdd++;
			}
		}
		while(i<m)
		{
			tempResult[arr[startLeft + i].index] += toAdd;
			temp[k++] = arr[startLeft+(i++)];
		}
		while(j<n)
		{
			temp[k++] = arr[startRight+(j++)];
		}
		for(int x=0; x<temp.length; x++)
		{
			arr[startLeft+x] = temp[x];
			System.out.println(arr[startLeft+x].val +" "+arr[startLeft+x].index+" ");
		}
	}

	private void mergeSort(Info[] arr, int l, int r)
	{
		if(l>=r)
			return;
		int m = (l+r)/2;
		mergeSort(arr, l, m);
		mergeSort(arr, m+1, r);
		merge(arr, l, m, m+1, r);
	}
	public int[] constructLowerArray(int[] nums , int n)
	{
		Info[] arr = new Info[nums.length];
		for(int x=0; x<nums.length; x++)
		{
			arr[x] = new Info(nums[x], x);
		}

		tempResult = new int[nums.length];
		mergeSort(arr, 0, nums.length-1);
		return tempResult;
	}
}

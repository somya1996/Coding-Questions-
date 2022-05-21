package Array;

import java.util.Scanner;

public class Form_Biggest_Number{
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			int size = sc.nextInt();
			long[] arr = new long[size];
			for (int row = 0; row < arr.length; row++) {
				arr[row] = sc.nextLong();
				//System.out.println(arr[row]);
			}
			long x = 0;
			for(int i=0; i<arr.length; i++){
				if(arr[i]*(long)Math.pow(10,len((int) x))+x > x*(long)Math.pow(10,len((int)arr[i]))+arr[i]){
					x  =  arr[i]*(long)Math.pow(10,len((int) x))+x;
				}
				else{
					x =  x*(long)Math.pow(10,len((int)arr[i]))+arr[i];
				}
			}
			System.out.println(x);
		}
	}
	public static long len(int x){
		long length = 0;
		while(x!=0){
			int temp = x%10;
			length++;
			x /=10;
		}
		return length;
	}*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			sort(arr);

			display(arr);
			tc--;
		}
	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + "");
		}

		System.out.println();
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (compare(arr[j], arr[j + 1]) > 0) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static int compare(int n1, int n2) {
		String val1 = n1 + "" + n2;
		String val2 = n2 + "" + n1;

		int val1int = Integer.valueOf(val1);
		int val2int = Integer.valueOf(val2);

		if (val1int > val2int)
			return -1;
		else
			return 1;
	}
	/*int len = scn.nextInt();
	int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
		arr[i] = scan.nextInt();
	}
		return arr;*/
}

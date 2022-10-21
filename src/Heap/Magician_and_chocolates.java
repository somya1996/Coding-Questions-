package Heap;

import java.util.Scanner;

public class Magician_and_chocolates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		Magician_and_chocolates mac = new Magician_and_chocolates();
		int sum = mac.nchoc(A , B);
		System.out.println(sum);
	}
	public int nchoc(int[] B , int A) {
		for(int i=0; i<B.length; i++){
			heapify(B , B.length , i);
		}
		printHeap(B);
		int sum = 0;
		for(int i=0; i<A; i++){
			heapify(B , B.length , i);
			System.out.println("B[0] "+B[0]);
			sum += B[0];
			B[0] = (int)Math.floor(B[0]/2);
			heapify(B , B.length , i);
			printHeap(B);
		}
		return sum;
	}
	public static void heapify(int[] arr , int size , int i){
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		if(left < size && arr[left] > arr[largest])
			largest = left;
		if(right < size && arr[right] > arr[largest])
			largest = right;
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, size, largest);
		}
	}
	public void printHeap(int arr[]){
		int N = arr.length;
		System.out.println("Array representation of Heap is:");

		for (int i = 0; i < N; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}

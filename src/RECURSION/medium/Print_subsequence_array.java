package RECURSION.medium;

import java.util.ArrayList;
import java.util.Scanner;

public class Print_subsequence_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer>al = new ArrayList<>();
		subsequence(0 , arr , al , n);
	}
	public static void subsequence(int index , int[] arr , ArrayList<Integer>al, int n){
		//Base case
		if(index == n){
			if(al.size()>0) {
				for (int x : al) {
					System.out.print(x + " ");
				}
				System.out.println();
			}
			return;
		}
		al.add(arr[index]);//including current index
		subsequence(index+1 , arr , al , n);
		al.remove(al.size()-1);// exclusing current index
		subsequence(index+1,arr , al , n);
	}
	// TIME COMPLEXITY - Here for every index value there are two options take and not take so forn index (2^n)*n
	//                    O(2^n)(Take and not take two types)*n (to print elements in arraylist)
	//                         Recursion tree
	/*                              [3 1 2]
									f(0,[])
						 (Take)/               \(Not take)
					f(1,[3])                      f(1,[])
				  /	        \                    /         \
		f(2,[3,1])            f(2,[3])    f(2,[1])           f(2,[])
		/      \              /     \      /     \            /      \
f(3,[3,1,2])  f(3,[3,1]  f(3,[3,2]  |      |     f(3,[1])  f(3,[3,2]) f(3,[])
								f(3,[3])  f(3,[1,2])
		[3 , 1 , 2]
		[3 , 1]
		[3 , 2]
		[3]
		[1, 2]
		[1]
		[3, 2]
		[2]

	*/
}

package Array.medium_level.Two_Pointer_Approach;

import java.util.Scanner;

public class Three_pointer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" size of Array A");
		int n = sc.nextInt();
		int A[] = new int[n];
		System.out.println("Values should be sorted");
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		System.out.println(" size of Array B");
		int m = sc.nextInt();
		int B[] = new int[m];
		System.out.println("Values should be sorted");
		for (int i = 0; i < m; i++) {
			B[i] = sc.nextInt();
		}

		System.out.println(" size of Array C");
		int o = sc.nextInt();
		int C[] = new int[o];
		System.out.println("Values should be sorted");
		for (int i = 0; i < m; i++) {
			C[i] = sc.nextInt();
		}

		int min = minimize(A , B , C);
		System.out.println(min);
	}
	public static int minimize(final int[] A, final int[] B, final int[] C) {
		int ans = Integer.MAX_VALUE;
		int a = A.length , b = B.length , c = C.length;
		int i = 0 , j = 0 , k = 0;

		while(i<a && j<b && k<c){
			int max = Math.max(A[i] , Math.max(B[j] , C[k]));
			int min = Math.min(A[i] , Math.min(B[j] , C[k]));
			int diff  = Math.abs(max - min);
			ans = Math.min(ans , diff);

			if(min == A[i]) i++;
			else if(min == B[j]) j++;
			else k++;
		}
		return ans;
	}
}
/*
int n = A.length;
        int m = B.length;
        int o = C.length;

        if(n == 1)
            return 0;

        int ans = Integer.MAX_VALUE;

        int i=0, j=0, k=0;
        while(i<n && j<m && k<o)
        {

            int difference = Math.abs(maximum(A[i], B[j], C[k]) - minimum(A[i], B[j], C[k]));

            ans = Math.min(ans, difference);

            int min = minimum(A[i], B[j], C[k]);

            if(min == A[i])
                i++;
            else if(min == B[j])
                j++;
            else
                k++;
        }

        return ans;
    }

    public int minimum(int A, int B, int C)
    {
        return Math.min(Math.min(A,B),C);
    }


    public int maximum(int A, int B, int C)
    {
        return Math.max(Math.max(A,B),C);
    }
}
 */
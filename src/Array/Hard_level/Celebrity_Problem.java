package Array.Hard_level;

import java.util.Scanner;
import java.util.Stack;

public class Celebrity_Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		int celeb = find_celebrity(mat , n);
		System.out.println(celeb);
	}
	public static int find_celebrity(int[][] mat , int n){
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<n; i++){
			st.push(i);
		}
		while ((st.size()>1)){
			int a = st.pop();
			int b = st.pop();
			if(mat[a][b] == 1){
				st.push(b);
			}
			else{
				st.push(a);
			}
		}
		if(st.empty())
			return -1;
		int c = st.pop();

		for(int k =0; k<n; k++){
			if(c!=k && (mat[k][c] == 0 || mat[c][k] == 1))
				return -1;
		}
		return c;
		/*int i=0,j=n-1;
		while(i<j){
			if(mat[i][j]==1) {  //i knows j so i cannot be celebrity
				System.out.println("i "+i);
				i++;

			}
			else {  //i does'nt knows j so j canot be celebrity
				System.out.println("j "+j);
				j--;
			}
		}
		//i can be a potential celebrity
		int candidate=i;
		for(int k=0;k<n;k++){
			if(candidate!=k){
				if(mat[candidate][k]==1||mat[k][candidate]==0)
					return -1;
			}
		}
		return i;*/
	}
}

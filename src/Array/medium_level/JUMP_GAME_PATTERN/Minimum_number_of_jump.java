package Array.medium_level.JUMP_GAME_PATTERN;
import java.util.Scanner;
public class Minimum_number_of_jump{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(minJumps(arr));
	}
	public static int minJumps(int[] arr){
		int n = arr.length;
		//Case 1
		if(n == 1)
			return 0;
		// case 2
		if(arr[0] == 0)
			return -1;

		int maxlength = arr[0];
		int step = arr[0];
		int jump = 1;

		for(int i=1; i<n; i++){
			//case 3
			if(i == n-1)
				return jump;
			maxlength = Math.max(maxlength , i+arr[i]);
			step--;
			if(step == 0){
				jump++;
				if(i >= maxlength)
					return  -1;
				step = maxlength - i;
			}

		}
		return -1;
	}
}

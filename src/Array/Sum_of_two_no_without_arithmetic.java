package Array;
import java.util.Scanner;


public class Sum_of_two_no_without_arithmetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		/*for(int i=0;i<b;i++){
			a++;
		}
		System.out.println(a);*/
		int carry=a&b;
		int sum=a^b;
		while(carry>0){
			int shift=carry<<1;
			carry=sum&shift;
			sum=sum^shift;
		}
		System.out.println(sum);
	}
}

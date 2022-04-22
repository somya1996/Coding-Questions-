package Array;

public class Longest_common_prefix_in_array {
	public static void main(String[] args) {
		//String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"};
		String arr[] = {"hello","world"};

		//working
		int len = arr.length;
		String ans = arr[0];
		for(int i=1; i<len; i++){               // TIME COMPLEXITY O(n)
			 ans = common(ans , arr[i]);
		}
		if(ans == ""){ System.out.println(-1);}

		System.out.println(ans);
	}
	public static String common(String a , String b){
		String res = "";
		int a_len = a.length();
		int b_len = b.length();
		int i = 0 , j = 0;
		while(i<a_len && j<b_len){                      //O(n+m)
			if(a.charAt(i) == b.charAt((j))){
				res += a.charAt(i);
				i++;
				j++;
			}
			else
				break;

		}
		return res;
	}
}

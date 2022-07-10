package Strings.Medium;
import java.util.Scanner;

public class String_Compression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] chars = s.toCharArray();
		String_Compression s_c = new String_Compression();
		int ans = s_c.compress(chars);
		System.out.println(ans);
	}
	public int compress(char[] chars) {
		int index = 0 , compress_len = 0;

		while(index < chars.length){
			char c = chars[index];
			int count = 0;
			while(index < chars.length && chars[index] == c){
				count++;
				index++;
			}
			chars[compress_len++] = c;
			if(count != 1){
				char[] count_array = Integer.toString(count).toCharArray();
				for( char i : count_array){
					chars[compress_len++] = i;
				}
			}
		}
		return compress_len;
	}
}

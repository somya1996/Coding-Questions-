package Strings;

import java.util.*;

public class Uncommon_character {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine().toLowerCase();
		String s2 = sc.nextLine().toLowerCase();
		Uncommon_character uc = new Uncommon_character();
		//String res = uc.UncommonChars(s1,s2);
		//System.out.println(res);
		String ans = UncommonString(s1,s2);
		System.out.println(ans);
	}

	public static String UncommonString(String A, String B) {

		String result = "";

		for(int i=0;i<A.length();i++){
			if (!B.contains(String.valueOf(A.charAt(i))) && (!result.contains(String.valueOf(A.charAt(i))))) {
				result += A.charAt(i);
			}
		}
		System.out.println(result);
		for(int i=0;i<B.length();i++){
			if (!A.contains(String.valueOf(B.charAt(i))) && (!result.contains(String.valueOf(B.charAt(i))))) {
				result += B.charAt(i);
			}
		}
		System.out.println(result);
		String ans = "";

		char[] res = result.toCharArray();
		Arrays.sort(res);
		for(int i=0;i<res.length;i++){
			ans += res[i];
		}
		System.out.println(ans);
		return ans;
	}

	/*public  String UncommonChars(String A, String B)
	{
		String result="";
		ArrayList<Character> arr=new ArrayList<>();
		ArrayList<Character> brr=new ArrayList<>();
		ArrayList<Character> temp=new ArrayList<>();

		for(int i=0;i<A.length();i++){
			if(!arr.contains(A.charAt(i))){
				arr.add(A.charAt(i));
			}
		}
		System.out.println(arr);

		for(int i=0;i<B.length();i++){
			if(!brr.contains(B.charAt(i))){
				brr.add(B.charAt(i));
			}
		}
		System.out.println(brr);

		int size=brr.size();
		for(int i=0;i<size;i++){
			if(arr.contains(brr.get(i))){
				char ch=brr.get(i);
				arr.remove(new Character(ch));
				brr.remove(new Character(ch));
				size--;
				i--;
			}
		}
		System.out.println(" After removing similar elements: ");
		System.out.println(arr);
		System.out.println(brr);

		for(int i=0;i<arr.size();i++){
			temp.add(arr.get(i));
		}

		for(int i=0;i<brr.size();i++){
			temp.add(brr.get(i));
		}

		Collections.sort(temp);

		for(int i=0;i<temp.size();i++){
			result+=temp.get(i);
		}

		if(result.length()==0)return "-1";

	}*/
}

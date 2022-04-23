package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Uncommon_character {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine().toLowerCase();
		String s2 = sc.nextLine().toLowerCase();
		Uncommon_character uc = new Uncommon_character();
		String res = uc.UncommonChars(s1,s2);
		System.out.println(res);
	}
	public  String UncommonChars(String A, String B)
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

		for(int i=0;i<B.length();i++){
			if(!brr.contains(B.charAt(i))){
				brr.add(B.charAt(i));
			}
		}

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

		return result;
	}
}

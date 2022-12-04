package GRAPH;

import java.util.*;

public class word_ladder_I {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<String> wordList = new ArrayList<>();
		for(int i=0; i<n; i++){
			wordList.add(sc.nextLine());
		}
		System.out.println("startword");
		String startword = sc.nextLine();
		System.out.println("endword");
		String endword = sc.nextLine();
		word_ladder_I wl = new word_ladder_I();
		int steps = wl.ladderLength(startword , endword , wordList);
		System.out.println(steps);
	}
	class Pair{
		String  first;
		int second;
		Pair(String f , int s){
			first = f;
			second = s;
		}
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(beginWord , 1));

		HashSet<String > hs = new HashSet<>();
		for(int i=0; i<wordList.size(); i++){
			hs.add(wordList.get(i));
		}
		hs.remove(beginWord);

		while(!q.isEmpty()){
			Pair p = q.poll();
			String word = p.first;
			int steps = p.second;

			if(word.equals(endWord) == true)
				return steps;
			// N * wordlen * 26
			for(int i=0; i<word.length(); i++){
				for(char ch = 'a'; ch <= 'z'; ch++){
					char replacedCharArray[] = word.toCharArray();
					replacedCharArray[i] = ch;
					String new_word = new String(replacedCharArray);
					if(hs.contains(new_word)){
						hs.remove(new_word);
						q.add(new Pair(new_word , steps+1));
					}
				}
			}
		}
		return 0;
	}
}

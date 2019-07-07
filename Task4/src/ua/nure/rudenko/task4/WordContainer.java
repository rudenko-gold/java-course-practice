package ua.nure.rudenko.task4;

import java.util.Arrays;
import java.util.Scanner;

public class WordContainer {
	public static void main(String[] args) {
		int containerSize = 0;
		Word[] wordsMap = new Word[512];
		
		for (int i = 0; i < 512; i++) {
			wordsMap[i] = new Word();
		}
		
		Scanner in = new Scanner(System.in);
		
		String query = "";
		while (!"stop".equals(query)) {
			query = in.nextLine();
			String[] words = query.split("-|\\.|\\n|\\r|,|\\s");
    		
    		for (String word : words) {
    			if ("stop".equals(word)) {
    				query = "stop";
    				break;
    			}
    			
    			Boolean find = false;
    			for (int i = 0; i < containerSize; i++) {
    				if (wordsMap[i].getContent().equals(word)) {
    					find = true;
    					wordsMap[i].increase();
    				}
    			}
    			if (!find) {
    				wordsMap[containerSize] = new Word(word, 1);
    				containerSize++;
    			}
    		} 
		}
		in.close();
		
		Arrays.sort(wordsMap, (o1, o2) -> o1.compareTo(o2));
		
		for (Word w : wordsMap) {
			if (w.getFrequency() > 0) {
				System.out.println(w.getContent() + " : " + w.getFrequency());
			}
		}
	}
}

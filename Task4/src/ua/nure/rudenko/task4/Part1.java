package ua.nure.rudenko.task4;

import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
    		String input = Reader.readFile("part1.txt");

    		StringBuilder latn = new StringBuilder();
    		StringBuilder kyrl = new StringBuilder();
    		
    		String[] words = input.split("-|\\.|\\n|\\r|,|\\s");
    		
    		for (String word : words) {
    			if (word.length() == 0) {
    				continue;
    			} else if (word.charAt(0) <= (int)'z') {
    				latn.append(word + " ");
    			} else {
    				kyrl.append(word + " ");
    			}
    		}
    		
    		Scanner in = new Scanner(System.in);
    		
    		String query = "";
    		while (!"stop".equals(query)) {
    			query = in.nextLine();
    			
    			if ("Latn".equals(query)) {
    				System.out.println("Latn: " + latn.toString());
    			} else if ("Cyrl".equals(query)) {
    				System.out.println("Cyrl: " + kyrl.toString());
    			} else if (!"stop".equals(query)) {
    				System.out.println(query + ": Incorrect input");
    			}
    		}
    		in.close();
	}
}

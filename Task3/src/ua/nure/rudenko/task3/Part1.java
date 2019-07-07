package ua.nure.rudenko.task3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	public static final int LEFT_BOUND = 1000;
	public static final int RIGHT_BOUND = 9000;
	
	public static void main(String[] args) {
		String path = "part1.txt";
		System.out.println(convert1(Reader.readFile(path)));
		System.out.println(convert2(Reader.readFile(path)));
		System.out.println(convert3(Reader.readFile(path)));
		System.out.println(convert4(Reader.readFile(path)));
	}
	public static String convert1(String input) {
		StringBuilder result = new StringBuilder();
		String patternString = "([^;^\\n]*);{1}([^\\s]*\\s{1}[^;]*);{1}([^@^\\s]*@{1}([^\\.]*\\.{1}.*)(^$|^\\s)*)";
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher match = pattern.matcher(input);
		
		while (match.find()) {
			result.append(match.group(1) + ": " + match.group(3) + "\n");
		}
		
		return result.toString().substring(0, result.toString().length() - 1);
	}

	public static String convert2(String input) {
		StringBuilder result = new StringBuilder();
		String patternString = "([^;^\\n]*);{1}(([^\\s]*)\\s{1}([^;]*));{1}([^@^\\s]*@{1}([^\\.]*\\.{1}.*)(^$|^\\s)*)";
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher match = pattern.matcher(input);
		
		while (match.find()) {
			result.append(match.group(4) + " " + match.group(3) + " (email: " + match.group(5) + ")" + "\n");
		}
		
		return result.toString().substring(0, result.toString().length() - 1);
	}

	public static String convert3(String input) {
		StringBuilder result = new StringBuilder();
		String patternString = "([^;^\\n]*);{1}([^\\s]*\\s{1}[^;]*);{1}([^@^\\s]*@{1}([^\\.]*\\.{1}.*)(^$|^\\s)*)";
		Pattern pattern = Pattern.compile(patternString);
		Matcher match = pattern.matcher(input);
		while (match.find()) {
			StringBuilder sb = new StringBuilder();
			if (result.toString().indexOf(match.group(4)) != -1) {
				continue;
			}
			sb.append(match.group(4) + " ==>");
			Matcher mat1 = pattern.matcher(input);
			while (mat1.find()) {
				if (match.group(4).equals(mat1.group(4))) {
					sb.append(" " + mat1.group(1) + ",");
				}
			}
			result.append(sb.toString().substring(0, sb.toString().length() - 1) + "\n");

		}

		return result.toString().substring(0, result.toString().length() - 1);
	}

	public static String convert4(String input) {
		StringBuilder result = new StringBuilder();
		String matchingStr = "";
		
		String patternStringEmail = ".*Email";
		Pattern patternEmail = Pattern.compile(patternStringEmail);
		
		String patternStringWord = ".*[^\\s]";
		
		Pattern patternWord = Pattern.compile(patternStringWord);
		Matcher matchWord = patternWord.matcher(input);
		
		while (matchWord.find()) {
			matchingStr = input.substring(matchWord.start(), matchWord.end());
			
			Matcher matchEmail = patternEmail.matcher(matchingStr);
			
			if (matchEmail.find()) {
				result.append(matchingStr + ";Password" + "\n");
			} else {
				SecureRandom rand = new SecureRandom();
				int random = LEFT_BOUND + rand.nextInt(RIGHT_BOUND);
				result.append(matchingStr + ";" + random + "\n");
			}
		
		}
		
		return result.toString();
	}

}

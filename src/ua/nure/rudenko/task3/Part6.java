package ua.nure.rudenko.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
	public static void main(String[] args) {
		System.out.print(convert(Reader.readFile("part6.txt")));
	}

	public static String convert(String input) {
		String result = input;
		
		String patternString = "(\\b[a-zA-Z¿¯¸¨À-ßà-ÿ]+\\b)";
		Pattern pattern = Pattern.compile(patternString);
		Matcher match = pattern.matcher(input);
		
		while (match.find()) {
			int count = 0;
			
			String string = "(\\b" + match.group() + "\\b)";
			Pattern patternGroup = Pattern.compile(string);
			Matcher finder = patternGroup.matcher(input);
			
			while (finder.find()) {
				count++;
			}
			
			if (count > 1) {
				result = result.replaceAll("\\b" + match.group() + "\\b", "_" + match.group());
			}

		}
		return result;
	}

}

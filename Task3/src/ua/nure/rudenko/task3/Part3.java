package ua.nure.rudenko.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	public static void main(String[] args) {
		System.out.println(convert(Reader.readFile("part3.txt")));
	}

	public static String convert(String input) {
		String temp = input;
		String patternString = "[a-zA-Z¸¨¿¯à-ÿÀ-ß]*";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			String str = input.substring(matcher.start(), matcher.end());
			if (str.length() > 2 && Character.isLowerCase(str.charAt(0))) {
				temp = temp.substring(0, matcher.start()) + Character.toUpperCase(str.charAt(0))
						+ temp.substring(matcher.start() + 1, temp.length());
			} else if (str.length() > 2 && Character.isUpperCase(str.charAt(0))) {
				temp = temp.substring(0, matcher.start()) + Character.toLowerCase(str.charAt(0))
						+ temp.substring(matcher.start() + 1, temp.length());
			}
		}
		return temp;
	}

}

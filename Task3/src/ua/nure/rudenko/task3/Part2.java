package ua.nure.rudenko.task3;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
	public static void main(String[] args) {
		File file = new File("part2.txt");
		System.out.print(convert(Reader.readFile(file.getAbsolutePath())));
	}
	
	public static String convert(String input) {
		StringBuilder resultMin = new StringBuilder();
		StringBuilder resultMax = new StringBuilder();
		
		resultMin.append("Min:");
		resultMax.append("Max:");
		
		String patternString = "\\b[a-zA-Z¸¨¿¯à-ÿÀ-ß]+\\b";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(input);
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		while (matcher.find()) {
			if (matcher.group().length() < min) {
				min = matcher.group().length();
				resultMin = new StringBuilder();
				resultMin.append("Min:");
				resultMin.append(" " + matcher.group() + ",");
			} else if (matcher.group().length() == min && resultMin.toString().indexOf(matcher.group()) == -1) {
				resultMin.append(" " + matcher.group() + ",");
			}
			
			if (matcher.group().length() > max) {
				max = matcher.group().length();
				resultMax = new StringBuilder();
				resultMax.append("Max:");
				resultMax.append(" " + matcher.group() + ",");
			} else if (matcher.group().length() == max && resultMax.toString().indexOf(matcher.group()) == -1) {
				resultMax.append(" " + matcher.group() + ",");
			}
		}
		return (resultMin.toString().substring(0, resultMin.toString().length() - 1) + "\n"
				+ resultMax.toString().substring(0, resultMax.toString().length() - 1));
	}
}

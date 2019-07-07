package ua.nure.rudenko.task1;

public class Part1 {
	public static void main(String[] args) {
		int argumentsSum = 0;
		for (int i = 0; i < args.length; ++i) {
			argumentsSum += Integer.parseInt(args[i]);
		}
		System.out.print(argumentsSum);
	}
}
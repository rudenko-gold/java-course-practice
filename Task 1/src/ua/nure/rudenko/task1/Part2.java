package ua.nure.rudenko.task1;

public class Part2 {
	public static void main(String[] args) {	
		for (int i = args.length - 1; i > 0; --i) {
			System.out.print(args[i] + " ");
		}
		if (args.length > 0) {
			System.out.print(args[0]);
		}
	}
}

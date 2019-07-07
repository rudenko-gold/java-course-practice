package ua.nure.rudenko.task1;

public class Part4 {
	public static void main(String[] args) {
		int digitCounter = 0;
		
		for (int i = 0; i < args.length; ++i) {
			for (int j = 0; j < args[i].length(); ++j) {
				if (args[i].charAt(j) >= '0' && args[i].charAt(j) <= '9') {
					digitCounter += (args[i].charAt(j) - '0');
				}
			}
		}
		System.out.print(digitCounter);
	}
}

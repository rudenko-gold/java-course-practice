package ua.nure.rudenko.task1;

public class Part3 {
	public static int gcd (int a, int b) {
		while (b > 0) {
			a %= b;
			
			a ^= b;
		    b ^= a;
		    a ^= b;
		}
		return a;
	}
	
	public static int max (int a, int b) {
		if(a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static int min (int a, int b) {
		if(a > b) {
			return b;
		} else {
			return a;
		}
	}
	
	public static int lcm (int a, int b) {
		return (max(a, b) / gcd(a, b)) * min(a, b);
	}
	
	public static void main(String[] args) {
		int firstArg = 1;
		int secondArg = 1;
		if (args.length > 0) {
			firstArg = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			secondArg = Integer.parseInt(args[1]);
		}
		int g = gcd(firstArg, secondArg);
		int l = lcm(firstArg, secondArg);
		System.out.print(g + " " + l);
	}
}

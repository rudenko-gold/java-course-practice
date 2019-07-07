package ua.nure.rudenko.task1;

public class Part5 {
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		
		for (int i = 2; i <= Math.sqrt(n); ++i) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] getPrimeNumbers(int n) {
		int primeCounter = 0;
		int[] result = new int[n];
		
		for (int i = 2; primeCounter < n; ++i) {
			if(isPrime(i)) {
				result[primeCounter] = i;
				primeCounter++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int n = 1;
		
		if (args.length != 0) {
			n = Integer.parseInt(args[0]);
		}
		int[] primeNumbers = getPrimeNumbers(n);
		for (int i = 0; i < n - 1; ++i) {
			System.out.print(primeNumbers[i] + " ");
		}
		if (n > 0) {
			System.out.print(primeNumbers[n - 1]);
		}
	}
}

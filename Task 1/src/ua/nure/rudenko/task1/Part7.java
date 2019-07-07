package ua.nure.rudenko.task1;

public class Part7 {
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		
		for (int i = 2; i <= Math.sqrt(n); ++i) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int digitSum(int n) {
		int result = 0;
		while(n > 0) {
			result += (n % 10);
			n /= 10;
		}
		return result;
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
		int maximalDigitSum = digitSum(primeNumbers[0]);
		int maximalCounter = 1;
		for (int i = 1; i < primeNumbers.length; ++i) {
			if(digitSum(primeNumbers[i]) > maximalDigitSum) {
				maximalDigitSum = digitSum(primeNumbers[i]);
				maximalCounter = 1;
				
			} else if(digitSum(primeNumbers[i]) == maximalDigitSum) {
				maximalCounter++;
			}
		}
		System.out.print(maximalDigitSum + " " + maximalCounter);
	}
}

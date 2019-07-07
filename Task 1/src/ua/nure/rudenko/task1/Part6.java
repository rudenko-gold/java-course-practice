package ua.nure.rudenko.task1;

public class Part6 {
	private static int primeSize = 1_000_000;
	private static int maxPrime = 1_000_001;
	protected static boolean[] isPrime = new boolean[primeSize];
	public static void fillPrimes() {
		for (int i = 0; i < isPrime.length; ++i) {
			isPrime[i] = true;
		}
		
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i < isPrime.length; ++i) {
			if(isPrime[i] && i * i < isPrime.length && i * i > 0) {
				for (int j = i * i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
	public static int nextPrime(int x) {
		for (int i = x + 1; i < isPrime.length; i++) {
			if(isPrime[i]) {
				return i;
			}
		}
		return maxPrime;
	}
	
	public static void main(String[] args) {
		int n = 0;
		
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}		
		if (n == 1) {
			System.out.print("1^1");
		}
		fillPrimes();
		int currentPrime = 2;
		System.out.print(n + " = ");
		while(n > 1) {
			int divisorCounter = 0;
			while(n % currentPrime == 0 && n > 1) {
				n /= currentPrime;
				divisorCounter++;
			}
			if(divisorCounter > 0) {
				System.out.print(currentPrime + "^" + divisorCounter);
				if(n > 1 && currentPrime <= Math.sqrt(n)) {
					System.out.print(" x ");
				} else {
					break;
				}
			}
			currentPrime = nextPrime(currentPrime);
		}
		if (n > 1) {
			System.out.print(" x " + n + "^1");
		}
	}
}

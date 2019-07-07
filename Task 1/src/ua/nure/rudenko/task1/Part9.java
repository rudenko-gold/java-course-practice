package ua.nure.rudenko.task1;

public class Part9 {
	public static class Primes {
		private static boolean[] isPrime = new boolean[1];
		
		public Primes(int n) {
			fillPrimes(n);
		}
		
		public void printPrimeNumbers() {
			int lastPrime = 2;
			for (int i = lastPrime + 1; i < isPrime.length; ++i) {
				if(isPrime[i]) {
					System.out.print(lastPrime + " ");
					lastPrime = i;
				}
			}
			System.out.print(lastPrime);
		}
		
		private static void fillPrimes(int n) {
			isPrime = new boolean[n + 1];
			
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
	}
	
	public static void main(String[] args) {
		int n = 1;
		if(args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		Primes p = new Primes(n);
		p.printPrimeNumbers();
	}
}

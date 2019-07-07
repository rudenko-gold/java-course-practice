package ua.nure.rudenko.task1;

public class Part8 {
	public static int[][] pascal(int n) {
		int[][] result = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			result[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				if(j == 0 || j == i) {
					result[i][j] = 1;
				} else if(i != 0) {
					result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int n = 1;
		
		if (args.length != 0) {
			n = Integer.parseInt(args[0]);
		}
		
		int[][] pascalTriangle = pascal(n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; ++j) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; ++j) {
				System.out.print(pascalTriangle[i][j]);
				if(j != i) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
}

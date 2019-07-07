package ua.nure.rudenko.task3;

public class Part5 {

	public static final String ROMAN = "IVXLC";
	protected static final int[] DECIMAL = new int[] { 1, 5, 10, 50, 100 };
	protected static final int[] exeptionsDEC = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
	public static final int MAX_VALUE = 101;

	public static void main(String[] args) {
		for (int i = 1; i < MAX_VALUE; i++) {
			System.out.print(i + " --> " + decimal2Roman(i) + " --> " + roman2Decimal(decimal2Roman(i)) + "\n");
		}
	}
	
	public static String decimal2Roman(int input) {
		String[] exeptionsROM = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		StringBuilder s = new StringBuilder();
		
		for (int i =  exeptionsROM.length - 1; i >= 0; i--) {
			while (input >= exeptionsDEC[i]) {
				s.append(exeptionsROM[i]);
				input -= exeptionsDEC[i];
			}
		}
		return s.toString();
	}

	public static int roman2Decimal(String input) {
		int res = 0;
		int i = 0;
		while (i < input.length()) {
			int j = ROMAN.indexOf(input.charAt(i));
			int temp = DECIMAL[j];
			if (i != input.length() - 1 && temp < DECIMAL[ROMAN.indexOf(input.charAt(i + 1))]) {
				res += DECIMAL[ROMAN.indexOf(input.charAt(i + 1))] - temp;
				i += 2;
			} else {
				res += DECIMAL[ROMAN.indexOf(input.charAt(i))];
				i++;
			}
		}
		return res;
	}
}
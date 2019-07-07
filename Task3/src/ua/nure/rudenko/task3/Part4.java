package ua.nure.rudenko.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Part4 {
	public static final int SIXTEEN = 16;
	public static final int TEN = 10;
	public static final int NINE = 9;

	public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest dig = MessageDigest.getInstance(algorithm);
		StringBuilder strin = new StringBuilder();
		
		dig.update(input.getBytes());
		byte[] hash = dig.digest();
		
		for (int mByt : hash) {
			int bytVal = mByt & 0xFF;
			
			int f = bytVal / SIXTEEN;
			int s = bytVal % SIXTEEN;

			char fC;
			char sC;
			
			if (f > NINE) {
				fC = (char) ('A' + f - TEN);
			} else {
				fC = (char) ('0' + f);
			}
			
			if (s > NINE) {
				sC = (char) ('A' + s - TEN);
			} else {
				sC = (char) ('0' + s);
			}

			String result = "" + fC + sC;
			strin.append(result);
		}

		return strin.toString().toUpperCase(Locale.UK);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(hash("asdf", "MD5"));
		System.out.println(hash("asdf", "SHA-256"));
	}
}
package ua.nure.rudenko.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Reader {
	private static final String ENCODING = "Cp1251";
	
	private Reader() {
		  throw new IllegalStateException("Utility class");
	}
	
	public static String readFile(String path) {
		String result = null;
		
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(path));
			result = new String(bytes, ENCODING);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
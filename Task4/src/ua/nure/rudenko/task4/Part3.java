package ua.nure.rudenko.task4;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String query = "";
		
		while (!"stop".equals(query)) {
			query = in.nextLine();
			String command = query.split("\\s")[0];
			if (!"stop".equals(command)) {
				if (query.split("\\s|\\n").length < 2) {
					System.out.println("Incorrect input");
					continue;
				}
				String loc = query.split("\\s|\\n")[1];
				Locale l = new Locale(loc);
				try {
					ResourceBundle rb = ResourceBundle.getBundle("resources", l);
					if (rb.containsKey(command)) {
						System.out.println(rb.getString(command));
					} else {
						System.out.println("Incorrect input");
					}
				} catch(MissingResourceException ex) {
					System.out.println("Incorrect input");
				}
			}
		}
		in.close();
	}
}

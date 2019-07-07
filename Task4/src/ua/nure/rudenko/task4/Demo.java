package ua.nure.rudenko.task4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
    private static final InputStream STD_IN = System.in;

    // place your default encoding here
	private static final String ENCODING = "Cp1251";
	
	public static void main(String[] args) throws IOException {
        System.out.println("=================== PART1 ===================");
        System.setIn(new ByteArrayInputStream(
                "asdf^Latn^Cyrl^stop^"
					.replace("^", System.lineSeparator()).getBytes(ENCODING)));
        Part1.main(args);
        System.setIn(STD_IN);
        
        System.out.println("=================== PART2 ===================");
        Part2.main(args);
        
        System.out.println("=================== PART3 ===================");
        System.setIn(new ByteArrayInputStream(
                "table en^table ru^apple en^asfd asdf^apple ru^stop^"
					.replace("^", System.lineSeparator()).getBytes(ENCODING)));
        Part3.main(args);
        System.setIn(STD_IN);
        
        System.out.println("=================== PART4 ===================");
        Part4.main(args);
        System.out.println("=================== PART5 ===================");
        Part5.main(args);
	}
}

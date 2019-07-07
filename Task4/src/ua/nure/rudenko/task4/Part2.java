package ua.nure.rudenko.task4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Part2 {

    private static final InputStream STD_IN = System.in;

	private static final String ENCODING = "Cp1251";

    public static void main(String[] args) throws IOException { 
        System.setIn(new ByteArrayInputStream(
                "asd asdf asd asdf^asdf 43 asdsf 43 43 434^stop^"
					.replace("^", System.lineSeparator()).getBytes(ENCODING)));
        
		WordContainer.main(new String[0]);
		
        // restore the standard input
        System.setIn(STD_IN);
    }
}
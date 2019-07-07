package ua.nure.rudenko.task4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class Part4 {
	public static void main(String[] args) throws IOException {
		File file = new File("part4.txt");
		
		file.createNewFile();
		
		try(FileWriter writer = new FileWriter(file, false)) {
			for (int i = 0; i < 10; i++) {
				SecureRandom random = new SecureRandom();
				int num = random.nextInt(50);
				writer.write(num + " ");
			}

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
		
		StringBuilder sb = new StringBuilder();
		
        try(FileReader reader = new FileReader(file)) {
            int c;
            while((c=reader.read())!=-1){
            	sb.append((char)c);
            } 
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }   
        
        String[] input = sb.toString().split("\\s");
        int[] numbers = new int[10];
        
        System.out.print("input  ==> ");
        
        for (int i = 0; i < 10; i++) {
        	numbers[i] = Integer.parseInt(input[i]);
        	System.out.print(numbers[i] + " ");
        }
        System.out.print("\n");
        
        for (int k = 0; k < 10; k++) {
        	for (int i = 1; i < 10; i++) {
        		if (numbers[i] < numbers[i - 1]) {
        			int t = numbers[i];
        			numbers[i] = numbers[i - 1];
        			numbers[i - 1] = t;
        		}
        	}
        }
        
		file = new File("part4_sorted.txt");
		
		file.createNewFile();
		
		System.out.print("output ==> ");
		try(FileWriter writer = new FileWriter(file, false)) {
			writer.write(numbers[0] + " ");
			System.out.print(numbers[0] + " ");
			for (int i = 1; i < 10; i++) {
				if (numbers[i] != numbers[i - 1]) {
					writer.write(numbers[i] + " ");
					System.out.print(numbers[i] + " ");
				}
			}
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
		System.out.print("\n");
	}
}

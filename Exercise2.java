package lab04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Exercise2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Enter number of file you want to create: ");
		int n = scanner.nextInt();
		
		Path folder = Paths.get("EX2_LuckyNumber");
		try {
            Files.createDirectories(folder);
        } catch (IOException e) {
            System.out.println("Failed to create folder: " + e.getMessage());
            return;
        }

		
		int numbersPerFile = 20; // change if needed
        for (int i = 1; i <= n; i++) {
            Path file = folder.resolve("file" + i + ".csv");
            try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
                writer.write("LuckyNumber");
                writer.newLine();
                for (int j = 0; j < numbersPerFile; j++) {
                    int number = rand.nextInt(100) + 1; // 1..100
                    writer.write(Integer.toString(number));
                    writer.newLine();
                }
                System.out.println("Created: " + file.toString());
            } catch (IOException e) {
                System.out.println("Error writing " + file + ": " + e.getMessage());
            }
        }

		
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Path file = folder.resolve("file" + i + ".csv");
            try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                String line;
                boolean skipHeader = true;
                while ((line = reader.readLine()) != null) {
                    if (skipHeader) {
                        skipHeader = false; // skip "LuckyNumber" header
                        continue;
                    }
                    line = line.trim();
                    if (!line.isEmpty()) {
                        numbers.add(Integer.parseInt(line));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading " + file + ": " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number in " + file + ": " + e.getMessage());
            }
        }

		
		if (numbers.isEmpty()) {
            System.out.println("No numbers found.");
        } else {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);
            System.out.println("Total numbers collected: " + numbers.size());
            System.out.println("Maximum number: " + max);
            System.out.println("Minimum number: " + min);
        }
		
		scanner.close();
	}	
}



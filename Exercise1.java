package lab04;

import java.io.*;
import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        String fileName = "LuckyNumber.csv";
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("LuckyNumber"); 
            for (int i = 0; i < 500; i++) {
                int number = rand.nextInt(1000) + 1;
                writer.println(number);
            }
            System.out.println("500 random numbers saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        
        System.out.println("\nReading numbers from " + fileName + ":\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean skipHeader = true;
            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

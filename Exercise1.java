  package lab04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Exercise1 {
    public static void main(String[] args) {
        String fileName = "LuckyNumber.csv";
        Random rand = new Random();
        
        int randomNumber = rand.nextInt() + 1;

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Lucky Number: ");
            System.out.println("Random Lucky number saved to file: " + randomNumber);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}


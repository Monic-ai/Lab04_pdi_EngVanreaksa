package lab04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Exercise3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String fileName = "Ex3StudentData.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Name,ID,Gender");

            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter details for student " + i + ":");

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("ID: ");
                String id = scanner.nextLine();

                System.out.print("Gender: ");
                String gender = scanner.nextLine();

                writer.println(name + "," + "p" + id + "," + gender);
            }

            System.out.println("\nData successfully written to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        scanner.close();	
	}
}

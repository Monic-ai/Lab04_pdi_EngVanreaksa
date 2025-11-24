package lab04;

import java.io.*;
import java.util.*;

public class Exercise5 {

    static class Student {
        String name;
        String id;
        String gender;

        Student(String name, String id, String gender) {
            this.name = name;
            this.id = id;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return name + "," + id + "," + gender;
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\Desktop\\Javaproject\\src\\Lab04\\EX3StudentData.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean skipHeader = true;
            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        students.add(new Student("Reaksa", "p20240006", "M"));
        students.add(new Student("Sovannroth", "p20240020", "M"));
        students.add(new Student("Monouk", "p20240062", "M"));

        students.sort(Comparator.comparing(s -> s.name));

        String outputFile = "D:\\Desktop\\Javaproject\\src\\Lab04\\StudentData.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("Name,ID,Gender"); 
            for (Student s : students) {
                writer.println(s);
            }
            System.out.println("Data successfully saved in " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        System.out.println("\nFinal Student List (sorted A-Z):");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", ID: " + s.id + ", Gender: " + s.gender);
        }
    }
}
package lab04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise04 {
	
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
            return "Name: " + name + ", ID: " + id + ", Gender: " + gender;
        }
    }
		
	public static void main(String[] args) throws IOException{
		
		File file = new File("D:\\Desktop\\Javaproject\\src\\Lab04\\Ex3StudentData.csv");
		
		ArrayList<Student> students = new ArrayList<>();

		try (Scanner scan = new Scanner(file)) {
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0];
                    String id = parts[1];
                    String gender = parts[2];

                    students.add(new Student(name, id, gender));
                }
            }
        }
		
		System.out.println("Student Data from CSV:");
        for (Student s : students) {
            System.out.println(s);
        }
	}
}

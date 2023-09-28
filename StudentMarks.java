
/**
 * Write a description of class StudentMarks here.
 *
 * @author (Rajwant Kaur)
 * @version (24-09-23)
 */

import java.io.*;
import java.util.*;

public class StudentMarks
{
   public static void main(String[] args) throws IOException {
        class Student {
            String name;
            String id;
            int[] marks = new int[3];
            int totalMark;

            public Student(String name, String id, int[] marks) {
                this.name = name;
                this.id = id;
                this.marks = marks;
                this.totalMark = marks[0] + marks[1] + marks[2]; // Calculating total mark for each student (F2)
            }
        }

        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // F1: Read the unit name and students' marks from a given text file.
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("#")) { // Ignoring lines that are comments
                String[] parts = line.split(" ");
                String name = parts[0];
                String id = parts[1];
                int[] marks = new int[]{Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])};
                students.add(new Student(name, id, marks));
            }
        }
        br.close();
        
        while (true) {
            // F5: Menu System
            System.out.println("Select an option:");
            System.out.println("1. Print students total marks:");
            System.out.println("2. Print students below a certain threshold");
            System.out.println("3. Print top 5 students");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            if (choice == 1) {
                // F2: Calculate and Print the total mark for each student.
                for (Student student : students) {
                    System.out.println("Name: " + student.name + ", ID: " + student.id + ", Total Marks: " + student.totalMark);
                }
        }
        else if (choice ==2){
            // F3: Print the list of students with total marks less than a certain threshold.
                System.out.print("Enter the threshold: ");
                int threshold = scanner.nextInt();
                for (Student student : students) {
                    if (student.totalMark < threshold) {
                        System.out.println(student.name + " " + student.id + " " + student.totalMark);
                    }
                }
        }
        else if (choice ==3){
            
        }
        else if (choice ==4){
            System.exit(0);
        }
        else{
             System.out.println("Invalid choice. Please try again.");
        }
    }
}
        
        
}


/**
 * Write a description of class StudentMarks here.
 *
 * @author (Rajwant Kaur)
 * @version (24-09-23)
 */

import java.io.*;
import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        class Student {
            String lastName;
            String firstName;
            String id;
            int[] marks = new int[3];
            int totalMark;

            public Student(String lastName, String firstName, String id, int[] marks) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.id = id;
                this.marks = marks;
                this.totalMark = marks[0] + marks[1] + marks[2];
            }
        }

        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the Student marks filename with file extension");

            try {
                String fileName = scanner.nextLine();
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                br.readLine();  // Skip the header line
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");  // Splitting by comma for CSV
                    String lastName = parts[0];
                    String firstName = parts[1];
                    String id = parts[2];
                    int[] marks = new int[]{
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5])};
                    students.add(new Student(lastName, firstName, id, marks));
                }
                System.out.println("File read successfully");
                br.close();
                break;
            } catch (IOException e) {
                System.out.println("Invalid Filename. Please enter again");
            }
        }

        while (true) {
            System.out.println();
            System.out.println("******************************************");
            System.out.println("Welcome to Student Marks Calculation Program");
            System.out.println("******************************************");
            System.out.println("Select an option:");
            System.out.println("1. Print students total marks:");
            System.out.println("2. Print students below a certain threshold");
            System.out.println("3. Print top 5 students");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            if (choice == 1) {
                for (Student student : students) {
                    System.out.println("Last Name: " + student.lastName + ", First Name: " + student.firstName + ", ID: " + student.id + ", Total Marks: " + student.totalMark);
                }
            } else if (choice == 2) {
                System.out.print("Enter the threshold: ");
                int threshold = scanner.nextInt();
                for (Student student : students) {
                    if (student.totalMark < threshold) {
                        System.out.println(student.lastName + " " + student.firstName + " " + student.id + " " + student.totalMark);
                    }
                }
            } else if (choice == 3) {
                List<Student> highestStudents = new ArrayList<>();
                List<Student> lowestStudents = new ArrayList<>();
                
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    if (highestStudents.size() < 5) {
                        highestStudents.add(student);
                        lowestStudents.add(student);
                        continue;
                    }

                    // Compute top 5 students with highest marks
                    Student minHighestStudent = Collections.min(highestStudents, Comparator.comparingInt(s -> s.totalMark));
                    if (student.totalMark > minHighestStudent.totalMark) {
                        highestStudents.remove(minHighestStudent);
                        highestStudents.add(student);
                    }

                    // Compute top 5 students with lowest marks
                    Student maxLowestStudent = Collections.max(lowestStudents, Comparator.comparingInt(s -> s.totalMark));
                    if (student.totalMark < maxLowestStudent.totalMark) {
                        lowestStudents.remove(maxLowestStudent);
                        lowestStudents.add(student);
                    }
                }

                // Printing the top 5 highest students
                System.out.println("Top 5 students with the highest total marks:");
                for (Student s : highestStudents) {
                    System.out.println("Last Name: " + s.lastName + ", First Name: " + s.firstName + ", ID: " + s.id + ", Total Marks: " + s.totalMark);
                }

                // Printing the top 5 lowest students
                System.out.println("\nTop 5 students with the lowest total marks:");
                for (Student s : lowestStudents) {
                    System.out.println("Last Name: " + s.lastName + ", First Name: " + s.firstName + ", ID: " + s.id + ", Total Marks: " + s.totalMark);
                }
            } else if (choice == 4) {
                System.out.println("Student Marks Statistics Program Exiting");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

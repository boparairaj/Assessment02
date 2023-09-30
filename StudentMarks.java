
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
        while (true) {
            System.out.println("Enter the Student marks filename");
            
          
            try {
                // F1: Read the unit name and students' marks from a given text file.
                
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
                System.out.println("File read successfully");
                br.close();
                break;
            } catch (IOException e) {
                
                System.out.println("Please enter existing filename");
            }
        
        }
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
            // F4: prints the top 5 students with the highest total marks and the top 5 students with the lowest total marks.
            List<Student> highestStudents = new ArrayList<>();
            List<Student> lowestStudents = new ArrayList<>();
            
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (i < 5) {
                    highestStudents.add(student);
                    lowestStudents.add(student);
                    continue;
                }
                Student minHighestStudent = Collections.min(highestStudents, Comparator.comparingInt(s -> s.totalMark));
                if (student.totalMark > minHighestStudent.totalMark) {
                    highestStudents.remove(minHighestStudent);
                    highestStudents.add(student);
                }
            
                Student maxLowestStudent = Collections.max(lowestStudents, Comparator.comparingInt(s -> s.totalMark));
                if (student.totalMark < maxLowestStudent.totalMark) {
                    lowestStudents.remove(maxLowestStudent);
                    lowestStudents.add(student);
                }
            }
            
            // Printing the top 5 highest and lowest students
            System.out.println("Top 5 students with the highest total marks:");
            for (Student s : highestStudents) {
                System.out.println(s.name + " " + s.id + " " + s.totalMark);
            }
            
            System.out.println("Top 5 students with the lowest total marks:");
            for (Student s : lowestStudents) {
                System.out.println(s.name + " " + s.id + " " + s.totalMark);
            }
           
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

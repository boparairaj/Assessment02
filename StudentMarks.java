
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
    }
        
        
}

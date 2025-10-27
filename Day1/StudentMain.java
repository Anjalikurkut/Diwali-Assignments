import java.io.*;
import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Create 10 student objects
        students.add(new Student(1, "Aarav", "CSE", 85, 92));
        students.add(new Student(2, "Riya", "ECE", 58, 80));
        students.add(new Student(3, "Kabir", "IT", 95, 88));
        students.add(new Student(4, "Neha", "CSE", 60, 65));
        students.add(new Student(5, "Kiran", "ME", 78, 70));
        students.add(new Student(6, "Rahul", "CSE", 50, 50));
        students.add(new Student(7, "Meena", "IT", 88, 96));
        students.add(new Student(8, "Vikas", "ECE", 82, 91));
        students.add(new Student(9, "Sneha", "CSE", 92, 89));
        students.add(new Student(10, "Rohan", "ME", 69, 72));

        // Serialize students to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            for (Student s : students) {
                oos.writeObject(s);
            }
            System.out.println("10 student objects serialized to students.dat file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by decreasing attendance
        Collections.sort(students);
        System.out.println("\nStudents in decreasing order of attendance:");
        for (Student s : students) {
            System.out.println(s);
            try {
                System.out.println("Grade: " + s.calculateGrade());
            } catch (LowAttendanceException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
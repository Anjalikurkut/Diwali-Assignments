package com.demo.assessment;

import com.demo.assessment.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.demo.assessment.LowAttendanceException;

public class Main{
	public static void main(String[] args) throws LowAttendanceException  {
		
		List<Student>students = new ArrayList<>(); 
		
		students.add(new Student(1, "Anjali", "Java", 85, 78));
        students.add(new Student(2, "Ravi", "Python", 55, 68));
        students.add(new Student(3, "Neha", "Java", 90, 92));
        students.add(new Student(4, "Amit", "C++", 20, 10));
        students.add(new Student(5, "Priya", "Java", 75, 88));
        students.add(new Student(6, "Rohan", "C#", 65, 80));
        students.add(new Student(7, "Meena", "AI", 95, 91));
        students.add(new Student(8, "Vikas", "ML", 59, 85));
        students.add(new Student(9, "Sahil", "C++", 82, 77));
        students.add(new Student(10, "Sneha", "Python", 70, 84));
        
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            System.out.println("10 Students serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<Student> deserializedStudents = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"))) {
            deserializedStudents = (List<Student>) ois.readObject();
            System.out.println("\n Students deserialized successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Collections.sort(deserializedStudents);

        System.out.println("\n Students sorted in decreasing order of attendance:");
        for (Student s : deserializedStudents) {
            System.out.println(s);
        }

     
        System.out.println("\n⚠️ Attendance check:");
        for (Student s : deserializedStudents) {
            try {
                s.calculateGrade(s.getAttendancePercentage());
            } catch (LowAttendanceException e) {
                System.out.println(e.getMessage());
            }
        }
        
		
	}
}

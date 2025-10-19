package com.demo.assessment;
import com.demo.assessment.LowAttendanceException;
import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>  {
	
    private static final long serialVersionUID = 1L;
	private int rollno;
	private String sname;
	private String course;
	private double attendance_percentage;
	private double score;
	
	public Student() {
		super();
	}

	public Student(int rollno, String sname, String course, double attendance_percentage, double score) {
		super();
		this.rollno = rollno;
		this.setSname(sname);
		this.course = course;
		this.attendance_percentage = attendance_percentage;
		this.score = score;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public void calculateGrade(double attendance_percentage) throws LowAttendanceException {
		
			if(attendance_percentage < 60) {
				throw new LowAttendanceException(getSname() +" has less attendance");
			}else {
				System.out.println(getSname() + " has sufficient attendance.");
			}
		
	}

	@Override
	public int compareTo(Student o) {
		
		return Double.compare(o.attendance_percentage, this.attendance_percentage);
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course + ", attendance_percentage="
				+ attendance_percentage + ", score=" + score + "]";
	}

	public double getAttendancePercentage() {
		// TODO Auto-generated method stub
		return attendance_percentage;
	}

	
	
}

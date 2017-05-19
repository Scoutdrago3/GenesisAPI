package com.kharboutli.genesisAPI;

/*
 * A class used to contain any grade book information. It is composed
 * of an array and various methods get and set various pieces of grade 
 * information. It is also composed of a nested private class that
 * represents a single course in the grade book.
 */

public class Gradebook {
	/*
	 * A course object which contains information and methods to
	 * pertaining to the information of a single course in the
	 * grade book.
	 */
	private class Course
	{
		private String courseName;
		private String teacherLastName;
		private double grade;
		
		public Course()
		{
			//TODO
		}
		
		public String getCourseName()
		{
			return courseName;
		}
		
		public String getTeacher()
		{
			return teacherLastName;
		}
		
		public double getGrade()
		{
			return grade;
		}
		
		public String toString()
		{
			return "Name: " + courseName + ", Taught By: " + teacherLastName + ", Current Course Grade: " + grade;
		}
	}
	
	private Course[] courses = new Course[9];
	
	public Gradebook() 
	{
		//TODO
	}
}

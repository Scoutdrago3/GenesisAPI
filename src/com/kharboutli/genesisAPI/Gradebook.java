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
	
	private Course[] myCourses = new Course[0];
	
	public Gradebook() 
	{
		//TODO
	}
	
	public Course[] getCourses()
	{
		return myCourses;
	}
	
	public int getAverage100Grade()
	{
		double sum = 0;
		for(int c = 0; c < myCourses.length; c++)
		{
			sum += myCourses[c].getGrade();
		}
		return (int) Math.round(sum / myCourses.length);
	}
	
	public double getAverage4Grade()
	{
		
	}
	
	public Course getCourse()
	{
		
	}
	
	public String toString()
	{
		String result = "";
		for(int c = 0; c < myCourses.length; c++)
		{
			result += myCourses[c].toString();
		}
		return result;
	}
	
	
}

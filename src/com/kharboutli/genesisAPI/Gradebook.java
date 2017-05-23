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
		double sum = 0;
		for(int c = 0; c < myCourses.length; c++)
		{
			double grade = myCourses[c].getGrade();
			if(grade >= 90) sum += 4.0;
			else if(grade >= 86) sum += 3.5;
			else if(grade >= 80) sum += 3;
			else if(grade >= 76) sum += 2.5;
			else if(grade >= 70) sum += 2;
			else if(grade >= 65) sum += 1.5;
			else if(grade >= 60) sum += 1;
			else if(grade >= 56) sum += .5;
			else sum += 0;
			
		}
		return sum / myCourses.length;
	}
	
	public Course getCourse(String key)
	{
		for(int c = 0; c < myCourses.length; c++)
		{
			for(int d = 0; d < myCourses[c].getCourseName().length() - key.length(); d++)
			{
				if(myCourses[c].getCourseName().substring(d, d + key.length()).equals(key)) return myCourses[c];
			}
		}
		return null;
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

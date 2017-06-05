package com.kharboutli.genesisAPI;

/*
 * A course object which contains information and methods to
 * pertaining to the information of a single course in the
 * grade book.
 */
public class Course
{
	private String myCourseName;
	private String myTeacherLastName;
	private double myGrade;
	//private int myPeriod;
	
	public Course(String info[])
	{
//		myCourseName = courseName;
//		myTeacherLastName = teacherLastName;
//		myGrade = grade;
//		myPeriod = period;
	}
	
	public String getCourseName()
	{
		return myCourseName;
	}
	
	public String getTeacher()
	{
		return myTeacherLastName;
	}
	
	public double getGrade()
	{
		return myGrade;
	}
	
//	public int getPeriod()
//	{
//		return myPeriod;
//	}
	
	public String toString()
	{
		return "Name: " + myCourseName + ", Taught By: " + myTeacherLastName + ", Current Course Grade: " + myGrade;
	}
}

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
	private int myPeriod;
	
	public Course(String info[])
	{
		myCourseName = info[0];
		myTeacherLastName = info[1].replace(" Email:", "").split(",")[0];
		myGrade = Double.parseDouble(info[2].replace(" ", ""));
		myPeriod = -1;
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
	
	public int getPeriod()
	{
		return myPeriod;
	}
	
	public String toString()
	{
		return "Name: " + myCourseName + ", Taught By: " + myTeacherLastName + ", Current Course Grade: " + myGrade;
	}
}

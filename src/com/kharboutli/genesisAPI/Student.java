package com.kharboutli.genesisAPI;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Student implements Serializable {
	
	private Gradebook myGradebook;
	private String myFirstName;
	private int myGrade;
	private String myStudentID;
	
	public Student(String email, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		Genesis gen = new Genesis(email, password);
		myGradebook = new Gradebook(gen.generateCourses());
		myFirstName = gen.findName();
		myGrade = Integer.parseInt(gen.findGrade());
		myStudentID = gen.findStudentID();
	}
	
	public Gradebook getGradebook()
	{
		return myGradebook;
	}
	
	public String getFirstName()
	{
		return myFirstName;
	}
	
	public int getGrade()
	{
		return myGrade;
	}
	
	public String getStudentID()
	{
		return myStudentID;
	}
}

package com.kharboutli.genesisAPI;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Student {
	
	private Gradebook myGradebook;
	private String myFirstName;
	private int myGrade;
	private String myStudentID;
	
	public Student(String email, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		Genesis gen = new Genesis(email, password);
//		myGradebook = new Gradebook(gen.generateCourses());
//		myFirstName = gen.findName();
//		gen.findGrade();		//test
//		gen.findStudentID();	//test
		//System.out.println(gen.findName());
//		System.out.println(gen.findStudentID());
//		System.out.println(gen.findGrade());
		System.out.println(gen.generateCourses());
//		myGrade = gen.findGrade();
//		myStudentID = gen.findStudentID();
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

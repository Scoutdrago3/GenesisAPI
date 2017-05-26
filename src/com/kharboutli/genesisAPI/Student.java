package com.kharboutli.genesisAPI;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Student {
	
	private Gradebook myGradebook;
	private String myFirstName;
	private String myLastName;
	private int myGrade;
	
	public Student(String email, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		Genesis gen = new Genesis(email, password);
		myGradebook = new Gradebook(gen.generateCourses());
		myFirstName = gen.findName().substring(0, gen.findName().indexOf(','));
		myLastName = gen.findName().substring(gen.findName().indexOf(',') + 1);
		myGrade = gen.findGrade();
	}
	
	public Gradebook getGradebook()
	{
		return myGradebook;
	}
	
	public String getFirstName()
	{
		return myFirstName;
	}
	
	public String getLastName()
	{
		return myLastName;
	}
	
	public int getGrade()
	{
		return myGrade;
	}
}

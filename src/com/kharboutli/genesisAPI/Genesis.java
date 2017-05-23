package com.kharboutli.genesisAPI;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;

/*
 * Class to represent a full "Genesis object". This class will contain
 * the the main HTML for a student that has been scraped from the
 * Genesis Parent Portal. In order to construct an object of this type,
 * the constructor will make calls to authenticate the user. This class
 * will only have getters to return the data.
 */

public class Genesis {
	
	private String mainPage;
	private String gradebookPage;
	
	public Genesis(String email, String password)
	{
		//TODO: authenticate, get HTML for the two important pages
	}
	
	//TODO: parsing...
//	public String findName()
//	{
//		
//	}
//	
//	public int findGrade()
//	{
//		
//	}
//	
//	public String findStudentID()
//	{
//		
//	}
//	
//	public String findSchedule()
//	{
//		
//	}
//	
//	public ArrayList<Course> generateCourses()
//	{
//		
//	}
}

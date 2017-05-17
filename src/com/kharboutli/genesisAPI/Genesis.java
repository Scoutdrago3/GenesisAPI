package com.kharboutli.genesisAPI;

/*
 * Class to represent a full "Genesis object". This class will contain
 * the various pieces of student data that have been scraped from the
 * Genesis Parent Portal. In order to construct an object of this type,
 * the constructor will make calls to authenticate the user, grab all
 * of the information from the portal and store them in instance
 * variables. This class will only have getters to return the data.
 * 
 * 
 */

public class Genesis {
	
	private String firstName;
	private String lastName;
	private String preferedName;
	
	private int grade;
	
	
	/*
	 * Placeholder Default constructor
	 */
	public Genesis()
	{
		
	}
}

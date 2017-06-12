package com.kharboutli.genesisAPI;

/*
 * A class used to contain any grade book information. It is composed
 * of an array and various methods get and set various pieces of grade 
 * information.
 */
public class Gradebook {
	
	private Course[] myCourses = new Course[0];
	
	public Gradebook(Course[] courses)
	{
		myCourses = courses;
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
			else if(grade >= 85.5) sum += 3.5;
			else if(grade >= 80) sum += 3;
			else if(grade >= 75.5) sum += 2.5;
			else if(grade >= 70) sum += 2;
			else if(grade >= 65.5) sum += 1.5;
			else if(grade >= 60) sum += 1;
			else if(grade >= 55.5) sum += .5;
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
	
//TODO: find period and ship it with array
//	public Course getCourse(int period)
//	{
//		for(int c = 0; c < myCourses.length; c++)
//		{
//			if(myCourses[c].getPeriod() == period) return myCourses[c]; // needs work: what if you have more than one class that period!
//		}
//		return null;
//	}
	
	public String toString()
	{
		String result = "";
		for(int c = 0; c < myCourses.length; c++)
		{
			result += myCourses[c].toString() + "\n";
		}
		return result;
	}
}

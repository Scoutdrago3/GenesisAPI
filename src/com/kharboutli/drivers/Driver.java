package com.kharboutli.drivers;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.kharboutli.genesisAPI.Student;

public class Driver {
	public static void main(String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		Student stud = new Student("jooleen14@yahoo.com", "Marwan#3");
	}
}

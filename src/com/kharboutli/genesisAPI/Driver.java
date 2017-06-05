package com.kharboutli.genesisAPI;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Driver {
	public static void main(String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		Student stud = new Student("jooleen14@yahoo.com", "Marwan#3");
	}
}

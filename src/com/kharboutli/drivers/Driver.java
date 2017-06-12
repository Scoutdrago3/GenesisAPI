package com.kharboutli.drivers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.kharboutli.genesisAPI.Student;

public class Driver {
	public static void main(String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		Scanner info = new Scanner(System.in);
		System.out.println("Email: ");
		String email = info.next();
		System.out.println("Password: ");
		String password = info.next();
		
		Student stud = new Student(email, password);
		System.out.println(stud.getFirstName());
		System.out.println(stud.getGrade());
		System.out.println(stud.getStudentID());
		System.out.println(stud.getGradebook());
	}
}

package com.kharboutli.genesisAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlEmailInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

/*
 * Class to represent a full "Genesis object". This class will contain
 * the the main HTML for a student that has been scraped from the
 * Genesis Parent Portal. In order to construct an object of this type,
 * the constructor will make calls to authenticate the user. This class
 * will only have getters to return the data.
 */
public class Genesis {
	
	private HtmlPage homePage;
	private HtmlPage gradebookPage;
	private String homePageContent;
	private String gradebookPageContent;
	
	/*
	 * The constructor for the Genesis class will create a HTMLUnit WebClient
	 * and connect to parents.westfieldnjk12.org. It will authenticate the user
	 * and then scrape the home and gradebook pages' HTML.
	 * 
	 * @param {string} email - the email address to authenticate the user
	 * @param {string} password - the password to authenticate the user
	 */
	public Genesis(String email, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		WebClient webCli = new WebClient();
		webCli.getOptions().setCssEnabled(false);
		webCli.getOptions().setAppletEnabled(false);
		webCli.getOptions().setJavaScriptEnabled(false);

		HtmlPage authPage = webCli.getPage("http://parents.westfieldnjk12.org/genesis/parents?gohome=true");
		HtmlForm logonForm = authPage.getFormByName("logon");

		HtmlEmailInput emailInput = logonForm.getInputByName("j_username");
		HtmlPasswordInput passwordInput = logonForm.getInputByName("j_password");
		HtmlSubmitInput submitButton = logonForm.getInputByValue("Login");

		emailInput.setText(email);
		passwordInput.setText(password);
		homePage = submitButton.click();

		String gradebookURL = homePage.getUrl().toString().replace("tab2=studentsummary",
				"tab2=gradebook&tab3=weeklysummary");
		gradebookPage = webCli.getPage(gradebookURL);
		
		homePageContent = homePage.getWebResponse().getContentAsString();
		gradebookPageContent = gradebookPage.getWebResponse().getContentAsString();
		
		webCli.close();
	}
	
	/*
	 * The method will search the HTML for the first name of the
	 * student. There are no implemented methods as of right now for the 
	 */
	public String findName()
	{
		Element body = Jsoup.parse(homePageContent).body();
		return body.select("span[style*=font-weight]").select("span[style*=color]").first().text();
	}
	
	public String findGrade()
	{
		Element body = Jsoup.parse(homePageContent).body();
		return body.select("td[style*=text-align: center]").text().split(" ")[1].replace(" ", "");
	}
	
	public String findStudentID()
	{
		Element body = Jsoup.parse(homePageContent).body();
		return body.select("td[style*=font-size]").select("span[style*=font-weight: bold]").text().split(" ")[0];
	}
	
	public Course[] generateCourses()
	{
		ArrayList<Course> arr = new ArrayList<Course>();
		Element body = Jsoup.parse(gradebookPageContent).body();
		Elements els = body.select("table[class=list]").select("table[border*=0]").first().getElementsByTag("tr");
		for(int c = 1; c <= els.indexOf(els.last()); c+=2)
		{
			String info[] = new String[3];
			Elements el = els.get(c).getElementsByTag("td"); //get all "td"s
			for(int d = 0; d <= el.indexOf(el.last()); d++) // go through all the 
			{
				if(d == 0)
				{
					Element td = el.get(0);
					info[0] = td.select("span[class*=categorytab]").text(); 
				} else if(d == 1)
				{
					info[1] = el.get(1).text();
				} else if(d == 2)
				{
					String grade = el.get(2).select("td[style*=border:0;color:#0066CC;]").text(); //"span[style*=font-style]").first().text();
					if(grade.length() < 1) info[2] = "-1.0";
					else info[2] = grade.replace("%", "");
				}
			}
			arr.add(new Course(info));
		}
		return (Course[]) arr.toArray(new Course[0]);
	}
}

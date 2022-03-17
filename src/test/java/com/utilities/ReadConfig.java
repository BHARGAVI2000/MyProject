package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	// Properties Class
	Properties pro; 

	// Constructor
	public ReadConfig()
	{
		File src = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");// Creating File object

		try 
		{
			// Open FileInputStream and Read data 
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); // Load config.properties file
		} 
		catch (Exception e) 
		{	
			// If config.properties file is not available it will throw an exception
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// Methods to read data from config.properties 
	public String getApplicationURL()                            // ok - add new url in config.properties
	{
		String url=pro.getProperty("baseURL"); // Value from config.properties stored in url variable
		return url;
	}
	public String getUsername1() // new 
	{
		String username1=pro.getProperty("username1");
		return username1;
	}



	public String getPassword() 
	{
		String password=pro.getProperty("password");
		return password;
	}

	public String getFirstName() 
	{
		String firstname=pro.getProperty("firstname");
		return firstname;
	}

	public String getLastName() 
	{
		String lastname=pro.getProperty("lastname");
		return lastname;
	}

	public String getEmail() 
	{
		String email=pro.getProperty("email");
		return email;
	}


	public String getEmail1() 
	{
		String email1=pro.getProperty("email1");
		return email1;
	}


	public String getMobileNumber() 
	{
		String mobile=pro.getProperty("mobile");
		return mobile;
	}
	public String getChromePath() 
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getbrowser() 
	{
		String browser=pro.getProperty("browser");
		return browser;
	}
	public String getcountry() 
	{
		String country=pro.getProperty("country");
		return country;
	}

	public String getusCountry() 
	{
		String uscountry=pro.getProperty("uscountry");
		return uscountry;
	}
	public String getusMobile() 
	{
		String usmobile=pro.getProperty("usmobile");
		return usmobile;
	}

}

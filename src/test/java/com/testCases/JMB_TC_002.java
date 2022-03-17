package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;


//Candidate_SignUpPage_valid data

public class JMB_TC_002 extends BaseClass 

{
	SoftAssert softassert = new SoftAssert();

	@Test(priority=1)
	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the Candidate LandingPage test
		logger.info("CandidateLandingPageTest Started");

		//Create the object for LandingPage
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//Click on SignUp
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on Candidate SignUp 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//1:Validate whether SignUp form is displayed
		String actualtext1=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();//SignUp form title Locator
		String expectedText1 = "Sign Up";
		
		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SigUp Page Successful! SignUp form is displayed ");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SigUp Page UnSuccessful!SignUp form failed");
			captureScreen(driver,"SignUpTest");
		}
		logger.info("CandidateLandingPageTest Completed");

	}	

	@Test(priority=2)
	public void SignUpTest() throws IOException, InterruptedException
	{
		//Started the candidate SignUp test
		logger.info("SignUpTest Started");

		//Create the object for SignUpPage
		CA_SignUpPage su= new  CA_SignUpPage(driver);

		//Enter the details for the SignUp with valid data 
		//All the field values for below are declared in config file
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail(email); //email should be unique for every test
		su.clickCountryCode();
		su.SelectCountry(country);   // Canada country selected
		su.settxtPhone(mobile);  // Canada mobile number 
		su.settxtPassword(password);
		su.clickAgree();
		su.clickConsent();
		//Thread.sleep(2000);  //this should be used  in order to manually select the reCaptcha button
		su.clickJoinNow(); // Click on JoinNow 
		logger.info("Entered all the candidate details in the  SignUp form");

		//2:Validate whether SignUp is successful

		String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Verify Your Email')]")).getText();//Verify email locator
		String expectedText = "Verify Your Email";

		if(actualText.equals(expectedText))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUp Successful!");
			logger.info("SignUp form submitted. Veriy your email page displayed!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUp UnSuccessful!Verify your email page failed");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");

	}

}
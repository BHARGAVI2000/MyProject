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
		//Started the candidate landing page test
		logger.info("LandingPageTest Started");

		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//click on sign up
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on candidate sign up 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//1: Validate whether SignUp form is displayed

		//SignUp form should be displayed
		String actualtext1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2")).getText();//SignUp Locator
		String expectedText1 = "Sign Up";
		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SigUp Page Successful! SignUp form is displayed ");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SigUp Page UnSuccessful!SigUp form is not displayed");
			captureScreen(driver,"SignUpTest");
		}
		    logger.info("LandingPageTest Completed");

	}	
	
	@Test(priority=2)
	public void SignUpTest() throws IOException, InterruptedException
	{
		//Started the candidate SignUp test
		logger.info("SignUpTest Started");

		//Create the object for SignUpPage
		CA_SignUpPage su= new  CA_SignUpPage(driver);
		

		//Enter the details for the SignUp with valid data
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail("saritha13@gmail.com");
		su.clickCountryCode();
		su.SelectCountry(country);   // selected Canada
		su.settxtPhone(mobile);
		su.settxtPassword(password);
		su.clickAgree();
		su.clickConsent();
		Thread.sleep(2000);
		su.clickJoinNow();
		logger.info("Entered all the candidate details in the  SignUp form");

		//2:Validate whether SignUp  is successful
		if(driver.getTitle().equals("Verify your e-mail"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUp Successful! Account created");
			logger.info("Veriy your email page displayed");
		}

		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUp failed!Account not created");
			logger.info("Veriy your email page not displayed");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");

	}

}

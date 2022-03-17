package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;


//Candidate_SignUpPage_Non Canada valid mobile number 

public class JMB_TC_015 extends BaseClass {

	SoftAssert softassert = new SoftAssert();
	@Test(priority=1)
	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the candidate landing page test
		logger.info("CandidateLandingPageTest Started");


		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//clicking on SignUp
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Clicking on Candidate SignUp
		
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();

		//1: Validate whether SignUp form is displayed

		String actualtext1=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();//SignUp form titleLocator
		String expectedText1 = "Sign Up";
		
		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed!SigUp Page Successful! SignUp form is displayed");
		}                                       
		else

		{
		softassert.assertTrue(false);
		logger.error("Test Failed! SigUp Page UnSuccessful! SignUp form failed");
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

		//Enter the details for the sign up with valid  non Canada mobile number
		//All the field values for below are declared in config file
		logger.info("Enter the candidate details in the  SignUp form");	
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail(email);// email should be unique for everytest
		su.clickCountryCode();
		su.SelectCountry(uscountry);   // US country code selected
		su.settxtPhone(usmobile);      // US Country mobile number
		su.settxtPassword(password);
		su.clickAgree();
		su.clickConsent();
		//Thread.sleep(2000);  //this should be used  in order to manually select the reCaptcha button
		su.clickJoinNow(); // Click on JoinNow 
		logger.info("Entered all the candidate details in the  SignUp form");

		//2:Validate whether SignUp  is successful when valid US mobile is entered
		String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Verify Your Email')]")).getText();//Verify email locator
		String expectedText = "Verify Your Email";
		
		if(actualText.equals(expectedText))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed!SignUp Successful!Verify Your Email page displayed");
		}

		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed!SignUp UnSuccessful!Verify Your Email page is failed");
		logger.info("SignUpTest Completed");

	}}

}


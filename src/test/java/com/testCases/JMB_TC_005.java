package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import com.utilities.XLUtils;


//Candidate_SignUpPage_ValidEmail

public class JMB_TC_005 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test(priority=1)
	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the candidate landing page test
		logger.info("CandidateLandingPageTest Started");

		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//click on Signup
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on candidate Signup 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//1: Validate whether SignUp form is displayed
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
			logger.error("Test Failed! SigUp Page UnSuccessful! SignUp form failed ");
			captureScreen(driver,"SignUpTest");
		}
		logger.info("CandidateLandingPageTest Completed");
	}	


	@Test(priority =2) 
	public void SignUp() throws InterruptedException, IOException

	{

		//Started the candidate SignUp test
		logger.info("SignUpTest Started");

		//Create the object for SignUpPage
		CA_SignUpPage su= new  CA_SignUpPage(driver);

		//Enter the details for the sign up and  for valid email with hyphen and underscore
		//All the field values for below are declared in config file
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail(email1); // email unique for every test and enter the email with underscore and hyphen
		su.clickCountryCode();
		su.SelectCountry(country);  //Canada country selected
		su.settxtPhone(mobile);     // Canada mobile number
		su.settxtPassword(password);
		su.clickAgree();
		su.clickConsent();
		//Thread.sleep(2000);  //this should be used  in order to manually select the reCaptcha button
		su.clickJoinNow(); // Click on JoinNow 
		logger.info("Entered all the candidate details in the  SignUp form");

		//2:Validate whether SignUp  is successful with valid email with hyphen and underscore
		
		String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Verify Your Email')]")).getText();
		String expectedText = "Verify Your Email";//  verify your email page locator
		
		if(actualText.equals(expectedText))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUp Successful! Verify Your Email page displayed");
			logger.info("SignUp form submitted with email with hyphen and underscore");
		}

		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUp UnSuccessful!Verify Your Email page failed");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");

	}}
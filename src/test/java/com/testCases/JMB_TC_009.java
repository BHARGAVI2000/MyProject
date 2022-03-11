package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;

//Candidate_SignUpPage_valid mobile number with space and hyphen


public class JMB_TC_009 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test(priority=1)
	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the candidate landing page test
		logger.info("LandingPageTest Started");

		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//clicking on sign up
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Clicking on candidate sign up 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();

		//1: Validate whether SignUp form is displayed
		String actualtext1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2")).getText();//SignUp Locator
		String expectedText1 = "Sign Up";
		if(actualtext1.equals(expectedText1)){
			softassert.assertTrue(true);
			logger.info("Test Passed!CandidateLandingPage Successful! SignUp form is displayed ");
		}                                       
		else

		{
		softassert.assertTrue(false);
		logger.error("Test Failed! CandidateLandingPage UnSuccessful! SigUp form is not displayed");
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

	
		//Enter the details for the Signup with valid mobile number with space and hyphen
		
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail("saritha48@gmail.com");// every test the email must be unique for the signup
		su.clickCountryCode();
		su.SelectCountry(country);
		su.settxtPhone(mobile); // canada mobile number
		su.settxtPassword(password);
		su.clickAgree();
		su.clickConsent();
		Thread.sleep(1000);
		su.clickJoinNow();
		logger.info("Entered all the candidate details in the  SignUp form");

		//2:Validate whether SignUp  is successful with valid mobile number with space and hyphen
		String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Verify Your Email')]")).getText();//Verify email locator
		String expectedText = "Verify Your Email";
		if(actualText.equals(expectedText))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUp Successful! Verify Your Email page displayed");
			logger.info("SignUp form submitted with valid mobile number with space and hyphen");
		}

		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUp UnSuccessful!Verify Your Email page displayed");
			logger.info("SignUp form not submitted with valid mobile number with space and hyphen");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");

	}

}


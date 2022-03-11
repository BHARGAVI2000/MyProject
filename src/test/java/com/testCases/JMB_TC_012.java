package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;


//Candidate_SignUpPage_existing Jombone account

public class JMB_TC_012 extends BaseClass {

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
			logger.info("Test Passed! CandidateLandingPage Successful! SignUp form is displayed ");
		}                                       
		else

		{softassert.assertTrue(false);
		logger.error("Test Failed!CandidateLandingPage Successful! SigUp form is not displayed");
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

		//Enter the details for the sign up with existing account details
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail("saritha88@gmail.com");
		su.clickCountryCode();
		su.SelectCountry(country);
		su.settxtPhone(mobile);//canada mobile number
		su.settxtPassword(password);
		su.clickAgree();
		Thread.sleep(1000);
		su.clickConsent();
		su.clickJoinNow();
		logger.info("Entered all the candidate details in the  SignUp form");
		
		//2:Validate whether SignUp account should be created with existing account number
		String actualText=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div")).getText();
		if(actualText.equals("Already have an account? Log In"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Already have an account message displayed");
			logger.info("SignUp form not submitted with existing account details");
		}

		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed ! Error message not displayed");
			logger.info("SignUp form submitted with existing account details");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");

	}

}


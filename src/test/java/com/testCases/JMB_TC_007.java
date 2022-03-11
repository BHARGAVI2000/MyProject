package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;


//Candidate_SignUpPage_CountryCode with selecting other country than Canada

public class JMB_TC_007 extends BaseClass {

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

		//SignUp form should be displayed
		String actualtext1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2")).getText();//SignUp Locator
		String expectedText1 = "Sign Up";
		if(actualtext1.equals(expectedText1)){
			softassert.assertTrue(true);
			logger.info("Test Passed!Candidate LandingPage Successful with SignUp form is displayed ");
		}                                       
		else

		{softassert.assertTrue(false);
		logger.error("Test Failed!Candidate LandingPage UnSuccessful with SigUp form is not displayed");
		captureScreen(driver,"SignUpTest");
		}
		logger.info("LandingPageTest Completed");
	}	


	@Test(priority=2)
	public void SignUpTest() throws IOException, InterruptedException
	{

		//Started the candidate SignUp test
		logger.info("SignUpTest Started");

		//Create the object for SignUp Page
		 CA_SignUpPage su= new  CA_SignUpPage(driver);	
		
		//Enter the details for the sign up with valid data with US country code selected
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail("saritha91@gmail.com"); // every test the email must be unique for the signup
		su.clickCountryCode();
		su.SelectCountry(usCountry);  // US Country code selected
		su.settxtPhone(usMobile);//  US mobile number
		su.settxtPassword(password);
		su.clickAgree();
		su.clickConsent();
		Thread.sleep(3000);
		su.clickJoinNow();
		logger.info("Entered all the candidate details in the  SignUp form");
		

		//2:Validate whether SignUp  is successful when other country code(US) selected
		
		String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Verify Your Email')]")).getText();//Verify email locator
		String expectedText = "Verify Your Email";
		if(actualText.equals(expectedText))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUp Successful! Verify Your Email page displayed");
			logger.info("SignUp form submitted when the other countrycode is selected");
		}

		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUp UnSuccessful!Verify Your Email page not displayed");
			logger.info("SignUp form  not submitted when the other countrycode is selected");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");

	}

}


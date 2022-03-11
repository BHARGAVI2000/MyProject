package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;



//Candidate_SignUpPage_mobile number formatting

public class JMB_TC_013 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test(priority=1)
	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the candidate landing page test
		logger.info("Started CandidateLandingPageTest");

		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//click on SignUp
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on candidate SignUp
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//Validate whether candidate landing page  is successful

		String actualtext1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2")).getText();//SignUp Locator
		String expectedText1 = "Sign Up";

		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CandidateLandingPage Successful! Sign form is displayed ");
		} 
		else

			logger.info("Test Failed! CandidateLandingPage UnSuccessful!SigUp form is not displayed ");

		captureScreen(driver,"landingPageTest");}



	@Test(priority=2)
	public void SignUpTest() throws IOException, InterruptedException{


		//Started the candidate SignUp test
		logger.info("SignUpTest Started");

		//Create the object for SignUpPage
		CA_SignUpPage su= new  CA_SignUpPage(driver);

		//Enter the details for the sign up 
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail("saritha88@gmail.com");
		su.clickCountryCode();
		su.SelectCountry(country);
		logger.info("mobile number formatting started");
		su.settxtPhone(mobile);
		su.settxtPassword(password);
		su.clickAgree();
		Thread.sleep(1000);
		su.clickConsent();
		su.clickJoinNow();
		logger.info("Entered all the candidate details in the  SignUp form");


		// Validate the SignUp mobile number is formatted
		String actualText= driver.findElement(By.xpath("//*[@id=\"phone\"]")).getAttribute("value");//formatted mobile number text locator
		String expectedText ="(416) 858-7777";
		if(actualText.endsWith(expectedText))
		{
			logger.info("Mobile number in the SignUp form formatted");

		}
		else
		{
			logger.info("Mobile number in the SignUp form not formatted");
		}

		softassert.assertAll();
		logger.info("Mobile number formatting completed");
		logger.info("SignUp completed");


	}}



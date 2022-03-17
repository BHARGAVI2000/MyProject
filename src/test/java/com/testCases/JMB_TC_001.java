package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;


public class JMB_TC_001 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	//verify Candidate_LandingPage_valid URL

	@Test(priority=1)
	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the candidate landing page test
		logger.info("CandidateLandingPageTest Started");

		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//click on SignUp
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on Candidate SignUp 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//Validate whether Candidate LandingPage  is successful

		//1.SignUp should be displayed in bold 


		String actualtext1=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();
		String expectedText1 = "Sign Up";// SignUp locator 

		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Candidate LandingPageSuccessful! SigUp is displayed in bold");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Candidate LandingPage failed! SigUp bold display failed");
			captureScreen(driver,"landingPageTest");
		}

		//2.text at bottom of image in 4 lines should be displayed  	
		// 4lines text locator
		String actualText2= driver.findElement(By.xpath("//li[contains(text(),'Connect with local businesses to find the job and ')]")).getText();
		String expectedText2 = "Connect with local businesses to find the job and shift you need. Live a happy life!";
		if(actualText2.equals(expectedText2))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Candidate LandingPageSuccessful! 4lines text is displayed");
		}    
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Candidate LandingPage 4lines text failed!  ");
			captureScreen(driver,"landingPageTest");
		}  

		//3.Validate Jombone logo is displayed


		Boolean actualimg1=  driver.findElement(By.xpath("//a[@class='login_logo']")).isDisplayed();// Jombone logo locator
		Boolean expectedimg1=true;

		if(actualimg1.equals(expectedimg1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Candidate LandingPageSuccessful! Jombone image displayed");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Candidate LandingPage failed! Jombone image failed");
			captureScreen(driver,"landingPageTest");
		}

		// 4. Validate landing page image displayed

		Boolean actualimg2=  driver.findElement(By.xpath("//div[@class='login_left_section clearfix']")).isDisplayed();
		Boolean expectedimg2=true;                  //landing page image locator

		if(actualimg2.equals(expectedimg2))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Candidate LandingPageSuccessful! landing page image displayed");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Candidate LandingPage failed! landing page image failed");
			captureScreen(driver,"landingPageTest");
		}

		softassert.assertAll();
		logger.info("CandidateLandingPageTest completed");

	}

}

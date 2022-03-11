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

		//click on sign up
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on candidate sign up 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();
		

		//Validate whether candidate landing page  is successful
		
		//1.SignUp should be displayed in bold
		String actualtext1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2")).getText();//SignUp Locator
		String expectedText1 = "Sign Up";
		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Candidate LandingPageSuccessful! SigUp is displayed in bold");
		}                                       
		else
		{
		softassert.assertTrue(false);
		logger.error("Test Failed! Candidate LandingPage failed! SigUp is not displayed in bold");
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
		logger.error("Test Failed! Candidate LandingPage failed! 4lines text is not displayed");
		captureScreen(driver,"landingPageTest");}  

		softassert.assertAll();
		logger.info("CandidateLandingPageTest completed");

	}

}

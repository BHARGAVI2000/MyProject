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

//Candidate_SignUpPage_Invalid mobile number


public class JMB_TC_010 extends BaseClass {

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

		//Clicking on Candidate SIgnUp 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();
		

		//1: Validate whether SignUp form is displayed 

		String actualtext1=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();//SignUp form title Locator
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

	@Test(dataProvider="TestData",priority =2) 
	public void SignUp(String firstname, String lastname, String email, String mobile, String password) throws InterruptedException, IOException
	{
		//Started the candidate SignUp test
		logger.info("SignUpTest Started");

		//Create the object for SignUp Page
		CA_SignUpPage su= new  CA_SignUpPage(driver);

		// Enter the details in sign up and mobile with multiple sets of data
		//All the field values for below are declared in config file
		logger.info("Enter the candidate details in the  SignUp form");
		su.settxtFirstName(firstname);
		su.settxtLastName(lastname);
		su.settxtEmail(email);
		su.clickCountryCode();
		su.SelectCountry(country);  // CanadaCountry code selected
		su.settxtPhone(mobile);  // Canada mobile number
		su.settxtPassword(password);
		su.clickAgree();
		//Thread.sleep(2000);  //this should be used  in order to manually select the reCaptcha button
		su.clickConsent();
		su.clickJoinNow();// Click on JoinNow 
		logger.info("Entered all the candidate details in the  SignUp form");


		//2:Validate SignUp mobile number error messages displayed with multiple invalid sets of data
		
		String actualText2 =driver.findElement(By.xpath("//*[@id=\"candidateForm\"]/div[2]/div[3]/div/div/span")).getText();
		String expectedText2 ="Please enter your mobile number";// mobile error message locator for blank

		String actualText3 =driver.findElement(By.xpath("//*[@id=\"candidateForm\"]/div[2]/div[3]/div/div/span")).getText();
		String expectedText3 ="Please enter a valid 10 digit mobile number";// mobile error message locator for invalid data

		if(actualText2.equals(expectedText2))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed!Error message Please enter your mobile number displayed");
			driver.navigate().refresh(); // to refresh the data in the text fields for the next iteration of data set
		}

		else if(actualText3.equals(expectedText3))
		{
			softassert.assertTrue(true);
			logger.error("Test Passed!Error message Please enter a valid 10 digit mobile number");
			driver.navigate().refresh();
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Error message for mobile number failed");
			captureScreen(driver,"SignUpTest");
			driver.navigate().refresh();
		}

		//3.Validating SignUp form not submitted with invalid mobile multiple sets of data

		String actualtext4=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();//SignUp form title Locator
		String expectedText4 = "Sign Up";
		if(actualtext4.equals(expectedText4))
		{
			softassert.assertTrue(true);  //SignUp form not submitted with invalid mobile number remained in the same signup for page
			logger.info("Test Passed!SignUp form successful!");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SigUp form failed");
			captureScreen(driver,"SignUpTest");
		}
		softassert.assertAll();
		logger.info("SignUpTest Completed");
	}

	@DataProvider(name="TestData")
	public String[][] testData() throws IOException {

		String path= ".\\src\\test\\java\\com\\testData\\Jombone_SignUpMobileData.xlsx";
		XLUtils xlutil = new XLUtils();
		int totalRows=xlutil.getRowCount(path, "sheet1");
		int totalcols=xlutil.getCellCount(path, "sheet1", 1);
		String SignUpData[][]= new String[totalRows][totalcols];
		for (int i = 1; i <= totalRows; i++)  
		{
			for (int j = 0; j < totalcols; j++) {
				SignUpData[i-1][j]= xlutil.getCellData(path, "Sheet1", i, j);
			}

		}return SignUpData;
	}}

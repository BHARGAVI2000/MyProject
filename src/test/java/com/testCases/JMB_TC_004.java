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


//Candidate_SignUpPage_Invalid LastName

public class JMB_TC_004 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test(priority=1)

	public void LandingPageTest() throws IOException, InterruptedException
	{
		//Started the candidate landing page test
		logger.info("LandingPageTest Started");

		//Create the object for landing Page
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//click on SignUp 
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on candidate SignUp 
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//1: Validate whether SignUp form is displayed
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
			logger.error("Test Failed! SigUp Page not Successful! SigUp form is not displayed");
			captureScreen(driver,"SignUpTest");
		}
		logger.info("LandingPageTest Completed");
	}	


	@Test(dataProvider="TestData",priority =2) 

	public void SignUp(String firstname, String lastname, String email, String mobile, String password) throws InterruptedException, IOException{
		{

			//Started the candidate SignUp test
			logger.info("SignUpTest Started");

			//Create the object for SignUp Page
			CA_SignUpPage su= new  CA_SignUpPage(driver);

			//Enter the details for the sign up and  for last name multiple sets of data
			logger.info("Enter the candidate details in the  SignUp form");
			su.settxtFirstName(firstname);
			su.settxtLastName(lastname);
			su.settxtEmail(email);
			su.settxtPhone(mobile);
			su.settxtPassword(password);
			su.clickAgree();
			Thread.sleep(2000);
			su.clickConsent();
			su.clickJoinNow();
			logger.info("Entered all the candidate details in the  SignUp form");

			//2:Validate whether SignUp  is successful
			String actualText1 =driver.findElement(By.xpath("//*[@id=\"candidateForm\"]/div[2]/div[1]/div[2]/div/span")).getText();
			String expectedText1 ="Please enter last name";// lastname field error message locator with blank

			String actualText2 =driver.findElement(By.xpath("//*[@id=\"candidateForm\"]/div[2]/div[1]/div[2]/div/span")).getText();
			String expectedText2 ="Please enter valid last name";// lastname field error message locator with invalid data

			if(actualText1.equals(expectedText1))
			{
				softassert.assertTrue(true);
				logger.info("Test Passed!Error message Please enter last name displayed");
				logger.info("SignUp form not submitted with invalid lastname ");
			}
			else if(actualText2.equals(expectedText2))
			{
				softassert.assertTrue(true);
				logger.error("Test Passed!Error message Please enter valid last name displayed");
				logger.info("SignUp form not submitted with invalid lastname ");
				captureScreen(driver,"SignUpTest");
			}
			else

			{
				softassert.assertTrue(false);
				logger.error("Test Failed! SignUp failed! Error message for lastname not displayed");
				logger.info("SignUp form submitted with invalid lastname ");
				captureScreen(driver,"SignUpTest");
			}

			softassert.assertAll();
			logger.info("SignUpTest Completed");
		}}

	@DataProvider(name="TestData")
	public String[][] testData() throws IOException {

		String path= ".\\src\\test\\java\\com\\testData\\Jombone_SignUpLastNameData.xlsx";
		XLUtils xlutil = new XLUtils();
		int totalRows=xlutil.getRowCount(path, "sheet1");
		int totalcols=xlutil.getCellCount(path, "sheet1", 1);
		String SignUpData[][]= new String[totalRows][totalcols];
		for (int i = 1; i <= totalRows; i++)  
		{
			for (int j = 0; j < totalcols; j++) {
				SignUpData[i-1][j]= xlutil.getCellData(path, "Sheet1", i, j);
			}

		}
		return SignUpData;
	     }
	  }



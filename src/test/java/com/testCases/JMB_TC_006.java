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


//Candidate_SignUpPage_InvalidEmail

public class JMB_TC_006 extends BaseClass {

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

		//Click on candidate  SignUp
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//1: Validate whether SignUp form is displayed

		String actualtext1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2")).getText();//SignUp Locator
		String expectedText1 = "Sign Up";

		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! LandingPage Successful! SignUp form is displayed ");
		}                                       
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! LandingPage UnSuccessful! SigUp form is not displayed");
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


			//Enter the details for the sign up and  for email multiple sets of data
			logger.info("Enter the candidate details in the  SignUp form");
			su.settxtFirstName(firstname);
			su.settxtLastName(lastname);
			su.settxtEmail(email); 
			su.clickCountryCode();
			su.SelectCountry(country); // country selected canada
			su.settxtPhone(mobile);
			su.settxtPassword(password);
			su.clickAgree();
			su.clickConsent();
			Thread.sleep(2000);
			su.clickJoinNow();
			logger.info("Entered all the candidate details in the  SignUp form");


			//2:Validate whether SignUp  is successful

			String actualText =driver.findElement(By.xpath("//*[@id=\"candidateForm\"]/div[2]/div[2]/div/span")).getText();
			String expectedText ="Please enter valid email.";

			if(actualText.equals(expectedText))
			{
				softassert.assertTrue(true);
				logger.info("Test Passed!Error message Please enter valid email displayed");
				logger.info("SignUp form not submitted with invalid email data");
			}


			else
			{
				softassert.assertTrue(false);
				logger.error("Test Failed! Error message Please enter valid email not displayed");
				logger.info("SignUp form submitted with invalid email data");
				captureScreen(driver,"SignUpTest");
			}
			softassert.assertAll();
			logger.info("SignUpTest Completed");
		}
	}

	@DataProvider(name="TestData")
	public String[][] testData() throws IOException {

		String path= ".\\src\\test\\java\\com\\testData\\Jombone_SignUpLastEmailData.xlsx";
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



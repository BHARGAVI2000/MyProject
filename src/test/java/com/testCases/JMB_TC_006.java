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
		//Started the Candidate LandingPage test
		logger.info("CandidateLandingPageTest Started");

		//Create the object for LandingPage
		CA_LandingPage lp= new  CA_LandingPage(driver);

		//click on SignUp
		logger.info("click on SignUp");
		lp.clickSignUp();

		//Click on Candidate SignUp
		logger.info("click on candidate SignUp");
		lp.clickCandidateSignUp();


		//1: Validate whether SignUp form is displayed

		String actualtext1=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();//SignUp form title Locator
		String expectedText1 = "Sign Up";

		if(actualtext1.equals(expectedText1))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SigUp Page Successful! SignUp form is displayed  ");
			driver.navigate().refresh();
		}                                       
		else 

		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SigUp Page UnSuccessful! SignUp form failed");
			captureScreen(driver,"SignUpTest");
			driver.navigate().refresh();
		}
		logger.info("CandidateLandingPageTest Completed");
	}	

	@Test(dataProvider="TestData",priority =2) 

	public void SignUp(String firstname, String lastname, String email, String mobile, String password) throws InterruptedException, IOException{
		{

			//Started the candidate SignUp test
			logger.info("SignUpTest Started");

			//Create the object for SignUp Page
			CA_SignUpPage su= new  CA_SignUpPage(driver);


			//Enter the details for the sign up and  for email multiple sets of data
			//All the field values for below are declared in config file
			logger.info("Enter the candidate details in the  SignUp form");
			su.settxtFirstName(firstname);
			su.settxtLastName(lastname);
			su.settxtEmail(email); 
			su.clickCountryCode();
			su.SelectCountry(country); // Country selected Canada
			su.settxtPhone(mobile);  //Canada mobile number
			su.settxtPassword(password);
			su.clickAgree();
			su.clickConsent();
			//Thread.sleep(2000);  //this should be used  in order to manually select the reCaptcha button
			su.clickJoinNow(); // Click on JoinNow 
			logger.info("Entered all the candidate details in the  SignUp form");


			//2:Validate SignUp email error messages displayed with  multiple invalid sets of data

			String actualText1 =driver.findElement(By.xpath("//*[@id=\"candidateForm\"]/div[2]/div[2]/div/span")).getText();
			String expectedText1 ="Please enter valid email.";   // Please enter valid email  error message locator

			if(actualText1.equals(expectedText1))
			{

				softassert.assertTrue(true);
				logger.info("Test Passed!Error message Please enter valid email displayed");
				driver.navigate().refresh(); // to refresh the data in the text fields for the next iteration of data set
			}
			else

			{
				softassert.assertTrue(false);
				logger.error("Test Failed! Error message Please enter valid email failed");
				captureScreen(driver,"SignUpTest");
				driver.navigate().refresh();
			}

			//3.Validating SignUp form not submitted with invalid email multiple sets of data

			String actualtext2=driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]")).getText();//SignUp form title Locator
			String expectedText2 = "Sign Up";
			if(actualtext2.equals(expectedText2))
			{
				softassert.assertTrue(true);  //SignUp form not submitted with invalid email remained in the same signup for page
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
	}

	@DataProvider(name="TestData")
	public String[][] testData() throws IOException {

		String path= ".\\src\\test\\java\\com\\testData\\Jombone_SignUpEmailData.xlsx";
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



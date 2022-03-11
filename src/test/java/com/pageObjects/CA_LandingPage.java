package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.base.BasePage;

public class CA_LandingPage extends BaseClass  {


	public WebDriver ldriver;

	SoftAssert softassert = new SoftAssert();

	// Constructor
	public CA_LandingPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	//Looking for Job WebElement
	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul[2]/li[3]/a")
	@CacheLookup
	WebElement look_for_job;

	public void click_LookForJob()
	{
		look_for_job.click();
	}

	//Looking for SignUp WebElement
	@FindBy(xpath="/html/body/div/main/section[1]/div/div/div/div/div/a[2]")
	@CacheLookup
	WebElement signup;

	//Performing click operations for SignUp WebElement
	public void clickSignup() {
		signup.click();

	}

	//Looking for SignUp WebElement
	@FindBy(linkText="Sign Up")
	@CacheLookup
	WebElement linkSignUp;

	//Performing click operations for SignUp WebElement
	public void clickSignUp() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(linkSignUp));
		linkSignUp.click();
	}

	// Looking for Candidate SignUp WebElement
	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul[2]/li[2]/div/div/div/a[1]")
	@CacheLookup
	WebElement linkcandidateSignUp;



	////Performing click operations for candidate SignUp
	public void clickCandidateSignUp() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(linkcandidateSignUp));
		linkcandidateSignUp.click();}}
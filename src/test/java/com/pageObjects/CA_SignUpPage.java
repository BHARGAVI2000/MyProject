package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CA_SignUpPage {

	public WebDriver ldriver;

	// Constructor
	public CA_SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	//Capture FirstNamefield

	@FindBy(id="firstname")
	@CacheLookup
	WebElement txtfirstname;

	//Capture LastName field
	@FindBy(id = "lastname")
	@CacheLookup
	WebElement txtlastname;

	//Capture email field
	@FindBy(id ="email")
	@CacheLookup
	WebElement txtemail;

	//Capture phone field
	@FindBy(id = "phone")
	@CacheLookup
	WebElement txtphone;

	//Capture password field
	@FindBy(id ="password-field")
	@CacheLookup
	WebElement txtpassword;

	// Capture  agree radio button 
	@FindBy(xpath ="//*[@id=\"candidateForm\"]/div[2]/div[5]/div/label")
	@CacheLookup
	WebElement radiobtnAgree;

	//Capture  consent radio button 
	@FindBy(xpath ="//*[@id=\"candidateForm\"]/div[2]/div[6]/div/label")
	@CacheLookup
	WebElement radiobtnConsent;

	//Capture  captcha radio button 
	@FindBy(xpath ="//*[@id=\"recaptcha-anchor\"]/div[1]")
	@CacheLookup
	WebElement radiobtnCaptcha;

	//Capture  join now button 
	@FindBy(id ="sbBt")
	@CacheLookup
	WebElement btnjoinnow;

	//capture click on country code combobox
	@FindBy(xpath ="//div[contains(text(),'+1')]")
	@CacheLookup
	WebElement CountryCode;

	//capture list of all elements in the country code combobox
	@FindBy(xpath ="//ul[@class='country-list']//li")
	@CacheLookup
	List<WebElement> countryList;


	@FindBy(xpath ="//*[@id=\"candidateForm\"]/div[2]/div[3]/div/div/div/div/div[2]")
	@CacheLookup
	WebElement comboboxCountryCode;


	@FindBy(xpath="//*[@id=\"country-listbox\"]")
	@CacheLookup
	WebElement comboboxCountryList;


	@FindBy(xpath="//*[@id=\"iti-item-us\"]")
	@CacheLookup
	WebElement comboboxCountryList1;


	// ==================Action methods===========================//

	// Send text to the firstname field
	public void settxtFirstName(String firstname) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtfirstname));
		txtfirstname.sendKeys(firstname);
	}

	// Send text to the lastname field
	public void settxtLastName(String lastname) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtlastname));
		txtlastname.sendKeys(lastname);
	}
	// Send text to email field
	public void settxtEmail(String email) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.sendKeys(email);
	}

	// Send text to phone field
	public void settxtPhone(String phone) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtphone));
		txtphone.sendKeys(phone);
	}
	// Send text to password field
	public void settxtPassword(String password) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(password);
	}

	// click on agree radio button
	public void clickAgree() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(radiobtnAgree));
		radiobtnAgree.click();
	}

	// click on consent radio button
	public void clickConsent(){
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(radiobtnConsent));
		radiobtnConsent.click();
	}

	// click on recaptcha radio button
	public void clickCaptcha(){
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(radiobtnCaptcha));
		radiobtnCaptcha.click();
	}

	// click on JoinNow(for signup)
	public void clickJoinNow() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnjoinnow));
		btnjoinnow.click();
	}

	// click on 
	public void clickCountryCodeCombobox() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(comboboxCountryCode));
		comboboxCountryCode.click();


	}


	public void clickCountrylist(String country) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(comboboxCountryList));
		comboboxCountryList.click();
	}
	public void clickCountrylist1(String country) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(comboboxCountryList));
		comboboxCountryList1.click();
	}

	// click on country code comboxbox
	public void clickCountryCode() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(CountryCode));
		CountryCode.click();
	}

	//country code selection from the list of country codes
	public void SelectCountry(String country)
	{
		for(int i =0; i<countryList.size();i++) {
			
		System.out.println(countryList.size());
		System.out.println(countryList.get(i).getText());
		
			
			
			if(countryList.get(i).getText().equals(country))
			{
				countryList.get(i).click();
				break;
			}
		}

	}}



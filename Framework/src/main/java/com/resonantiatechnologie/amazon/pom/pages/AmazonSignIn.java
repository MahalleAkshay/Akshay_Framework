package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.utility.Constants;

public class AmazonSignIn {
	@FindBy(css = ".a-link-nav-icon")
	WebElement amazonSignInLink;

	@FindBy(xpath = "//h1[@class='a-spacing-small']")
	WebElement loginLabel;

	@FindBy(css = ".a-form-label")
	WebElement emailOrMobilePhoneNumberLabel;

	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement enterUsernameText;

	@FindBy(css = ".a-button-input")
	WebElement countinueButton;

	@FindBy(css = "#auth-fpp-link-bottom")
	WebElement forgotPasswordLink;

	@FindBy(css = "#ap-other-signin-issues-link")
	WebElement otherIssuesWithSignInLink;

	@FindBy(xpath = "//h5[contains(text(),'New to Amazon?')]")
	WebElement newToAmazonLabel;

	@FindBy(id = "createAccountSubmit")
	WebElement createYourAmazonAccountButtonLink;

	@FindBy(xpath = "//a[contains(text(),'Conditions of Use')]")
	WebElement conditionsOfUseLink;

	@FindBy(xpath = "//a[contains(text(),'Privacy Notice')]")
	WebElement privacyNoticeLink;

	@FindBy(xpath = "//a[contains(text(),'Help')]")
	WebElement helpLink;

	@FindBy(css = "#ap_change_login_claim")
	WebElement changeLink;

	@FindBy(xpath = "//label[contains(text(),'Password')]")
	WebElement passwordLabel;

	@FindBy(css = "#ap_password")
	WebElement enterPasswordText;

	@FindBy(css = "#signInSubmit")
	WebElement loginButtonLink;

	@FindBy(xpath = "//input[@name='rememberMe']")
	WebElement Checkbox;

	@FindBy(css = "#remember_me_learn_more_link")
	WebElement detailsLink;

	@FindBy(xpath = "//h5[contains(text(),'or')]")
	WebElement orLabel;

	@FindBy(css = "#continue")
	WebElement loginUsingAnOtpLink;

	@FindBy(xpath = "//i[@class='a-icon a-icon-info a-icon-small']")
	WebElement iIconLabel;

	@FindBy(xpath = "//span[@class='a-size-small a-color-tertiary']")
	WebElement messageAndDataRatesMayApplyLabel;

	@FindBy(css = "#nav-cart")
	WebElement cartLink;

	// Here we are going to launch the page objects
	public AmazonSignIn() {
		PageFactory.initElements(Constants.driver, this);
	}

	// This method will click on particular link
	public void clickOnAmazonSignInLink() {
		amazonSignInLink.click();
	}// end of method

	// This method will take the text of given label
	public String takeTextOfLoginLabel() {
		return loginLabel.getText();
	}// end of method

	// This method will get the text of given label
	public void takeTextOfemailOrMobilePhoneNumberLabel() {
		emailOrMobilePhoneNumberLabel.getText();
	}// end of method

	// This method is used to enter text in given loaction
	public void enterUsernameText() {
		enterUsernameText.sendKeys(Constants.prop.getProperty("USERNAME"));
	}// end of method

	// This method will click on particular link
	public void clickOncountinueButton() {
		countinueButton.click();
	}// end of method

	// This method will click on particular link
	public void clickOnforgotPasswordLink() {
		forgotPasswordLink.click();
	}// end of method

	// This method will click on particular link
	public void clickOnOtherIssuesWithSignInLink() {
		otherIssuesWithSignInLink.click();
	}// end of method

	// This method will take the text of given label
	public String takeTextOfNewToAmazonLabel() {
		return newToAmazonLabel.getText();
	}// end of method

	// This method will click on particular link
	public void clickOnCreateYourAmazonAccountButtonLink() {
		createYourAmazonAccountButtonLink.click();
	}// end of method

	// This method will click on particular link
	public void clickOnConditionsOfUseLink() {
		conditionsOfUseLink.click();
	}// end of method

	// This method will click on particular link
	public void clickOnPrivacyNoticeLink() {
		privacyNoticeLink.click();
	}// end of method

	// This method will click on particular link
	public void clickOnHelpLink() {
		helpLink.click();
	}// end of method

	// This method will click on particular link
	public void clickOnChangeLink() {
		changeLink.click();
	}// end of method

	// This method will take the text of given label
	public void takeTextOfPasswordLabel() {
		passwordLabel.getText();
	}// end of method

	// This method will enter text at password location
	public void enterPasswordText() {
		enterPasswordText.sendKeys(Constants.prop.getProperty("PASSWORD"));
	}// end of method

	// This method will click on particular link
	public void clickOnLoginButtonLink() {
		loginButtonLink.click();
	}// end of method

	// This method will click on particular link
	public void clickOnCheckbox() {
		Checkbox.click();
	}// end of method

	// This method will click on particular link
	public void clickOnDetailsLink() {
		detailsLink.click();
	}// end of method

	// This method will take the text of given label
	public String takeTextOfOrLabel() {
		return orLabel.getText();
	}// end of method

	// This method will click on particular link
	public void clickOnLoginUsingAnOtpLink() {
		loginUsingAnOtpLink.click();
	}// end of method

	// This method will take the text of given label
	public String takeTextOfIIconLabel() {
		return iIconLabel.getText();
	}// end of method

	// This method will take the text of given label
	public String takeTextOfMessageAndDataRatesMayApplyLabel() {
		return messageAndDataRatesMayApplyLabel.getText();
	}// end of method

	// This method will click on given link
	public void clickOnCartlink() {
		cartLink.click();
	}// end of method

	// This method is used to login on amazon
	public OnlineShopingSiteInIndia login() {
		enterUsernameText.sendKeys(Constants.prop.getProperty("USERNAME"));
		countinueButton.click();
		enterPasswordText.sendKeys(Constants.prop.getProperty("PASSWORD"));
		loginButtonLink.click();
		return new OnlineShopingSiteInIndia();
	}// end of the method
	
	// This method is a overloaded method of login for reading excel file only to pass multiple parameters
	public OnlineShopingSiteInIndia login(String userName, String password) {
		enterUsernameText.sendKeys(userName);
		countinueButton.click();
		enterPasswordText.sendKeys(password);
		loginButtonLink.click();
		//cartLink.click();
		return new OnlineShopingSiteInIndia();
	}// end of the method

}

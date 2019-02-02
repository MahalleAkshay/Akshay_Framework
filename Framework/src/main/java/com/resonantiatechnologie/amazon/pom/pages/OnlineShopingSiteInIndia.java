package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.utility.Constants;

public class OnlineShopingSiteInIndia {
	@FindBy(xpath = "//a[@id='nav-link-yourAccount']")
	WebElement helloSignInYourOrdersLink;

	@FindBy(xpath = "//a[@id='nav-link-prime']")
	WebElement tryPrimeLink;

	@FindBy(xpath = "//a[@id='nav-link-wishlist']")
	WebElement yourListsLink;

	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement cartLink;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	WebElement signOutLink;

	// Here we are going to launch the page objects
	public OnlineShopingSiteInIndia() {
		PageFactory.initElements(Constants.driver, this);
	}

	// These are the various a methods for the webelements on the given page
	// This method is used to click on the particular link
	public void clickOnhelloSignInYourOrdersLink() {
		helloSignInYourOrdersLink.click();
	}// End of the method

	// This method will move to the particular webelement on page
	public void mouseMovementOnhelloSignInYourOrdersLink() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(helloSignInYourOrdersLink).build().perform();

	}// End of the method

	// This method is used to click on the particular link
	public AmazonPrime clickOnTryPrimeLink() {
		tryPrimeLink.click();
		return new AmazonPrime();
	}// End of the method

	// This method will move to the particular webelement on page
	public void mouseMovementOnTryPrimeLink() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(tryPrimeLink).build().perform();
	}

	// This method is used to click on the particular link
	public void clickOnYourListsLink() {
		yourListsLink.click();
	}// End of the method

	// This method will move to the particular webelement on page
	public void mouseMovementOnYourListsLink() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(yourListsLink).build().perform();
	}// End of the method

	// This method is used to click on the particular link
	public ShoppingCart clickOnCartLink() {
		cartLink.click();
		return new ShoppingCart();
	}// End of the method

	// This method is used to click on the particular link
	public void clicksignOutLink() {
		signOutLink.click();
	}// End of the method

	// This method will move to the particular webelement on page
	public void mouseMovementsignOutLink() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(signOutLink).build().perform();
	}// End of the method

}

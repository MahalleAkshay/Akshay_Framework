package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.utility.Constants;

public class ShoppingCart {

	@FindBy(xpath = "//select[@name='quantity']")
	WebElement selectQuantity;

	@FindBy(xpath = "//input[@name='proceedToCheckout']")
	WebElement proceedToCheckout;

	// Here we are going to launch the page objects
	public ShoppingCart() {
		PageFactory.initElements(Constants.driver, this);
	}

	//This method will click on check out link
	public void proceedToCheckoutLink() {
		proceedToCheckout.click();
	}//End of the method

}

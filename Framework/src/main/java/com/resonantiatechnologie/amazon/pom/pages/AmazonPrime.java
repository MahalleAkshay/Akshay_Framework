package com.resonantiatechnologie.amazon.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.utility.Constants;

public class AmazonPrime extends POMBase {
	@FindBy(xpath = "//i[@class='a-icon a-accordion-radio a-icon-radio-active']")
	WebElement tryPrimeFree;

	@FindBy(xpath = "//input[@aria-labelledby='a-autoid-0-announce']")
	WebElement startYour30DaysTrial;

	@FindBy(css = "a-icon a-accordion-radio a-icon-radio-active")
	WebElement joinPrimeStartingRs129;

	@FindBy(xpath = "//input[@aria-labelledby='a-autoid-1-announce']")
	WebElement joinPrimeStartingRs129PerMonth;

	@FindBy(xpath = "///input[@aria-labelledby='a-autoid-2-announce']")
	WebElement joinPrimeStartingRs999PerYear;

	// Here we are going to launch the page objects
	public AmazonPrime() {
		PageFactory.initElements(Constants.driver, this);
	}

	// This method will click on given button
	public void tryPrimeFreeButton() {
		tryPrimeFree.click();
	}// End of the method

	// This method will click on given button
	public void startYour30DaysTrialButton() {
		startYour30DaysTrial.click();
	}// End of the method

	// This method will click on given button
	public void joinPrimeStartingRs129Button() {
		joinPrimeStartingRs129.click();
	}// End of the method

	// This method will click on given button
	public void joinPrimeStartingRs129PerMonthButton() {
		joinPrimeStartingRs129PerMonth.click();
	}// End of the method

	// This method will click on given button
	public void joinPrimeStartingRs999PerYearButton() {
		joinPrimeStartingRs999PerYear.click();
	}// End of the method

}

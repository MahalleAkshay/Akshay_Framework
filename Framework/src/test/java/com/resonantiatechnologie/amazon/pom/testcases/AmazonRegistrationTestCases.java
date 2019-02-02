package com.resonantiatechnologie.amazon.pom.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonRegistration;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;

public class AmazonRegistrationTestCases extends POMBase {
	AmazonRegistration registration;
	AmazonSignIn signIn;
	OnlineShopingSiteInIndia online;

	// this is the constructor of Amazon registration page
	public AmazonRegistrationTestCases() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		Keyword.implicitWait(20, TimeUnit.SECONDS);
		Keyword.windowMaximize();
		online = new OnlineShopingSiteInIndia();
		signIn = new AmazonSignIn();
		registration = new AmazonRegistration();
		openURL();
	}

	@Test()
	public void amazonRegistrationTest() {
		Keyword.getWebElement("cssSelector", "#createAccountSubmit").click();
		Keyword.getWebElement("cssSelector", "#ap_customer_name").sendKeys("Prithviraj Singh");
		// Keyword.handleDropdown("cssSelector", "auth-country-picker-container", "Hong Kong");
		Keyword.getWebElement("cssSelector", "#ap_phone_number").sendKeys("7267367");
		Keyword.getWebElement("cssSelector", "#ap_email").sendKeys("ajf@pickmail.com");
		Keyword.getWebElement("cssSelector", "#ap_password").sendKeys("123423");
		Keyword.getWebElement("cssSelector", "#continue").click();
		Keyword.implicitWait(10, TimeUnit.SECONDS);
		Keyword.takeScreenshot();

	}
}

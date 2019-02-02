package com.resonantiatechnologie.amazon.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonRegistration;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;
import com.resonantiatechnologie.amazon.pom.pages.YourAccount;

public class YourAccountTestCases extends POMBase {
	YourAccount account;
	AmazonSignIn signIn;
	OnlineShopingSiteInIndia online;

	// this the constructor of Amazon registration page
	public YourAccountTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		Keyword.implicitWait(20, TimeUnit.SECONDS);
		Keyword.windowMaximize();
		online = new OnlineShopingSiteInIndia();
		signIn = new AmazonSignIn();
		account = new YourAccount();
		openURL();
		online = signIn.login();
	}

	@Test()
	public void yourAccountTest() {
		Keyword.mouseMovement("xpath", "//a[@id='nav-link-yourAccount']");
		Keyword.click("xpath", "//span[contains(text(),'Your Account')]");
		Keyword.implicitWait(10, TimeUnit.SECONDS);
		Keyword.takeScreenshot();

	}
}

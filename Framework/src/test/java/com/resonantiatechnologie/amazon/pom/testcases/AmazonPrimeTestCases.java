package com.resonantiatechnologie.amazon.pom.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.resonantiatechnologie.amazon.keywords.Keyword;
import com.resonantiatechnologie.amazon.pom.base.POMBase;
import com.resonantiatechnologie.amazon.pom.pages.AmazonPrime;
import com.resonantiatechnologie.amazon.pom.pages.AmazonSignIn;
import com.resonantiatechnologie.amazon.pom.pages.OnlineShopingSiteInIndia;

public class AmazonPrimeTestCases extends POMBase {
	AmazonPrime prime;
	AmazonSignIn signIn;
	OnlineShopingSiteInIndia online;

	// this is the constructor of Amazon Prime page
	public AmazonPrimeTestCases() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		Keyword.implicitWait(20, TimeUnit.SECONDS);
		Keyword.windowMaximize();
		online = new OnlineShopingSiteInIndia();
		signIn = new AmazonSignIn();
		prime = new AmazonPrime();
		openURL();
		online = signIn.login();

	}

	@Test()
	public void amazonPrimeTest() {
		prime = online.clickOnTryPrimeLink();
		prime.tryPrimeFreeButton();
		prime.startYour30DaysTrialButton();
		Keyword.takeScreenshot();

	}

}
